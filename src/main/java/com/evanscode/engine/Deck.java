package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** Represents a standard 52-card deck. */
public class Deck {

    /** FIELDS */
    private final List<Card> cards = new ArrayList<>();

    /** CONSTRUCTOR */
    public Deck() {
        /* Create and add each card to a deck */
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }
    /** Get cards from deck */
    public List<Card> getCards() {
        return this.cards;
    }
}
