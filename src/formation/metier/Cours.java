/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.metier;

/**
 * classe métier d'un cours
 * @author donof
 * version 1.0
 */
public class Cours {

    
    /**
     * identifiant unique du cours
     */
    protected int idcours;
    
    /**
     * matiere du cours
     */
    protected String matiere;

    /**
     * nombre d'heures du cours
     */
    protected int heures;

    /**
     * constructeur par défaut
     */
    public Cours() {
    }

    /**
     * contructeur paramétré
     * @param idcours
     * @param matiere
     * @param heures 
     */
    public Cours(int idcours, String matiere, int heures) {
        this.idcours = idcours;
        this.matiere = matiere;
        this.heures = heures;
    }

    /**
     * getter de l'identifiant(id) du cours
     * @return l'id du cours
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
     * getter de la matiere du cours
     * @return la matiere
     */
    public String getMatiere() {
        return matiere;
    }
    
    /**
     * setter de la matiere du cours
     * @param matiere 
     */
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
    /**
     * getter du nombre d'heures du cours
     * @return les heures
     */
    public int getHeures() {
        return heures;
    }
    
    /**
     * setter du nomnbre d'heures du cours
     * @param heures 
     */
    public void setHeures(int heures) {
        this.heures = heures;
    }
    
    /**
     * méthode toString
     * @return les infos complètes
     */
    @Override
    public String toString() {
        return "Cours{" + "idcours=" + idcours + ", matiere=" + matiere + ", heures=" + heures + '}';
    }
    
    

}
