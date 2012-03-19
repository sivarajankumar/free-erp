/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidhodin.freeerp.data.configuration;

import com.davidhodin.freeerp.data.production.Stock;
import com.davidhodin.freeerp.data.tiers.AdressePostale;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Entity
public class ZoneGeo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nomZone;
    @ManyToOne
    private AdressePostale adressePostale;
    @ManyToOne
    private ZoneGeo zoneParent;
    private String descriptionZone;
    @OneToMany(mappedBy = "zoneStock")
    private List<Stock> stocks;
    @OneToMany(mappedBy = "zoneParent")
    private List<ZoneGeo> zones;
    
    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public AdressePostale getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(AdressePostale adressePostale) {
        this.adressePostale = adressePostale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionZone() {
        return descriptionZone;
    }

    public void setDescriptionZone(String descriptionZone) {
        this.descriptionZone = descriptionZone;
    }

    public String getNomZone() {
        return nomZone;
    }

    public void setNomZone(String nomZone) {
        this.nomZone = nomZone;
    }

    public ZoneGeo getZoneParent() {
        return zoneParent;
    }

    public void setZoneParent(ZoneGeo zoneParent) {
        this.zoneParent = zoneParent;
    }

    public List<ZoneGeo> getZones() {
        return zones;
    }

    public void setZones(List<ZoneGeo> zones) {
        this.zones = zones;
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
        if (!(object instanceof ZoneGeo)) {
            return false;
        }
        ZoneGeo other = (ZoneGeo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomZone;
    }
    
}
