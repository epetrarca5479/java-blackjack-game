package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private double chips;

    // A player may have multiple hands due to splits
    private final List<Hand> hands;
    private final List<Double> bets;  // bet per hand

    // Insurance only applies to the original first hand
    private double insuranceBet;
    private boolean hasInsurance;
    private boolean isActive;

    public Player(String name, double chips) {
        this.name = name;
        this.chips = chips;
        this.hands = new ArrayList<>();
        this.bets = new ArrayList<>();
        this.isActive = true;
        this.insuranceBet = 0;
        this.hasInsurance = false;
    }

    // --- HAND MANAGEMENT ---

    public void addHand(Hand hand, double bet) {
        this.hands.add(hand);
        this.bets.add(bet);
        this.chips -= bet;
    }

    public Hand getHand(int index) {
        return hands.get(index);
    }

    public double getBet(int index) {
        return bets.get(index);
    }

    public void setBet(int index, double amount) {
        bets.set(index, amount);
    }

    public int getHandCount() {
        return hands.size();
    }

    public List<Hand> getHands() {
        return hands;
    }

    public void clearHands() {
        hands.clear();
        bets.clear();
        clearInsurance();
    }

    // --- SPLITTING ---

    public void splitHand(final int index) {
        Hand original = hands.get(index);
        double originalBet = bets.get(index);

        // Card to move to new hand
        Card secondCard = original.removeSecondCard();

        // Create new split hand
        Hand newHand = new Hand();
        newHand.addCardToHand(secondCard);

        // Each hand keeps original bet
        hands.add(newHand);
        bets.add(originalBet);

        // Deduct chips for second bet
        chips -= originalBet;
    }

    // --- INSURANCE LOGIC ---

    public boolean isValidInsuranceBet(double insuranceBet, double mainBet, double chipsAvailable) {
        if (insuranceBet <= 0) return false;
        if (insuranceBet > mainBet / 2.0) return false;
        if (insuranceBet > chipsAvailable) return false;
        return true;
    }

    public void placeInsurance(double insuranceBet) {
        this.insuranceBet = insuranceBet;
        this.hasInsurance = true;
        this.chips -= insuranceBet;
    }

    public boolean hasInsurance() {
        return hasInsurance;
    }

    public double getInsuranceBet() {
        return insuranceBet;
    }

    public void payInsuranceWin() {
        // Player gets their insurance bet back + 2:1 payout
        chips += (insuranceBet * 3);
        clearInsurance();
    }

    public void loseInsurance() {
        clearInsurance();
    }

    public void clearInsurance() {
        insuranceBet = 0;
        hasInsurance = false;
    }

    // --- CHIPS ---

    public double getChips() {
        return chips;
    }

    public void addChips(double amount) {
        chips += amount;
    }

    public String getName() {
        return name;
    }

    public void setActive(final boolean isActive) {
        this.isActive = isActive;
    }
}
