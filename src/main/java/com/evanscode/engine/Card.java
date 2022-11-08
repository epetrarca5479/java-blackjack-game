//Package
package com.evanscode.engine;

//Class to represent a Card from a standard deck of Cards
public class Card {
    private String rank;
    private Suit cardSuit;

    public Card(final String rank, final Suit cardSuit) {
        this.rank = rank;
        this.cardSuit = cardSuit;
    }

    //Getter for a card's Rank
    public String getCardRank() {
        return rank;
    }

    //Getter for a card's Suit
    public Suit getCardSuit() {
        return cardSuit;
    }

    public int getRankValue() {
        //Checks for Jack, Queen, or King cards
        if(rank == "J" || rank == "Q" || rank == "K") {
            return 10;
        }
        //Check for Ace card (defaults to 1; May need to be updated later for cases when A should = 11)
        else if (rank == "A") {
            return 1;
        }
        //Any other card will have the value as the rank is described
        else {
            return Integer.parseInt(rank);
        }
    }
}
