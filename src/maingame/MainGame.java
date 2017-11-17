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
public class MainGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userChoice;

        Menu mainMenu = new Menu();

        do {
            userChoice = mainMenu.menuChoice();

            if (userChoice == 1) {
                Solo1 gameInstance = new Solo1();
                gameInstance.run();
            } else if (userChoice == 2) {
                Hungarian gameInstance = new Hungarian(2);
                gameInstance.run();
            }

        } while (userChoice != 0);
        
        System.out.printf("%n%n%n                     ===== Thank you for playing ===== %n%n%n");

    }

}
