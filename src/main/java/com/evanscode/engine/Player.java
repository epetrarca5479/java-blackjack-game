package com.evanscode.engine;

public class Player {
    private String name;
    private int chips;
    private Hand hand;
    private String decision;

    //Constructor for a Player (hand is built)
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new Hand();
    }

    //Clear player's hand
    public void clearHand() {
        hand.emptyHand();
    }

    //Subtract the bet chips from a player's chips
    public void removeChips(final int bet) {
        this.chips -= bet;
    }

    //Add chip winnings to player's chips
    public void collectChips(final int winnings) {
        this.chips += winnings;
    }
}
