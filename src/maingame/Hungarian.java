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
public class Hungarian {

    Heap heap;
    Table table;
    Player player;
    Bot bot;

    public Hungarian() {
        heap = new Heap();
        table = new Table();
        player = new Player();
        bot = new Bot();
    }

    private int whoPlaysFirst() {
        //returns 1 if player is to play first. 
        //returns 2 if bot is to play first
        Tile playerTile = player.getHighestTile();
        Tile botTile = bot.getHighestTile();

        if (playerTile.getNum1() > botTile.getNum1()) {
            return 1;
        } else {
            return 2;
        }
    }

    public void run() {
        int playingNow; //1 means player is playing, 2 means bot is playing.
        Scanner input = new Scanner(System.in);
        int choice;
        Tile chosenTile;

        do {
            playingNow = whoPlaysFirst();
            do {
                switch (playingNow) {

                    case 1:
                        player.showPlayerTiles();
                        do {
                            System.out.println("Choose which tile you want to play with (1-" + player.getPlayerTilesAmount());
                            choice = input.nextInt();

                            if (choice < 1 || choice > player.getPlayerTilesAmount()) {
                                System.out.println("Wrong choice number!");
                                //continue;
                            } else {
                                chosenTile = player.chooseTile(choice);

                                if (checkTileChoice(chosenTile) == 0) {
                                    System.out.println("Invalid move. Please try again!");
                                    //continue
                                } else if (checkTileChoice(chosenTile) == 1) {
                                    table.addTile(chosenTile);
                                    player.removeTile(choice);
                                    break;
                                } else if (checkTileChoice(chosenTile) == 2) {
                                    chosenTile.rotateTile();
                                    table.addTile(chosenTile);
                                    player.removeTile(choice);
                                    break;
                                }
                            }

                        } while (true);
                        break;
                    case 2:
                        

//                            
                }

            } while (h partida den teleiose);
            
            
            
        
        } while (player.getScore() < 100 && bot.getScore() < 100);
    
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
            return 1;
        } else if (piece.getNum2() == table.getLastTile().getNum2()) {
            return 2;

            //incorrect tile choice from heap incompatible with table
        } else {
            return 0;
        }

    }

}
