package com.evanscode.engine;

import java.util.ArrayList;
import java.util.List;

/** Represents a Blackjack table */
public class Table {

    /* =============================================================
       ======================   FIELDS   ============================
       ============================================================= */

    private final List<Player> players;
    private final Hand dealerHand;
    private Shoe shoe;

    private int betMinimum;
    private int betMaximum;

    public static final int MAX_PLAYERS = 7;

    /* =============================================================
       ====================   CONSTRUCTOR   =========================
       ============================================================= */

    public Table() {
        this.players = new ArrayList<>();
        this.dealerHand = new Hand();

        setBetMinimum(10);
        setBetMaximum(1000);
    }

    /* =============================================================
       ==================   BETTING LIMITS   ========================
       ============================================================= */

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

    /* =============================================================
       ====================   PLAYER LOGIC   =========================
       ============================================================= */

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

    public boolean isFull() {
        return getPlayerCount() >= MAX_PLAYERS;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public Player getPlayer(final int index) {
        return players.get(index);
    }

    /* =============================================================
       ======================   SHOE LOGIC   ========================
       ============================================================= */

    public void createNewShoe(final int numDecks) {
        this.shoe = new Shoe(numDecks);
    }

    /* =============================================================
       ====================   DEALING CARDS   ========================
       ============================================================= */

    public void dealCard(final int playerIndex, final int handIndex) {
        Card card = shoe.draw();
        players.get(playerIndex).getHand(handIndex).addCardToHand(card);
    }

    public void setPlayerBet(final int playerIndex, final int betAmount) {
        players.get(playerIndex).setBet(betAmount);
    }

    /* =============================================================
       ====================   DEALER LOGIC   ========================
       ============================================================= */

    public void dealDealerCard() {
        dealerHand.addCardToHand(shoe.draw());
    }

    public void clearDealerHand() {
        dealerHand.emptyHand();
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    /** Dealer’s visible card (2nd card, since 1st is face down) */
    public Card showDealerCard() {
        return dealerHand.getSecondCard();
    }
}
