package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** Class to represent a players hand in a game of blackjack */
public class Hand {

    /** Fields */
    private final List<Card> hand;
    private double bet;

    /** Constructor */
    public Hand(final double bet) {
        this.hand = new ArrayList<>();
        this.bet = bet;
    }

    /** Adding card to a hand */
    public void addCard(final Card newCard) {
        this.hand.add(newCard);
    }

    /** Get a hand's cards as a toString */
    public String getCards() {
        return this.hand.toString();
    }

    /** Get the second card in a hand */
    public Card getSecondCard() {
        if (this.hand.size() < 2) return null;
        return this.hand.get(1);
    }

    /** Getting a hands total  */
    public int getTotal() {
        int total = 0;
        int aces = 0;

        for (Card card : this.hand) {
            int value = card.rankValue();
            if (value == 11) aces++;
            total += value;
        }

        /* Adjust Aces downward */
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    /** Clearing a hand */
    public void clear() {
        this.hand.clear();
        this.bet = 0;
    }

    /** Checking for blackjack */
    public boolean hasBlackJack() {
        return this.hand.size() == 2 && getTotal() == 21;
    }

    /** Checking if a hand can be split */
    public boolean canSplit(final int splitCount) {
        if (this.hand.size() != 2) return false;
        if (splitCount >= 3) return false;

        Card c1 = this.hand.get(0);
        Card c2 = this.hand.get(1);

        /* For rank-based matching */
        return c1.rank().equals(c2.rank());

        /* For 10-value split rules
        return c1.value() == c2.value();*/
    }

    /** Remove the second card from a hand */
    public void removeSecondCard() {
        if (this.hand.size() == 2) {
            this.hand.remove(1);
        }
    }

    /** Place a hand's bet */
    public void setBet(final double bet) {
        this.bet = bet;
    }

    /** Get a hand's bet */
    public double getBet() {
        return this.bet;
    }
}
