package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

// Class to represent a BlackJack table
public class Table {
    private final List<Player> players;
    private final Hand dealerHand;
    private Shoe shoe;
    private int totalPlayers;
    private int betMinimum;
    private int betMaximum;

    // Constructor for a table object
    public Table() {
        this.players = new ArrayList<>();
        this.dealerHand = new Hand();
        this.totalPlayers = 0;
        this.betMinimum = 10;
        this.betMaximum = 1000;
    }

    //Method for getting table betting limits
    public int getBetLimit(String limitType) {
        if (limitType.equals("max")) {
            return betMaximum;
        } else if (limitType.equals("min")) {
            return betMinimum;
        } else System.out.println("Incorrect input");
        return 0;
    }

    // Method for modifying betting limits
    public void changeBetLimit(String limitType, int limit) {
        if (limitType.equals("max")) {
            betMaximum = limit;
        } else if (limitType.equals("min")) {
            betMinimum = limit;
        } else System.out.println("Incorrect input");
    }

    // Method to add a Player object to the table
    public void addPlayer(final Player newPlayer) {
        if (this.totalPlayers < 7) {
            this.players.add(newPlayer);
            this.totalPlayers++;
        } else {
            throw new IllegalStateException("Table is full");
        }
    }

    // Getter for a player at the table
    public Player getPlayer(final int playerIndex) {
        return this.players.get(playerIndex);
    }

    // Method to create a new shoe using number of decks provided
    public void createNewShoe(final int numDecks) {
        this.shoe = new Shoe(numDecks);
    }

    // Method to deal a card to a player
    public void dealCard(final int playerIndex, final int playersHand) {
        this.players.get(playerIndex).getHand(playersHand).addCardToHand(this.shoe.getNextCard());
    }

    // Method to set a player bet
    public void setBets(final int playerIndex, final int playerBet) {
        this.players.get(playerIndex).setBet(playerBet);
    }

    // Method to deal the dealer a card
    public void dealDealerCard() {
        this.dealerHand.addCardToHand(this.shoe.getNextCard());
    }

    // Method to clear the dealer's current hand
    public void clearDealerHand() {
        this.dealerHand.emptyHand();
    }

    // Method to return a dealer current hand
    public Hand getDealerCards() {
        return this.dealerHand;
    }

    // Method to return the second Card (for use with a dealer, as first is face down)
    public Card showDealerCard() {
        return this.dealerHand.getSecondCard();
    }

    // Methods for getting the number of players at a table
}
