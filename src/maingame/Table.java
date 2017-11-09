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
    
    public void addTile(Tile piece) {
        //addTile receives tile after its rotation (if needed).
        Scanner input = new Scanner(System.in);
        String answer;
        boolean acceptInput = false;
        
        if (piece.getNum2() == getLastTile().getNum1() && getFirstTile().getNum2() == piece.getNum1()){
            System.out.println("There are two possible moves for this piece!");
            System.out.println("Do you want to place the piece to the left or to the right?");
            do{
                answer = input.nextLine();
                
                if (answer.equals("left") || answer.equals("right")){
                    acceptInput = true;
                }else {
                    System.out.println("Wrong entry! Please type left or right");
                }   
                
            }while(acceptInput == false);
            
        }else if (piece.getNum2() == getLastTile().getNum1()) {
            tableTiles.add(0,piece);
        }else if (getFirstTile().getNum2() == piece.getNum1()) {
            tableTiles.add(piece);
        }
        //prepei na rotaei ton paikti poy na to valei se periptosi poy tairiazei kai stis 2 meries
    }
    
    public void showTable() {
        for(Tile piece : tableTiles) {
            System.out.printf("|%d %d|", piece.getNum1(), piece.getNum2());
        }
    }
    
}
