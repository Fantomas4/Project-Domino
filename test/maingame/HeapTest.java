/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.ArrayList;
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
public class HeapTest {
    Heap instance;
    
    public HeapTest() {
        instance = new Heap();
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
     * Test of getHeap method, of class Heap.
     */
    @Test
    public void testGetHeap() {
        System.out.println("getHeap");
        
        boolean result = false;
        boolean expResult = true;
        if (instance.getHeap().size()>0)
            result = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTile method, of class Heap.
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        
        int choice = 0;
        ArrayList<Tile> column = instance.getHeap().get(choice);
        Tile expResult = column.get(5);
        instance.removeTile(choice+1);
        Tile result = instance.getHeap().get(choice).get(column.size()-1);
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseTile method, of class Heap.
     */
    @Test
    public void testChooseTile() {
        System.out.println("chooseTile");
        
        int choice = 0;
        ArrayList<Tile> column = instance.getHeap().get(choice);
        Tile expResult = column.get(column.size()-1);
        Tile result = instance.chooseTile(choice+1);
        assertEquals(expResult, result);
    }

    /**
     * Test of pickRandomTile method, of class Heap.
     */
    @Test
    public void testPickRandomTile() {
        System.out.println("pickRandomTile");
        
        boolean result = false;
        boolean expResult = true;
        Tile piece = instance.pickRandomTile();
        if (piece.getNum1()>-1 && piece.getNum1()<7 && piece.getNum2()>-1 && piece.getNum2()<7)
            result = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of setAllTiles method, of class Heap.
     */
    @Test
    public void testSetAllTiles() {
        System.out.println("setAllTiles");
        instance.setAllTiles();
    }
    
}
