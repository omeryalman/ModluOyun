/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamburgersavaslari;

import modluoyun.AskerSavaslari;
import modluoyun.HamburgerSavaslari;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ASUS
 */
public class AskerSavaslariNGTest {
    
    public AskerSavaslariNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
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
