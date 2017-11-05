/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.Scanner;

/**
 *
 * @author Sierra Kilo
 */
public class MainGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int entry;
        int choice;
        Scanner input = new Scanner(System.in);
        
        
        do{
            entry = input.nextInt();    
        }
        while (entry != 0 || entry != 1 || entry != 2);
        
        switch(entry) {
            case 0:
                System.exit(entry);
            case 1:
                Solo1 currentGame = new Solo1();
                
                while (currentGame.gameStatus() == 1) {
                    currentGame.heap.showHeap();
                    System.out.println("Choose which line's (1-4) tile will be removed: ");
                    do{
                        choice = input.nextInt();
                    }while(choice < 1 || choice > 4);  
                    
                }
//                int choice;
//                int side;
//                Solo1 currentGame = new Solo1();
//                currentGame.heap.showHeap();
//                System.out.println("Choose which line's (1-4) tile will be removed: ");
//                do{
//                    choice = input.nextInt();
//                }while(choice < 1 || choice > 4);  
//                
//                System.out.println("Do you want to place the piece left(0) or right(1)?");
//                do{
//                    side = input.nextInt();
//                }while(choice != 0 || choice != 1); 
//                
//                if (currentGame.checkTile(currentGame.heap.chooseTile(choice), side)) {
//                    currentGame.table.addTile(currentGame.heap.chooseTile(choice));
//                    currentGame.heap.removeTile(choice);   
//                }else {
//                    System.out.println("Cannot place Tile on the desired location. Try again.");
//                }
//                
                
                break;
            case 2: 
                
                break;
        }      
    }
    
}
