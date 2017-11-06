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
public class Solo1 {
    Heap heap;
    Table table;
    
    public Solo1() {
        heap = new Heap();
        table = new Table();
        
    }
    
    public boolean checkTileChoice(Tile piece) {
        if (table.getSize() == 0) {
            //table is empty and we are placing the first tile
            table.addTile(piece,1);
        } else {
            if (piece.getNum1() == table.getFirstTile().getNum1()) {
                piece.rotateTile();
                table.addTile(piece, 0);
            }
            
            
            
            
            
            
            
                
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
            result = 1;
        } else if(table.getSize() < 28 && moveExists(table) == true ) {
            result = 0;
        } else if(table.getSize() < 28 && moveExists(table) == false) {
            result = 2;
        }
        return result;
    }
    
}
