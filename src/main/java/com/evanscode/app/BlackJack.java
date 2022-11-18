//Package
package com.evanscode.app;

//Imports
import com.evanscode.engine.Player;
import com.evanscode.engine.Shoe;
import com.evanscode.engine.Table;

import java.util.Scanner;

//Main app class
public class BlackJack {

    //Declaring variables used in main
    private static Table table;
    private static Scanner scan;
    private static int numCurrentPlayers;

    //Main method for BlackJack game
    public static void main(String[] args) {

        //Initialize scanner
        scan = new Scanner(System.in);

        //Create new table
        table = new Table();

        //Pick number of decks to use
        System.out.println("How many decks to play with?");
        final int numDecks = scan.nextInt();
        table.createNewShoe(numDecks);

        //Set number of initial players at Table
        System.out.println("How many players entering the table");
        numCurrentPlayers = scan.nextInt();
        for(int i =0; i < numCurrentPlayers; i++) {
            System.out.println("Player Name: ");
            String playerName = scan.next();
            int playerWallet = scan.nextInt();
            table.addPlayer(new Player(playerName,playerWallet));
        }

        //Loop game ADD CODE
        while(true) {

            //Get bets
            for (int i = 0; i < numCurrentPlayers; i++) {
                System.out.println("Place your bets: ");
                final int bet = scan.nextInt();

                table.setBets(i, bet);
            }

            //Deal cards
            for (int i = 0; i < numCurrentPlayers; i++) {
                table.dealCard(i);
            }

            //Each player plays round
            for(int i = 0; i < numCurrentPlayers; i++) {

            }
        }
    }
}