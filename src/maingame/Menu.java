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
public class Menu {

    public Menu() {
    }

    public int menuChoice() {

        Scanner input = new Scanner(System.in);
        int choice;
        
        System.out.printf("%n%n%n%n%n%n");
        System.out.println("                ======== Welcome to the Domino game ========");
        System.out.printf("%n%n%n");
        System.out.println("> Select an option: ");
        System.out.printf("%n");
        System.out.println("0. Exit program.");
        System.out.println("1. Start a new Solo 1 game.");
        System.out.println("2. Start a new Hungarian game for 2 players.");
        System.out.printf("%n%n");

        do {
            choice = input.nextInt();
            if (choice < 0 || choice > 2) {
                System.out.printf("%n%n");
                System.out.printf("> Wrong choice number. Please choose one of the given options. %n");
                System.out.printf("> Select an option: ");
            }
        } while (choice < 0 || choice > 2);

        return choice;

    }

}
