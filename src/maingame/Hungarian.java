/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Sierra Kilo
 */
public class Hungarian {

    int gamemode; //2: two players (one human, one bot), 3: 3 players (one human, two bots) etc.
    Heap heap;
    Table table;
    ArrayList<Player> playerOrderedList; //The first position of the list containes the player that is to play now.
    Player playingNowObj;
    int playingNowIndex;
    Player winner;
    
    
    
    public Hungarian(int mode) {
        gamemode = mode;
        heap = new Heap();
        table = new Table();
        playerOrderedList = new ArrayList<>();
        playerOrderedList.add(new Player("Human","Human"));

        for (int i = 1; i < gamemode; i++) {
            //adds as many bots to playerlist as the chosen game mode needs.
            playerOrderedList.add(new Player("Bot" + i,"Bot"));
        }

    }

    private int firstPlayerIndex() {
        
        // *** WORK IN PROGRESS ***
        
        Player firstPlayer = playerOrderedList.get(0); //gets the first player ( the Human) for the 
        //ordered player list and initializes the firstPlayer with him.
        int index = 0; // position of the player playing first in the playerOrderedList
        
        
        for (int i=1 ; i < playerOrderedList.size() ; i++) {
            if (playerOrderedList.get(i).getHighestTile().getNum1() > firstPlayer.getHighestTile().getNum1()) {
                firstPlayer = playerOrderedList.get(i);
                index = i;
            }
        }
        return index; 
      
    }

    public void run() {

        Scanner input = new Scanner(System.in);
        String answer;
        int choice;
        Tile chosenTile;
        ArrayList<PossibleMove> result;

        do {
            playingNowIndex = firstPlayerIndex();
            playingNowObj = playerOrderedList.get(playingNowIndex);
            do {
                table.showTable(); 
                System.out.println("%n%n");
                
                if (playingNowObj.isBot() == true) {
                    //the player that plays now is a bot

                    // ****** WORK IN PROGRESS ******* 
                } else {
                    //the player that plays now is Human
                    playingNowObj.showPlayerTiles();

                    do {
                        System.out.println("Choose which tile you want to play with (1-" + playingNowObj.getPlayerTilesAmount());
                        choice = input.nextInt();

                        if (choice < 1 || choice > playingNowObj.getPlayerTilesAmount()) {
                            System.out.println("Wrong choice number!");
                            //continue;
                        } else {
                            chosenTile = playingNowObj.chooseTile(choice);
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
                                playingNowObj.removeTile(choice); //removes tile from player's hand.
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
                                    playingNowObj.removeTile(choice); //removes tile from player's hand.
                                    break;

                                } else if (result.get(1).whereToPlace().equals(answer)) {
                                    if (result.get(1).needsRotation() == true) {
                                        chosenTile.rotateTile();
                                    }
                                    table.addTile(chosenTile, answer);
                                    playingNowObj.removeTile(choice); //removes tile from player's hand
                                    break;
                                }

                            }

                        }

                    } while (true);

                        
                }
                
                // sets the player index for the player who is to play next.
                // if we have already reached the last player in the PlayerList,
                // the index is reset to the first player (index = 0 ).
                
                playingNowIndex++;
                if (playingNowIndex == playerOrderedList.size()) {
                    playingNowIndex = 0;
                }
                
            } while (h partida den teleiose);
            
            
        } while (scoreLimitReached() == true);
        
    
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

    public boolean possibleMoveExists(Player subject) {
        ArrayList<PossibleMove> result;
        ArrayList<Tile> playerTiles;

        playerTiles = subject.getPlayerTiles();

        for (Tile piece : playerTiles) {
            result = checkTileChoice(piece);
            if (result.size() > 0) {
                //there is at least one possible move 
                return true;
            }
        }
        return false;
    }

    public int roundStatus() {
        //0: end round, 1: player has the next move, 2: bot has the next move
        //MPOREI NA SIKONEI KAI VELTIOSI ALGORITHMOU

        
        // **** WORK IN PROGRESS **** 
        
        
        
        
//        if (playingNow == 1) {
//            if (possibleMoveExists(player) == true) {
//                return 1;
//            } else if (possibleMoveExists(bot) == true) {
//                return 2;
//            }
//
//        } else if (playingNow == 2) {
//            if (possibleMoveExists(bot) == true) {
//                return 2;
//            } else if (possibleMoveExists(player) == true) {
//                return 1;
//            }
//        }
//
//        return 0; //no possible move for neither player nor bot.

    }
    
    public boolean scoreLimitReached() {
        for (Player obj : playerOrderedList) {
            if (obj.getScore() >= 100) {
                winner = obj;
                return true;
            }
        }
        return false;
        
        
    }

}
