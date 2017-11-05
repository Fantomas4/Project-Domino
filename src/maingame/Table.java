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
    ArrayList<Tile> tableTiles;
    
    public Table() {
        tableTiles = new ArrayList<>();
        
    }
    
    public int getSize() {
        return tableTiles.size();
    }
    
    public Tile getTile(int pos) {
        return tableTiles.get(pos);
    }
    
    public void addTile(Tile piece,int side) {
        //side == 0 is left, side == 1 is right
        if (side == 0) {
            tableTiles.add(0,piece);
        }else {
            tableTiles.add(piece);
        }
    }
    
    public void showTable() {
        for(Tile piece : tableTiles) {
            System.out.printf("|%d %d|", piece.getNum1(), piece.getNum2());
        }
    }
    
}
