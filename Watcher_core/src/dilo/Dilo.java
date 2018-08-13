/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dilo;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Oldřich
 */
public abstract class Dilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String nazev, nazevAnglicky;
    private ETyp typ;
    private EStav stav;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dne;
    private URL adresa, titulky;

    public long getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getNazevAnglicky() {
        return nazevAnglicky;
    }

    public void setNazevAnglicky(String nazevAnglicky) {
        this.nazevAnglicky = nazevAnglicky;
    }

    public ETyp getTyp() {
        return typ;
    }

    public void setTyp(ETyp typ) {
        this.typ = typ;
    }

    public EStav getStav() {
        return stav;
    }

    public void setStav(EStav stav) {
        this.stav = stav;
    }

    public Date getDne() {
        return dne;
    }

    public void setDne(Date dne) {
        this.dne = dne;
    }

    public URL getAdresa() {
        return adresa;
    }

    public void setAdresa(URL adresa) {
        this.adresa = adresa;
    }

    public URL getTitulky() {
        return titulky;
    }

    public void setTitulky(URL titulky) {
        this.titulky = titulky;
    }

    @Override
    public String toString() {
        return "Dilo{" + "id=" + id + ", nazev=" + nazev + ", nazevAnglicky=" + nazevAnglicky + ", typ=" + typ + ", stav=" + stav + ", dne=" + dne + ", adresa=" + adresa + ", titulky=" + titulky + '}';
    }

}
