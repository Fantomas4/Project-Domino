/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sierra Kilo
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
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
    }

    /**
     * Test of rotateTile method, of class Tile.
     */
    @Test
    public void testRotateTile() {
        System.out.println("rotateTile");
        Tile instance = new Tile(6,0);
        instance.rotateTile();
    }
    
}
