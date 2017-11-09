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
    
    public Hungarian(){
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
        } else{
            return 2;
        }
    }
    
    public void run() {
        int playingNow; //1 means player is playing, 2 means bot is playing.
        Scanner input = new Scanner(System.in);
        int choice;
        
        do{
            playingNow = whoPlaysFirst();
            do{
                if (playingNow == 1) {
                    player.showPlayerTiles();
                    
                    do{
                       System.out.println("Choose which tile you want to play with (1-" + player.getPlayerTilesAmount());
                       choice = input.nextInt(); 
                    }while(choice < 1 || choice > player.getPlayerTilesAmount());
                    
                    table.addTile(player.playTile(choice));
                    
                    
                }
                
                
            }while(//round has not ended);
            
            
            
        }while(//score < 100);
    }
    
}
