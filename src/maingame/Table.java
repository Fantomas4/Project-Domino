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

    /**
     * Constructs and initializes a new table object.
     */
    public Table() {
        tableTiles = new ArrayList<>();

    }

    /**
     * Used to get the current size of the table (the amount of tiles it holds).
     * @return Integer representing table size.
     */
    public int getSize() {
        return tableTiles.size();
    }

    /**
     * Used to get the first (leftmost) Tile of the table.
     * @return The Tile object of the leftmost Tile of the table.
     */
    public Tile getFirstTile() {
        return tableTiles.get(0);
    }

    /**
     * Used to get the last (rightmost) Tile of the table.
     * @return The Tile object of the rightmost Tile of the table.
     */
    public Tile getLastTile() {
        return tableTiles.get(tableTiles.size() - 1);
    }

    /**
     * Used to add a new Tile to the table.
     * @param piece the tile object that will be added to the table.
     * @param side the side of the table (left - beginning or right - end) the tile will be added to.
     */
    public void addTile(Tile piece, String side) {
        //addTile receives tile after its rotation (if needed).

        if (side.equals("left")) {
            tableTiles.add(0, piece);
        } else {
            tableTiles.add(piece);
        }

    }
    
    /**
     * Called to clear the table of all its tiles
     * and reset it to an empty state (size == 0).
     */
    public void clearTable() {
        tableTiles.clear();
    }

    /**
     * Returns the table in its current state.
     * @return An ArrayList containing all the Tile objects
     * the table currently has.
     */
    public ArrayList<Tile> getTable() {
        return tableTiles;
    }

}
