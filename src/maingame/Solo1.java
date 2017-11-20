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
public class Solo1 {

    private Heap heap;
    private Table table;

    public Solo1() {
        heap = new Heap();
        table = new Table();

    }

    public void run() {
        Scanner input = new Scanner(System.in);
        String answer;
        int choice;
        Tile chosenTile;
        ArrayList<PossibleMove> result;

        do {
            System.out.println("Heap: ");
            showHeap();
            System.out.printf("%n%n%n");
            
            do {
                System.out.println("Enter the row from which you want to take the Tile (1-4): ");
                choice = input.nextInt();

                if (choice < 1 || choice > 4) {
                    System.out.println("Wrong choice number! Choose a number from 1 to 4");
                    //continue;
                } else {
                    chosenTile = heap.chooseTile(choice);
                    result = checkTileChoice(chosenTile);
                    if (result.size() == 0) {
                        //there is no possible move with the chosen tile.
                        System.out.println("There is no possible move with the chosen tile! Try again!");
                        //continue
                    } else if (result.size() == 1) {
                        //there is one possible move so tile is placed automatically

                        if (result.get(0).needsRotation() == true) {
                            chosenTile.rotateTile();
                        }
                        table.addTile(chosenTile, result.get(0).whereToPlace());
                        heap.removeTile(choice);
                        break;

                    } else {
                        //there are more 2 possible moves 
                        //so user is asked about where to place tile

                        System.out.println("There are 2 possible moves with this tile.");
                        System.out.println("Do you want to place the tile left or right?");
                        do {
                            answer = input.nextLine();
                            if (answer.equals("left") || answer.equals("right")) {
                                break;
                            } else {
                                System.out.println("Please enter left or right as an answer.");
                            }
                        } while (true);

                        if (result.get(0).whereToPlace().equals(answer)) {
                            if (result.get(0).needsRotation() == true) {
                                chosenTile.rotateTile();
                            }
                            table.addTile(chosenTile, answer);
                            heap.removeTile(choice);
                            break;

                        } else if (result.get(1).whereToPlace().equals(answer)) {
                            if (result.get(1).needsRotation() == true) {
                                chosenTile.rotateTile();
                            }
                            table.addTile(chosenTile, answer);
                            heap.removeTile(choice);
                            break;
                        }

                    }

                }

            } while (true);
            
            System.out.println("Table: ");
            showTable();
            System.out.printf("%n%n%n");

        } while (gameStatus() == 1); // 1: game in progress.

   if (gameStatus() == 0) {
            System.out.println("Game over! There are no possible moves left!");
        } else if (gameStatus() == 2) {
            System.out.println("Congratulations! You have won!");
        }
    }

    public boolean possibleMoveExists() {
        ArrayList<PossibleMove> result;
        for (int i = 1; i < 5; i++) {
            result = checkTileChoice(heap.chooseTile(i)); //choose tile accepts int in range 1-4.

            if (result.size() > 0) { //if a list containing at least one possible move is returned
                return true;
            }
        }
        return false;
    }

    public ArrayList<PossibleMove> checkTileChoice(Tile piece) {

        ArrayList<PossibleMove> result = new ArrayList<>();

        if (table.getSize() == 0) {
            //table is empty and we are placing the first tile.
            result.add(new PossibleMove(false, "left")); // no rotation needed, tile can be placed on both sides
        } else {

            if (piece.getNum1() == table.getFirstTile().getNum1()) {
                result.add(new PossibleMove(true, "left"));

            } else if (piece.getNum2() == table.getFirstTile().getNum1()) {
                result.add(new PossibleMove(false, "left"));

            }

            if (piece.getNum1() == table.getLastTile().getNum2()) {
                result.add(new PossibleMove(false, "right"));
            } else if (piece.getNum2() == table.getLastTile().getNum2()) {
                result.add(new PossibleMove(true, "right"));
            }
        }
        return result;
    }
  
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
    
    public void showTable() {
        
        ArrayList<Tile> tableTiles = table.getTable();
        
        for (Tile piece : tableTiles) {
            System.out.printf("|%d %d|", piece.getNum1(), piece.getNum2());
        }
    }
    
    public void showHeap() {
        
        ArrayList<ArrayList<Tile>> heapTiles = heap.getHeap();
        
        for (int i = 0; i < heapTiles.size(); i++) {
            ArrayList<Tile> column = heapTiles.get(i);
            for (int j = 0; j < column.size(); j++) {
                Tile piece = column.get(j);
                System.out.printf("|%d %d| ", piece.getNum1(), piece.getNum2());
            }
            System.out.printf("%n%n");
        }
    }

}
