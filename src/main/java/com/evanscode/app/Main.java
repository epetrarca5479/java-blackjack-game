//Package
package com.evanscode.app;

//Imports

import com.evanscode.engine.Card;
import com.evanscode.engine.Shoe;

import java.util.Scanner;

//Main app class
public class Main {

    //Declaring variables used in main
    private static Shoe shoe;
    private static Scanner scan;
    private static int numDecks;

    //Main method for BlackJack game
    public static void main(String[] args) {

        //Get input from user
        scan = new Scanner(System.in);
        System.out.println("How many decks to play with?");
        int numDecks = scan.nextInt();

        //Build shoe
        Shoe shoe = new Shoe(numDecks);
        shoe.buildShoe();

        //Print shoe
        for (int i = 0; i < shoe.getShoeMaxSize(); i++) {

            //Get temp card variable
            Card tempCard = shoe.getCard();

            //Print
            System.out.println(tempCard.getCardRank() + " " + tempCard.getCardSuit());
        }
    }
}