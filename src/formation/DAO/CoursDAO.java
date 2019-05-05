package formation.DAO;

/**
 * classe de mappage poo-relationnel Cours
 *
 * @author D'Onofrio Terence
 * @version 1.0
 * @see Formateur
 */
import java.sql.*;
import formation.metier.Cours;
import formation.metier.SessionCours;
import java.util.ArrayList;
import java.util.List;

public class CoursDAO extends DAO<Cours> {

    /**
     * création d'un cours sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj cours à créer
     * @return cours créé
     */
    @Override
    public Cours create(Cours obj) throws SQLException {

        String req1 = "insert into cours(matiere,heures) values(?,?)";
        String req2 = "select idcours from cours where matiere=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatiere());
            pstm1.setInt(2, obj.getHeures());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation du cours, aucune ligne créée");
            }

            pstm2.setString(1, obj.getMatiere());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idcours = rs.getInt(1);
                    obj.setIdcours(idcours);
                    return read(idcours);
                } else {
                    throw new SQLException("erreur de création du cours, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un cours sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idcours identifiant du cours
     * @return cours trouvé
     */
    @Override
    public Cours read(int idcours) throws SQLException {

        String req = "select * from cours where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idcours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String mat = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");

                    return new Cours(idcours, mat, heures);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du cours sur base de son identifiant
     *
     * @return cours
     * @param obj cours à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Cours update(Cours obj) throws SQLException {
        String req = "update cours set idcours=?,matiere=?,heures=? where idcours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(4, obj.getIdcours());
            pstm.setInt(1, obj.getIdcours());
            pstm.setString(2, obj.getMatiere());
            pstm.setInt(3, obj.getHeures());

            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucunes lignes cours mises à jour");
            }
            return read(obj.getIdcours());
        }
    }

    /**
     * effacement du cours sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj cours à effacer
     */
    @Override
    public void delete(Cours obj) throws SQLException {
        String req = "delete from sessioncours where idcours= ?";
        String req2 = "delete from cours where idcours = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {

            pstm.setInt(1, obj.getIdcours());

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Ligne dans la table sessioncours supprimée");
                }

            }
            pstm2.setInt(1, obj.getIdcours());
            int n = pstm2.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne cours effacée");
            }

        }
    }

    public List<SessionCours> affSessioncours(int id) throws SQLException {
        List<SessionCours> plusieurs = new ArrayList<>();
        String req = "select * from sessioncours where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int ids = rs.getInt("IDSESSIONCOURS");
                    Date datedeb = rs.getDate("DATEDEBUT");
                    Date datefin = rs.getDate("DATEFIN");
                    int nbreinscrit = rs.getInt("NBREINSCRITS");
                    int idcours = rs.getInt("IDCOURS");
                    int idlocal = rs.getInt("IDLOCAL");
                    plusieurs.add(new SessionCours(ids, datedeb, datefin, nbreinscrit, idcours, idlocal));
                }

                if (!trouve) {
                    throw new SQLException("Aucune session de cous correspondante à ce cours");
                } else {
                    return plusieurs;
                }
            }
        }
    }

    public List<Cours> rechMatiere(String matrech) throws SQLException {
        List<Cours> plusieurs = new ArrayList<>();
        String req = "select * from cours where matiere = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, matrech);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idcours = rs.getInt("IDCOURS");
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");
                    plusieurs.add(new Cours(idcours, matiere, heures));
                }
                if (!trouve) {
                    throw new SQLException("matière inconnue");
                } else {
                    return plusieurs;
                }
            }
        }

    }

}
