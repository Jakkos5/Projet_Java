/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier;

import java.util.Objects;

/**
 *
 * @author donof
 */
public class Infos {

    private int nh;
    private SessionCours session;
    private Formateur formateur;

    public Infos(SessionCours session, Formateur formateur) throws Exception {
        this.session = session;
        this.formateur = formateur;
    }

    public int getNh() {
        return nh;
    }

    public void setNh(int nh) {
        this.nh = nh;
    }

    public SessionCours getSession() {
        return session;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.session);
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
        final Infos other = (Infos) obj;
        if (!Objects.equals(this.session, other.session)) {
            return false;
        }
        return true;
    }

}
