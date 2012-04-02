package com.davidhodin.freeerp.data;

import com.davidhodin.freeerp.data.tiers.*;
import com.davidhodin.freeerp.data.util.JsfUtil;
import com.davidhodin.freeerp.data.util.PaginationHelper;
import com.lowagie.text.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;
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

@ManagedBean(name = "tiersController")
@SessionScoped
public class TiersController implements Serializable {

    private Tiers current;
    private AdressePostale adressePostale;
    private Telephone telephone;
    private AdresseNumerique adresseNumerique;
    private Contact contact;
    private DataModel items = null;
    private List<Tiers> allItems;
    @EJB
    private com.davidhodin.freeerp.data.TiersFacade ejbFacade;
    @EJB
    private AdressePostaleFacade adressePostaleFacade;
    @EJB
    private TelephoneFacade telephoneFacade;
    @EJB
    private AdresseNumeriqueFacade adresseNumeriqueFacade;
    @EJB
    private ContactFacade contactFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public TiersController() {
    }

    // getter et setter + modif David
    // ----- En cours...
    public List<Tiers> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<Tiers> allItems) {
        this.allItems = allItems;
    }

    public String tousLesItems() {
        allItems = ejbFacade.findAll();
        return "List";
    }

    public void preProcessPDF(Object document) throws DocumentException, BadElementException, MalformedURLException, IOException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

//        String logo = "/resources/images/icones/PDF.png";

        Paragraph p1 = new Paragraph(new Chunk("1er paragraphe.", FontFactory.getFont(FontFactory.HELVETICA, 12)));
        Paragraph p2 = new Paragraph(new Phrase("2em paragraphe.", FontFactory.getFont(FontFactory.HELVETICA, 12)));
        Paragraph p3 = new Paragraph("3em paragraphe.", FontFactory.getFont(FontFactory.HELVETICA, 12));

//        pdf.add(Image.getInstance(logo));
        pdf.add(p1);
        pdf.add(p2);
        pdf.add(p3);
    }
    // ----- En cours.. End

    public AdressePostale getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(AdressePostale adressePostale) {
        this.adressePostale = adressePostale;
    }

    public String ajouteAdresse() {
        try {
            adressePostaleFacade.create(adressePostale);
            current.getAdressesPost().add(adressePostale);
            getFacade().edit(current);
            adressePostale = new AdressePostale();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }

    public AdresseNumerique getAdresseNumerique() {
        return adresseNumerique;
    }

    public void setAdresseNumerique(AdresseNumerique adresseNumerique) {
        this.adresseNumerique = adresseNumerique;
    }

    public String ajouteAdresseNum() {
        try {
            adresseNumeriqueFacade.create(adresseNumerique);
            current.getAdressesNum().add(adresseNumerique);
            getFacade().edit(current);
            adresseNumerique = new AdresseNumerique();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String ajouteContact() {
        try {
            contactFacade.create(contact);
            current.getContacts().add(contact);
            getFacade().edit(current);
            contact = new Contact();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersCreated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return null;
    }

    // ----------------------------------------------------------------
    public Tiers getSelected() {
        if (current == null) {
            current = new Tiers();
            // David ---- Initialisation 
            adressePostale = new AdressePostale();
            adresseNumerique = new AdresseNumerique();
            telephone = new Telephone();
            contact = new Contact();

            selectedItemIndex = -1;
        }
        return current;
    }

    private TiersFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

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
        current = (Tiers) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Tiers();
        // David ---- Initialisation 
        adressePostale = new AdressePostale();
        adresseNumerique = new AdresseNumerique();
        telephone = new Telephone();
        contact = new Contact();

        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Tiers) getItems().getRowData();
        // David ---- Initialisation 
        adressePostale = new AdressePostale();
        adresseNumerique = new AdresseNumerique();
        telephone = new Telephone();
        contact = new Contact();

        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Tiers) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TiersDeleted"));
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

    @FacesConverter(forClass = Tiers.class)
    public static class TiersControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TiersController controller = (TiersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tiersController");
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
            if (object instanceof Tiers) {
                Tiers o = (Tiers) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TiersController.class.getName());
            }
        }
    }
}
