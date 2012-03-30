/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.comptabilite.TVA;
import com.davidhodin.freeerp.data.production.StockProduit;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @NotNull
    private String nomProduit;
    @ManyToOne
    private CategorieProduit categorie;
    // Informations commerciales
    private Float prixVente;
    @ManyToOne
    private TVA tvaVente;
    @ManyToOne
    private EtatCommercial etatCommercial;
    private Float prixAchat;
    @ManyToOne
    private TVA tvaAchat;
    private String codeDouane;
    private String informationFacture;
    // Informations de production
    private Integer stockAlert;
    @OneToMany(mappedBy = "produit")
    private List<StockProduit> stocksProduit;
    // Informations produit
    private String description;
    private Integer poids;
    private Integer volume;

    public Produit() {
    prixAchat = 0f;
    prixVente = 0f;
    poids = 0;
    volume = 0;
    }
      
    public CategorieProduit getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieProduit categorie) {
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDouane() {
        return codeDouane;
    }

    public void setCodeDouane(String codeDouane) {
        this.codeDouane = codeDouane;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformationFacture() {
        return informationFacture;
    }

    public void setInformationFacture(String informationFacture) {
        this.informationFacture = informationFacture;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStockAlert() {
        return stockAlert;
    }

    public void setStockAlert(Integer stockAlert) {
        this.stockAlert = stockAlert;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public EtatCommercial getEtatCommercial() {
        return etatCommercial;
    }

    public void setEtatCommercial(EtatCommercial etatCommercial) {
        this.etatCommercial = etatCommercial;
    }

    public List<StockProduit> getStocksProduit() {
        return stocksProduit;
    }

    public void setStocksProduit(List<StockProduit> stocksProduit) {
        this.stocksProduit = stocksProduit;
    }

    public Float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Float prixVente) {
        this.prixVente = prixVente;
    }

    public TVA getTvaAchat() {
        return tvaAchat;
    }

    public void setTvaAchat(TVA tvaAchat) {
        this.tvaAchat = tvaAchat;
    }

    public TVA getTvaVente() {
        return tvaVente;
    }

    public void setTvaVente(TVA tvaVente) {
        this.tvaVente = tvaVente;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // Info: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (!"".equals(reference)) {
            return nomProduit + " (" + reference + ")";
        } else {
            return nomProduit;
        }
    }
}
