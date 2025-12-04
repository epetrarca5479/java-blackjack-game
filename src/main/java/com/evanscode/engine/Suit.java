package com.evanscode.engine;

/** Represents a cards suit in a standard 52-card deck. */
public enum Suit {
    CLUBS("Clubs", "f"),
    DIAMONDS("Diamonds", "♦"),
    HEARTS("Hearts", "♥"),
    SPADES("Spades", "♠");

    private final String displayName;
    private final String symbol;

    Suit(String displayName, String symbol) {
        this.displayName = displayName;
        this.symbol = symbol;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return displayName + " " + symbol;
    }
}
