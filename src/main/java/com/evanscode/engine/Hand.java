//Package
package com.evanscode.engine;

//Imports

import java.util.ArrayList;
import java.util.List;

//Class to represent a player's hand of cards
public class Hand {
	private final List<Card> hand;

	//Constructor for a player's "Hand" of cards
	public Hand() {
		this.hand = new ArrayList<>();
	}

	//Add card to current hand
	public void addCardToHand(final Card newCard) {
		this.hand.add(newCard);
	}

	//Get the value of current hand
	public int getHandTotal() {
		int total = 0;

		for (Card card : this.hand) {
			total += card.getRankValue();
		}
		return total;
	}

	//Empty hand
	public void emptyHand() {
		this.hand.clear();
	}

    //Remove 2nd card
    public Card removeSecondCard() {
        Card removedCard = this.hand.get(1);
        this.hand.remove(1);
        return removedCard;
    }

	//Checks for blackjack hand
	public boolean hasBlackJack() {
		if (this.hand.size() == 2) {
			int total = 0;
			for (Card card : this.hand) {
				total += card.getRankValue();
			}
			return total == 21;
		} else {
			return false;
		}
	}

    //Checks for a possible split hand
    public Boolean canSplit(final int splitCount) {
        if (this.hand.size() != 2) return false; //must be a hand of 2 cards
        if (splitCount >= 3) return false; //max split of 4

        Card c1 = this.hand.get(0); //Get first card
        Card c2 = this.hand.get(1); //Get second card

        //Returns result when comparing card 1 to card 2s rank
        return c1.getCardRank().equals(c2.getCardRank());
    }

    //Returns the hand
	public String getCards() {
		return this.hand.toString();
	}
}
