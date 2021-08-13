/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamburgersavaslari;

import modluoyun.AskerSavaslari;
import modluoyun.HamburgerSavaslari;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
public class AskerSavaslariTest {
    
    public AskerSavaslariTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of requestFocus method, of class AskerSavaslari.
     */
    @Test
    public void testRequestFocus() {
        System.out.println("requestFocus");
        AskerSavaslari instance = new AskerSavaslari();
        instance.requestFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFocusTraversalKeysEnabled method, of class AskerSavaslari.
     */
    @Test
    public void testSetFocusTraversalKeysEnabled() {
        System.out.println("setFocusTraversalKeysEnabled");
        boolean b = false;
        AskerSavaslari instance = new AskerSavaslari();
        instance.setFocusTraversalKeysEnabled(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFocusable method, of class AskerSavaslari.
     */
    @Test
    public void testSetFocusable() {
        System.out.println("setFocusable");
        boolean b = false;
        AskerSavaslari instance = new AskerSavaslari();
        instance.setFocusable(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addKeyListener method, of class AskerSavaslari.
     */
    @Test
    public void testAddKeyListener_Oyun() {
        System.out.println("addKeyListener");
        HamburgerSavaslari oyun = null;
        AskerSavaslari instance = new AskerSavaslari();
        instance.addKeyListener(oyun);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addKeyListener method, of class AskerSavaslari.
     */
    @Test
    public void testAddKeyListener_AskerSavaslari() {
        System.out.println("addKeyListener");
        AskerSavaslari asker = null;
        AskerSavaslari instance = new AskerSavaslari();
        instance.addKeyListener(asker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
