/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.financier;

import com.davidhodin.freeerp.data.comptabilite.Reglement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Mouvement implements Serializable {
    @OneToMany(mappedBy = "mouvement")
    private List<Reglement> reglements;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String labelMouvement;
    private String description;
    @ManyToOne
    private CategorieMouvement categorieMouvement;
    @ManyToOne
    private Comptes compte;
    private Boolean debit;
    private Float montant;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOperation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateValeur;
    @ManyToOne
    private Rapprochement rapprochement;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieMouvement getCategorieMouvement() {
        return categorieMouvement;
    }

    public void setCategorieMouvement(CategorieMouvement categorieMouvement) {
        this.categorieMouvement = categorieMouvement;
    }

    public Comptes getCompte() {
        return compte;
    }

    public void setCompte(Comptes compte) {
        this.compte = compte;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Date getDateValeur() {
        return dateValeur;
    }

    public void setDateValeur(Date dateValeur) {
        this.dateValeur = dateValeur;
    }

    public Boolean getDebit() {
        return debit;
    }

    public void setDebit(Boolean debit) {
        this.debit = debit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabelMouvement() {
        return labelMouvement;
    }

    public void setLabelMouvement(String labelMouvement) {
        this.labelMouvement = labelMouvement;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Rapprochement getRapprochement() {
        return rapprochement;
    }

    public void setRapprochement(Rapprochement rapprochement) {
        this.rapprochement = rapprochement;
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
        if (!(object instanceof Mouvement)) {
            return false;
        }
        Mouvement other = (Mouvement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davidhodin.freeerp.data.financier.Mouvement[ id=" + id + " ]";
    }
    
}