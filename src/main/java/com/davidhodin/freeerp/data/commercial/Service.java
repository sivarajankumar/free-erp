/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.comptabilite.TVA;
import com.davidhodin.freeerp.data.configuration.Pays;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private String nomService;
    @ManyToOne
    private CategorieService categorieService;
    // Information commerciales
    @ManyToOne
    private EtatCommercial etatCommercial;
    private Float prixVente;
    @ManyToOne
    private TVA tvaVente;
    private Float prixAchat;
    @ManyToOne
    private TVA tvaAchat;
    private String codeDouane;
    private String informationFacture;
    // Information description
    @ManyToOne
    private Pays paysOrigine;
    private String description;

    public Service() {
    prixAchat = 0f;
    prixVente = 0f;    
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

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
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

    public CategorieService getCategorieService() {
        return categorieService;
    }

    public void setCategorieService(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    public String getInformationFacture() {
        return informationFacture;
    }

    public void setInformationFacture(String informationFacture) {
        this.informationFacture = informationFacture;
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

    public EtatCommercial getEtatCommercial() {
        return etatCommercial;
    }

    public void setEtatCommercial(EtatCommercial etatCommercial) {
        this.etatCommercial = etatCommercial;
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
        if (reference != null) {
            return nomService + " (" + reference + ")";
        } else {
            return nomService;
        }
    }
}
