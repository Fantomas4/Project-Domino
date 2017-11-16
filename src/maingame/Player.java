/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

import java.util.ArrayList;

/**
 *
 * @author Sierra Kilo
 */
public class Player {

    ArrayList<Tile> playerTiles;
    int score;
    String name;
    boolean bot;
    Heap heap;

    public Player(String name, String type, int tilesAmount, Heap heap) {

        score = 0;

        if (type.equals("Human")) {
            bot = false;
        } else if (type.equals("Bot")) {
            bot = true;
        }

        this.name = name;
        this.heap = heap;
        
        givePlayerTiles(tilesAmount); //gives player
    }

    public int getScore() {
        return score;
    }

    public String getPlayerName() {
        return name;
    }

    public ArrayList<Tile> getPlayerTiles() {
        return playerTiles;
    }

    public int getRemainingTilePoints() {
        int sum = 0;

        for (Tile piece : playerTiles) {
            sum += piece.getNum1() + piece.getNum2();
        }
        return sum;
    }

    public void givePlayerTiles(int tilesAmount) {
        playerTiles = new ArrayList<>();

        for (int i = 1; i <= tilesAmount; i++) {
            playerTiles.add(heap.pickRandomTile());
        }

    }

    public void increaseScore(int points) {
        score += points;

    }

    public Tile getHighestTile() {
        // (-1,-1) is a tile representing that the player has no tiles with num1 == num2
        Tile maxTile = new Tile(-1, -1);

        for (Tile piece : playerTiles) {
            if (piece.getNum1() == piece.getNum2()) {
                if (piece.getNum1() > maxTile.getNum1()) {
                    maxTile = piece;
                }
            }

        }
        return maxTile;
    }

    public void showPlayerTiles() {
        for (Tile piece : playerTiles) {
            System.out.printf("|%d %d|", piece.getNum1(), piece.getNum2());
        }
    }

    public int getPlayerTilesAmount() {
        return playerTiles.size();
    }

    public Tile chooseTile(int choice) {

        return playerTiles.get(choice - 1);
    }

    public void removeTile(int choice) {
        // choice index 1 - amount of player tiles
        playerTiles.remove(choice - 1);
    }

    public boolean isBot() {
        return bot;
    }

}
