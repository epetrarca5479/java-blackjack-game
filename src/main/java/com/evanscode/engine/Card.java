package com.evanscode.engine;

/** Represents a single playing card in a standard 52-card deck. */
public record Card(String rank, Suit suit) {

    /**
     * Returns the Blackjack value of the card.
     * Face cards = 10
     * Ace = 1 (soft-hand logic handled elsewhere)
     * Number cards = their numeric value
     */
    public int value() {
        return switch (rank) {
            case "J", "Q", "K" -> 10;
            case "A" -> 1;
            default -> Integer.parseInt(rank);
        };
    }
}
