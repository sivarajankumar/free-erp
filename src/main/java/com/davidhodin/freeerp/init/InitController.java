package com.davidhodin.freeerp.init;

import com.davidhodin.freeerp.data.*;
import com.davidhodin.freeerp.data.commercial.*;
import com.davidhodin.freeerp.data.comptabilite.CategorieFacture;
import com.davidhodin.freeerp.data.comptabilite.CategorieReglement;
import com.davidhodin.freeerp.data.comptabilite.TVA;
import com.davidhodin.freeerp.data.configuration.Pays;
import com.davidhodin.freeerp.data.configuration.ZoneGeo;
import com.davidhodin.freeerp.data.financier.CategorieBanque;
import com.davidhodin.freeerp.data.financier.CategorieMouvement;
import com.davidhodin.freeerp.data.financier.TypeCompte;
import com.davidhodin.freeerp.data.tiers.*;
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
    private CategorieTelephone categorieTelephone1;
    private CategorieTelephone categorieTelephone2;
    private CategorieTelephone categorieTelephone3;
    private CategorieTiers categorieTiers1;
    private CategorieTiers categorieTiers2;
    private CategorieTiers categorieTiers3;
    private CategorieProduit categorieProduit1;
    private CategorieProduit categorieProduit2;
    private CategorieProduit categorieProduit3;
    private CategorieService categorieService1;
    private CategorieService categorieService2;
    private CategorieService categorieService3;
    private CategorieAchat categorieAchat1;
    private CategorieAchat categorieAchat2;
    private CategorieAchat categorieAchat3;
    private CategorieOffre categorieOffre1; 
    private CategorieOffre categorieOffre2; 
    private CategorieOffre categorieOffre3; 
    private CategorieEvenement categorieEvenement1;
    private CategorieEvenement categorieEvenement2;
    private CategorieEvenement categorieEvenement3;
    private CategorieBanque categorieBanque1;
    private CategorieBanque categorieBanque2;
    private TypeCompte typeCompte1;
    private TypeCompte typeCompte2;
    private CategorieMouvement categorieMouvement1;
    private CategorieMouvement categorieMouvement2;
    private CategorieFacture categorieFacture1;
    private CategorieFacture categorieFacture2;
    private CategorieFacture categorieFacture3;
    private CategorieReglement categorieReglement1;
    private CategorieReglement categorieReglement2;
    private CategorieReglement categorieReglement3;
    // Etats-Type
    private TypeTiers typeTiers1;
    private TypeTiers typeTiers2;
    private TypeTiers typeTiers3;
    private EtatAchat etatAchat1;
    private EtatAchat etatAchat2;
    private EtatAchat etatAchat3;
    private EtatCommercial etatCommercial1;
    private EtatCommercial etatCommercial2;
    private EtatCommercial etatCommercial3;
    private EtatOffre etatOffre1;
    private EtatOffre etatOffre2;
    private EtatOffre etatOffre3;
    private EtatEvenement etatEvenement1;
    private EtatEvenement etatEvenement2;
    private EtatEvenement etatEvenement3;
    //Réf
    private TitreContact titreContact1;
    private TitreContact titreContact2;
    private TitreContact titreContact3;
    private Pays pays1;
    private Pays pays2;
    private Pays pays3;
    private TVA tva1;
    private TVA tva2;
    private TVA tva3;
    private ZoneGeo zoneGeo1;
    private ZoneGeo zoneGeo2;
    private ZoneGeo zoneGeo3;
    
    
    @EJB
    private CategorieAdressePostaleFacade ejbAdressePostale;
    @EJB
    private CategorieAdresseNumeriqueFacade ejbAdresseNumerique;
    @EJB
    private CategorieTelephoneFacade categorieTelephoneFacade;
    @EJB
    private CategorieTiersFacade categorieTiersFacade;
    @EJB
    private CategorieProduitFacade categorieProduitFacade;
    @EJB
    private CategorieServiceFacade categorieServiceFacade;
    @EJB
    private CategorieAchatFacade categorieAchatFacade;
    @EJB
    private CategorieOffreFacade categorieOffreFacade;
    @EJB 
    private CategorieEvenementFacade categorieEvenementFacade;
    @EJB 
    private CategorieBanqueFacade categorieBanqueFacade;
    @EJB 
    private TypeCompteFacade compteFacade;
    @EJB 
    private CategorieMouvementFacade categorieMouvementFacade;
    @EJB 
    private CategorieFactureFacade categorieFactureFacade;
    @EJB 
    private CategorieReglementFacade categorieReglementFacade;    
    @EJB 
    private TypeTiersFacade typeTiersFacade;
    @EJB 
    private EtatAchatFacade etatAchatFacade;
    @EJB 
    private EtatCommercialFacade etatCommercialFacade;
    @EJB 
    private EtatOffreFacade etatOffreFacade;
    @EJB 
    private EtatEvenementFacade etatEvenementFacade;
    @EJB 
    private TitreContactFacade titreContactFacade;
    @EJB 
    private PaysFacade paysFacade;
    @EJB 
    private TVAFacade tVAFacade;
    @EJB 
    private ZoneGeoFacade zoneGeoFacade;
    
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
        categorieTelephone1 = new CategorieTelephone();
        categorieTelephone2 = new CategorieTelephone();
        categorieTelephone3 = new CategorieTelephone();
        categorieTiers1 = new CategorieTiers();
        categorieTiers2 = new CategorieTiers();
        categorieTiers3 = new CategorieTiers();
        categorieProduit1 = new CategorieProduit();
        categorieProduit2 = new CategorieProduit();
        categorieProduit3 = new CategorieProduit();
        categorieService1 = new CategorieService();
        categorieService2 = new CategorieService();
        categorieService3 = new CategorieService();
        categorieAchat1 = new CategorieAchat();
        categorieAchat2 = new CategorieAchat();
        categorieAchat3 = new CategorieAchat();
        categorieOffre1 = new CategorieOffre();
        categorieOffre2 = new CategorieOffre();
        categorieOffre3 = new CategorieOffre();
        categorieEvenement1 = new CategorieEvenement();
        categorieEvenement2 = new CategorieEvenement();
        categorieEvenement3 = new CategorieEvenement();
        categorieBanque1 = new CategorieBanque();
        categorieBanque2 = new CategorieBanque();
        typeCompte1 = new TypeCompte();
        typeCompte2 = new TypeCompte();
        categorieMouvement1 = new CategorieMouvement();
        categorieMouvement2 = new CategorieMouvement();
        categorieFacture1 = new CategorieFacture();
        categorieFacture2 = new CategorieFacture();
        categorieFacture3 = new CategorieFacture();
        categorieReglement1 = new CategorieReglement();
        categorieReglement2 = new CategorieReglement();
        categorieReglement3 = new CategorieReglement();
        // Etat-Type
        typeTiers1 = new TypeTiers();
        typeTiers2 = new TypeTiers();
        typeTiers3 = new TypeTiers();
        etatAchat1 = new EtatAchat();
        etatAchat2 = new EtatAchat();
        etatAchat3 = new EtatAchat();
        etatCommercial1 = new EtatCommercial();
        etatCommercial2 = new EtatCommercial();
        etatCommercial3 = new EtatCommercial();
        etatOffre1 = new EtatOffre();
        etatOffre2 = new EtatOffre();
        etatOffre3 = new EtatOffre();
        etatEvenement1 = new EtatEvenement();
        etatEvenement2 = new EtatEvenement();
        etatEvenement3 = new EtatEvenement();
        //Réf
        titreContact1 = new TitreContact();
        titreContact2 = new TitreContact();
        titreContact3 = new TitreContact();
        pays1 = new Pays();
        pays2 = new Pays();
        pays3 = new Pays();
        tva1 = new TVA();
        tva2 = new TVA();
        tva3 = new TVA();
        zoneGeo1 = new ZoneGeo();
        zoneGeo2 = new ZoneGeo();
        zoneGeo3 = new ZoneGeo();
        
        // ---------------------------------------
        // Initialisation des données
        AdressePostale1.setNomCategorie("Adresse de courrier");
        AdressePostale2.setNomCategorie("Adresse de facturation");
        AdressePostale3.setNomCategorie("Adresse comptable");
        adresseNumerique1.setNomCategorie("Email");
        adresseNumerique2.setNomCategorie("Site Web");
        adresseNumerique3.setNomCategorie("Adresse Facebook");
        categorieTelephone1.setNomCategorie("Fixe");
        categorieTelephone2.setNomCategorie("Portable");
        categorieTelephone3.setNomCategorie("Travail");
        categorieTiers1.setNomCategorie("Partenaire privilégié");
        categorieTiers2.setNomCategorie("Fournisseur à surveiller");
        categorieTiers3.setNomCategorie("Client Premium");
        categorieProduit1.setNomCategorie("Haut de gamme");
        categorieProduit2.setNomCategorie("Moyenne gamme");
        categorieProduit3.setNomCategorie("Bas de gamme");
        categorieService1.setNomCategorie("Service Premium");
        categorieService2.setNomCategorie("Service Standard");
        categorieService3.setNomCategorie("Service Low cost");
        categorieAchat1.setNomCategorie("Fournitures");
        categorieAchat2.setNomCategorie("Matière première");
        categorieAchat3.setNomCategorie("Services");
        categorieOffre1.setNomCategorie("Vente au détail");
        categorieOffre2.setNomCategorie("Vente en gros");
        categorieOffre3.setNomCategorie("Vente du magasin");
        categorieEvenement1.setNomCatEvenement("Premier contact");
        categorieEvenement2.setNomCatEvenement("Appel téléphonique");
        categorieEvenement3.setNomCatEvenement("Echange électronique");
        categorieBanque1.setNomCategorie("Banque de dépôt");
        categorieBanque2.setNomCategorie("Banque d'investissement");
        typeCompte1.setTypeCompte("Compte courant");
        typeCompte2.setTypeCompte("Compte d'épargne");
        categorieMouvement1.setNomCategorie("Paiement Facture");
        categorieMouvement2.setNomCategorie("Retrait");
        categorieFacture1.setNomCategorie("A payer");
        categorieFacture2.setNomCategorie("Attente paiement");
        categorieFacture3.setNomCategorie("Avoir");
        categorieReglement1.setNomCategorie("Cheque");
        categorieReglement2.setNomCategorie("Espèce");
        categorieReglement3.setNomCategorie("CB");
        // Etat-Type
        typeTiers1.setNomType("Fournisseur");
        typeTiers2.setNomType("Client");
        typeTiers3.setNomType("Partenaire");
        etatAchat1.setEtatAchat("Demande propal");
        etatAchat2.setEtatAchat("Attente de validation");
        etatAchat3.setEtatAchat("En commande");
        etatCommercial1.setEtat("Devis");
        etatCommercial2.setEtat("Attente signature");
        etatCommercial3.setEtat("Signée");
        etatOffre1.setEtatOffre("En cours");
        etatOffre2.setEtatOffre("A relancer");
        etatOffre3.setEtatOffre("Terminée");
        etatEvenement1.setEtatEvenement("A réaliser");
        etatEvenement2.setEtatEvenement("En cours");
        etatEvenement3.setEtatEvenement("Terminé");
        //Réf
        titreContact1.setNomTitre("M");
        titreContact2.setNomTitre("Me");
        titreContact3.setNomTitre("Mlle");
        pays1.setCodePays("FR");
        pays2.setCodePays("UK");
        pays3.setCodePays("US");
        pays1.setNomPays("France");
        pays2.setNomPays("Grande bretagne");
        pays3.setNomPays("Etats Unis");
        tva1.setDescription("TVA 5.5%");
        tva2.setDescription("TVA 19.6%");
        tva3.setDescription("TVA 0%");
        tva1.setTaux(0.055f);
        tva2.setTaux(0.196f);
        tva3.setTaux(0f);
        zoneGeo1.setNomZone("Accueil");
        zoneGeo2.setNomZone("Cafétariat");
        zoneGeo3.setNomZone("Parking");
        zoneGeo1.setDescriptionZone("Zone réservée à l'accueil des clients et fournisseurs");
        zoneGeo2.setDescriptionZone("Salle de détente avec tout le nécessaire pour une petite collation");
        zoneGeo3.setDescriptionZone("Parking réservé au personnel");
    }

    public String create() {
        try {
            initialiseDonnees();
            ejbAdresseNumerique.create(adresseNumerique1);
            ejbAdresseNumerique.create(adresseNumerique2);
            ejbAdresseNumerique.create(adresseNumerique3);
            ejbAdressePostale.create(AdressePostale1);
            ejbAdressePostale.create(AdressePostale2);
            ejbAdressePostale.create(AdressePostale3);
            categorieTelephoneFacade.create(categorieTelephone1);
            categorieTelephoneFacade.create(categorieTelephone2);
            categorieTelephoneFacade.create(categorieTelephone3);
            categorieTiersFacade.create(categorieTiers1);
            categorieTiersFacade.create(categorieTiers2);
            categorieTiersFacade.create(categorieTiers3);
            categorieProduitFacade.create(categorieProduit1);
            categorieProduitFacade.create(categorieProduit2);
            categorieProduitFacade.create(categorieProduit3);
            categorieServiceFacade.create(categorieService1);
            categorieServiceFacade.create(categorieService2);
            categorieServiceFacade.create(categorieService3);
            categorieAchatFacade.create(categorieAchat1);
            categorieAchatFacade.create(categorieAchat2);
            categorieAchatFacade.create(categorieAchat3);
            categorieOffreFacade.create(categorieOffre1);
            categorieOffreFacade.create(categorieOffre2);
            categorieOffreFacade.create(categorieOffre3);
            categorieEvenementFacade.create(categorieEvenement1);
            categorieEvenementFacade.create(categorieEvenement2);
            categorieEvenementFacade.create(categorieEvenement3);
            categorieBanqueFacade.create(categorieBanque1);
            categorieBanqueFacade.create(categorieBanque2);
            compteFacade.create(typeCompte1);
            compteFacade.create(typeCompte2);
            categorieMouvementFacade.create(categorieMouvement1);
            categorieMouvementFacade.create(categorieMouvement2);
            categorieFactureFacade.create(categorieFacture1);
            categorieFactureFacade.create(categorieFacture2);
            categorieFactureFacade.create(categorieFacture3);
            categorieReglementFacade.create(categorieReglement1);
            categorieReglementFacade.create(categorieReglement2);
            categorieReglementFacade.create(categorieReglement3);
            // Type-Etat
            typeTiersFacade.create(typeTiers1);
            typeTiersFacade.create(typeTiers2);
            typeTiersFacade.create(typeTiers3);
            etatAchatFacade.create(etatAchat1);
            etatAchatFacade.create(etatAchat2);
            etatAchatFacade.create(etatAchat3);
            etatCommercialFacade.create(etatCommercial1);
            etatCommercialFacade.create(etatCommercial2);
            etatCommercialFacade.create(etatCommercial3);
            etatOffreFacade.create(etatOffre1);
            etatOffreFacade.create(etatOffre2);
            etatOffreFacade.create(etatOffre3);
            etatEvenementFacade.create(etatEvenement1);
            etatEvenementFacade.create(etatEvenement2);
            etatEvenementFacade.create(etatEvenement3);
            //Réf
            titreContactFacade.create(titreContact1);
            titreContactFacade.create(titreContact2);
            titreContactFacade.create(titreContact3);
            paysFacade.create(pays1);
            paysFacade.create(pays2);
            paysFacade.create(pays3);
            tVAFacade.create(tva1);
            tVAFacade.create(tva2);
            tVAFacade.create(tva3);
            zoneGeoFacade.create(zoneGeo1);
            zoneGeoFacade.create(zoneGeo2);
            zoneGeoFacade.create(zoneGeo3);
            JsfUtil.addSuccessMessage("Initialisation des données Ok");
            return "/data/accueil/accueilConfiguration";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erreur d'initialisation des données");
            return null;
        }
    }
}
