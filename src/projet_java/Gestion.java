/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import formation.metier.Locaux;
import formation.DAO.DAO;
import formation.DAO.FormateurDAO;
import formation.DAO.LocauxDAO;
import formation.metier.Formateur;
import formation.metier.SessionCours;
import myconnections.DBConnection;

/**
 *
 * @author donof
 */
public class Gestion{

    Scanner sc = new Scanner(System.in);
    Locaux lcActuel = null;
    Formateur fmActuel = null;
    DAO<Locaux> locauxDAO = null;
    DAO<Formateur> formateurDAO = null;

    public Gestion(){

    }

    public void menu(){

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("Connexion établie\n");

        locauxDAO = new LocauxDAO();
        locauxDAO.setConnection(dbConnect);
        formateurDAO = new FormateurDAO();
        formateurDAO.setConnection(dbConnect);

        //menu permettant de choisir la classe avec laquelle on souhaite travailler
        int choix = 0;
        do{
        System.out.println("1.Locaux \n2.Formateur \n3.Infos \n4.Sessioncours \n5.Fin");
        System.out.println("Choix: ");
        choix = sc.nextInt();
        sc.skip("\n");
        switch (choix){
            case 1 : int ch = 0;
                        //menu Locaux et vues
                        do {
                            System.out.println("1.Nouveau \n2.Recherche\n3.Recherche sur la description\n4.Modification\n5.Suppresion.\n6.Affichage Sessions\n7.Affichage heures par session\n8.Fin\n");
                            System.out.print("choix :");
                            ch = sc.nextInt();
                            sc.skip("\n");
                            switch (ch) {
                                case 1:
                                    insertionLocaux();
                                    break;
                                case 2:
                                    rechercheLocaux();
                                    break;
                                case 3:
                                    rechDescription();
                                    break;
                                case 4:
                                    modificationLocaux();
                                    break;
                                case 5:
                                    suppressionLocaux();
                                    break;
                                case 6:
                                    affSession();
                                    break;
                                case 7:
                                    affHeures();
                                    break;
                                case 8:
                                    System.out.println("bye");
                                    break;
                                default:
                                    System.out.println("choix incorrect");
                            }

                        } while (ch != 8);
                        
            case 2 :  int ch1 = 0;
                        //menu pour les formateurs
                        do {
                            System.out.println("1.Nouveau \n2.Recherche\n3.Modification\n4.Suppresion.\n5.Fin\n");
                            System.out.print("choix :");
                            ch1 = sc.nextInt();
                            sc.skip("\n");
                            switch (ch1) {
                                case 1:
                                    insertionFormateur();
                                    break;
                                case 2:
                                    rechercheFormateur();
                                    break;
                                case 3:
                                    modificationFormateur();
                                    break;
                                case 4:
                                    suppressionFormateur();  
                                case 5:
                                    System.out.println("bye");
                                    break;
                                default:
                                    System.out.println("choix incorrect");
                            }
                            
                        } while (ch1 != 5);  
            case 5 :System.out.println("Aurevoir");
            break;
            default: System.out.println("Choix incorrect");
        }}while(choix != 5);
        
        DBConnection.closeConnection();
    }

    public void insertionLocaux(){

        System.out.print("sigle :");
        String sigle = sc.nextLine();
        System.out.print("places:");
        int places = sc.nextInt();
        sc.skip("\n");
        System.out.print("Description :");
        String description = sc.nextLine();
        lcActuel = new Locaux(0, sigle, places, description);
        try {
            lcActuel = locauxDAO.create(lcActuel);
            System.out.println("local actuel : " + lcActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void rechercheLocaux(){
        try {
            System.out.println("numéro recherché :");
            int nc = sc.nextInt();
            lcActuel = locauxDAO.read(nc);
            System.out.println("local actuel : " + lcActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    

    public void modificationLocaux(){
        try {
            System.out.println("Sigle: ");
            String sigle = sc.nextLine();
            lcActuel.setSigle(sigle);
            System.out.println("places :");
            int places = sc.nextInt();
            sc.skip("\n");
            lcActuel.setPlaces(places);
            System.out.println("Description: ");
            String desc = sc.nextLine();
            lcActuel.setDescription(desc);
            locauxDAO.update(lcActuel);
            System.out.println("ligne modifiée\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void suppressionLocaux(){
        try {
            locauxDAO.delete(lcActuel);
            System.out.println("Ligne supprimée\n");
        }catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

     public void rechDescription() {
        System.out.println("description recherchée : ");
        String desc = sc.nextLine();
        try {
            List<Locaux> lcx = ((LocauxDAO) locauxDAO).rechDescription(desc);
            for (Locaux lc : lcx) {
                System.out.println(lc);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
  
    
    public void affSession(){
        System.out.println("Id du formateur : ");
        int idform = sc.nextInt();
        try {
            List<SessionCours> SC = ((FormateurDAO) formateurDAO).affSession(idform);
            for (SessionCours S : SC) {
                System.out.println(S);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
        
    }
    
    public void affHeures() {
        try {
            System.out.println("Id de la session de cours: ");
            int id = sc.nextInt();
            
            int heures = ((FormateurDAO) formateurDAO).totHeures(id);
            
            System.out.println("Heures totales de cette session: "+heures+"\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    
    public void insertionFormateur(){
        System.out.print("Matricule :");
        String matricule = sc.nextLine();
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.println("Prenom: ");
        String prenom = sc.nextLine();
        System.out.println("Rue: ");
        String rue = sc.nextLine();
        System.out.println("Localite: ");
        String localite = sc.nextLine();
        System.out.println("Code postal: ");
        Short CP = sc.nextShort();
        sc.skip("\n");
        System.out.println("Telephone: ");
        String tel = sc.nextLine();
        
        fmActuel = new Formateur(0, matricule, nom, prenom,rue,localite,CP,tel);
        try {
            fmActuel = formateurDAO.create(fmActuel);
            System.out.println("formateur actuel : " + fmActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }
    
    public void rechercheFormateur(){
        
    }
    
    public void modificationFormateur(){
        
    }
    
    public void suppressionFormateur(){
        
    }
      public static void main(String[] args) {
        Gestion g = new Gestion();
        g.menu();
    }
}
