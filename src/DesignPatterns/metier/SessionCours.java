/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.sql.Date;

/**
 *
 * @author donof
 */
public class SessionCours {
    
    private int idsessioncours;
    private Date datedebut;
    private Date datefin;
    private int nbreinscrits;

    public SessionCours(int idsessioncours, Date datedebut, Date datefin, int nbreinscrits) {
        this.idsessioncours = idsessioncours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
    }

    public int getIdsessioncours() {
        return idsessioncours;
    }

    public void setIdsessioncours(int idsessioncours) {
        this.idsessioncours = idsessioncours;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getNbreinscrits() {
        return nbreinscrits;
    }

    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idsessioncours;
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
        final SessionCours other = (SessionCours) obj;
        if (this.idsessioncours != other.idsessioncours) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
