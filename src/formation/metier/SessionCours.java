/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.metier;

import java.sql.Date;

/**
 * classe metier session de cours
 * @author donof
 * version 1.0
 */
public class SessionCours {
    
    /**
     * identifiant unique d'une session de cours
     */
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
    
    /**
     * constructeur par défaut
     */
    public SessionCours(){
        
    }
    
    /**
     * constructeur paramétré
     * @param idsessioncours
     * @param datedebut
     * @param datefin
     * @param nbreinscrits
     * @param idcours
     * @param idlocal 
     */
    public SessionCours(int idsessioncours, Date datedebut, Date datefin, int nbreinscrits, int idcours, int idlocal) {
        this.idsessioncours = idsessioncours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
        this.idcours = idcours;
        this.idlocal = idlocal;
    }

    /**
     * identifiant d'une session de cours
     * @return l'identifiant d'une session de cours
     */
    public int getIdsessioncours() {
        return idsessioncours;
    }
    /**
     * setter d'une session de cours
     * @param idsessioncours 
     */
    public void setIdsessioncours(int idsessioncours) {
        this.idsessioncours = idsessioncours;
    }
    /**
     * getter de la date de debut d'une session de cours
     * @return la date de debut
     */
    public Date getDatedebut() {
        return datedebut;
    }
    /**
     * setter de la date de debut d'une session de cours
     * @param datedebut 
     */
    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }
    /**
     * getter de la date de fin d'une session de cours
     * @return la date de fin
     */
    public Date getDatefin() {
        return datefin;
    }
    /**
     * setter de la date de fin d'une session de cours
     * @param datefin 
     */
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
    /**
     * getter du nombres d'inscrits à une session de cours
     * @return le nombre d'inscrits
     */
    public int getNbreinscrits() {
        return nbreinscrits;
    }
    /**
     * setter du nombre d'inscrits à une session de cours
     * @param nbreinscrits 
     */
    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }
    /**
     * getter de l'identifiant du cours
     * @return l'indentifiant du cours
     */
    public int getIdcours() {
        return idcours;
    }
    /**
     * setter de l'identifiant du cours
     * @param idcours identifiant du cours
     */
    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }
    /**
     * getter de l'identifiant du local
     * @return l'identifiant du local
     */
    public int getIdlocal() {
        return idlocal;
    }
    /**
     * setter de l'identifiant du local
     * @param idlocal identifiant du local
     */
    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }
    /**
     * méthode toString
     * @return les infos complètes
     */
    @Override
    public String toString() {
        return "SessionCours{" + "idsessioncours=" + idsessioncours + ", datedebut=" + datedebut + ", datefin=" + datefin + ", nbreinscrits=" + nbreinscrits + ", idcours=" + idcours + ", idlocal=" + idlocal + '}';
    }
    
    
    
    
}
