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
public class Solo1 {

    Heap heap;
    Table table;

    public Solo1() {
        heap = new Heap();
        table = new Table();

    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int choice;
        Tile chosenTile;

        do {
            System.out.println("Heap: ");
            heap.showHeap();
            System.out.printf("%n%n%n");
            System.out.println("Table: ");
            table.showTable();
            System.out.printf("%n%n%n");

            do {
                System.out.println("Enter the row from which you want to take the Tile (1-4): ");
                choice = input.nextInt();

                if (choice < 1 || choice > 4) {
                    System.out.println("Wrong choice number! Choose a number from 1 to 4");
                    //continue;
                } else {
                    chosenTile = heap.chooseTile(choice);

                    if (checkTileChoice(chosenTile) == 0) {
                        System.out.println("Invalid move. Please try again!");
                        //continue;
                    } else if (checkTileChoice(chosenTile) == 1) {
                        table.addTile(chosenTile);
                        break;
                    } else if (checkTileChoice(chosenTile) == 2) {
                        chosenTile.rotateTile();
                        table.addTile(chosenTile);
                        break;
                    }
                }

            } while (true);

        } while (gameStatus() == 1); // 1: game in progress.
    }

    public boolean possibleMoveExists() {
        for (int i = 1; i < 5; i++) {
            if (checkTileChoice(heap.chooseTile(i)) != 0) { //choose tile accepts int in range 1-4.
                return true;
            }
        }
        return false;
    }

    public int checkTileChoice(Tile piece) {
        //result == 0 rejected choice
        //result == 1 accepted choice
        //result == 2 accepted choice but tile needs to rotate in order to be placed

        //table is empty and we are placing the first tile.
        if (table.getSize() == 0) {

            return 1;

            //there are already tiles placed on the table.
        } else if (piece.getNum1() == table.getFirstTile().getNum1()) {
            return 2;
        } else if (piece.getNum2() == table.getFirstTile().getNum1()) {
            return 1;
        } else if (piece.getNum1() == table.getLastTile().getNum2()) {
            return 2;
        } else if (piece.getNum2() == table.getLastTile().getNum2()) {
            return 2;

            //incorrect tile choice from heap incompatible with table
        } else {
            return 0;
        }

    }

//    public boolean moveExists(Table table) {
//
//        for(int i=1; i<5 ; i++) {
//            if (checkTile(heap.chooseTile(i),0) == true || checkTile(heap.chooseTile(i),1)== true ){
//                return true;
//            } 
//        }
//        return false;
//    }
//    
    public int gameStatus() {
        //0 == gameover, 1 = in progress, 2 = win
        //MPOREI NA SIKONEI KAI VELTIOSI ALGORITHMOU
        int result = 0;
        if (table.getSize() == 28) {
            result = 2;
        } else if (table.getSize() < 28 && possibleMoveExists() == true) {
            result = 1;
        } else if (table.getSize() < 28 && possibleMoveExists() == false) {
            result = 0;
        }
        return result;
    }

}
