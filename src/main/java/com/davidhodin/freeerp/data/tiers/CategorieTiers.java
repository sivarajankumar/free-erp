/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.tiers;

import com.davidhodin.freeerp.data.tiers.Tiers;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class CategorieTiers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomCategorie;
    @OneToMany(mappedBy = "categorie")
    private List<Tiers> tierss;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tiers> getTierss() {
        return tierss;
    }

    public void setTierss(List<Tiers> tierss) {
        this.tierss = tierss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public boolean equals(Object object) {
        // Info: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieTiers)) {
            return false;
        }
        CategorieTiers other = (CategorieTiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomCategorie;
    }
    
}
