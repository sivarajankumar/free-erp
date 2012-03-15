/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class ItemCommercial implements Serializable {
    @ManyToMany(mappedBy = "itemCommerciaux")
    private List<OffreCommerciale> offreCommerciales;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomItem;
    private Float quantite;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Service service;
    private Float montantHT;
    private Float montantTVA;
    
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

    public Float getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(Float montantTVA) {
        this.montantTVA = montantTVA;
    }

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public List<OffreCommerciale> getOffreCommerciales() {
        return offreCommerciales;
    }

    public void setOffreCommerciales(List<OffreCommerciale> offreCommerciales) {
        this.offreCommerciales = offreCommerciales;
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
        return nomItem;
    }
    
}
