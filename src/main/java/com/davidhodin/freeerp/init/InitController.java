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

    private CategorieAdressePostale categorieAdressePostale1;
    private CategorieAdressePostale categorieAdressePostale2;
    private CategorieAdressePostale categorieAdressePostale3;
    private CategorieAdresseNumerique categorieAdresseNumerique1;
    private CategorieAdresseNumerique categorieAdresseNumerique2;
    private CategorieAdresseNumerique categorieAdresseNumerique3;
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
    // Données
    // ----Tiers
    private AdressePostale adressePostale1;
    private AdressePostale adressePostale2;
    private Tiers tiers1;
    private Tiers tiers2;
    private AdresseNumerique adresseNumerique1;
    private AdresseNumerique adresseNumerique2;
    private Telephone telephone1;
    private Telephone telephone2;
    private Contact contact1;
    private Contact contact2;
    // ----Produits
    private Produit produit1;
    private Produit produit2;
    private Produit produit3;
    private Service service1;
    private Service service2;
    private Service service3;
    // ----Commercial
    private ItemCommercial itemCommercial1;
    private ItemCommercial itemCommercial2;
    private Evenement evenement1;
    private Evenement evenement2;
    private GroupeOffre groupeOffre1;
    private GroupeOffre groupeOffre2;
    private OffreCommerciale offreCommerciale1;
    private OffreCommerciale offreCommerciale2;
    private Achat achat1;
    private Achat achat2;  
    // ----Financier
    
    
    // ---- EJB
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
    @EJB
    private AdressePostaleFacade adressePostaleFacade;
    @EJB
    private TiersFacade tiersFacade;
    @EJB
    private ContactFacade contactFacade;
    @EJB
    private AdresseNumeriqueFacade adresseNumeriqueFacade;
    @EJB
    private TelephoneFacade telephoneFacade;
    @EJB
    private ProduitFacade produitFacade;
    @EJB
    private ServiceFacade serviceFacade;
    @EJB
    private EvenementFacade evenementFacade;
    @EJB
    private ItemCommercialFacade itemCommercialFacade;
    @EJB
    private AchatFacade achatFacade;
    @EJB
    private OffreCommercialeFacade offreCommercialeFacade;
    @EJB
    private GroupeOffreFacade groupeOffreFacade;

    public InitController() {
    }

    private void initialiseDonnees() {
        // création des classes
        categorieAdressePostale1 = new CategorieAdressePostale();
        categorieAdressePostale2 = new CategorieAdressePostale();
        categorieAdressePostale3 = new CategorieAdressePostale();
        categorieAdresseNumerique1 = new CategorieAdresseNumerique();
        categorieAdresseNumerique2 = new CategorieAdresseNumerique();
        categorieAdresseNumerique3 = new CategorieAdresseNumerique();
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
        // Données
        // ----Tiers
        adressePostale1 = new AdressePostale();
        adressePostale2 = new AdressePostale();
        tiers1 = new Tiers();
        tiers2 = new Tiers();
        adresseNumerique1 = new AdresseNumerique();
        adresseNumerique2 = new AdresseNumerique();
        contact1 = new Contact();
        contact2 = new Contact();
        telephone1 = new Telephone();
        telephone2 = new Telephone();

        // ----Produits
        produit1 = new Produit();
        produit2 = new Produit();
        produit3 = new Produit();
        service1 = new Service();
        service2 = new Service();
        service3 = new Service();

        // ----Commercial
        itemCommercial1 = new ItemCommercial();
        itemCommercial2 = new ItemCommercial();
        evenement1 = new Evenement();
        evenement2 = new Evenement();
        groupeOffre1 = new GroupeOffre();
        groupeOffre2 = new GroupeOffre();
        offreCommerciale1 = new OffreCommerciale();
        offreCommerciale2 = new OffreCommerciale();
        achat1 = new Achat();
        achat2 = new Achat();
        
        // ----Financier


        // ---------------------------------------
        // Initialisation des données
        // ----Tiers
        categorieAdressePostale1.setNomCategorie("Adresse de courrier");
        categorieAdressePostale2.setNomCategorie("Adresse de facturation");
        categorieAdressePostale3.setNomCategorie("Adresse comptable");
        categorieAdresseNumerique1.setNomCategorie("Email");
        categorieAdresseNumerique2.setNomCategorie("Site Web");
        categorieAdresseNumerique3.setNomCategorie("Adresse Facebook");
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
        etatCommercial1.setEtat("Vente uniquement");
        etatCommercial2.setEtat("Achat uniquement");
        etatCommercial3.setEtat("Achat et vente");
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
        // Données
        // ----Tiers
        adressePostale1.setLabelAdresse("Adresse 1");
        adressePostale2.setLabelAdresse("Adresse 2");
        tiers1.setNomTiers("Tiers 1");
        tiers2.setNomTiers("Tiers 2");
        contact1.setNom("HODIN");
        contact2.setNom("HODIN-GASQ");
        contact1.setPrenom("David");
        contact2.setPrenom("Christine");
        adresseNumerique1.setAdresseNum("dhodin@gmail.com");
        adresseNumerique2.setAdresseNum("dhodin@yahoo.com");
        telephone1.setDescriptionNumero("Personnel");
        telephone2.setDescriptionNumero("Travail");
        telephone1.setNumero("+33 01 02 03 04 05");
        telephone2.setNumero("+33 04 02 03 04 05");

        // ----Produits
        produit1.setNomProduit("PC portable");
        produit2.setNomProduit("Serveur");
        produit3.setNomProduit("Tablette");
        service1.setNomService("Développement d'application");
        service2.setNomService("Développement d'application Web d'entreprise");
        service3.setNomService("Hébergement d'application sur serveur virtualisé");

        // ----Commercial
        itemCommercial1.setNomItem("Serveur - Linux Mint");
        itemCommercial1.setQuantite(1f);
        itemCommercial2.setNomItem("Installation");
        itemCommercial2.setQuantite(1f);
        itemCommercial1.setMontantHT(1000f);
        itemCommercial2.setMontantHT(150f);
        evenement1.setNomEvenement("Description technique");
        evenement2.setNomEvenement("Installation sur site");
        groupeOffre1.setEnCours(Boolean.TRUE);
        groupeOffre2.setEnCours(Boolean.FALSE);
        groupeOffre1.setLabelGroupeOffre("Offres pour la refonte du SI");
        groupeOffre2.setLabelGroupeOffre("Offres déploiement SI Aéro");
        offreCommerciale1.setNomOffre("Installation SI - Offre 1");
        offreCommerciale2.setNomOffre("Installation SI - Offre 2");
        offreCommerciale1.setReceptionOk(Boolean.TRUE);
        offreCommerciale2.setReceptionOk(Boolean.TRUE);
        achat1.setNomAchat("Achat matériel informatique");
        achat2.setNomAchat("Achat prestation");

        // ----Financier

    }

    public String create() {
        try {
            initialiseDonnees();
            ejbAdresseNumerique.create(categorieAdresseNumerique1);
            ejbAdresseNumerique.create(categorieAdresseNumerique2);
            ejbAdresseNumerique.create(categorieAdresseNumerique3);
            ejbAdressePostale.create(categorieAdressePostale1);
            ejbAdressePostale.create(categorieAdressePostale2);
            ejbAdressePostale.create(categorieAdressePostale3);
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
            // Données
            // ----Tiers
            adressePostaleFacade.create(adressePostale1);
            adressePostale1.setCategorieAdressePostale(categorieAdressePostale1);
            adressePostaleFacade.edit(adressePostale1);
            adressePostaleFacade.create(adressePostale2);
            adresseNumeriqueFacade.create(adresseNumerique1);
            adresseNumerique1.setCategorieAdresse(categorieAdresseNumerique1);
            adresseNumeriqueFacade.edit(adresseNumerique1);
            adresseNumeriqueFacade.create(adresseNumerique2);
            telephoneFacade.create(telephone1);
            telephone1.setCategorieTelephone(categorieTelephone1);
            telephoneFacade.edit(telephone1);
            telephoneFacade.create(telephone2);
            contactFacade.create(contact1);
            contactFacade.create(contact2);
            contact1.setTitre(titreContact1);
            contact1.getAdressesElectronique().add(adresseNumerique1);
            contact1.getAdressesElectronique().add(adresseNumerique2);
            contact1.getTelephones().add(telephone1);
            contact1.getTelephones().add(telephone2);
            contactFacade.edit(contact1);
            contact2.setTitre(titreContact2);
            contactFacade.edit(contact2);
            tiersFacade.create(tiers1);
            tiersFacade.create(tiers2);
            tiers1.getAdressesPost().add(adressePostale2);
            tiers1.getAdressesPost().add(adressePostale1);
            tiers1.getAdressesNum().add(adresseNumerique1);
            tiers1.getTelephones().add(telephone1);
            tiers1.getTelephones().add(telephone2);
            tiers1.getContacts().add(contact1);
            tiers1.getContacts().add(contact2);
            tiers1.setCategorie(categorieTiers1);
            tiers1.setTypeTiers(typeTiers1);
            tiersFacade.edit(tiers1);
            tiers2.setCategorie(categorieTiers2);
            tiers2.setTypeTiers(typeTiers2);
            tiersFacade.edit(tiers2);

            // ----Produits
            produitFacade.create(produit1);
            produitFacade.create(produit2);
            produitFacade.create(produit3);
            serviceFacade.create(service1);
            serviceFacade.create(service2);
            serviceFacade.create(service3);
            produit1.setCategorie(categorieProduit1);
            produit1.setEtatCommercial(etatCommercial1);
            service1.setCategorieService(categorieService1);
            service1.setEtatCommercial(etatCommercial2);
            produitFacade.edit(produit1);
            serviceFacade.edit(service1);

            // ----Commercial
            itemCommercialFacade.create(itemCommercial1);
            itemCommercialFacade.create(itemCommercial2);
            evenementFacade.create(evenement1);
            evenementFacade.create(evenement2);
            itemCommercial1.setProduit(produit1);
            itemCommercial2.setService(service1);
            itemCommercial1.setTauxTVA(tva1);
            itemCommercial2.setTauxTVA(tva2);
            itemCommercialFacade.edit(itemCommercial1);
            itemCommercialFacade.edit(itemCommercial2);
            evenement1.setContact(contact1);
            evenement1.setCategorieEvenement(categorieEvenement1);
            evenement2.setContact(contact2);
            evenement2.setCategorieEvenement(categorieEvenement3);
            evenementFacade.edit(evenement1);
            evenementFacade.edit(evenement2);
            groupeOffreFacade.create(groupeOffre1);
            groupeOffreFacade.create(groupeOffre2);
            offreCommercialeFacade.create(offreCommerciale1);
            offreCommercialeFacade.create(offreCommerciale2);
            achatFacade.create(achat1);
            achatFacade.create(achat2);
            groupeOffre1.getOffreCommerciale().add(offreCommerciale1);
            groupeOffre1.getOffreCommerciale().add(offreCommerciale2);
            groupeOffreFacade.edit(groupeOffre1);
            offreCommerciale1.setCategorieOffre(categorieOffre1);
            offreCommerciale2.setCategorieOffre(categorieOffre2);
            offreCommerciale1.setEtatOffre(etatOffre1);
            offreCommerciale2.setEtatOffre(etatOffre2);
            offreCommerciale1.setTiers(tiers1);
            offreCommerciale2.setTiers(tiers2);
            offreCommerciale1.getItemCommerciaux().add(itemCommercial1);
            offreCommerciale2.getItemCommerciaux().add(itemCommercial2);
            offreCommercialeFacade.edit(offreCommerciale1);
            offreCommercialeFacade.edit(offreCommerciale2);
            achat1.setCategorieAchat(categorieAchat1);
            achat2.setCategorieAchat(categorieAchat1);
            achat1.setEtatAchat(etatAchat1);
            achat2.setEtatAchat(etatAchat1);
            achat1.setTiers(tiers2);
            achat2.setTiers(tiers1);
            achat1.getItemCommerciaux().add(itemCommercial1);
            achat1.getItemCommerciaux().add(itemCommercial2);
            achatFacade.edit(achat1);
            achatFacade.edit(achat2);
            
            // ----Financier

            JsfUtil.addSuccessMessage("Initialisation des données Ok");
            return "/data/accueil/accueilConfiguration";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erreur d'initialisation des données");
            return null;
        }
    }
}
