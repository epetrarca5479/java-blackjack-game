package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(final Card newCard) {
        this.hand.add(newCard);
    }

    public int getHandTotal() {
        int total = 0;
        int aces = 0;

        for (Card card : this.hand) {
            int value = card.value();
            if (value == 11) aces++;
            total += value;
        }

        // Adjust Aces downward
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public void emptyHand() {
        this.hand.clear();
    }

    public Card removeSecondCard() {
        if (this.hand.size() < 2) return null;
        return this.hand.remove(1);
    }

    public boolean hasBlackJack() {
        return this.hand.size() == 2 && getHandTotal() == 21;
    }

    public boolean canSplit(final int splitCount) {
        if (this.hand.size() != 2) return false;
        if (splitCount >= 3) return false;

        Card c1 = this.hand.get(0);
        Card c2 = this.hand.get(1);

        // If you want rank-based matching:
        return c1.rank().equals(c2.rank());

        // OR, if you want 10-value split rules:
        // return c1.value() == c2.value();
    }

    public String getCards() {
        return this.hand.toString();
    }

    public Card getSecondCard() {
        if (this.hand.size() < 2) return null;
        return this.hand.get(1);
    }
}
