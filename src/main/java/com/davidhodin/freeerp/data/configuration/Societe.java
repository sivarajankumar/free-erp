/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.configuration;

import com.davidhodin.freeerp.data.tiers.AdresseNumerique;
import com.davidhodin.freeerp.data.tiers.AdressePostale;
import com.davidhodin.freeerp.data.tiers.Telephone;
import com.davidhodin.freeerp.data.tiers.TypeTiers;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Societe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomSociete;
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
    private AdressePostale adressesPost;
    @OneToMany
    private List<AdresseNumerique> adressesNum;
    @OneToMany
    private List<Telephone> telephones;
    @OneToMany
    private List<ZoneGeo> sites;
    @ManyToOne
    private Logos logo;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AdresseNumerique> getAdressesNum() {
        return adressesNum;
    }

    public void setAdressesNum(List<AdresseNumerique> adressesNum) {
        this.adressesNum = adressesNum;
    }

    public AdressePostale getAdressesPost() {
        return adressesPost;
    }

    public void setAdressesPost(AdressePostale adressesPost) {
        this.adressesPost = adressesPost;
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

    public Logos getLogo() {
        return logo;
    }

    public void setLogo(Logos logo) {
        this.logo = logo;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getNumTVA() {
        return numTVA;
    }

    public void setNumTVA(String numTVA) {
        this.numTVA = numTVA;
    }

    public List<ZoneGeo> getSites() {
        return sites;
    }

    public void setSites(List<ZoneGeo> sites) {
        this.sites = sites;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Boolean getTva() {
        return tva;
    }

    public void setTva(Boolean tva) {
        this.tva = tva;
    }

    public TypeTiers getTypeTiers() {
        return typeTiers;
    }

    public void setTypeTiers(TypeTiers typeTiers) {
        this.typeTiers = typeTiers;
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
        if (!(object instanceof Societe)) {
            return false;
        }
        Societe other = (Societe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomSociete;
    }
    
}
