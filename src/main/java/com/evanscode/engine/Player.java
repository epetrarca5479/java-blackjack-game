package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** Represents a blackjack player */
public class Player {

    /** FIELDS */
    private final String name;
    private double chips;
    private final List<Hand> hands;
    private boolean isActive;
    private double insurance;
    private String decision;

    /** CONSTRUCTOR */
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hands = new ArrayList<>();
        this.hands.add(new Hand(0));    // Start with one default hand
        this.isActive = true;
        this.insurance = 0;
        this.decision = null;
    }

    /** Get a hand */
    public Hand getHand(final int index) {
        return this.hands.get(index);
    }

    /** Clear a players hand(s) and some player variables */
    public void clear() {
        /* Clear player variables */
        this.insurance = 0;
        this.decision = null;

        /* Clear hands */
        for (Hand hand : this.hands) {
            hand.clear();
        }
    }

    /** Get current count of hands a player has */
    public int getHandCount() {
        return hands.size();
    }

    public void buyInsurance(final double insuranceBet) {
        removeChips(insuranceBet);
        this.insurance = insuranceBet;
    }

    /** Checks if insurance bet is allowed */
    public boolean canBuyInsurance(double insuranceBet, double originalBet) {
        double maxInsurance = originalBet / 2.0;

        /* Preventing a 0 from being entered when buying insurance */
        if (insuranceBet <= 0) {
            System.out.println("❌ Insurance bet must be greater than zero.");
            return false;
        }
        /* Preventing an insurance bet greater than the amount initially bet */
        if (insuranceBet > maxInsurance) {
            System.out.println("❌ Insurance bet cannot exceed half your original bet (" + maxInsurance + ").");
            return false;
        }
        /* Preventing a player from placing an insurance bet when chip balance is less than the desired insurance bet  */
        if (!canBet(insuranceBet)) {
            System.out.println("❌ You don't have enough balance for that bet.");
            return false;
        }
        return true;
    }

    /** Get a player's insurance bet */
    public double getInsurance() {
        return this.insurance;
    }

    /** Get a player's chip balance */
    public double getChips() {
        return this.chips;
    }

    /** Deducts an amount from the player's chip balance */
    public void removeChips(final double amount) {
        this.chips -= amount;
    }

    /** Add an amount to the player's chip balance */
    public void addChips(final double amount) {
        this.chips += amount;
    }

    /** Get a player's name */
    public String getName() {
        return this.name;
    }

    /** Get a player's activity */
    public boolean isActive() {
        return this.isActive;
    }

    /** Set a player's name */
    public void setActive(boolean active) {
        this.isActive = active;
    }

    /** Get a player's decision */
    public String getDecision() {
        return this.decision;
    }

    /** Set a player's name */
    public void setDecision(final String decision) {
        this.decision = decision;
    }

    /** Determine if a player can place a bet for a hand */
    public boolean canBet(final double amount) {
        return this.chips >= amount;
    }
}
