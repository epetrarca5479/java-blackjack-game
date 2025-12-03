package com.evanscode.engine;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Represents a shoe of multiple shuffled decks used in Blackjack.
 * Typically, 4–8 decks.
 */
public class Shoe {

    /* =============================================================
       ========================   FIELDS   ===========================
       ============================================================= */

    private final int numDecks;
    private final Deque<Card> cards;

    /* =============================================================
       =====================   CONSTRUCTOR   =========================
       ============================================================= */

    public Shoe(int numDecks) {
        this.numDecks = numDecks;
        this.cards = new ArrayDeque<>();
        buildShoe();
    }

    /* =============================================================
       =====================   SHOE BUILDING   =======================
       ============================================================= */

    /** Builds the shoe by creating and shuffling decks. */
    private void buildShoe() {
        for (int i = 0; i < numDecks; i++) {
            Deck deck = new Deck();
            deck.shuffle();

            for (int j = 0; j < deck.size(); j++) {
                cards.add(deck.get(j));
            }
        }
    }

    /* =============================================================
       ======================   CARD DRAWING   =======================
       ============================================================= */

    /** Draws and removes the next card from the shoe. */
    public Card draw() {
        return cards.removeFirst();
    }

    /** Number of cards remaining in the shoe.
    public int size() {
        return cards.size();
    }*/

    /* =============================================================
       =========================   DEBUG   ============================
       ============================================================= */

    @Override
    public String toString() {
        return "Shoe{numDecks=" + numDecks + ", cardsRemaining=" + cards.size() + "}";
    }
}
