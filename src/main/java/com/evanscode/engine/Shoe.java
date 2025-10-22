//Package
package com.evanscode.engine;

//Imports

import java.util.Stack;

//A shoe is a combination and shuffled stack of multiple decks of cards.
//A shoe will usually have 4-8 decks
//More decks in a shoe result in an increased "House" edge.
public class Shoe {
    //Variable for number of decks to play a shoe with.
    private final int numDecks;

    //Multiple decks will be used to build the stack of cards
    private final Stack<Card> shoe;

    //Shoe constructor that takes in an int for number of decks to use. Also initializes the shoe stack.
    public Shoe(final int numDecks) {
        this.numDecks = numDecks;
        this.shoe = new Stack<>();
        this.buildShoe();
    }

    //Remove and return a card from the top of the stack
    public Card getNextCard() {
        return this.shoe.pop();
    }

    //Creates deck(s) and add cards from deck(s) to the Shoe
    private void buildShoe() {
        for (int i = 0; i < this.numDecks; i++) {
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
        return "Shoe{" + "numDecks=" + this.numDecks + ", shoe=" + this.shoe + '}';
    }
}


