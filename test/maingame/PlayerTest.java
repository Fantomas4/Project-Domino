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
        heap = new Heap();
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
        ArrayList<Tile> playerTiles = instance.getPlayerTiles();
        int expResult=0;
        for (Tile piece : playerTiles) {
            expResult+=piece.getNum1()+piece.getNum2();
        }
        int result = instance.getRemainingTilePoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of givePlayerTiles method, of class Player.
     */
//    @Test
//    public void testGivePlayerTiles() {
//        System.out.println("givePlayerTiles");
//        int tilesAmount = 0;
//        //Player instance = null;
//        instance.givePlayerTiles(tilesAmount);
//    }

    /**
     * Test of increaseScore method, of class Player.
     */
    @Test
    public void testIncreaseScore() {
        System.out.println("increaseScore");
        int points = 10;
        instance.increaseScore(points);
        int expResult=10;
        int result=instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestTile method, of class Player.
     */
    @Test
    public void testGetHighestTile() {
        System.out.println("getHighestTile");
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
        instance.showPlayerTiles();
        System.out.printf("%n");
    }

    /**
     * Test of getPlayerTilesAmount method, of class Player.
     */
    @Test
    public void testGetPlayerTilesAmount() {
        System.out.println("getPlayerTilesAmount");
        int expResult = 12;
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
        instance.removeTile(choice);
    }

    /**
     * Test of isBot method, of class Player.
     */
    @Test
    public void testIsBot() {
        System.out.println("isBot");
        boolean expResult = false;
        boolean result = instance.isBot();
        assertEquals(expResult, result);
    }
    
}
