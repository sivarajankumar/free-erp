/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.commercial;

import com.davidhodin.freeerp.data.tiers.Contact;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "com.davidhodin_freeERP_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFacade() {
        super(Contact.class);
    }
    
}
