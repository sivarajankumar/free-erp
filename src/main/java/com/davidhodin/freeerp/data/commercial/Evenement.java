/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.tiers.Contact;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CategorieEvenement categorieEvenement;
    private String nomEvenement;
    private String descriptionEvenement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreationEvenement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMajEvenement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateClotureEvenement;
    @ManyToOne
    private EtatEvenement etatEvenement;
    @ManyToOne
    private Contact contact;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieEvenement getCategorieEvenement() {
        return categorieEvenement;
    }

    public void setCategorieEvenement(CategorieEvenement categorieEvenement) {
        this.categorieEvenement = categorieEvenement;
    }

    public Date getDateClotureEvenement() {
        return dateClotureEvenement;
    }

    public void setDateClotureEvenement(Date dateClotureEvenement) {
        this.dateClotureEvenement = dateClotureEvenement;
    }

    public Date getDateCreationEvenement() {
        return dateCreationEvenement;
    }

    public void setDateCreationEvenement(Date dateCreationEvenement) {
        this.dateCreationEvenement = dateCreationEvenement;
    }

    public Date getDateMajEvenement() {
        return dateMajEvenement;
    }

    public void setDateMajEvenement(Date dateMajEvenement) {
        this.dateMajEvenement = dateMajEvenement;
    }

    public String getDescriptionEvenement() {
        return descriptionEvenement;
    }

    public void setDescriptionEvenement(String descriptionEvenement) {
        this.descriptionEvenement = descriptionEvenement;
    }

    public EtatEvenement getEtatEvenement() {
        return etatEvenement;
    }

    public void setEtatEvenement(EtatEvenement etatEvenement) {
        this.etatEvenement = etatEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davidhodin.freeerp.data.commercial.Evenement[ id=" + id + " ]";
    }
    
}
