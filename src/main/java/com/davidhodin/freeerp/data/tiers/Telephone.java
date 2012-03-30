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
public class Telephone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CategorieTelephone categorieTelephone;
    @NotNull
    private String descriptionNumero;
    private String numero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieTelephone getCategorieTelephone() {
        return categorieTelephone;
    }

    public void setCategorieTelephone(CategorieTelephone categorieTelephone) {
        this.categorieTelephone = categorieTelephone;
    }

    public String getDescriptionNumero() {
        return descriptionNumero;
    }

    public void setDescriptionNumero(String descriptionNumero) {
        this.descriptionNumero = descriptionNumero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        if (!(object instanceof Telephone)) {
            return false;
        }
        Telephone other = (Telephone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String retour;
        if (categorieTelephone != null) {
            retour = categorieTelephone.getNomCategorie() + " - " + descriptionNumero;
        } else {
            retour = descriptionNumero;
        }            
        return retour;
    }   
}
