/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.CoursDAO;
import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import myconnections.DBConnection;

/**
 *
 * @author donof
 */
public class GestionCours extends javax.swing.JFrame {

    /**
     * Creates new form GestionCours
     */
    CardLayout cardl;
    public GestionCours() {
        initComponents();
        cardl=(CardLayout)this.getContentPane().getLayout();
         Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this,"connexion invalide","ERREUR",JOptionPane.ERROR_MESSAGE);
        }
         
    CoursDAO coursDAO = new CoursDAO();
    coursDAO.setConnection(dbConnect);
    creaCours.setCoursDAO(coursDAO);
    rechCours.setCoursDAO(coursDAO);
    rechMatiere.setCoursDAO(coursDAO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creaCours = new formation.graph.CreaCours();
        rechCours = new formation.graph.RechCours();
        rechMatiere = new formation.graph.RechMatiere();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCours = new javax.swing.JMenu();
        itemCreation = new javax.swing.JMenuItem();
        itemrecherche = new javax.swing.JMenuItem();
        itemrechmat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(creaCours, "cardCreaCours");
        getContentPane().add(rechCours, "cardRechCours");
        getContentPane().add(rechMatiere, "cardRechMat");

        menuCours.setText("Cours");

        itemCreation.setText("Créer");
        itemCreation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreationActionPerformed(evt);
            }
        });
        menuCours.add(itemCreation);

        itemrecherche.setText("Recherche");
        itemrecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemrechercheActionPerformed(evt);
            }
        });
        menuCours.add(itemrecherche);

        itemrechmat.setText("Recherche par matiere");
        itemrechmat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemrechmatActionPerformed(evt);
            }
        });
        menuCours.add(itemrechmat);

        jMenuBar1.add(menuCours);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCreationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreationActionPerformed
        cardl.show(this.getContentPane(), "cardCreaCours");
    }//GEN-LAST:event_itemCreationActionPerformed

    private void itemrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemrechercheActionPerformed
        cardl.show(this.getContentPane(), "cardRechCours");
        
    }//GEN-LAST:event_itemrechercheActionPerformed

    private void itemrechmatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemrechmatActionPerformed
        cardl.show(this.getContentPane(), "cardRechMat");
    }//GEN-LAST:event_itemrechmatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionCours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCours().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private formation.graph.CreaCours creaCours;
    private javax.swing.JMenuItem itemCreation;
    private javax.swing.JMenuItem itemrecherche;
    private javax.swing.JMenuItem itemrechmat;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCours;
    private formation.graph.RechCours rechCours;
    private formation.graph.RechMatiere rechMatiere;
    // End of variables declaration//GEN-END:variables
}
