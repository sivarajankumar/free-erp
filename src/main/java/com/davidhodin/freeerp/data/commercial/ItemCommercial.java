/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.comptabilite.TVA;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class ItemCommercial implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomItem;
    @NotNull
    private Float quantite;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Service service;
    private Float montantHT;
    @ManyToOne
    private TVA tauxTVA;

    public ItemCommercial() {
    quantite = 1f;
    montantHT = 0f;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(Float montantHT) {
        this.montantHT = montantHT;
    }

    public TVA getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(TVA tauxTVA) {
        this.tauxTVA = tauxTVA;
    }


    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
        if (!(object instanceof ItemCommercial)) {
            return false;
        }
        ItemCommercial other = (ItemCommercial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomItem + " - Quantité : " + quantite.toString();
    }
    
}
