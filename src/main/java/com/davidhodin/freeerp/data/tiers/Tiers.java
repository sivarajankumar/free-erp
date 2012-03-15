/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.tiers;

import com.davidhodin.freeerp.data.commercial.OffreCommerciale;
import com.davidhodin.freeerp.data.configuration.Logos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Tiers implements Serializable {
    @OneToMany(mappedBy = "tiers")
    private List<OffreCommerciale> offreCommerciales;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomTiers;
    @ManyToOne
    private TypeTiers typeTiers;
    private String codeTiers;
    @ManyToMany
    private List<Contact> contacts;
    @ManyToOne
    private CategorieTiers categorie;
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

    public String getCodeTiers() {
        return codeTiers;
    }

    public void setCodeTiers(String codeTiers) {
        this.codeTiers = codeTiers;
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
