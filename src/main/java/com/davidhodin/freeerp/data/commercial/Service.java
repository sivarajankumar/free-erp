/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.comptabilite.TVA;
import com.davidhodin.freeerp.data.configuration.Pays;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Service implements Serializable {

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
    private String codeDouane;
    @ManyToOne
    private Pays paysOrigine;
    private String description;
    private Float prix;
    @ManyToOne
    private TVA tva;
    @ManyToOne
    private CategorieProduit categorie;

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davidhodin.freeerp.data.Service[ id=" + id + " ]";
    }
}
