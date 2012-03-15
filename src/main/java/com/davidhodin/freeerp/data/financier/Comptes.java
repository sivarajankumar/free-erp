/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.financier;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
public class Comptes implements Serializable {
    @OneToMany(mappedBy = "compteAssocie")
    private List<Rapprochement> rapprochements;
    @OneToMany(mappedBy = "compte")
    private List<Mouvement> mouvements;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomCompte;
    private String description;
    private Boolean compteBancaire;
    @ManyToOne
    private Banque banque;
    private Float soldeCompte;
    @ManyToOne
    private TypeCompte typeCompte;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public Float getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(Float soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Boolean getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(Boolean compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Mouvement> getMouvements() {
        return mouvements;
    }

    public void setMouvements(List<Mouvement> mouvements) {
        this.mouvements = mouvements;
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
        if (!(object instanceof Comptes)) {
            return false;
        }
        Comptes other = (Comptes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.davidhodin.freeerp.data.financier.Comptes[ id=" + id + " ]";
    }
    
}
