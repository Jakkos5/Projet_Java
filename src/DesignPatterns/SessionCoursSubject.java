/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import java.sql.Date;

/**
 *
 * @author donof
 */


public class SessionCoursSubject extends Subject {

    protected int idsessioncours;
    /**
     * date de debut d'une session de cours
     */
    protected Date datedebut;
    /**
     * date de fin d'une session de cours
     */
    protected Date datefin;
    /**
     * nombres d'inscrits d'une session de cours
     */
    protected int nbreinscrits;
    /**
     * identifiant d'un cours
     */
    protected int idcours;
    /**
     * identifiant d'un local
     */
    protected int idlocal;

    public SessionCoursSubject(int idsessioncours, Date datedebut, Date datefin, int nbreinscrits, int idcours, int idlocal) {
        this.idsessioncours = idsessioncours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
        this.idcours = idcours;
        this.idlocal = idlocal;
       
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

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "SessionCoursSubject{" + "idsessioncours=" + idsessioncours + ", datedebut=" + datedebut + ", datefin=" + datefin + ", nbreinscrits=" + nbreinscrits + ", idcours=" + idcours + ", idlocal=" + idlocal + '}';
    }

    @Override
    public String getNotification() {
        return "Le nouveau local de la session de cours numéro " + idsessioncours + " est le local n°" + idlocal;
    }
}
