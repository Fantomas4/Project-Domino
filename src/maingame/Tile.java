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
public class Tile {
    private int num1;
    private int num2;
    
    public Tile(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    
    }
    
    public int getNum1() {
        return num1;
        
    }
    
    public int getNum2() {
        return num2;
    }
    
    public void rotateTile() {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    
    
}
