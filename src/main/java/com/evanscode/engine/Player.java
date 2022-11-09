package com.evanscode.engine;

public class Player {
    private String name;
    private int chips;
    private Hand hand;

    //Constructor for a Player (hand is built
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new Hand();
    }

    //Clear players hand
    public void clearHand() {
        hand.emptyHand();
    }

    //Subtract the bet from a players chips
    public void placeBet(final int bet) {
        this.chips -= bet;
    }

    public void collectChips(final int winnings) {
        this.chips += winnings;
    }
}
