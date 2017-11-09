/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

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
    
}
