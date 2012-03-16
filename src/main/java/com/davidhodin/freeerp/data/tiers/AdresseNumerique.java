/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.tiers;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class AdresseNumerique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CategorieAdresseNumerique categorieAdresse;
    @NotNull
    private String adresseNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresseNum() {
        return adresseNum;
    }

    public void setAdresseNum(String adresseNum) {
        this.adresseNum = adresseNum;
    }

    public CategorieAdresseNumerique getCategorieAdresse() {
        return categorieAdresse;
    }

    public void setCategorieAdresse(CategorieAdresseNumerique categorieAdresse) {
        this.categorieAdresse = categorieAdresse;
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
        if (!(object instanceof AdresseNumerique)) {
            return false;
        }
        AdresseNumerique other = (AdresseNumerique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (categorieAdresse != null) {
            return categorieAdresse.getNomCategorie() + " : " + adresseNum;
        } else {
            return adresseNum;
        }
    }
}
