/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.tiers;

import com.davidhodin.freeerp.data.configuration.Pays;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class AdressePostale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String labelAdresse;
    private String ligne1Adresse;
    private String ligne2Adresse;
    private String ligne3Adresse;
    private String codePostal;
    private String ville;
    @ManyToOne
    private Pays pays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLabelAdresse() {
        return labelAdresse;
    }

    public void setLabelAdresse(String labelAdresse) {
        this.labelAdresse = labelAdresse;
    }

    public String getLigne1Adresse() {
        return ligne1Adresse;
    }

    public void setLigne1Adresse(String ligne1Adresse) {
        this.ligne1Adresse = ligne1Adresse;
    }

    public String getLigne2Adresse() {
        return ligne2Adresse;
    }

    public void setLigne2Adresse(String ligne2Adresse) {
        this.ligne2Adresse = ligne2Adresse;
    }

    public String getLigne3Adresse() {
        return ligne3Adresse;
    }

    public void setLigne3Adresse(String ligne3Adresse) {
        this.ligne3Adresse = ligne3Adresse;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
        if (!(object instanceof AdressePostale)) {
            return false;
        }
        AdressePostale other = (AdressePostale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davidhodin.freeerp.data.Adresse[ id=" + id + " ]";
    }
    
}
