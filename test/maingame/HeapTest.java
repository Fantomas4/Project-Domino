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
    ArrayList<ArrayList<Tile>> allTiles;
    ArrayList<Tile> playerTiles;
    
    public HeapTest() {
        instance = new Heap();
        playerTiles = new ArrayList<>();
        playerTiles.add(new Tile(1,2));
        playerTiles.add(new Tile(2,3));
        playerTiles.add(new Tile(3,6));
        allTiles = new ArrayList<>();
        allTiles.add(playerTiles);
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
     * Test of showHeap method, of class Heap.
     */
    @Test
    public void testShowHeap() {
        System.out.println("showHeap");
        instance.showHeap();
    }

    /**
     * Test of removeTile method, of class Heap.
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        int choice = 1;
        Tile expResult = allTiles.get(0).get(choice+1);
        instance.removeTile(choice);
        Tile result = allTiles.get(0).get(choice);
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseTile method, of class Heap.
     */
    @Test
    public void testChooseTile() {
        System.out.println("chooseTile");
        int choice = 1;
        Tile expResult = new Tile(3,6);
        Tile result = instance.chooseTile(choice);
        assertEquals(expResult, result);
    }

    /**
     * Test of pickRandomTile method, of class Heap.
     */
//    @Test
//    public void testPickRandomTile() {
//        System.out.println("pickRandomTile");
//        Tile expResult = null;
//        Tile result = instance.pickRandomTile();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of setAllTiles method, of class Heap.
     */
    @Test
    public void testSetAllTiles() {
        System.out.println("setAllTiles");
        instance.setAllTiles();
    }
    
}
