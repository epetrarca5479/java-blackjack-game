//Package
package com.evanscode.engine;

//Imports

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Class to represent a deck of cards
//A deck is represented as a set (in this case a LIST) of 52 playing Cards
public class Deck {

	//Declaring variables in a deck
	private final List<Card> deck;

	//Constructing a deck object by initializing an ArrayList of Cards
	public Deck() {
		this.deck = new ArrayList<>();
	}

	//Getter for returning the Deck's size
	public int getDeckSize() {
		return this.deck.size();
	}

	//Setter for randomizing or "shuffling" the deck
	public void shuffleDeck() {
		Collections.shuffle(this.deck);
	}

	//Setter for adding each card in a standard 52 card deck of cards to the current deck (Legit order of a real deck, minus jokers)
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

	//Getter for returning a specific card from the deck
	public Card getCardFromDeck(final int index) {
		return this.deck.get(index);
	}
}
