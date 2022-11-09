//Package
package com.evanscode.app;

//Imports
import com.evanscode.engine.Shoe;

import java.util.Scanner;

//Main app class
public class BlackJack {

    //Declaring variables used in main
    private static Shoe shoe;
    private static Scanner scan;
    private static int numDecks;
    private static int numCurrentPlayers;

    //Main method for BlackJack game
    public static void main(String[] args) {

        //Get input from user
        scan = new Scanner(System.in);

        //ADD OPTIONS: this will increase or decrease difficulty
        System.out.println("How many decks to play with?");
        final int numDecks = scan.nextInt();

        //Build shoe
        Shoe shoe = new Shoe(numDecks);
        shoe.buildShoe();

        //Set initial players at Table
        System.out.println("How many players entering the table");







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