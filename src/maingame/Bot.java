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
    
    public Bot() {
        botTiles = new ArrayList<>();
    }
    
    public void pickTiles(Heap heap) {
        for(int i=1; i<=12 ; i++){
            botTiles.add(heap.pickRandomTile());
        }
    }
    
    
}
