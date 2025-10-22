//Package
package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

// Class to represent a player
public class Player {
    private final String name;
    private int chips;
    private final List<Hand> hands;
    private String move;
    private int bet;
    private int insurance;
    private int splitCount;
    private boolean isActive;

    // Constructor for a Player
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hands = new ArrayList<>();
        this.hands.add(new Hand()); //Add the player's initial hand
        this.splitCount = 0;
        this.isActive = true;
    }

    // Method to modify a players active status in a hand
    public void changeActive(boolean active) {
        if (active == true) {
            isActive = true;
        } else if (active == false) {
            isActive = false;
        }
    }

    // Method to check players active status in a current hand
    public boolean getActive() {
        return this.isActive;
    }

    // Getter for a PLayer's name
    public String getName() {
        return this.name;
    }

    // Reset Player split count
    public void resetSplitCount() {
        this.splitCount = 0;
    }

    // Increment split count
    public void increaseSplitCount() {
        this.splitCount++;
    }

    // Getter for number of active hands
    public int getHandCount() {
        return this.hands.size();
    }

    // Getter for a Player's chips
    public int getChips() {
        return this.chips;
    }

    // Getter for a Player's move
    public String getDecision() {
        return this.move;
    }

    // Getter for a Player's bet
    public int getBet() {
        return this.bet;
    }

    // Setter for Player's move
    public void setMove(final String newMove) {
        this.move = newMove;
    }

    // Setter for a Player's bet
    public void setBet(final int bet) {
        this.bet = bet;
    }

    // Clear player's hand
    public void clearHand(int handToClear) {
        this.hands.get(handToClear).emptyHand();
    }

    // Add a card to a Player's hand
    public void addCard(final Card newCard, final int handToAddTo) {
        this.hands.get(handToAddTo).addCardToHand(newCard);
    }

    // Subtract chips from Player
    public void removeChips(final int chips) {
        this.chips -= chips;
    }

    // Give chips to Player
    public void addChips(final int chips) {
        this.chips += chips;
    }

    // Setter for a Player's insurance bet
    public void setInsurance(final int insuranceBet) {
        this.insurance = insuranceBet;
    }

    // Getter for a Player's insurance bet
    public int getInsurance() {
        return this.insurance;
    }

    // Getter for a players hand
    public Hand getHand(final int handToGet) {
        return this.hands.get(handToGet);
    }

    // Split a hand
    public void splitHand(final Hand hand) {
        // Cant split
        if (!hand.canSplit(this.splitCount)) return;

        // Can split, creates new hand, places 2nd card in new hand,
        Card cardToMove = hand.removeSecondCard();
        Hand newHand = new Hand();
        newHand.addCardToHand(cardToMove);

        // Add the new hand to the player's list of hands
        this.hands.add(newHand);

        // Increment split count
        this.increaseSplitCount();
    }
}
