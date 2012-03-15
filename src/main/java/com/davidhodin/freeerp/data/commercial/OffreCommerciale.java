/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.comptabilite.Facture;
import com.davidhodin.freeerp.data.configuration.Documents;
import com.davidhodin.freeerp.data.tiers.Tiers;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class OffreCommerciale implements Serializable {
    @ManyToOne
    private GroupeOffre groupeOffre;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomOffre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCloture;
    @ManyToOne
    private Tiers tiers;
    @ManyToOne
    private CategorieOffre categorieOffre;
    @ManyToOne
    private EtatOffre etatOffre;
    @OneToMany
    private List<Evenement> evenements;
    @ManyToOne
    private Facture facture;
    private Boolean factureOk;
    private Boolean receptionOk;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateReceptionOk;
    @ManyToOne
    private Documents documents;
 
    @ManyToMany
    private List<ItemCommercial> itemCommerciaux;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieOffre getCategorieOffre() {
        return categorieOffre;
    }

    public void setCategorieOffre(CategorieOffre categorieOffre) {
        this.categorieOffre = categorieOffre;
    }

    public String getNomOffre() {
        return nomOffre;
    }

    public void setNomOffre(String nomOffre) {
        this.nomOffre = nomOffre;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public EtatOffre getEtatOffre() {
        return etatOffre;
    }

    public void setEtatOffre(EtatOffre etatOffre) {
        this.etatOffre = etatOffre;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public GroupeOffre getGroupeOffre() {
        return groupeOffre;
    }

    public void setGroupeOffre(GroupeOffre groupeOffre) {
        this.groupeOffre = groupeOffre;
    }

    public Tiers getTiers() {
        return tiers;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
    }


    public Date getDateReceptionOk() {
        return dateReceptionOk;
    }

    public void setDateReceptionOk(Date dateReceptionOk) {
        this.dateReceptionOk = dateReceptionOk;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Boolean getFactureOk() {
        return factureOk;
    }

    public void setFactureOk(Boolean factureOk) {
        this.factureOk = factureOk;
    }

    public Boolean getReceptionOk() {
        return receptionOk;
    }

    public void setReceptionOk(Boolean receptionOk) {
        this.receptionOk = receptionOk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OffreCommerciale)) {
            return false;
        }
        OffreCommerciale other = (OffreCommerciale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String retour;
        if (groupeOffre != null) {
            retour = groupeOffre.getLabelGroupeOffre() + " - " + nomOffre;
        } else {
            retour = nomOffre;
        }
        return retour;
    }
    
}
