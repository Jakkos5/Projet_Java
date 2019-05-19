/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.Infos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author donof
 */
public class InfosDAO extends DAO<Infos> {

    @Override
    public Infos create(Infos obj) throws SQLException {
        String req1 = "insert into infos(nbheures,idsessioncours,idform) values(?,?,?)";
        String req2 = "select * from infos where idform=?";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getNbheures());
            pstm1.setInt(2, obj.getIdsessioncours());
            pstm1.setInt(3, obj.getIdform());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation de l'info, aucune ligne créée");
            }
            
            pstm2.setInt(1, obj.getIdform());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idsessioncours = rs.getInt("IDSESSIONCOURS");
                    obj.setIdsessioncours(idsessioncours);
                    return read(idsessioncours);
                } else {
                    throw new SQLException("erreur de création du cours, record introuvable");
                }
            }
        }
    }

    @Override
    public Infos read(int idsess) throws SQLException {

        String req = "select * from infos where idsessioncours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idsess);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int nbheures = rs.getInt("NBHEURES");
                    int idsessioncours = rs.getInt("IDSESSIONCOURS");
                    int idformateur = rs.getInt("IDFORM");

                    return new Infos(nbheures, idsessioncours, idformateur);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    @Override
    public Infos update(Infos obj) throws SQLException {
        String req = "update infos set nbheures=?,idsessioncours=?,idform=? where idform=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(4, obj.getIdform());
            pstm.setInt(1, obj.getNbheures());
            pstm.setInt(2, obj.getIdsessioncours());
            pstm.setInt(3, obj.getIdform());

            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucunes lignes infos mises à jour");
            }
            return read(obj.getIdform());
        }
    }

    @Override
    public void delete(Infos obj) throws SQLException {
        String req = "delete from infos where idform= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdform());

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Ligne dans la table infos supprimée");
                }

            }

        }
    }

}
