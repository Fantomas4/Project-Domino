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
    
    public HungarianTest() {
        instance = new Hungarian(2);
        heap = new Heap();
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
        Tile piece = null;
        ArrayList<PossibleMove> expResult = null;
        ArrayList<PossibleMove> result = instance.checkTileChoice(piece);
        assertEquals(expResult, result);
    }

    /**
     * Test of possibleMoveExists method, of class Hungarian.
     */
    @Test
    public void testPossibleMoveExists() {
        System.out.println("possibleMoveExists");
        Player subject = null;
        boolean expResult = false;
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
        
        boolean expResult = true;
        boolean result = false;
        if (instance.giveRoundPoints()>0)
            result = true;
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
