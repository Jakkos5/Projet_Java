/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 *
 * @author donof
 */
public class Cours {

    private int idcours;
    private String matiere;
    private int heures;
    private Set<SessionCours> session = new HashSet<>();

    public Cours(int idcours, String matiere, int heures) {
        this.idcours = idcours;
        this.matiere = matiere;
        this.heures = heures;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public Set<SessionCours> getSession() {
        return session;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idcours;
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
        final Cours other = (Cours) obj;
        if (this.idcours != other.idcours) {
            return false;
        }
        return true;
    }

}
