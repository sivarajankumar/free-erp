/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.comptabilite;

import com.davidhodin.freeerp.data.financier.Mouvement;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Reglement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomReglement;
    private Float soldeReglement;
    @ManyToOne
    private CategorieReglement categorieReglement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateReglement;
    @ManyToOne
    private Mouvement mouvement;
    @ManyToOne
    private Facture facture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReglement() {
        return dateReglement;
    }

    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Mouvement getMouvement() {
        return mouvement;
    }

    public void setMouvement(Mouvement mouvement) {
        this.mouvement = mouvement;
    }

    public String getNomReglement() {
        return nomReglement;
    }

    public void setNomReglement(String nomReglement) {
        this.nomReglement = nomReglement;
    }

    public Float getSoldeReglement() {
        return soldeReglement;
    }

    public void setSoldeReglement(Float soldeReglement) {
        this.soldeReglement = soldeReglement;
    }

    public CategorieReglement getCategorieReglement() {
        return categorieReglement;
    }

    public void setCategorieReglement(CategorieReglement categorieReglement) {
        this.categorieReglement = categorieReglement;
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
        if (!(object instanceof Reglement)) {
            return false;
        }
        Reglement other = (Reglement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String retour;
        if (categorieReglement != null) {
            retour = categorieReglement.getNomCategorie() + " - " + nomReglement;
        } else {
            retour = nomReglement;
        }
        return retour;
    }
}
