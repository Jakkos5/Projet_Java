package formation.DAO;

/**
 * classe de mappage poo-relationnel formateur
 *
 * @author D'Onofrio Terence
 * @version 1.0
 * @see Formateur
 */
import java.sql.*;
import formation.metier.Formateur;
import formation.metier.SessionCours;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormateurDAO extends DAO<Formateur> {

    /**
     * création d'un formateur sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj formateur à créer
     * @return formateur créé
     */
    @Override
    public Formateur create(Formateur obj) throws SQLException {

        String req1 = "insert into formateur(matricule,nom,prenom,rue,localite,cp,tel) values(?,?,?,?,?,?,?)";
        String req2 = "select idform from formateur where nom=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setString(4, obj.getRue());
            pstm1.setString(5, obj.getLocalite());
            pstm1.setShort(6, obj.getCP());
            pstm1.setString(7, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation de local, aucune ligne créée");
            }
            pstm2.setString(1, obj.getNom());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idform = rs.getInt(1);
                    obj.setIdform(idform);
                    return read(idform);
                } else {
                    throw new SQLException("erreur de création de local, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un formateur sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idform identifiant du formateur
     * @return formateur trouvé
     */
    @Override
    public Formateur read(int idform) throws SQLException {

        String req = "select * from formateur where idform = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    Short cp = rs.getShort("CP");
                    String tel = rs.getString("TEL");

                    return new Formateur(idform, matricule, nom, prenom, rue, localite, cp, tel);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du formateur sur base de son identifiant
     *
     * @return formateur
     * @param obj formateur à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Formateur update(Formateur obj) throws SQLException {
        String req = "update formateur set idform=?,matricule=?,nom=?,prenom=?,rue=?,localite=?,cp=?,tel=? where idform= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(9, obj.getIdform());
            pstm.setInt(1, obj.getIdform());
            pstm.setString(2, obj.getMatricule());
            pstm.setString(3, obj.getNom());
            pstm.setString(4, obj.getPrenom());
            pstm.setString(5, obj.getRue());
            pstm.setString(6, obj.getLocalite());
            pstm.setShort(7, obj.getCP());
            pstm.setString(8, obj.getTel());

            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne formateur mise à jour");
            }
            return read(obj.getIdform());
        }
    }

    /**
     * effacement du formateur sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj formateur à effacer
     */
    @Override
    public void delete(Formateur obj) throws SQLException {
        String req = "delete from formateur where idform= ?";
        String req2 = "delete from infos where idform = ?";
        try (PreparedStatement pstm2 = dbConnect.prepareStatement(req2);
             PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm2.setInt(1, obj.getIdform());
            
            try(ResultSet rs = pstm2.executeQuery()){
                if(rs.next()){
                    System.out.println("Ligne dans la table infos supprimée");
                }
                
            }
            pstm.setInt(1, obj.getIdform());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne formateur effacée");
            }
            
            
            

        }
    }
    
    /**
     * méthode permettant de récupérer toutes les sessions de cours correspondant à un certain formateur

     * @param id identifiant du formateur recherché
     * @return liste de sessions de cours
     * @throws SQLException nom inconnu
     */
    public List<SessionCours> affSession(int id) throws SQLException {
        List<SessionCours> plusieurs = new ArrayList<>();
        String req = "select * from affsession where idform = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int  ids = rs.getInt("IDSESSIONCOURS");
                    Date datedeb = rs.getDate("DATEDEBUT");
                    Date datefin = rs.getDate("DATEFIN");
                    int nbreinscrit = rs.getInt("NBREINSCRITS");
                    int idcours = rs.getInt("IDCOURS");
                    int idlocal = rs.getInt("IDLOCAL");
                    plusieurs.add(new SessionCours(ids,datedeb,datefin,nbreinscrit,idcours,idlocal));
                }

                if (!trouve) {
                    throw new SQLException("nom inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
    }
    /**
     * méthode permettant de récupérer le nombre d'heures totales de cours organisées pour une certaine session 
     * @param idSess identifiant de la session de cours
     * @return le nombre d'heures totales
     * @throws SQLException 
     */
    public int totHeures(int idSess) throws SQLException{
         String req = "select total from tot_heures where idsessioncours = ?";
         try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
             pstm.setInt(1,idSess);
             try(ResultSet rs = pstm.executeQuery()){
                 if(rs.next()){
                     int heures = rs.getInt(1);
                     return heures;
                 }
                 else throw new SQLException("Pas de de session de cours prévue en rapport avec cet id");
             }
         }
    }

}
