package formation.DAO;

/**
 * classe de mappage poo-relationnel SessionCours
 *
 * @author D'Onofrio Terence
 * @version 1.0
 * @see SessionCours
 */
import java.sql.*;
import formation.metier.Cours;
import formation.metier.SessionCours;


public class SessionCoursDAO extends DAO<SessionCours> {

    /**
     * création d'une session de cours sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj SessionCours à créer
     * @return SessionCours créée
     */
    @Override
    public SessionCours create(SessionCours obj) throws SQLException {

        String req1 = "insert into sessioncours(datedebut,datefin,nbreinscrits,idcours,idlocal) values(?,?,?,?,?)";
        String req2 = "select idsessioncours from sessioncours where idlocal=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setDate(1, obj.getDatedebut());
            pstm1.setDate(2, obj.getDatefin());
            pstm1.setInt(3, obj.getNbreinscrits());
            pstm1.setInt(4, obj.getIdcours());
            pstm1.setInt(5, obj.getIdlocal());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation du cours, aucune ligne créée");
            }
            
            pstm2.setInt(1, obj.getIdlocal());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idsessioncours = rs.getInt(1);
                    obj.setIdsessioncours(idsessioncours);
                    return read(idsessioncours);
                } else {
                    throw new SQLException("erreur de création du cours, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'une session de cours sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idsessioncours identifiant de la session du cours
     * @return sessiocours trouvé
     */
    @Override
    public SessionCours read(int idsessioncours) throws SQLException {

        String req = "select * from sessioncours where idsessioncours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idsessioncours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Date datedeb = rs.getDate("DATEDEBUT");
                    Date datefin = rs.getDate("DATEFIN");
                    int nbreinscrits = rs.getInt("NBREINSCRITS");
                    int idcours = rs.getInt("IDCOURS");
                    int idlocal = rs.getInt("IDLOCAL");
                   

                    return new SessionCours(idsessioncours, datedeb,datefin,nbreinscrits,idcours,idlocal);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données d'une session de cours sur base de son identifiant
     *
     * @return sessioncours
     * @param obj sessioncours à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public SessionCours update(SessionCours obj) throws SQLException {
        String req = "update sessioncours set idsessioncours=?,datedebut=?,datefin=?,nbreinscrits=?,idcours=?,idlocal=? where idsessioncours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm.setInt(7, obj.getIdsessioncours());
            pstm.setInt(1, obj.getIdsessioncours());
            pstm.setDate(2, obj.getDatedebut());
            pstm.setDate(3, obj.getDatefin());
            pstm.setInt(4, obj.getNbreinscrits());
            pstm.setInt(5, obj.getIdcours());
            pstm.setInt(6, obj.getIdlocal());
            

            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucunes lignes sessioncours mises à jour");
            }
            return read(obj.getIdsessioncours());
        }
    }

    /**
     * effacement d'une session de cours sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj sessioncours à effacer
     */
    @Override
    public void delete(SessionCours obj) throws SQLException {
        String req = "delete from sessioncours where idsessioncours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm.setInt(1, obj.getIdsessioncours());
            
            try(ResultSet rs = pstm.executeQuery()){
                if(rs.next()){
                    System.out.println("Ligne supprimée");
                }
                
            }
           
        }
    }
    

}
