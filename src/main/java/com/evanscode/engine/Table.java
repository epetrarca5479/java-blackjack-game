package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Player> players;
    int bank;
    Shoe shoe;
    int minBet;
    Player currentPlayer;
    //float blackJackPayout;
    //Dealer dealer; may implement later

    public Table() {
        this.players = new ArrayList<Player>();
        this.bank = 1000000; //Initial bankroll of 1 million
    }

    public void addPlayer(final Player newPlayer) {
        this.players.add(newPlayer);
    }

    public int getBankTotal() {
        return this.bank;
    }

    public void createNewShoe(final int numDecks) {
        this.shoe = new Shoe(numDecks);
    }

    public Shoe getShoe() {
        return this.shoe;
    }

    public void setMinBet(final int minBet) {
        this.minBet = minBet;
    }

    public int getMinBet() {
        return this.minBet;
    }

    public void setCurrentPlayer(final int playerIndex) {
        this.currentPlayer = this.players.get(playerIndex);
    }

    public Player getCurrentPlayer(final int playerIndex) {
        return this.currentPlayer = this.players.get(playerIndex);
    }
}
