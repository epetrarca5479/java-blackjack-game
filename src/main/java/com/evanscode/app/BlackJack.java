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
    private static int numDecks;
    private static int numCurrentPlayers;

    //Main method for BlackJack game
    public static void main(String[] args) {

        //Get input from user
        scan = new Scanner(System.in);

        //Create new table, and set min bet
        table = new Table();
        System.out.println("Enter min bet: ");
        table.setMinBet(scan.nextInt());


        //ADD OPTIONS later: this will increase or decrease difficulty (for now just ask num decks to use)
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

        //Game starts

    }
}


        /*
        //Deal entire shoe
        for (int i = 0; i < shoe.getShoeMaxSize(); i++) {

            //Get temp card variable
            Card tempCard = shoe.getCard();

            //Print
            System.out.println(tempCard.getCardRank() + " " + tempCard.getCardSuit());
        }
        */