/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.comptabilite;

import com.davidhodin.freeerp.data.commercial.Achat;
import com.davidhodin.freeerp.data.commercial.OffreCommerciale;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Facture implements Serializable {
    @OneToMany(mappedBy = "facture")
    private List<Achat> achats;
    @OneToMany(mappedBy = "facture")
    private List<OffreCommerciale> offreCommerciales;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomFacture;
    @ManyToOne
    private CategorieFacture categorieFacture;
    @OneToMany(mappedBy = "facture")
    private List<Reglement> reglements;
    private Boolean paiementOk;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCloture;    
    private Float soldeHT;
    private Float soldeTVA;
    private Float soldePaye;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }

    public CategorieFacture getCategorieFacture() {
        return categorieFacture;
    }

    public void setCategorieFacture(CategorieFacture categorieFacture) {
        this.categorieFacture = categorieFacture;
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

    public String getNomFacture() {
        return nomFacture;
    }

    public void setNomFacture(String nomFacture) {
        this.nomFacture = nomFacture;
    }

    public List<OffreCommerciale> getOffreCommerciales() {
        return offreCommerciales;
    }

    public void setOffreCommerciales(List<OffreCommerciale> offreCommerciales) {
        this.offreCommerciales = offreCommerciales;
    }

    public Boolean getPaiementOk() {
        return paiementOk;
    }

    public void setPaiementOk(Boolean paiementOk) {
        this.paiementOk = paiementOk;
    }

    public List<Reglement> getReglements() {
        return reglements;
    }

    public void setReglements(List<Reglement> reglements) {
        this.reglements = reglements;
    }

    public Float getSoldeHT() {
        return soldeHT;
    }

    public void setSoldeHT(Float soldeHT) {
        this.soldeHT = soldeHT;
    }

    public Float getSoldePaye() {
        return soldePaye;
    }

    public void setSoldePaye(Float soldePaye) {
        this.soldePaye = soldePaye;
    }

    public Float getSoldeTVA() {
        return soldeTVA;
    }

    public void setSoldeTVA(Float soldeTVA) {
        this.soldeTVA = soldeTVA;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davidhodin.freeerp.data.comptabilite.Facture[ id=" + id + " ]";
    }
    
}
