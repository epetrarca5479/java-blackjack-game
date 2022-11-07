package com.evanscode.engine;

import java.util.Stack;

public class Shoe {
    private int numDecks;

    //Multiple decks will be used to build the stack of cards
    private Stack<Card> shoe;

    //private Deck deck1,deck2,deck3,deck4,deck5,deck6,deck7,deck8;

    public Shoe(final int numDecks) {
        this.numDecks = numDecks;
        this.shoe = new Stack<Card>();
    }

    public Card getCard() {
        return this.shoe.pop();
    }

    public int getShoeSize() {
        return this.shoe.size();
    }

    public int getNumDecks() {
        return numDecks;
    }

    public void buildShoe() {
        for(int i = 0; i < numDecks; i++) {
            Deck deck = new Deck();
            deck.addCardsToDeck();
            deck.shuffleDeck();
            for(int j = 0; j < deck.getDeckSize(); j++) {
                this.shoe.add(deck.getCardFromDeck(i));
            }
        }



        /*
        if(numDecks == 4) {
            for(int i = 0; i < numDecks; i++) {
                Deck deck = new Deck();
                deck.addCardsToDeck();
                deck.shuffleDeck();
                for(int j = 0; j < deck.getDeckSize(); j++) {
                    this.shoe.add(deck.getCardFromDeck(i));
                }
            }
        } else if (numDecks == 8) {
            for(int i = 0; i < numDecks; i++) {
                Deck deck = new Deck();
                deck.addCardsToDeck();
                deck.shuffleDeck();
                for(int j = 0; j < deck.getDeckSize(); j++) {
                    this.shoe.add(deck.getCardFromDeck(i));
                }
            }
        }
        */
    }


    @Override
    public java.lang.String toString() {
        return "Shoe{" +
                "numDecks=" + numDecks +
                ", shoe=" + this.shoe +
                '}'
                ;
    }
}


