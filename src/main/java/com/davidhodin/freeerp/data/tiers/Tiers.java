/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.tiers;

import com.davidhodin.freeerp.data.commercial.Achat;
import com.davidhodin.freeerp.data.commercial.OffreCommerciale;
import com.davidhodin.freeerp.data.configuration.Logos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Tiers implements Serializable {
    @OneToMany(mappedBy = "tiers")
    private List<Achat> achats;
    @OneToMany(mappedBy = "tiers")
    private List<OffreCommerciale> offreCommerciales;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomTiers;
    @ManyToOne
    private TypeTiers typeTiers;
    private String codeInterneTiers;
    private String formeJuridique;
    private String capital;
    private Integer effectif;
    private Boolean tva;
    private String numTVA;
    private String identifiantLegal;
    @ManyToOne
    private CategorieTiers categorie;
    @ManyToMany
    private List<Contact> contacts;
    @OneToMany
    private List<AdressePostale> adressesPost;
    @OneToMany
    private List<AdresseNumerique> adressesNum;
    @OneToMany
    private List<Telephone> telephones;
    @ManyToOne
    private Logos logo;
    
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

    public String getNomTiers() {
        return nomTiers;
    }

    public void setNomTiers(String nomTiers) {
        this.nomTiers = nomTiers;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public TypeTiers getTypeTiers() {
        return typeTiers;
    }

    public void setTypeTiers(TypeTiers typeTiers) {
        this.typeTiers = typeTiers;
    }

    public CategorieTiers getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieTiers categorie) {
        this.categorie = categorie;
    }

    public List<AdresseNumerique> getAdressesNum() {
        return adressesNum;
    }

    public void setAdressesNum(List<AdresseNumerique> adressesNum) {
        this.adressesNum = adressesNum;
    }

    public List<AdressePostale> getAdressesPost() {
        return adressesPost;
    }

    public void setAdressesPost(List<AdressePostale> adressesPost) {
        this.adressesPost = adressesPost;
    }

    public Logos getLogo() {
        return logo;
    }

    public void setLogo(Logos logo) {
        this.logo = logo;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCodeInterneTiers() {
        return codeInterneTiers;
    }

    public void setCodeInterneTiers(String codeInterneTiers) {
        this.codeInterneTiers = codeInterneTiers;
    }

    public Integer getEffectif() {
        return effectif;
    }

    public void setEffectif(Integer effectif) {
        this.effectif = effectif;
    }

    public String getFormeJuridique() {
        return formeJuridique;
    }

    public void setFormeJuridique(String formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    public String getIdentifiantLegal() {
        return identifiantLegal;
    }

    public void setIdentifiantLegal(String identifiantLegal) {
        this.identifiantLegal = identifiantLegal;
    }

    public String getNumTVA() {
        return numTVA;
    }

    public void setNumTVA(String numTVA) {
        this.numTVA = numTVA;
    }

    public List<OffreCommerciale> getOffreCommerciales() {
        return offreCommerciales;
    }

    public void setOffreCommerciales(List<OffreCommerciale> offreCommerciales) {
        this.offreCommerciales = offreCommerciales;
    }

    public Boolean getTva() {
        return tva;
    }

    public void setTva(Boolean tva) {
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
        if (!(object instanceof Tiers)) {
            return false;
        }
        Tiers other = (Tiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomTiers;
    }
    
}
