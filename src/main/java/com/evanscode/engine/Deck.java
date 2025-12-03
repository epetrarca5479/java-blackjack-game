package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** Represents a standard 52-card deck. */
public class Deck {
    /** FIELDS */
    private final List<Card> cards = new ArrayList<>();
    /** CONSTRUCTOR */
    public Deck() {
        String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        /* Create and add each card to a deck */
        for (Suit suit : Suit.values()) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }
    /** Get cards from deck */
    public List<Card> getCards() {
        return this.cards;
    }
}
