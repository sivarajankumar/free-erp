package com.davidhodin.freeerp.init;

import com.davidhodin.freeerp.data.tiers.CategorieAdresseNumerique;
import com.davidhodin.freeerp.data.tiers.CategorieAdressePostale;
import com.davidhodin.freeerp.data.util.JsfUtil;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "initController")
@SessionScoped
public class InitController implements Serializable {

    private CategorieAdressePostale AdressePostale1;
    private CategorieAdressePostale AdressePostale2;
    private CategorieAdressePostale AdressePostale3;
    private CategorieAdresseNumerique adresseNumerique1;
    private CategorieAdresseNumerique adresseNumerique2;
    private CategorieAdresseNumerique adresseNumerique3;
    
    @EJB
    private com.davidhodin.freeerp.data.CategorieAdressePostaleFacade ejbAdressePostale;
    @EJB
    private com.davidhodin.freeerp.data.CategorieAdresseNumeriqueFacade ejbAdresseNumerique;
    
    public InitController() {
    }

    private void initialiseDonnees() {
        // création des classes
        AdressePostale1 = new CategorieAdressePostale();
        AdressePostale2 = new CategorieAdressePostale();
        AdressePostale3 = new CategorieAdressePostale();
        adresseNumerique1 = new CategorieAdresseNumerique();
        adresseNumerique2 = new CategorieAdresseNumerique();
        adresseNumerique3 = new CategorieAdresseNumerique();
        
        // Initialisation des données
        AdressePostale1.setNomCategorie("Adresse de courrier");
        AdressePostale2.setNomCategorie("Adresse de facturation");
        AdressePostale3.setNomCategorie("Adresse comptable");
        adresseNumerique1.setNomCategorie("Email");
        adresseNumerique1.setNomCategorie("Site Web");
        adresseNumerique1.setNomCategorie("Adresse Facebook");
        
    }

    public String create() {
        try {
            initialiseDonnees();
            ejbAdressePostale.create(AdressePostale1);
            ejbAdressePostale.create(AdressePostale2);
            ejbAdressePostale.create(AdressePostale3);
            ejbAdresseNumerique.create(adresseNumerique1);
            ejbAdresseNumerique.create(adresseNumerique2);
            ejbAdresseNumerique.create(adresseNumerique3);
            JsfUtil.addSuccessMessage("Initialisation des données Ok");
            return "/data/accueil/accueilConfiguration";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erreur d'initialisation des données");
            return null;
        }
    }
}
