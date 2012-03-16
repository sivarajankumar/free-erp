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
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Achat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomAchat;
    @ManyToOne
    private Tiers tiers;
    @ManyToOne
    private CategorieAchat categorieAchat;
    @OneToMany
    private List<ItemCommercial> itemCommerciaux;
    // Dates
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCloture;
    // Suivi
    @ManyToOne
    private EtatAchat etatAchat;
    private Boolean receptionOk;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateReceptionOk;
    @OneToMany
    private List<Evenement> evenements;
    // Financier
    @ManyToOne
    private Facture facture;
    private Boolean factureOk;
    // Autre
    @ManyToOne
    private Documents documents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieAchat getCategorieAchat() {
        return categorieAchat;
    }

    public void setCategorieAchat(CategorieAchat categorieAchat) {
        this.categorieAchat = categorieAchat;
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

    public EtatAchat getEtatAchat() {
        return etatAchat;
    }

    public void setEtatAchat(EtatAchat etatAchat) {
        this.etatAchat = etatAchat;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
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

    public List<ItemCommercial> getItemCommerciaux() {
        return itemCommerciaux;
    }

    public void setItemCommerciaux(List<ItemCommercial> itemCommerciaux) {
        this.itemCommerciaux = itemCommerciaux;
    }

    public String getNomAchat() {
        return nomAchat;
    }

    public void setNomAchat(String nomAchat) {
        this.nomAchat = nomAchat;
    }

    public Boolean getReceptionOk() {
        return receptionOk;
    }

    public void setReceptionOk(Boolean receptionOk) {
        this.receptionOk = receptionOk;
    }

    public Tiers getTiers() {
        return tiers;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
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
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomAchat;
    }
}
