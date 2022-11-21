//Package
package com.evanscode.engine;

//Imports
import java.util.ArrayList;
import java.util.List;

//Class to represent a BlackJack table
public class Table {
    private final List<Player> players;
    private final Hand dealerHand;
    private Shoe shoe;
    private int totalPlayers;
    private int bank;

    //Constructor for a table object
    public Table() {
        this.players = new ArrayList<>();
        this.dealerHand = new Hand();
        this.bank = 1000000; //Initial bankroll of 1 million
        this.totalPlayers = 0;
    }

    public int getBankTotal() {
        return this.bank;
    }

    public void addToBank(final int chips) {
        this.bank += chips;
    }
    public void subtractFromBank(final int chips) {
        this.bank -= chips;
    }

    //Method to add a Player object to the table
    public void addPlayer(final Player newPlayer) {
        if(this.totalPlayers < 7) {
            this.players.add(newPlayer);
            this.totalPlayers++;
        }
        else {
            throw  new IllegalStateException("Table is full");
        }
    }

    public Player getPlayer(final int playerIndex) {
        return this.players.get(playerIndex);
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
