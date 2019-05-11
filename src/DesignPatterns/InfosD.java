/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import java.util.Objects;

/**
 *
 * @author donof
 */
  public class InfosD {
    /**
     * nombres d'heures pour chaque session
     */
    protected int nbheures;
    /**
     * idendifiant d'une session de cours
     */
    private FormateurObserver formateur;
    
    private SessionCoursSubject session;

    public InfosD(FormateurObserver formateur,SessionCoursSubject session) {
        this.formateur = formateur;
        session.addObserver(formateur);
        
    }

    public int getNbheures() {
        return nbheures;
    }

    public void setNbheures(int nbheures) {
        this.nbheures = nbheures;
    }

    public FormateurObserver getFormateur() {
        return formateur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.formateur);
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
        final InfosD other = (InfosD) obj;
        if (!Objects.equals(this.formateur, other.formateur)) {
            return false;
        }
        return true;
    }
    
    
    
    
    

    
    
    
    
}


