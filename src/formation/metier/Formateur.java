/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.metier;

/**
 * classe metier d'un formateur
 * @author donof
 * @version 1.0
 */
public class Formateur {
    
    /**
     * identifiant unique du formateur
     */
    protected int idform;
    /**
     * matricule d'un formateur
     */
    protected String matricule;
    /**
     * nom d'un formateur
     */
    protected String nom;
    /**
     * prenom d'un formateur
     */
    protected String prenom;
    /**
     * rue d'un formateur
     */
    protected String rue;
    /**
     * localite d'un formateur
     */
    protected String localite;
    /**
     * code postal d'un formateur
     */
    protected short CP;
    /**
     * telephone d'un formateur
     */
    protected String tel;
    
    /**
     * constructeur par défaut
     */
    public Formateur(){
        
    }

    /**
     * constructeur paramétré
     * @param idform
     * @param matricule
     * @param nom
     * @param prenom
     * @param rue
     * @param localite
     * @param CP
     * @param tel 
     */
    public Formateur(int idform, String matricule, String nom, String prenom, String rue, String localite, short CP, String tel) {
        this.idform = idform;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.localite = localite;
        this.CP = CP;
        this.tel = tel;
    }
    /**
     * getter de l'id d'un formateur
     * @return identifiant d'un formateur
     */
    public int getIdform() {
        return idform;
    }
    /**
     * setter de l'id d'un formateur
     * @param idform identifiant d'un formateur
     */
    public void setIdform(int idform) {
        this.idform = idform;
    }
    /**
     * getter du matricule
     * @return le matricule
     */
    public String getMatricule() {
        return matricule;
    }
    /**
     * setter du matricule
     * @param matricule 
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    /**
     * getter du nom
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter du nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter du prenom
     * @return le prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter du prenom
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter de la rue
     * @return la rue
     */
    public String getRue() {
        return rue;
    }
    /**
     * setter de la rue
     * @param rue 
     */
    public void setRue(String rue) {
        this.rue = rue;
    }
    /**
     * getter de la localite
     * @return la localite
     */
    public String getLocalite() {
        return localite;
    }
    /**
     * setter de la localite
     * @param localite 
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }
    /**
     * getter du code postal
     * @return le code postal
     */
    public short getCP() {
        return CP;
    }
    /**
     * setter du code postal
     * @param CP code postal
     */
    public void setCP(short CP) {
        this.CP = CP;
    }
    /**
     * getter du telephone
     * @return le telephone
     */
    public String getTel() {
        return tel;
    }
    /**
     * setter du telephone
     * @param tel telephone
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * methode toString
     * @return les informations completes
     */
    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", localite=" + localite + ", CP=" + CP + ", tel=" + tel + '}';
    }
    
    
    
}
