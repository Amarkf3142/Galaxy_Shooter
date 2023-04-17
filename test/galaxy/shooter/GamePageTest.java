/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amar
 */
public class GamePageTest {
    
    public GamePageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of my_update method, of class GamePage.
     */
    @Test
    public void testMy_update() {
        try {
            System.out.println("my_update");
            String ID = "";
            GamePage instance = new GamePage();
            instance.my_update(ID);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (IOException ex) {
            Logger.getLogger(GamePageTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of actionPerformed method, of class GamePage.
     */
    @Test
    public void testActionPerformed() {
        try {
            System.out.println("actionPerformed");
            ActionEvent ae = null;
            GamePage instance = new GamePage();
            instance.actionPerformed(ae);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (IOException ex) {
            Logger.getLogger(GamePageTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of main method, of class GamePage.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        GamePage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
