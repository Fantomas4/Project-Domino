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
public class Table {
    ArrayList<Tile> playedTiles;
    
    public Table() {
        playedTiles = new ArrayList<>();
        
    }
    
    public int getSize() {
        return playedTiles.size();
    }
    
    public Tile getTile(int pos) {
        return playedTiles.get(pos);
    }
    
    public void setTile(Tile piece) {
        playedTiles.add(piece);
    }
    
    public void showTable() {
        for(Tile piece : playedTiles) {
            System.out.printf("%d %d|", piece.getNum1(), piece.getNum2());
        }
    }
    
}
