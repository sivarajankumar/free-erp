/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Product implements Serializable {
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
    private Float prixVente;
    private Float TVA;
    @ManyToOne
    private Categorie categorie;
    @ManyToMany
    private List<Stock> stocksProduit;
    

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTVA() {
        return TVA;
    }

    public void setTVA(Float TVA) {
        this.TVA = TVA;
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

    public Float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Float prixVente) {
        this.prixVente = prixVente;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
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
