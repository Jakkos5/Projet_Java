package formation.DAO;

/**
 * classe de mappage poo-relationnel locaux
 *
 * @author D'Onofrio Terence
 * @version 1.0
 * @see Locaux
 */
import java.sql.*;
import java.util.*;
import formation.metier.Locaux;

public class LocauxDAO extends DAO<Locaux> {

    /**
     * création d'un local sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj locaux à créer
     * @return local créé
     */
    @Override
    public Locaux create(Locaux obj) throws SQLException {

        String req1 = "insert into local(sigle,places,description) values(?,?,?)";
        String req2 = "select idlocal from local where sigle=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getSigle());
            pstm1.setInt(2, obj.getPlaces());
            pstm1.setString(3, obj.getDescription());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation de local, aucune ligne créée");
            }
            pstm2.setString(1, obj.getSigle());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idlocal = rs.getInt(1);
                    obj.setIdlocal(idlocal);
                    return read(idlocal);
                } else {
                    throw new SQLException("erreur de création de local, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données du local sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idlocal identifiant du local
     * @return local trouvé
     */   
    @Override
    public Locaux read(int idlocal) throws SQLException {

        String req = "select * from local where idlocal = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idlocal);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");

                    return new Locaux(idlocal, sigle, places, description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du local sur base de son identifiant
     *
     * @return local
     * @param obj locaux à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Locaux update(Locaux obj) throws SQLException {
        String req = "update local set idlocal=?,sigle=?,places=?,description=? where idlocal= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(5, obj.getIdlocal());
            pstm.setInt(1, obj.getIdlocal());
            pstm.setString(2, obj.getSigle());
            pstm.setInt(3, obj.getPlaces());
            pstm.setString(4, obj.getDescription());

            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne locaux mise à jour");
            }
            return read(obj.getIdlocal());
        }
    }

    /**
     * effacement du local sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj locaux à effacer
     */
    @Override
    public void delete(Locaux obj) throws SQLException {

        String req = "delete from local where idlocal= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdlocal());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne local effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les locaux portant une certaine description

     * @param desc description recherchée
     * @return liste de locaux
     * @throws SQLException nom inconnu
     */
    public List<Locaux> rechDescription(String desc) throws SQLException {
        List<Locaux> plusieurs = new ArrayList<>();
        String req = "select * from local where description like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1,"%"+desc+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idlocal = rs.getInt("IDLOCAL");
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    plusieurs.add(new Locaux(idlocal, sigle, places, description));
                }

                if (!trouve) {
                    throw new SQLException("description inconnue");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
}
