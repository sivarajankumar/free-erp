/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author david
 */
@ManagedBean(name = "generalControleur")
@RequestScoped
public class GeneralControleur {
    
    /**
     * Creates a new instance of GeneralControleur
     */
    public GeneralControleur() {
    }
    
    // Configuration
    public String adressePostale() {
        return "index";
    }
}
