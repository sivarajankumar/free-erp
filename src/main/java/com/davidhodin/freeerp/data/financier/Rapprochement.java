/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.financier;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Rapprochement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomRapprochement;
    private String identifiantReleve;
    @ManyToOne
    private Comptes compteAssocie;
    private Float montantTotalDebit;
    private Float montantTotalCredit;
    private Float montantDebitRapproche;
    private Float montantCreditRapproche;
    @OneToMany(mappedBy = "rapprochement")
    private List<Mouvement> mouvements;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comptes getCompteAssocie() {
        return compteAssocie;
    }

    public void setCompteAssocie(Comptes compteAssocie) {
        this.compteAssocie = compteAssocie;
    }

    public String getIdentifiantReleve() {
        return identifiantReleve;
    }

    public void setIdentifiantReleve(String identifiantReleve) {
        this.identifiantReleve = identifiantReleve;
    }

    public Float getMontantCreditRapproche() {
        return montantCreditRapproche;
    }

    public void setMontantCreditRapproche(Float montantCreditRapproche) {
        this.montantCreditRapproche = montantCreditRapproche;
    }

    public Float getMontantDebitRapproche() {
        return montantDebitRapproche;
    }

    public void setMontantDebitRapproche(Float montantDebitRapproche) {
        this.montantDebitRapproche = montantDebitRapproche;
    }

    public Float getMontantTotalCredit() {
        return montantTotalCredit;
    }

    public void setMontantTotalCredit(Float montantTotalCredit) {
        this.montantTotalCredit = montantTotalCredit;
    }

    public Float getMontantTotalDebit() {
        return montantTotalDebit;
    }

    public void setMontantTotalDebit(Float montantTotalDebit) {
        this.montantTotalDebit = montantTotalDebit;
    }

    public List<Mouvement> getMouvements() {
        return mouvements;
    }

    public void setMouvements(List<Mouvement> mouvements) {
        this.mouvements = mouvements;
    }

    public String getNomRapprochement() {
        return nomRapprochement;
    }

    public void setNomRapprochement(String nomRapprochement) {
        this.nomRapprochement = nomRapprochement;
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
        if (!(object instanceof Rapprochement)) {
            return false;
        }
        Rapprochement other = (Rapprochement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomRapprochement;
    }
    
}
