package com.evanscode.engine;

/** Represents a single playing card in a standard 52-card deck. */
public record Card(Rank rank, Suit suit) {

    /**
     * Returns the Blackjack value of the card.
     * Face cards = 10
     * Ace = 11
     * Number cards = their numeric value
     */
    public int rankValue() {
        return rank.getValue();
    }

    public String rankName() {
        return rank.getDisplayName();
    }

    public String suitName() {
        return suit.getDisplayName();
    }

    public String suitSymbol() {
        return suit.getSymbol();
    }
}

