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
public class EtatOffre implements Serializable {
    @OneToMany(mappedBy = "etatOffre")
    private List<OffreCommerciale> offreCommerciales;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String etatOffre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtatOffre() {
        return etatOffre;
    }

    public void setEtatOffre(String etatOffre) {
        this.etatOffre = etatOffre;
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
        if (!(object instanceof EtatOffre)) {
            return false;
        }
        EtatOffre other = (EtatOffre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return etatOffre;
    }
    
}
