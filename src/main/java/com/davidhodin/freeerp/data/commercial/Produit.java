/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.comptabilite.TVA;
import com.davidhodin.freeerp.data.configuration.Pays;
import com.davidhodin.freeerp.data.production.Stock;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

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
    private String label;
    @ManyToOne
    private Etat_SeviceProduit etatVente;
    @ManyToOne
    private Etat_SeviceProduit etatAchat;
    private Integer stockAlert;
    private String description;
    private Integer poids;
    private Integer volume;
    private String codeDouane;
    @ManyToOne
    private Pays paysOrigine;
    private String informationFacture;
    private Float prix;
    @ManyToOne
    private TVA tva;
    @ManyToOne
    private CategorieProduit categorie;
    @ManyToMany
    private List<Stock> stocksProduit;

    

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Pays getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(Pays paysOrigine) {
        this.paysOrigine = paysOrigine;
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

    public Etat_SeviceProduit getEtatAchat() {
        return etatAchat;
    }

    public void setEtatAchat(Etat_SeviceProduit etatAchat) {
        this.etatAchat = etatAchat;
    }

    public Etat_SeviceProduit getEtatVente() {
        return etatVente;
    }

    public void setEtatVente(Etat_SeviceProduit etatVente) {
        this.etatVente = etatVente;
    }

    public List<Stock> getStocksProduit() {
        return stocksProduit;
    }

    public void setStocksProduit(List<Stock> stocksProduit) {
        this.stocksProduit = stocksProduit;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public TVA getTva() {
        return tva;
    }

    public void setTva(TVA tva) {
        this.tva = tva;
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
        return "com.davidhodin.freeerp.data.Product[ id=" + id + " ]";
    }
    
}
