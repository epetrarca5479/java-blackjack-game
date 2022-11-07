package com.evanscode.app;

import com.evanscode.engine.Deck;
import com.evanscode.engine.Shoe;

import java.util.Scanner;

public class Main {

    private static Shoe shoe;
    private static Scanner scan;

    private static int numDecks;

    public static void main(String[] args) {

        //Get input from user
        scan = new Scanner(System.in);
        System.out.println("Playing with 4 or 8 decks?");
        int numDecks = scan.nextInt();

        //Build shoe
        Shoe shoe = new Shoe(numDecks);
        shoe.buildShoe();

        //Print shoe
        for(int i = 0; i < shoe.getShoeSize(); i++) {
            System.out.println(shoe.getCard());
        }
    }
}