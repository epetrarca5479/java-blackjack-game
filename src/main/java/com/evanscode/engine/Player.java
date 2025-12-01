package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

// Represents a blackjack player
public class Player {

    /* =============================================================
       ===============   FIELDS & PLAYER STATE   ====================
       ============================================================= */

    private final String name;
    private double chips;

    private final List<Hand> hands;
    private int currentHandIndex;

    private double bet;
    private double insurance;

    private String decision;
    private boolean isActive;
    private int handCount;

    /* =============================================================
       ====================   CONSTRUCTOR   =========================
       ============================================================= */

    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;

        this.hands = new ArrayList<>();
        this.hands.add(new Hand());    // Start with one default hand

        this.currentHandIndex = 0;
        this.isActive = true;
        this.handCount = 0;
        this.insurance = 0;
    }

    /* =============================================================
       =====================   HAND LOGIC   =========================
       ============================================================= */

    public Hand getHand(final int index) {
        return this.hands.get(index);
    }

    public void clearHand(int handIndex) {
        this.hands.get(handIndex).emptyHand();
    }

    public void addCard(final Card card, final int handIndex) {
        this.hands.get(handIndex).addCardToHand(card);
    }

    public int getCurrentHandIndex() {
        return this.currentHandIndex;
    }

    public void setCurrentHandIndex(final int handIndex) {
        this.currentHandIndex = handIndex;
    }

    public void resetHandCount() {
        this.handCount = 0;
    }

    public void increaseHandCount() {
        this.handCount++;
    }

    public int getHandCount() {
        return this.handCount;
    }

    /* =============================================================
       ===================   BETTING LOGIC   ========================
       ============================================================= */

    public double getBet() {
        return this.bet;
    }

    /** Sets bet and immediately deducts chips. */
    public void setBet(final double bet) {
        this.bet = bet;
        removeChips(bet);
    }

    public void buyInsurance(final double insuranceBet) {
        removeChips(insuranceBet);
        this.insurance = insuranceBet;
    }

    public boolean isValidInsuranceBet(double insuranceBet, double originalBet, double balance) {
        double maxInsurance = originalBet / 2.0;

        if (insuranceBet <= 0) {
            System.out.println("❌ Insurance bet must be greater than zero.");
            return false;
        }
        if (insuranceBet > maxInsurance) {
            System.out.println("❌ Insurance bet cannot exceed half your original bet (" + maxInsurance + ").");
            return false;
        }
        if (insuranceBet > balance) {
            System.out.println("❌ You don't have enough balance for that bet.");
            return false;
        }

        return true;
    }

    public double getInsurance() {
        return this.insurance;
    }

    /* =============================================================
       ===================   CHIP MANAGEMENT   ======================
       ============================================================= */

    public double getChips() {
        return this.chips;
    }

    public void removeChips(final double amount) {
        this.chips -= amount;
    }

    public void addChips(final double amount) {
        this.chips += amount;
    }

    /* =============================================================
       ===================   PLAYER STATE   =========================
       ============================================================= */

    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public String getDecision() {
        return this.decision;
    }

    public void setDecision(final String decision) {
        this.decision = decision;
    }
}
