/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.mydata;

import java.util.Objects;

/**
 *
 * @author jens.papenhagen
 */
public class Artikel {
    
    private final int id;
    private final String artikelname;
    private final double wiegth;
    private final double price;

    public Artikel(int id, String artikelname, double wiegth, double price) {
        this.id = id;
        this.artikelname = artikelname;
        this.wiegth = wiegth;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getArtikelname() {
        return artikelname;
    }

    public double getWiegth() {
        return wiegth;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.artikelname);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.wiegth) ^ (Double.doubleToLongBits(this.wiegth) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artikel other = (Artikel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.wiegth) != Double.doubleToLongBits(other.wiegth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.artikelname, other.artikelname)) {
            return false;
        }
        return true;
    }

   

   
    
    
}
