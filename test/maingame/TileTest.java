/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pbach
 */
public class TileTest {
    
    public TileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNum1 method, of class Tile.
     */
    @Test
    public void testGetNum1() {
        System.out.println("getNum1");
        Tile instance = new Tile(3,5);
        int expResult = 3;
        int result = instance.getNum1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNum2 method, of class Tile.
     */
    @Test
    public void testGetNum2() {
        System.out.println("getNum2");
        Tile instance = new Tile(3,5);
        int expResult = 5;
        int result = instance.getNum2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateTile method, of class Tile.
     */
    @Test
    public void testRotateTile() {
        System.out.println("rotateTile");
        Tile instance = null;
        instance.rotateTile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
