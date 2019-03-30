package formation.DAO;

/**
 * classe de mappage poo-relationnel formateur
 *
 * @author D'Onofrio Terence
 * @version 1.0
 * @see Formateur
 */
import java.sql.*;
import formation.metier.Cours;


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
        String req2 = "select idcours from cours where idcours=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatiere());
            pstm1.setInt(2, obj.getHeures());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation du cours, aucune ligne créée");
            }
            pstm2.setInt(1, obj.getIdcours());
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
                   

                    return new Cours(idcours, mat,heures);

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
        String req = "update cours set idcours=?,matiere=?,heures=? where idform= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(9, obj.getIdcours());
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
        try (PreparedStatement pstm2 = dbConnect.prepareStatement(req2);
             PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm2.setInt(1, obj.getIdcours());
            
            try(ResultSet rs = pstm2.executeQuery()){
                if(rs.next()){
                    System.out.println("Ligne dans la table sessioncours supprimée");
                }
                
            }
            pstm.setInt(1, obj.getIdcours());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne cours effacée");
            }
            
            
            

        }
    }
    

}