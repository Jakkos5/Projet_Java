/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.metier;

/**
 * classe metier des infos 
 * @author donof
 * version 1.0
 */
public class Infos {
    /**
     * nombres d'heures pour chaque session
     */
    protected int nbheures;
    /**
     * idendifiant d'une session de cours
     */
    protected int idsessioncours;
    /**
     * identifiant du formateur
     */
    protected int idform;
    
    
    /**
     * constructeur par défaut
     */
    public Infos(){
        
    }
    
    /**
     * constructeur paramétré
     * @param nbheures
     * @param idsessioncours
     * @param idform 
     */
    public Infos(int nbheures, int idsessioncours, int idform) {
        this.nbheures = nbheures;
        this.idsessioncours = idsessioncours;
        this.idform = idform;
    }

    /**
     * getter du nombre d'heures
     * @return le nombre d'heures
     */
    public int getNbheures() {
        return nbheures;
    }
    /**
     * setter du nombre d'heures
     * @param nbheures nombre d'heures
     */
    public void setNbheures(int nbheures) {
        this.nbheures = nbheures;
    }
    /**
     * identifiant d'une session de cours
     * @return l'idenfiant d'une session de cours
     */
    public int getIdsessioncours() {
        return idsessioncours;
    }
    /**
     * setter de l'identifiant d'une session de cours
     * @param idsessioncours identifiant d'une session de cours
     */
    public void setIdsessioncours(int idsessioncours) {
        this.idsessioncours = idsessioncours;
    }
    /**
     * getter de l'identifiant du formateur
     * @return l'identifiant du formateur
     */
    public int getIdform() {
        return idform;
    }
    /**
     * setter de l'identifiant du formateur
     * @param idform identifiant du formateur
     */
    public void setIdform(int idform) {
        this.idform = idform;
    }
    /**
     * méthode toString
     * @return les infos complètes
     */
    @Override
    public String toString() {
        return "Infos{" + "nbheures=" + nbheures + ", idsessioncours=" + idsessioncours + ", idform=" + idform + '}';
    }
    
    
    
}
