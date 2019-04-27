/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;

import formation.DAO.CoursDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import formation.metier.Locaux;
import formation.DAO.DAO;
import formation.DAO.FormateurDAO;
import formation.DAO.LocauxDAO;
import formation.DAO.SessionCoursDAO;
import formation.metier.Cours;
import formation.metier.Formateur;
import formation.metier.SessionCours;
import java.sql.Date;
import myconnections.DBConnection;

/**
 *
 * @author donof
 */
public class Gestion {

    Scanner sc = new Scanner(System.in);
    Locaux lcActuel = null;
    Formateur fmActuel = null;
    Cours csActuel = null;
    SessionCours scActuel = null;
    DAO<Cours> coursDAO = null;
    DAO<Locaux> locauxDAO = null;
    DAO<Formateur> formateurDAO = null;
    DAO<SessionCours> sessioncoursDAO = null;

    public Gestion() {

    }

    public void menu() {

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
        coursDAO = new CoursDAO();
        coursDAO.setConnection(dbConnect);
        sessioncoursDAO = new SessionCoursDAO();
        sessioncoursDAO.setConnection(dbConnect);

        //menu permettant de choisir la classe avec laquelle on souhaite travailler
        int choix = 0;
        do {
            System.out.println("1.Locaux \n2.Formateur \n3.Cours \n4.Sessioncours \n5.Fin");
            System.out.println("Choix: ");
            choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    int ch = 0;
                    //menu Locaux et vues
                    do {
                        System.out.println("1.Nouveau \n2.Recherche\n3.Recherche sur la description\n4.Modification\n5.Suppresion\n6.Fin\n");
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
                                System.out.println("bye\n");
                                break;
                            default:
                                System.out.println("choix incorrect");
                        }

                    } while (ch != 6);
                    break;
                case 2:
                    int ch1 = 0;
                    //menu pour les formateurs et vues
                    do {
                        System.out.println("1.Nouveau\n2.Recherche\n3.Modification\n4.Suppresion\n5.Affichage Sessions\n6.Affichage heures par session\n7.Fin\n");
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
                                affSession();
                                break;
                            case 6:
                                affHeures();
                                break;
                            case 7:
                                System.out.println("Goodbye");
                                break;
                            default:
                                System.out.println("choix incorrect");
                        }

                    } while (ch1 != 7);
                case 3:
                    int ch2 = 0;
                    //menu cours
                    do {
                        System.out.println("1.Nouveau \n2.Recherche\n3.Modification\n4.Suppresion\n5.Fin\n");
                        System.out.print("choix :");
                        ch2 = sc.nextInt();
                        sc.skip("\n");
                        switch (ch2) {
                            case 1:
                                insertionCours();
                                break;
                            case 2:
                                rechercheCours();
                                break;
                            case 3:
                                modificationCours();
                                break;
                            case 4:
                                suppressionCours();
                                break;
                            case 5:
                                System.out.println("bye\n");
                                break;
                            default:
                                System.out.println("choix incorrect");
                        }

                    } while (ch2 != 5);
                    break;
                case 4:
                    int ch3 = 0;
                    //menu sessioncours
                    do {
                        System.out.println("1.Nouveau \n2.Recherche\n3.Modification\n4.Suppresion\n5.Fin\n");
                        System.out.print("choix :");
                        ch3 = sc.nextInt();
                        sc.skip("\n");
                        switch (ch3) {
                            case 1:
                                insertionSessionCours();
                                break;
                            case 2:
                                rechercheSessionCours();
                                break;
                            case 3:
                                modificationSessionCours();
                                break;
                            case 4:
                                suppressionSessionCours();
                                break;
                            case 5:
                                System.out.println("bye bye\n");
                                break;
                            default:
                                System.out.println("choix incorrect");
                        }

                    } while (ch3 != 5);
                    break;
                case 5:
                    System.out.println("Aurevoir\n");
                    break;
                default:
                    System.out.println("Choix incorrect");
            }
        } while (choix != 5);

        DBConnection.closeConnection();
    }

    public void insertionLocaux() {

        System.out.print("sigle :");
        String sigle = sc.nextLine();
        String p = saisie("places: ", "[1-9][0-9]*");
        int places = Integer.parseInt(p);
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

    public void rechercheLocaux() {
        try {
            System.out.println("Id du local recherché :");
            int nc = sc.nextInt();
            lcActuel = locauxDAO.read(nc);
            System.out.println("local actuel : " + lcActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void modificationLocaux() {
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

    public void suppressionLocaux() {
        try {
            locauxDAO.delete(lcActuel);
            System.out.println("Ligne supprimée\n");
        } catch (SQLException e) {
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

    public void affSession() {
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

            System.out.println("Heures totales de cette session: " + heures + "\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void insertionFormateur() {
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

        fmActuel = new Formateur(0, matricule, nom, prenom, rue, localite, CP, tel);
        try {
            fmActuel = formateurDAO.create(fmActuel);
            System.out.println("formateur actuel : " + fmActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }

    public void rechercheFormateur() {

        try {
            System.out.println("Id du formateur recherché :");
            int nc = sc.nextInt();
            fmActuel = formateurDAO.read(nc);
            System.out.println("formateur actuel : " + fmActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void modificationFormateur() {

        try {
            System.out.println("Matricule: ");
            String matricule = sc.nextLine();
            fmActuel.setMatricule(matricule);
            System.out.println("Nom :");
            String nom = sc.nextLine();
            fmActuel.setNom(nom);
            System.out.println("Prenom: ");
            String prenom = sc.nextLine();
            fmActuel.setPrenom(prenom);
            System.out.println("Rue: ");
            String rue = sc.nextLine();
            fmActuel.setRue(rue);
            System.out.println("Localite: ");
            String localite = sc.nextLine();
            fmActuel.setLocalite(localite);
            System.out.println("Code postal: ");
            Short CP = sc.nextShort();
            fmActuel.setCP(CP);
            sc.skip("\n");
            System.out.println("Telephone: ");
            String tel = sc.nextLine();
            fmActuel.setTel(tel);
            formateurDAO.update(fmActuel);
            System.out.println("ligne modifiée\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void suppressionFormateur() {

        try {
            formateurDAO.delete(fmActuel);
            System.out.println("Ligne supprimée\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void insertionCours() {

        System.out.print("Matiere :");
        String matiere = sc.nextLine();
        System.out.print("Nombre d'heures :");
        int heures = sc.nextInt();
        csActuel = new Cours(0, matiere, heures);
        try {
            csActuel = coursDAO.create(csActuel);
            System.out.println("cours actuel : " + csActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void rechercheCours() {

        try {
            System.out.println("Id du cours recherché :");
            int nc = sc.nextInt();
            csActuel = coursDAO.read(nc);
            System.out.println("cours actuel : " + csActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void modificationCours() {

        try {
            System.out.println("Matiere: ");
            String matiere = sc.nextLine();
            csActuel.setMatiere(matiere);
            System.out.println("Heures :");
            int heures = sc.nextInt();
            csActuel.setHeures(heures);

            coursDAO.update(csActuel);
            System.out.println("ligne modifiée\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void suppressionCours() {

        try {
            coursDAO.delete(csActuel);
            System.out.println("Ligne supprimée\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void insertionSessionCours() {

        String dd = saisie("Date de debut: (format YYYY-MM-DD)", "[2][0][1-2][0-9]-[0-1][1-9]-[0-3][0-9]");
        Date datedebut = Date.valueOf(dd);
        String df = saisie("Date de fin: (format YYYY-MM-DD)", "[2][0][1-2][0-9]-[0-1][1-9]-[0-3][0-9]");
        Date datefin = Date.valueOf(df);
        System.out.println("Nombre d'inscrits: ");
        int nbreinscrits = sc.nextInt();
        sc.skip("\n");
        System.out.println("Id du cours: ");
        int idcours = sc.nextInt();
        sc.skip("\n");
        System.out.println("Id du local");
        int idlocal = sc.nextInt();

        scActuel = new SessionCours(0, datedebut, datefin, nbreinscrits, idcours, idlocal);
        try {
            scActuel = sessioncoursDAO.create(scActuel);
            System.out.println("Session de cours actuelle : " + scActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }

    public void rechercheSessionCours() {

        try {
            System.out.println("Id de la session du cours recherché :");
            int nc = sc.nextInt();
            scActuel = sessioncoursDAO.read(nc);
            System.out.println("session de cours actuelle : " + scActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void modificationSessionCours() {

        try {
            String dd = saisie("Date de debut: (format YYYY-MM-DD)", "[2][0][1-2][0-9]-[0-1][1-9]-[0-3][0-9]");
            Date datedebut = Date.valueOf(dd);
            scActuel.setDatedebut(datedebut);
            String df = saisie("Date de fin: (format YYYY-MM-DD)", "[2][0][1-2][0-9]-[0-1][1-9]-[0-3][0-9]");
            Date datefin = Date.valueOf(df);
            scActuel.setDatefin(datefin);
            System.out.println("Nombre d'inscrits: ");
            int nbreinscrits = sc.nextInt();
            scActuel.setNbreinscrits(nbreinscrits);
            sc.skip("\n");
            System.out.println("Id du cours: ");
            int idcours = sc.nextInt();
            scActuel.setIdcours(idcours);
            sc.skip("\n");
            System.out.println("Id du local");
            int idlocal = sc.nextInt();
            scActuel.setIdlocal(idlocal);

            sessioncoursDAO.update(scActuel);
            System.out.println("ligne modifiée\n");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void suppressionSessionCours() {

        try {
            sessioncoursDAO.delete(scActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public String saisie(String message, String regex) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.println(message);
            str = sc.nextLine();
            if (!str.matches(regex)) {
                System.out.println("Entrée incorrecte, veuillez recommencer");
            }
        } while (!str.matches(regex));

        return str;
    }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.menu();
    }
}
