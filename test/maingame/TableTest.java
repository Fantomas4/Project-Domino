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
    Table instance;
    
    public TableTest() {
        instance= new Table();
        instance.addTile(new Tile(3,5), "left");
        instance.addTile(new Tile(5,2),"right");
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
       // Table instance = new Table();
        int expResult = 2;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstTile method, of class Table.
     */
    @Test
    public void testGetFirstTile() {
        System.out.println("getFirstTile");
       // Table instance = new Table();
        Tile expResult = new Tile(3,5);
        Tile result = instance.getFirstTile();
        assertEquals(expResult, result);      
    }

    /**
     * Test of getLastTile method, of class Table.
     */
    @Test
    public void testGetLastTile() {
        System.out.println("getLastTile");
       // Table instance = new Table();
        Tile expResult = new Tile(5,2);
        Tile result = instance.getLastTile();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of addTile method, of class Table.
//     */
//    @Test
//    public void testAddTile() {
//        System.out.println("addTile");
//        Tile piece = null;
//        String side = "";
//       // Table instance = new Table();
//        instance.addTile(piece, side);
//    }

    /**
     * Test of clearTable method, of class Table.
     */
//    @Test
//    public void testClearTable() {
//        System.out.println("clearTable");
//        //Table instance = new Table();
//        instance.clearTable();
//    }

    /**
     * Test of showTable method, of class Table.
     */
//    @Test
//    public void testShowTable() {
//        System.out.println("showTable");
//        //Table instance = new Table();
//        instance.showTable();
//    }
    
}
