/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maingame;

/**
 *
 * @author sierra
 */
public class PossibleMove {
    boolean rotation;   // 0: Tile needs to be rotated before placing it 
                        //1: Tile does not need to be rotated before placing it
    
    String side; //left or right
    
    public PossibleMove(boolean rotation, String side) {
        this.rotation = rotation;
        this.side = side;
    }
    
    public boolean needsRotation() {
        return rotation;
    }
    
    public String whereToPlace() {
        return side;
    }
    
}
