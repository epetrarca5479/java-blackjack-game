package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

// Class to represent a player
public class Player {
    private final String name;
    private double chips;
    private final List<Hand> hands;
    private String move;
    private double bet;
    private double insurance;
    private int handCount;
    private boolean isActive;
    private int currentHandIndex;

    // Constructor for a Player
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hands = new ArrayList<>();
        this.hands.add(new Hand()); //Add the player's initial hand
        this.handCount = 0;
        this.isActive = true;
        this.insurance = 0;
        this.currentHandIndex = 0;
    }

    public int getCurrentHandIndex() {
        return this.currentHandIndex;
    }

    public void setCurrentHandIndex(final int hand) {
        this.currentHandIndex = hand;
    }

    // Method to modify a players active status in a hand
    public void setActive(boolean active) {
        this.isActive = active;
    }

    // Method to check players active status in a current hand
    public boolean getActive() {
        return this.isActive;
    }

    // Getter for a PLayer's name
    public String getName() {
        return this.name;
    }


    // Reset Player hand count
    public void resetHandCount() {
        this.handCount = 0;
    }

    // Increment hand count
    public void increaseHandCount() {
        this.handCount++;
    }

    // Getter for number of active hands
    public int getHandCount() {
        return this.handCount;
    }


    // Getter for a Player's chips
    public double getChips() {
        return this.chips;
    }

    // Getter for a Player's move
    public String getDecision() {
        return this.move;
    }

    // Setter for a Player's move
    public void setDecision(final String move) {
        this.move = move;
    }

    // Getter for a Player's bet
    public double getBet() {
        return this.bet;
    }

    // Setter for Player's move
    public void setMove(final String newMove) {
        this.move = newMove;
    }

    // Setter for a Player's bet
    public void setBet(final double bet) {
        this.bet = bet;
        removeChips(bet);
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
    public void removeChips(final double chips) {
        this.chips -= chips;
    }

    // Give chips to Player
    public void addChips(final double chips) {
        this.chips += chips;
    }

    // Setter for a Player's insurance bet
    public void buyInsurance(final double insuranceBet) {
        removeChips(insuranceBet);
        this.insurance = insuranceBet;
    }

    // Checks if insurance bet is valid
    public boolean isValidInsuranceBet(double insuranceBet, double originalBet, double balance) {
        double maxInsurance = originalBet / 2.0;

        if (insuranceBet > maxInsurance) {
            System.out.println("❌ Insurance bet cannot exceed half your original bet (" + maxInsurance + ").");
            return false;
        }
        if (insuranceBet > balance) {
            System.out.println("❌ You don't have enough balance for that bet.");
            return false;
        }
        if (insuranceBet <= 0) {
            System.out.println("❌ Insurance bet must be greater than zero.");
            return false;
        }

        return true;
    }

    // Getter for a Player's insurance bet
    public double getInsurance() {
        return this.insurance;
    }

    // Getter for a players hand
    public Hand getHand(final int handToGet) {
        return this.hands.get(handToGet);
    }

}
