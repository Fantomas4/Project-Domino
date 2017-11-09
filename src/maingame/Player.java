/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.ArrayList;

/**
 *
 * @author Sierra Kilo
 */
public class Player {
    ArrayList<Tile> playerTiles;
    int score;
    
    public Player() {
        playerTiles = new ArrayList<>();
        score = 0;
    }
    
    public void pickTiles(Heap heap) {
        for(int i=1; i<=12 ; i++){
            playerTiles.add(heap.pickRandomTile());
        }
    }
    
    public int getScore() {
        return score;
    }
    
    public void increaseScore(int points) {
        score += points;
        
    }
    
    
}
