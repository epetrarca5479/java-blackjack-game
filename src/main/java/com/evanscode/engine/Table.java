//Package
package com.evanscode.engine;

//Imports
import java.util.ArrayList;
import java.util.List;

//Class to represent a BlackJack table
public class Table {
    private final List<Player> players;
    private Hand dealerHand;
    private Shoe shoe;

    //Constructor for a table object
    public Table() {
        this.players = new ArrayList<>();
        this.dealerHand = new Hand();
        int bank = 1000000; //Initial bankroll of 1 million
    }

    //Method to add a Player object to the table
    public void addPlayer(final Player newPlayer) {
        this.players.add(newPlayer);
    }

    //Method to create a new shoe using number of decks provided
    public void createNewShoe(final int numDecks) {
        this.shoe = new Shoe(numDecks);
    }

    public void dealCard(final int playerIndex) {
        this.players.get(playerIndex).addCard(this.shoe.getNextCard());
    }

    public void setBets(final int playerIndex, final int playerBet) {
        this.players.get(playerIndex).setBet(playerBet);
    }

    public void dealDealerCard() {
        this.dealerHand.addCardToHand(this.shoe.getNextCard());
    }

    public void clearDealerHand() {
        this.dealerHand.emptyHand();
    }

    public Hand getDealerCards() {
        return this.dealerHand;
    }
}
