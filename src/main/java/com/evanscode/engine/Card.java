package com.evanscode.engine;

public class Card {
    private String rank;
    private Suit cardSuit;

    public Card(final String rank, final Suit cardSuit) {
        this.rank = rank;
        this.cardSuit = cardSuit;
    }

    public String getCardRank() {
        return rank;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

}
