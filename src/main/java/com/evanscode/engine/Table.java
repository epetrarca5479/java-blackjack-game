package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** Represents a Blackjack table */
public class Table {

    /** Fields */
    private final List<Player> players;
    private final Hand dealerHand;
    private Shoe shoe;
    private double betMinimum;
    private double betMaximum;
    public static final int MAX_PLAYERS = 7;
    private final int tableID;

    /** Constructor for a table */
    public Table(final int tableID, final double minBet, final double maxBet) {
        this.tableID = tableID;
        this.players = new ArrayList<>();
        this.dealerHand = new Hand(0);
        setBetMinimum(minBet);
        setBetMaximum(maxBet);
    }

    /** Getting and setting betting limits */
    public int getBetMinimum() {
        return betMinimum;
    }
    public int getBetMaximum() {
        return betMaximum;
    }
    public void setBetMinimum(int amount) {
        this.betMinimum = amount;
    }
    public void setBetMaximum(int amount) {
        this.betMaximum = amount;
    }

    /** Table player logic */
    public Player getPlayer(final int index) {
        return players.get(index);
    }
    public void addPlayer(final Player player) {
        if (isFull()) {
            throw new IllegalStateException("Table is full");
        }
        players.add(player);
    }
    public void removePlayer(final Player player) {
        if (!players.remove(player)) {
            throw new IllegalStateException("Player not found at table");
        }
    }
    public int getPlayerCount() {
        return players.size();
    }
    public boolean isFull() {
        return getPlayerCount() >= MAX_PLAYERS;
    }

    /** Shoe & Hand logic */
    public void createNewShoe(final int numDecks) {
        this.shoe = new Shoe(numDecks);
    }
    public void dealCard(final int playerIndex, final int handIndex) {
        Card card = shoe.draw();
        players.get(playerIndex).getHand(handIndex).addCard(card);
    }
    public void dealDealerCard() {
        dealerHand.addCard(shoe.draw());
    }
    public void clearHands() {
        /* Clear deaLer hand */
        dealerHand.clear();

        /* Clear players hands, count of hands,  */
        for (Player player : this.players) {
            player.clear();
        }
    }
    public Hand getDealerHand() {
        return dealerHand;
    }
    public Card showDealerCard() {
        /* Dealer’s visible card (2nd card, since 1st is face down) */
        return dealerHand.getSecondCard();
    }
}
