/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

/**
 *
 * @author donof
 */
public class GestionFormateurSession {

        public static void main(String[] args) {
            SessionCoursSubject sc = new SessionCoursSubject(1,null,null,5,1,3);
            SessionCoursSubject sc2 = new SessionCoursSubject(2,null,null,4,3,5);
            FormateurObserver fm1 = new FormateurObserver(1,"SBB-634","Durand", "Jean", 1000, "BXL","de la Senne","12A ","0456/990088");
            FormateurObserver fm2 = new FormateurObserver(2,"VTE-538","Dupont", "Luc", 1550, "Mons","Marabou","7301 ","078963214");
            sc.addObserver(fm1);
            sc.addObserver(fm2);
            sc2.addObserver(fm1);
            
            sc.setIdlocal(7);
            sc2.setIdlocal(11);


        }
}
