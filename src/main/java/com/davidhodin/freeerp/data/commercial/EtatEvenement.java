/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class EtatEvenement implements Serializable {
    @OneToMany(mappedBy = "etatEvenement")
    private List<Evenement> evenements;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String etatEvenement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtatEvenement() {
        return etatEvenement;
    }

    public void setEtatEvenement(String etatEvenement) {
        this.etatEvenement = etatEvenement;
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
        if (!(object instanceof EtatEvenement)) {
            return false;
        }
        EtatEvenement other = (EtatEvenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return etatEvenement;
    }
    
}
