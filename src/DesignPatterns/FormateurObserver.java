/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author donof
 */
public class FormateurObserver extends Observer{

    protected int idform;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected int cp;
    protected String localite;
    protected String rue;
    protected String num;
    protected String tel;
    protected Set<InfosD> mesInfos = new HashSet<>();

    public FormateurObserver(int idform, String matricule, String nom, String prenom, int cp, String localite, String rue, String num, String tel) {
        this.idform = idform;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
        this.tel = tel;
    }
       
    public int getIdform() {
        return idform;
        
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<InfosD> getMesInfos() {
        return mesInfos;
    }

    public void setMesInfos(Set<InfosD> mesInfos) {
        this.mesInfos = mesInfos;
    }

    @Override
    public String toString() {
        return "FormateurObserver{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + ", tel=" + tel + '}';
    }

    
    @Override
    public void update(String msg) {
        System.out.println(prenom + " " + nom + " a reçu le msg :" + msg);
    }

}
