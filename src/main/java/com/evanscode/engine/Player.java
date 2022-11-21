//Package
package com.evanscode.engine;

//Class to represent a player
public class Player {
    private final String name;
    private int chips;
    private final Hand hand;
    private String move;
    private int bet;
    private int insurance;

    //Constructor for a Player
    public Player(final String name, final int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new Hand();
    }

    //Getter for a PLayer's name
    public String getName() {
        return this.name;
    }

    //Getter for a Player's chips
    public int getChips() {
        return this.chips;
    }

    //Getter for a Player's move
    public String getDecision() {
        return this.move;
    }

    //Getter for a Player's bet
    public int getBet() {
        return this.bet;
    }

    //Setter for Player's move
    public void setMove(final String newMove) {
        this.move = newMove;
    }

    //Setter for a PLayer's bet
    public void setBet(final int bet) {
        this.bet = bet;
    }

    //Clear player's hand
    public void clearHand() {
        this.hand.emptyHand();
    }

    //Add a card to a Player's hand
    public void addCard(final Card newCard) {
        this.hand.addCardToHand(newCard);
    }

    //Subtract chips from Player
    public void removeChips(final int chips) {
        this.chips -= chips;
    }

    //Give chips to Player
    public void addChips(final int chips) {
        this.chips += chips;
    }

    //Setter for a Player's insurance bet
    public void setInsurance(final int insuranceBet) {
        this.insurance = insuranceBet;
    }

    //Getter for a PLayer's insurance bet
    public int getInsurance() {
        return this.insurance;
    }

    public Hand getHand() {
        return this.hand;
    }
}
