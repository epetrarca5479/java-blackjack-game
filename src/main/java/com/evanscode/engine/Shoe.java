package com.evanscode.engine;

import java.util.*;

/**
 * Represents a shoe of multiple shuffled decks used in Blackjack.
 * Typically, 4–8 decks.
 */
public class Shoe {

    /** FIELDS */
    private final int deckCount;
    private final Deque<Card> cards;

    /** CONSTRUCTOR */
    public Shoe(int deckCount) {
        this.deckCount = deckCount;
        this.cards = new ArrayDeque<>();
        List<Card> tempCards = new ArrayList<>();

        /* Create and combine decks of cards */
        for (int i = 0; i < deckCount; i++) {
            tempCards.addAll(new Deck().getCards());
        }

        /* Shuffle the combined decks */
        Collections.shuffle(tempCards);

        /* Load cards into shoe */
        for (Card card : tempCards) {
            cards.addLast(card);
        }
    }
    /** Draws and removes the next card from the shoe. */
    public Card draw() {
        return cards.removeFirst();
    }
    /** Number of cards remaining in the shoe. */
    public int size() {
        return cards.size();
    }
    /** DEBUG */
    @Override
    public String toString() {
        return "Shoe{numDecks=" + deckCount + ", cardsRemaining=" + cards.size() + "}";
    }
}
