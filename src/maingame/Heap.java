/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Sierra Kilo
 */
public class Heap {

    private ArrayList<Tile> allTiles; //contains all the 28 pieces of the domino.
    private ArrayList<ArrayList<Tile>> heapTiles; //4x7 table of all the heap tiles.
    private int pos = 0;

    public Heap() {
        
        setAllTiles(); // creates a new list with all the possible domino tiles for the game.

        heapTiles = new ArrayList<>();

        //Creating 4x7 heap Table.
        for (int i = 0; i < 4; i++) {
            ArrayList<Tile> column = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                column.add(allTiles.get(pos));
                pos++;
            }
            heapTiles.add(column);
        }
    }

    public ArrayList<ArrayList<Tile>> getHeap() {
        return heapTiles;
    }

    public void removeTile(int choice) {
        ArrayList<Tile> column;
        column = heapTiles.get(choice - 1);
        column.remove(column.size() - 1);

    }

    public Tile chooseTile(int choice) {
        //choice: 1-4
        ArrayList<Tile> column;
        column = heapTiles.get(choice - 1);
        return column.get(column.size() - 1);

    }

    public Tile pickRandomTile() {
        Random r1 = new Random();
        int tileChoice = r1.nextInt(allTiles.size());
        Tile pickedTile = allTiles.get(tileChoice);
        allTiles.remove(tileChoice);

        return pickedTile;

    }

    public void setAllTiles() {
        allTiles = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            //fills up the AllTiles ArrayList with all the existing domino pieces.
            for (int j = i; j <= 6; j++) {
                Tile Piece = new Tile(i, j);
                allTiles.add(Piece);
            }
        }
        Collections.shuffle(allTiles); //shuffles the AllTiles list (randomize).

    }

}
