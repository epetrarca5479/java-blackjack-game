//Package
package com.evanscode.engine;

//Class to represent a player
public class Player {
    private String name;
    private int chips;
    private Hand hand;
    private String decision;
    private int bet;
    private int insurance;

    //Constructor for a Player (hand is built)
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    public int getChips() {
        return this.chips;
    }
    public String getDecision() {
        return this.decision;
    }

    public int getBet() {
        return this.bet;
    }

    public void setDecision(final String decision) {
        this.decision = decision;
    }

    public void setBet(final int bet) {
        this.bet = bet;
    }


    //Clear player's hand
    public void clearHand() {
        this.hand.emptyHand();
    }

    public void addCard(final Card newCard) {
        this.hand.addCardToHand(newCard);
    }

    //Subtract the chips from a player's chips
    public void removeChips(final int chips) {
        this.chips -= chips;
    }

    //Add chips to a player's chips
    public void addChips(final int chips) {
        this.chips += chips;
    }

    public void setInsurance(final int insuranceBet) {
        this.insurance = insuranceBet;
    }

    public int getInsurance() {
        return this.insurance;
    }
}
