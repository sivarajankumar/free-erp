/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.tiers;

import com.davidhodin.freeerp.data.tiers.Telephone;
import com.davidhodin.freeerp.data.tiers.Tiers;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Contact implements Serializable {

    @ManyToMany(mappedBy = "contacts")
    private List<Tiers> tierss;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private TitreContact titre;
    private String nom;
    private String prenom;
    private String fonction;
    @OneToOne
    private AdressePostale adressePostale;
    @OneToMany
    private List<Telephone> telephones;
    @OneToMany
    private List<AdresseNumerique> adressesElectronique;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdressePostale getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(AdressePostale adressePostale) {
        this.adressePostale = adressePostale;
    }

    public List<AdresseNumerique> getAdressesElectronique() {
        return adressesElectronique;
    }

    public void setAdressesElectronique(List<AdresseNumerique> adressesElectronique) {
        this.adressesElectronique = adressesElectronique;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public TitreContact getTitre() {
        return titre;
    }

    public void setTitre(TitreContact titre) {
        this.titre = titre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<Tiers> getTierss() {
        return tierss;
    }

    public void setTierss(List<Tiers> tierss) {
        this.tierss = tierss;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (titre != null) {
            return titre.getNomTitre() + " " + prenom + " " + nom + " - " + fonction;
        } else {
            return prenom + " " + nom + " - " + fonction;
        }
    }
}
