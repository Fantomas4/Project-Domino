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
    
    public Tile getFirstTile() {
        return tableTiles.get(0);
    }
    
    public Tile getLastTile() {
        return tableTiles.get(tableTiles.size()-1);
    }
    
    public void addTile(Tile piece,int side) {
        //side == 0 places tile to the left edge, side == 1 places tile to the right edge 
        //and is also used for placing the first tile on the table.
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
