/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author donof
 */
public class Local {
    
    private int idlocal;
    private String sigle;
    private int places;
    private String description;
    private Set<SessionCours> session = new HashSet<>();

    public Local(int idlocal, String sigle, int places, String description) {
        this.idlocal = idlocal;
        this.sigle = sigle;
        this.places = places;
        this.description = description;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SessionCours> getSession() {
        return session;
    }

    public void setSession(Set<SessionCours> session) {
        this.session = session;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.sigle);
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
        final Local other = (Local) obj;
        if (!Objects.equals(this.sigle, other.sigle)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
