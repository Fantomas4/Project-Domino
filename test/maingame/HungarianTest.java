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
public class HungarianTest {
    Hungarian instance;
    Heap heap;
    Table table;
    
    public HungarianTest() {
        instance = new Hungarian(2);
        heap = new Heap();
        table = new Table();
        table.addTile(new Tile(1,2), "left");
        table.addTile(new Tile(2,4),"right");
        table.addTile(new Tile(4,3),"right");
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
     * Test of run method, of class Hungarian.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        instance.run();
    }

    /**
     * Test of checkTileChoice method, of class Hungarian.
     */
    @Test
    public void testCheckTileChoice() {
        System.out.println("checkTileChoice");
        
        ArrayList<PossibleMove> expResult = new ArrayList<>();
        ArrayList<PossibleMove> result = instance.checkTileChoice(new Tile(3,5));
        expResult.add(new PossibleMove(false,"right"));
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoveExists method, of class Hungarian.
     */
    @Test
    public void testPossibleMoveExists() {
        System.out.println("possibleMoveExists");
        
        Player subject = new Player("Human","Human",12,heap);
        Tile playerTiles = new Tile(3,5);
        boolean expResult = true;
        boolean result = instance.possibleMoveExists(subject);
        assertEquals(expResult, result);
    }

    /**
     * Test of whoPlaysNext method, of class Hungarian.
     */
   @Test
   public void testWhoPlaysNext() {
       System.out.println("whoPlaysNext");
       
       int expResult = 1;
       if (instance.possibleMoveExists(new Player("Human","Human",12,heap)))
            expResult = 0;
        int result = instance.whoPlaysNext();
        assertEquals(expResult, result);
   }

    /**
     * Test of giveRoundPoints method, of class Hungarian.
     */
    @Test
    public void testGiveRoundPoints() {
        System.out.println("giveRoundPoints");
        
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.add(new Player("Human","Human",12,heap));
        allPlayers.add(new Player("Bot","Bot",12,heap));
        allPlayers.get(0).givePlayerTiles(12);
        allPlayers.get(1).givePlayerTiles(12);
        int expResult = allPlayers.get(0).getRemainingTilePoints();
        if(allPlayers.get(1).getRemainingTilePoints()>expResult)
            expResult = allPlayers.get(1).getRemainingTilePoints();
        int result = instance.giveRoundPoints();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of scoreLimitReached method, of class Hungarian.
     */
    @Test
    public void testScoreLimitReached() {
        System.out.println("scoreLimitReached");
        
        int score = 57;
        boolean expResult = false;
        if (score>=100)
            expResult = true ;
        boolean result = instance.scoreLimitReached();
        assertEquals(expResult, result);
    }

    /**
     * Test of showTable method, of class Hungarian.
     */
    @Test
    public void testShowTable() {
        System.out.println("showTable");
        instance.showTable();
    }
    
}
