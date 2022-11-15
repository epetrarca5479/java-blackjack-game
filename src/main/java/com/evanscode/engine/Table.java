//Package
package com.evanscode.engine;

//Imports
import java.util.ArrayList;
import java.util.List;

//Class to represent a BlackJack table
public class Table {
    private final List<Player> players;
    private Shoe shoe;

    //Constructor for a table object
    public Table() {
        this.players = new ArrayList<>();
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

    public void dealCard(int playerIndex) {
        this.players.get(playerIndex).addCard(this.shoe.getNextCard());
    }
}
