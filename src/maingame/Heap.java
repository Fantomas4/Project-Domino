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
    ArrayList<Tile> allTiles; //contains all the 28 pieces of the domino.
    ArrayList<ArrayList<Tile>> heapTiles; //4x7 table of all the heap tiles.
    int pos = 0;
    
    
    public Heap() {
        allTiles = new ArrayList<>();
        for (int i=0; i<6; i++) {
            //fills up the AllTiles ArrayList with all the existing domino pieces.
            for (int j=i; j<6; j++) {
                Tile Piece = new Tile(i,j);
                allTiles.add(Piece);
            }
        }
        Collections.shuffle(allTiles); //shuffles the AllTiles list (randomize).
        
        heapTiles = new ArrayList<>();
        
        //Creating 4x7 heap Table.
        for (int i=0; i<4 ; i++) {
            ArrayList<Tile> column = new ArrayList<>();  
            for (int j=0; j<7; j++) { 
                column.add(allTiles.get(pos));
                pos++;
            }
            heapTiles.add(column);
        }
    }
    
    public void showHeap() {
        for (int i=0 ; i<heapTiles.size() ; i++) {
            ArrayList<Tile> column = heapTiles.get(i);
            for (int j=0; j<column.size() ; j++) {
                Tile piece = column.get(j);
                System.out.printf("%d %d|",piece.getNum1(),piece.getNum2());  
            }
            System.out.println("%n");
        }
    }
  
    public void removeTile(int choice) {
        ArrayList<Tile> column;
        column = heapTiles.get(choice-1);
        column.remove(column.size()-1);

    } 
    
    public Tile chooseTile(int choice) {
        //choice: 1-4
        ArrayList<Tile> column;
        column = heapTiles.get(choice-1);
        return column.get(column.size()-1);
        
        
    }
    
    public Tile pickRandomTile() {
        Random r1 = new Random();
        int tileChoice = r1.nextInt(28);
        Tile pickedTile = allTiles.get(tileChoice);
        allTiles.remove(tileChoice);
        
        return pickedTile;
        
        
    }
    
    
}
