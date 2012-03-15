/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class EtatEvenementFacade extends AbstractFacade<EtatEvenement> {
    @PersistenceContext(unitName = "com.davidhodin_freeERP_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtatEvenementFacade() {
        super(EtatEvenement.class);
    }
    
}
