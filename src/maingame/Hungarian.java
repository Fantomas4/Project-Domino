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
    Player winner; // holds the Player object of the winner set by scoreLimitReached() func.
    int tilesAmount; // how many tiles each player is supposed to be given. Depends on type of game (2,3 or 4 players).
    // value is initialized for gamemode == 2 (2 players).

    public Hungarian(int mode) {
        gamemode = mode;
        heap = new Heap();
        table = new Table();
        playerOrderedList = new ArrayList<>();

        if (gamemode == 2) {
            tilesAmount = 12;
        } else if (gamemode == 3) {
            tilesAmount = 8;
        } else if (gamemode == 4) {
            tilesAmount = 6;
        }

        playerOrderedList.add(new Player("Human", "Human", tilesAmount, heap));

        for (int i = 1; i < gamemode; i++) {
            //adds as many bots to playerlist as the chosen game mode needs.
            playerOrderedList.add(new Player("Bot" + i, "Bot", tilesAmount, heap));
        }

    }

    private int firstPlayerIndex() {

        Player firstPlayer = playerOrderedList.get(0); //gets the first player ( the Human) for the 
        //ordered player list and initializes the firstPlayer with him.
        int index = 0; // position of the player playing first in the playerOrderedList

        for (int i = 1; i < playerOrderedList.size(); i++) {
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
            //System.out.println("LOOP 1");
            playingNowIndex = firstPlayerIndex();
            playingNowObj = playerOrderedList.get(playingNowIndex);

            do {
                System.out.printf("%n%n%n%n%n%n");
                System.out.println("==================================================================================");
                for (Player player : playerOrderedList) {
                    //prints each player's hand at the beginning of each move.
                    System.out.printf(player.getPlayerName() + " player's hand: ");
                    showPlayerTiles(player);
                    System.out.printf("%n");
                }
                System.out.println("==================================================================================");
                System.out.printf("%n");

                playingNowObj = playerOrderedList.get(playingNowIndex); // playingNowObj gets the Player object of the player that is to play now.

                //System.out.println("LOOP 2");
                System.out.println("*** Player  > " + playingNowObj.getPlayerName() + " <  is playing now. ***");
                System.out.printf("%n");
                System.out.printf("Table: ");
                showTable();
                System.out.printf("%n%n");
                System.out.printf("Player tiles: ");
                showPlayerTiles(playingNowObj);
                System.out.printf("%n");

                if (playingNowObj.isBot() == true) {
//                    //TEMP FOR DIAG ONLY
//                    System.out.println("^^^^DIAG: I AM A BOT!");
//                    System.out.println("^^^^DIAG: BOT TILES: ");
//                    playingNowObj.showPlayerTiles();
//                    System.out.printf("%n%n");
//                    //TEMP FOR DIAG ONLY

                    // ****** WORK IN PROGRESS ******* 
                    //the player that plays now is a bot
                    ArrayList<Tile> botTiles = playingNowObj.getPlayerTiles();
                    ArrayList<PossibleMove> botResult;
                    Tile botChosenTile;

                    for (int i = 0; i < botTiles.size(); i++) {
                        //System.out.println("LOOP 3");
                        botChosenTile = botTiles.get(i);
                        botResult = checkTileChoice(botChosenTile);
                        if (botResult.size() > 0) {
                            //System.out.println("DOMI IF 1");
                            // if at least one move exists for the selected bot tile.
                            if (botResult.get(0).needsRotation() == true) {
                                botChosenTile.rotateTile();
                            }
                            table.addTile(botChosenTile, botResult.get(0).whereToPlace());
                            playingNowObj.removeTile(i + 1); //removes tile from player's hand.
                            break;
                        }
                    }

                } else {
                    //the player that plays now is Human
//                    System.out.println("DIAG: I AM A HUMAN!");
//                    System.out.println("^^^^DIAG: HUMAN TILES: ");
//                    playingNowObj.showPlayerTiles();
//                    System.out.printf("%n%n");

                    do {
                        //System.out.println("LOOP 4");
                        System.out.printf("%n");
                        System.out.println("Choose which tile you want to play with (1-" + playingNowObj.getPlayerTilesAmount() + "): ");
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

                    System.out.println("==================================================================================");
                }

                playingNowIndex = whoPlaysNext();

            } while (playingNowIndex >= 0);

            int pointsGiven = giveRoundPoints();
            System.out.printf("%n%n%n");
            System.out.println("*** END OF ROUND! ***");
            System.out.println("$$$ Points given: " + pointsGiven);

            //clear game table for next round.
            table.clearTable();
            //reset tiles heap (from where players are given their tiles).
            heap.setAllTiles();
            //give new tiles to players for next round.
            for (Player player : playerOrderedList) {
                player.givePlayerTiles(tilesAmount);
            }

        } while (scoreLimitReached() == false);

        System.out.println("*** Player " + winner.getPlayerName() + " has won the game! ***");

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

    public int whoPlaysNext() {

        // returns index of playerOrderedList for the player that is to play next or -1 if no player has a possible move.
        int resultIndex = -1;

        if (possibleMoveExists(playerOrderedList.get(playingNowIndex)) == true) {
            //first we check if the player who plays now has a possible move.
            //System.out.println("===================Mpika 1");
            resultIndex = playingNowIndex;
        } else {
            //System.out.println("===================Mpika 2");
            //System.out.println("===================DIAG: before playingNowIndex: " + playingNowIndex);
            int indexLimit = playerOrderedList.size() - 1; // last index number
            int pos = playingNowIndex + 1; // we begin from the immediate next index from the index of the player playing now.
            //then we search in the order of the playerOrderedList for the first player that has a possible move.
            //System.out.println("===================DIAG: after playingNowIndex: " + playingNowIndex);
            int loops = 0; // counter - number of times the do-while loop below has been executed

            do {
                //System.out.println("===================POS IS: " + pos);
                if (pos > indexLimit) {
                    //System.out.println("===================Mpika 3");
                    // if we reach the last true index number, we reset the pos to 0 index.
                    pos = 0;
                }

                if (possibleMoveExists(playerOrderedList.get(pos)) == true) {
                    //System.out.println("===================Mpika 4");
                    resultIndex = pos;
                    break;
                } else {
                    //System.out.println("===================Mpika 5");
                    pos++;
                }

                loops++;

            } while (loops < playerOrderedList.size() - 1); // we check playerOrderedList.size() - 1 times since we have already 
            //checked whether the playingNowIndex player had a move using the initial if statement at the beginning of the function.               
        }

        //System.out.println("DIAG: the resultIndex return by function is: " + resultIndex);
        return resultIndex;

    }

    public int giveRoundPoints() {

        //increases player points in player object and returns total points added.
        int totalPoints = 0;
        int minPoints = playerOrderedList.get(0).getRemainingTilePoints();
        int minPlayerIndex = 0;

        // calculates the total sum of points of the tiles still in every player's hand.
        for (int i = 1; i < playerOrderedList.size(); i++) {

            totalPoints += playerOrderedList.get(i).getRemainingTilePoints();

            if (playerOrderedList.get(i).getRemainingTilePoints() < minPoints) {
                minPoints = playerOrderedList.get(i).getRemainingTilePoints();
                minPlayerIndex = i;
            }
        }

        totalPoints -= playerOrderedList.get(minPlayerIndex).getRemainingTilePoints(); //removes the points of the player that has the fewest points
        //in his hand and is about to receive the totalPoints sum.
        playerOrderedList.get(minPlayerIndex).increaseScore(totalPoints); //gives accumulated points to the
        // player who has the fewest points.

        return totalPoints;

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

    public void showTable() {

        ArrayList<Tile> tableTiles = table.getTable();

        for (Tile piece : tableTiles) {
            System.out.printf("|%d %d|", piece.getNum1(), piece.getNum2());
        }
    }
    
    public void showPlayerTiles(Player player) {
        
        ArrayList<Tile> playerTiles = player.getPlayerTiles();
        
        for (Tile piece : playerTiles) {
            System.out.printf("|%d %d|", piece.getNum1(), piece.getNum2());
        }
    }

}
