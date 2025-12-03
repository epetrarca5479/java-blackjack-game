package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> hand;
    private double bet;
    private boolean finished; // true when player stands or doubles

    public Hand(double bet) {
        this.hand = new ArrayList<>();
        this.bet = bet;
        this.finished = false;
    }

    // Add card
    public void addCardToHand(final Card newCard) {
        this.hand.add(newCard);
    }

    // Get the value of the hand
    public int getHandTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.value();
        }
        return total;
    }

    // Remove second card (for split)
    public Card removeSecondCard() {
        return this.hand.remove(1);
    }

    public boolean hasBlackJack() {
        return this.hand.size() == 2 && getHandTotal() == 21;
    }

    public boolean canSplit(final int currentSplitCount) {
        if (this.hand.size() != 2) return false;
        if (currentSplitCount >= 3) return false;

        Card c1 = this.hand.get(0);
        Card c2 = this.hand.get(1);

        return c1.rank().equals(c2.rank());
    }

    // Betting system for this hand
    public double getBet() {
        return bet;
    }

    public void doubleDown() {
        this.bet *= 2;
        this.finished = true;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public void emptyHand() {
        this.hand.clear();
    }

    public String getCards() {
        return this.hand.toString();
    }
}
