/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.metier;

/**
 * classe metier d'un local
 * @author donof
 * @version 1.0
 */
public class Locaux {
    
    /**
     * identifiant unique du local
     */
    protected int idlocal;
    /**
     * sigle du local
     */
    protected String sigle;
    /**
     * places du local
     */
    protected int places;
    /**
     * description du local
     */
    protected String description;
    /**
     * constructeur par défaut
     */
    public Locaux(){
        
    }
    /**
     * constructeur paramétré
     * @param idlocal
     * @param sigle
     * @param places
     * @param description 
     */
    public Locaux(int idlocal, String sigle, int places, String description) {
        this.idlocal = idlocal;
        this.sigle = sigle;
        this.places = places;
        this.description = description;
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
     * getter du sigle du local
     * @return le sigle du local
     */
    public String getSigle() {
        return sigle;
    }
    /**
     * setter du sigle du local
     * @param sigle sigle du local
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
    /**
     * getter des places du local
     * @return les places
     */
    public int getPlaces() {
        return places;
    }
    /**
     * setter des places du local
     * @param places 
     */
    public void setPlaces(int places) {
        this.places = places;
    }
    /**
     * getter de la description du local
     * @return la description
     */
    public String getDescription() {
        return description;
    }
    /**
     * setter de la description du local
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * méthodo toString
     * @return les infos complètes 
     */
    @Override
    public String toString() {
        return "Locaux{" + "idlocal=" + idlocal + ", sigle=" + sigle + ", places=" + places + ", description=" + description + '}';
    }
    
    
    
}
