package com.davidhodin.freeerp.data;

import com.davidhodin.freeerp.data.tiers.Contact;
import com.davidhodin.freeerp.data.util.JsfUtil;
import com.davidhodin.freeerp.data.util.PaginationHelper;
import com.davidhodin.freeerp.data.ContactFacade;
import com.davidhodin.freeerp.data.tiers.AdresseNumerique;
import com.davidhodin.freeerp.data.tiers.Telephone;

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

@ManagedBean(name = "contactController")
@SessionScoped
public class ContactController implements Serializable {

    private Contact current;
    private Telephone telephone;
    private AdresseNumerique adresseNumerique;
    private DataModel items = null;
    @EJB
    private com.davidhodin.freeerp.data.ContactFacade ejbFacade;
    @EJB
    private TelephoneFacade telephoneFacade;
    @EJB
    private AdresseNumeriqueFacade adresseNumeriqueFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ContactController() {
    }

    // getter et setter + modif David
    public AdresseNumerique getAdresseNumerique() {
        return adresseNumerique;
    }

    public void setAdresseNumerique(AdresseNumerique adresseNumerique) {
        this.adresseNumerique = adresseNumerique;
    }

    public String ajouteAdresseNum() {
        try {
            adresseNumeriqueFacade.create(adresseNumerique);
            current.getAdressesElectronique().add(adresseNumerique);
            getFacade().edit(current);
            adresseNumerique = new AdresseNumerique();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public String ajouteTelephone() {
        try {
            telephoneFacade.create(telephone);
            current.getTelephones().add(telephone);
            getFacade().edit(current);
            telephone = new Telephone();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }

    // ----------------------------------------------------------------
    public Contact getSelected() {
        if (current == null) {
            current = new Contact();
            // David ---- Initialisation 
            adresseNumerique = new AdresseNumerique();
            telephone = new Telephone();

            selectedItemIndex = -1;
        }
        return current;
    }

    private ContactFacade getFacade() {
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
        current = (Contact) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Contact();
                    // David ---- Initialisation 
            adresseNumerique = new AdresseNumerique();
            telephone = new Telephone();

        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Contact) getItems().getRowData();
                    // David ---- Initialisation 
            adresseNumerique = new AdresseNumerique();
            telephone = new Telephone();

        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Contact) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ContactDeleted"));
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

    @FacesConverter(forClass = Contact.class)
    public static class ContactControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ContactController controller = (ContactController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "contactController");
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
            if (object instanceof Contact) {
                Contact o = (Contact) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ContactController.class.getName());
            }
        }
    }
}
