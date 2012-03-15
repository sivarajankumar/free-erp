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
public class GroupeOffre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String labelGroupeOffre;
    private Boolean enCours;
    @OneToMany(mappedBy = "groupeOffre")
    private List<OffreCommerciale> offreCommerciale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnCours() {
        return enCours;
    }

    public void setEnCours(Boolean enCours) {
        this.enCours = enCours;
    }

    public String getLabelGroupeOffre() {
        return labelGroupeOffre;
    }

    public void setLabelGroupeOffre(String labelGroupeOffre) {
        this.labelGroupeOffre = labelGroupeOffre;
    }

    public List<OffreCommerciale> getOffreCommerciale() {
        return offreCommerciale;
    }

    public void setOffreCommerciale(List<OffreCommerciale> offreCommerciale) {
        this.offreCommerciale = offreCommerciale;
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
        if (!(object instanceof GroupeOffre)) {
            return false;
        }
        GroupeOffre other = (GroupeOffre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return labelGroupeOffre;
    }
    
}
