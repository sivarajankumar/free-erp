package com.davidhodin.freeerp.data;

import com.davidhodin.freeerp.data.commercial.Achat;
import com.davidhodin.freeerp.data.commercial.Evenement;
import com.davidhodin.freeerp.data.commercial.ItemCommercial;
import com.davidhodin.freeerp.data.util.JsfUtil;
import com.davidhodin.freeerp.data.util.PaginationHelper;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "achatController")
@SessionScoped
public class AchatController implements Serializable {

    private Achat current;
    private Evenement evenement;
    private ItemCommercial itemCommercial;
    private DataModel items = null;
    @EJB
    private com.davidhodin.freeerp.data.AchatFacade ejbFacade;
    @EJB
    private EvenementFacade evenementFacade;
    @EJB
    private ItemCommercialFacade itemCommercialFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AchatController() {
    }

    // getter et setter + modif David
    public ItemCommercial getItemCommercial() {
        return itemCommercial;
    }

    public void setItemCommercial(ItemCommercial itemCommercial) {
        this.itemCommercial = itemCommercial;
    }

    public String ajouteItemCommercial() {
        try {
            itemCommercialFacade.create(itemCommercial);
            current.getItemCommerciaux().add(itemCommercial);
            getFacade().edit(current);
            itemCommercial = new ItemCommercial();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemCommercialCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public String ajouteEvenement() {
        try {
            evenementFacade.create(evenement);
            current.getEvenements().add(evenement);
            getFacade().edit(current);
            evenement = new Evenement();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EvenementCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }
    // TODO : Pour les achats finaliser la possibilité de supprimer les items (puis repporter...)
    public String prepareEditItemCommercial() {
        DataModel itemsCommerciaux = (DataModel) current.getItemCommerciaux();
        itemCommercial = (ItemCommercial) itemsCommerciaux.getRowData();
        return null;
    }

    public String destroyItemCommercial() {
//        current = (Achat) getItems().getRowData();
//        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        performDestroy();
//        recreatePagination();
//        recreateModel();
        return null;
    }

    // ----------------------------------------------------------------
    public Achat getSelected() {
        if (current == null) {
            current = new Achat();
            // David ---- Initialisation 
            evenement = new Evenement();
            itemCommercial = new ItemCommercial();

            selectedItemIndex = -1;
        }
        return current;
    }

    private AchatFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(1000) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Achat) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Achat();
        // David ---- Initialisation 
        evenement = new Evenement();
        itemCommercial = new ItemCommercial();

        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AchatCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Achat) getItems().getRowData();
        // David ---- Initialisation 
        evenement = new Evenement();
        itemCommercial = new ItemCommercial();

        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AchatUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Achat) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AchatDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Achat.class)
    public static class AchatControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AchatController controller = (AchatController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "achatController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Achat) {
                Achat o = (Achat) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AchatController.class.getName());
            }
        }
    }
}
