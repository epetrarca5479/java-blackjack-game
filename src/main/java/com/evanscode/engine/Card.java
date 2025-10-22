//Package
package com.evanscode.engine;

// Class to represent a Card from a standard deck of 52 Cards
public record Card(String rank, Suit cardSuit) {

    // Getter for a card's Rank
    public String getCardRank() {
        return this.rank;
    }


    // Getter for a cards value
    public int getRankValue() {
        // Checks for Jack, Queen, or King cards
        if (this.rank.equals("J") || this.rank.equals("Q") || this.rank.equals("K")) {
            return 10;
        }
        // Check for Ace card (defaults to 1; May need to be updated later for cases when A should = 11)
        else if (this.rank.equals("A")) {
            return 1;
        }
        // Any other card will have the value as the rank is described
        else {
            return Integer.parseInt(this.rank);
        }
    }
}
