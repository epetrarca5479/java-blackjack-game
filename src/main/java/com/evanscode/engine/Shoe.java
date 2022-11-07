//Package
package com.evanscode.engine;

//Imports

import java.util.Stack;

//A shoe is a combination and shuffled stack of multiple decks of cards.
//A shoe will usually have 4-8 decks
//More decks in a shoe result in an increased "House" edge.
public class Shoe {
    //Variable for number of decks to play a shoe with.
    private int numDecks;

    //Multiple decks will be used to build the stack of cards
    private Stack<Card> shoe;

    //Shoe constructor that takes in an int for number of decks to use. Also initializes the shoe stack.
    public Shoe(final int numDecks) {
        this.numDecks = numDecks;
        this.shoe = new Stack<Card>();
    }

    //Remove and return a card from the top of the stack
    public Card getCard() {
        return this.shoe.pop();
    }

    //Get the Shoe's MAX size
    public int getShoeMaxSize() {
        return 52 * numDecks;
    }

    //Get the Shoe's MAX size
    public int getShoeSize() {
        return this.shoe.size();
    }

    //Return the number of Decks in the Shoe
    public int getNumDecks() {
        return numDecks;
    }

    //Creates deck(s) and add cards from deck(s) to the Shoe
    public void buildShoe() {
        for (int i = 0; i < numDecks; i++) {
            Deck deck = new Deck();
            deck.addCardsToDeck();
            deck.shuffleDeck();
            for (int j = 0; j < deck.getDeckSize(); j++) {
                this.shoe.add(deck.getCardFromDeck(j));
            }
        }
    }


    //Overriding the toString() method.
    @Override
    public java.lang.String toString() {
        return "Shoe{" + "numDecks=" + numDecks + ", shoe=" + this.shoe + '}';
    }
}


