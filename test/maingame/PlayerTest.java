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
public class PlayerTest {
    Player instance;
    Heap heap;
    
    public PlayerTest() {
        instance = new Player("Human","Human",12,heap);
        instance.givePlayerTiles(12);
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
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        //Player insance= null;
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerName method, of class Player.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
       // Player instance = null;
        String expResult = "Human";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerTiles method, of class Player.
     */
    @Test
    public void testGetPlayerTiles() {
        System.out.println("getPlayerTiles");
       // Player instance = null;
        int expResult = 12;
        int result = instance.getPlayerTiles().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRemainingTilePoints method, of class Player.
     */
    @Test
    public void testGetRemainingTilePoints() {
        System.out.println("getRemainingTilePoints");
        //Player instance = null;
        int expResult = 0;
        int result = instance.getRemainingTilePoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of givePlayerTiles method, of class Player.
     */
    @Test
    public void testGivePlayerTiles() {
        System.out.println("givePlayerTiles");
        int tilesAmount = 0;
        //Player instance = null;
        instance.givePlayerTiles(tilesAmount);
    }

    /**
     * Test of increaseScore method, of class Player.
     */
    @Test
    public void testIncreaseScore() {
        System.out.println("increaseScore");
        int points = 0;
        //Player instance = null;
        instance.increaseScore(points);
    }

    /**
     * Test of getHighestTile method, of class Player.
     */
    @Test
    public void testGetHighestTile() {
        System.out.println("getHighestTile");
        //Player instance = null;
        Tile expResult = null;
        Tile result = instance.getHighestTile();
        assertEquals(expResult, result);
    }

    /**
     * Test of showPlayerTiles method, of class Player.
     */
    @Test
    public void testShowPlayerTiles() {
        System.out.println("showPlayerTiles");
       // Player instance = null;
        instance.showPlayerTiles();
    }

    /**
     * Test of getPlayerTilesAmount method, of class Player.
     */
    @Test
    public void testGetPlayerTilesAmount() {
        System.out.println("getPlayerTilesAmount");
       // Player instance = null;
        int expResult = 0;
        int result = instance.getPlayerTilesAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of chooseTile method, of class Player.
     */
    @Test
    public void testChooseTile() {
        System.out.println("chooseTile");
        int choice = 0;
       // Player instance = null;
        Tile expResult = null;
        Tile result = instance.chooseTile(choice);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTile method, of class Player.
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        int choice = 0;
       // Player instance = null;
        instance.removeTile(choice);
    }

    /**
     * Test of isBot method, of class Player.
     */
    @Test
    public void testIsBot() {
        System.out.println("isBot");
       // Player instance = null;
        boolean expResult = false;
        boolean result = instance.isBot();
        assertEquals(expResult, result);
    }
    
}
