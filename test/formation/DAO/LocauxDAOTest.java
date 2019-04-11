/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.Locaux;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author donof
 */
public class LocauxDAOTest {

    static Connection dbConnect;

    public LocauxDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class LocauxDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Locaux obj = new Locaux(0, "TestSigle", 10,"TestDescription");
        LocauxDAO instance = new LocauxDAO();
        instance.setConnection(dbConnect);
        Locaux expResult = new Locaux(0, "TestSigle", 10,"TestDescription");
        Locaux result = instance.create(obj);

        assertEquals("Sigles différents", expResult.getSigle(), result.getSigle());
        assertEquals("Nombre de places différentes", expResult.getPlaces(), result.getPlaces());
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());
        
        assertNotEquals("id non généré", expResult.getIdlocal(), result.getIdlocal());
        obj = new Locaux(0, "TestSigle", 10,"TestDescription");
        try {
            Locaux result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
        }
        instance.delete(result);

        obj = new Locaux(0, "TestSigle", -10,"TestDescription");
        try {
            Locaux result3 = instance.create(obj);
            fail("exception de places négatives non déclenchée");
            instance.delete(result3);
        } catch (SQLException e) {
        }

    }

    /**
     * Test of read method, of class LocauxDAO.
     */
    
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idlocal = 0;
        LocauxDAO instance = new LocauxDAO();
        instance.setConnection(dbConnect);
        Locaux obj = new Locaux(0, "TestSigle", 10,"TestDescription");
        Locaux expResult = instance.create(obj);
        idlocal = expResult.getIdlocal();
        Locaux result = instance.read(idlocal);
        assertEquals("Sigles différents", expResult.getSigle(), result.getSigle());
        assertEquals("Nombre de places différentes", expResult.getPlaces(), result.getPlaces());
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());
        
        assertEquals("id différents", expResult.getIdlocal(), result.getIdlocal());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class LocauxDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Locaux obj = new Locaux(0, "TestSigle", 10,"TestDescription");
        LocauxDAO instance = new LocauxDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setSigle("TestSigle2");
        obj.setPlaces(15);
        obj.setDescription("TestDescription2");
        
        Locaux expResult = obj;
        Locaux result = instance.update(obj);
        assertEquals(expResult.getSigle(), result.getSigle());
        assertEquals(expResult.getPlaces(), result.getPlaces());
        assertEquals(expResult.getDescription(), result.getDescription());
        instance.delete(obj);
       
    }

    /**
     * Test of delete method, of class LocauxDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Locaux obj = new Locaux(0, "TestSigle", 10,"TestDescription");
        LocauxDAO instance = new LocauxDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdlocal());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
       
    }

    /**
     * Test of rechDescription method, of class LocauxDAO.
     */
    @Test
    public void testRechDescription() throws Exception {
        System.out.println("rechDescription");
        Locaux obj1 = new Locaux(0, "TestSigle", 10,"TestDescription");
        Locaux obj2 = new Locaux(0, "TestSigleBis", 50,"TestDescription");
        String description = "TestDescription";
        LocauxDAO instance = new LocauxDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);

        
        List<Locaux> result = instance.rechDescription(description);
      
        
        if (result.indexOf(obj1) < 0) {
            fail("record introuvable " + obj1);
        }
        if (result.indexOf(obj2) < 0) {
            fail("record numéro 2 introuvable" + obj2);
        }
        instance.delete(obj1);
        instance.delete(obj2);
    }

  

}
