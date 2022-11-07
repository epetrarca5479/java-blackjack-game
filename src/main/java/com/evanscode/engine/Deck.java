package com.evanscode.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Use a SET data structure
public class Deck {

    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public ArrayList<Card> getDeck() {
        return (ArrayList<Card>) deck;
    }

    public int getDeckSize() {
        return deck.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void addCardsToDeck() {
        //String rank, Suit cardSuit, int value)
        deck.add(new Card("A", Suit.Spades));
        deck.add(new Card("2", Suit.Spades));
        deck.add(new Card("3", Suit.Spades));
        deck.add(new Card("4", Suit.Spades));
        deck.add(new Card("5", Suit.Spades));
        deck.add(new Card("6", Suit.Spades));
        deck.add(new Card("7", Suit.Spades));
        deck.add(new Card("8", Suit.Spades));
        deck.add(new Card("9", Suit.Spades));
        deck.add(new Card("10", Suit.Spades));
        deck.add(new Card("J", Suit.Spades));
        deck.add(new Card("Q", Suit.Spades));
        deck.add(new Card("K", Suit.Spades));
        deck.add(new Card("A", Suit.Diamonds));
        deck.add(new Card("2", Suit.Diamonds));
        deck.add(new Card("3", Suit.Diamonds));
        deck.add(new Card("4", Suit.Diamonds));
        deck.add(new Card("5", Suit.Diamonds));
        deck.add(new Card("6", Suit.Diamonds));
        deck.add(new Card("7", Suit.Diamonds));
        deck.add(new Card("8", Suit.Diamonds));
        deck.add(new Card("9", Suit.Diamonds));
        deck.add(new Card("10", Suit.Diamonds));
        deck.add(new Card("J", Suit.Diamonds));
        deck.add(new Card("Q", Suit.Diamonds));
        deck.add(new Card("K", Suit.Diamonds));
        deck.add(new Card("A", Suit.Clubs));
        deck.add(new Card("2", Suit.Clubs));
        deck.add(new Card("3", Suit.Clubs));
        deck.add(new Card("4", Suit.Clubs));
        deck.add(new Card("5", Suit.Clubs));
        deck.add(new Card("6", Suit.Clubs));
        deck.add(new Card("7", Suit.Clubs));
        deck.add(new Card("8", Suit.Clubs));
        deck.add(new Card("9", Suit.Clubs));
        deck.add(new Card("10", Suit.Clubs));
        deck.add(new Card("J", Suit.Clubs));
        deck.add(new Card("Q", Suit.Clubs));
        deck.add(new Card("K", Suit.Clubs));
        deck.add(new Card("A", Suit.Hearts));
        deck.add(new Card("2", Suit.Hearts));
        deck.add(new Card("3", Suit.Hearts));
        deck.add(new Card("4", Suit.Hearts));
        deck.add(new Card("5", Suit.Hearts));
        deck.add(new Card("6", Suit.Hearts));
        deck.add(new Card("7", Suit.Hearts));
        deck.add(new Card("8", Suit.Hearts));
        deck.add(new Card("9", Suit.Hearts));
        deck.add(new Card("10", Suit.Hearts));
        deck.add(new Card("J", Suit.Hearts));
        deck.add(new Card("Q", Suit.Hearts));
        deck.add(new Card("K", Suit.Hearts));
    }

    public Card getCardFromDeck(final int index) {
        return deck.get(index);
    }

}
