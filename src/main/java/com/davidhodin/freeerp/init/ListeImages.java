/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.init;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author david
 */
@ManagedBean
@RequestScoped
public class ListeImages {

    private List<String> images;

    /**
     * Creates a new instance of ListeImages
     */
    public ListeImages() {
        // Initialisation des images
        images = new ArrayList<String>();
        images.add("Contact.png");
        images.add("Vente.png");
        images.add("achats.png");
        images.add("banque.png");
        images.add("categorie.png");
        images.add("comptabilite.png");
        images.add("compte.png");
        images.add("facture.png");
        images.add("produit.png");
        images.add("references.png");
        images.add("service.png");
        images.add("statut.png");
        images.add("tiers.png");
    }

    public List<String> getImages() {
        return images;
    }
}
