package com.evanscode.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Use a ArrayList
public class Deck {

    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public ArrayList<Card> getDeck() {
        return (ArrayList<Card>) this.deck;
    }

    public int getDeckSize() {
        return this.deck.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
        System.out.println(this.deck.toString());
    }

    public void addCardsToDeck() {
        //String rank, Suit cardSuit, int value)
        this.deck.add(new Card("A", Suit.Spades));
        this.deck.add(new Card("2", Suit.Spades));
        this.deck.add(new Card("3", Suit.Spades));
        this.deck.add(new Card("4", Suit.Spades));
        this.deck.add(new Card("5", Suit.Spades));
        this.deck.add(new Card("6", Suit.Spades));
        this.deck.add(new Card("7", Suit.Spades));
        this.deck.add(new Card("8", Suit.Spades));
        this.deck.add(new Card("9", Suit.Spades));
        this.deck.add(new Card("10", Suit.Spades));
        this.deck.add(new Card("J", Suit.Spades));
        this.deck.add(new Card("Q", Suit.Spades));
        this.deck.add(new Card("K", Suit.Spades));
        this.deck.add(new Card("A", Suit.Diamonds));
        this.deck.add(new Card("2", Suit.Diamonds));
        this.deck.add(new Card("3", Suit.Diamonds));
        this.deck.add(new Card("4", Suit.Diamonds));
        this.deck.add(new Card("5", Suit.Diamonds));
        this.deck.add(new Card("6", Suit.Diamonds));
        this.deck.add(new Card("7", Suit.Diamonds));
        this.deck.add(new Card("8", Suit.Diamonds));
        this.deck.add(new Card("9", Suit.Diamonds));
        this.deck.add(new Card("10", Suit.Diamonds));
        this.deck.add(new Card("J", Suit.Diamonds));
        this.deck.add(new Card("Q", Suit.Diamonds));
        this.deck.add(new Card("K", Suit.Diamonds));
        this.deck.add(new Card("A", Suit.Clubs));
        this.deck.add(new Card("2", Suit.Clubs));
        this.deck.add(new Card("3", Suit.Clubs));
        this.deck.add(new Card("4", Suit.Clubs));
        this.deck.add(new Card("5", Suit.Clubs));
        this.deck.add(new Card("6", Suit.Clubs));
        this.deck.add(new Card("7", Suit.Clubs));
        this.deck.add(new Card("8", Suit.Clubs));
        this.deck.add(new Card("9", Suit.Clubs));
        this.deck.add(new Card("10", Suit.Clubs));
        this.deck.add(new Card("J", Suit.Clubs));
        this.deck.add(new Card("Q", Suit.Clubs));
        this.deck.add(new Card("K", Suit.Clubs));
        this.deck.add(new Card("A", Suit.Hearts));
        this.deck.add(new Card("2", Suit.Hearts));
        this.deck.add(new Card("3", Suit.Hearts));
        this.deck.add(new Card("4", Suit.Hearts));
        this.deck.add(new Card("5", Suit.Hearts));
        this.deck.add(new Card("6", Suit.Hearts));
        this.deck.add(new Card("7", Suit.Hearts));
        this.deck.add(new Card("8", Suit.Hearts));
        this.deck.add(new Card("9", Suit.Hearts));
        this.deck.add(new Card("10", Suit.Hearts));
        this.deck.add(new Card("J", Suit.Hearts));
        this.deck.add(new Card("Q", Suit.Hearts));
        this.deck.add(new Card("K", Suit.Hearts));
    }

    public Card getCardFromDeck(final int index) {
        return this.deck.get(index);
    }

}
