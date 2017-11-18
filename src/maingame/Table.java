/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sierra Kilo
 */
public class Table {

    private ArrayList<Tile> tableTiles;

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
        return tableTiles.get(tableTiles.size() - 1);
    }

    public void addTile(Tile piece, String side) {
        //addTile receives tile after its rotation (if needed).

        if (side.equals("left")) {
            tableTiles.add(0, piece);
        } else {
            tableTiles.add(piece);
        }

    }
    
    public void clearTable() {
        tableTiles.clear();
    }

    public ArrayList<Tile> getTable() {
        return tableTiles;
    }

}
