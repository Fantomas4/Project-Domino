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
public class Bot {
    ArrayList<Tile> botTiles;
    int score;
    
    public Bot() {
        botTiles = new ArrayList<>();
        score = 0;
    }
    
    public void setTiles(Heap heap) {
        for(int i=1; i<=12 ; i++){
            botTiles.add(heap.pickRandomTile());
        }
    }
    
    public int getScore() {
        return score;
    }
    
    public void increaseScore(int points) {
        score += points;
        
    }
    
    public Tile getHighestTile() {
        // (-1,-1) is a tile representing that the player has no tiles with num1 == num2
        Tile maxTile = new Tile(-1,-1);
        
        for (Tile piece : botTiles) {
            if (piece.getNum1() == piece.getNum2()) {
                if (piece.getNum1() > maxTile.getNum1()) {
                    maxTile = piece;
                }
            }
            
        }
        return maxTile;
    }
    
}
