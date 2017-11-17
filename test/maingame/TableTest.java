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
 * @author pbach
 */
public class TableTest {
    
    public TableTest() {
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
     * Test of getSize method, of class Table.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstTile method, of class Table.
     */
    @Test
    public void testGetFirstTile() {
        System.out.println("getFirstTile");
        Table instance = new Table();
        Tile expResult = null;
        Tile result = instance.getFirstTile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastTile method, of class Table.
     */
    @Test
    public void testGetLastTile() {
        System.out.println("getLastTile");
        Table instance = new Table();
        Tile expResult = null;
        Tile result = instance.getLastTile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTile method, of class Table.
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        Tile piece = null;
        String side = "";
        Table instance = new Table();
        instance.addTile(piece, side);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearTable method, of class Table.
     */
    @Test
    public void testClearTable() {
        System.out.println("clearTable");
        Table instance = new Table();
        instance.clearTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTable method, of class Table.
     */
    @Test
    public void testShowTable() {
        System.out.println("showTable");
        Table instance = new Table();
        instance.showTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
