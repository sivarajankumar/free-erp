/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.production;

import com.davidhodin.freeerp.data.configuration.ZoneGeo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class Stock implements Serializable {

    @OneToMany(mappedBy = "stock")
    private List<StockProduit> stockProduits;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomStock;
    @ManyToOne
    @NotNull
    private ZoneGeo zoneStock;

    public ZoneGeo getZoneStock() {
        return zoneStock;
    }

    public void setZoneStock(ZoneGeo zoneStock) {
        this.zoneStock = zoneStock;
    }

    public String getNomStock() {
        return nomStock;
    }

    public void setNomStock(String nomStock) {
        this.nomStock = nomStock;
    }

    public List<StockProduit> getStockProduits() {
        return stockProduits;
    }

    public void setStockProduits(List<StockProduit> stockProduits) {
        this.stockProduits = stockProduits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomStock + "|" + zoneStock.toString();
    }
}
