//Package
package com.evanscode.engine;

//Imports
import java.util.ArrayList;
import java.util.List;

//Class to represent a player's hand of cards
public class Hand {
    private List<Card> hand;
    //Constructor for a player's "Hand" of cards
    public Hand(){
        this.hand = new ArrayList<>();
    }

    //Add card to current hand
    public void addCardToHand(Card newCard) {
        this.hand.add(newCard);
    }

    //Get the value of current hand
    public int getHandTotal() {
        int total = 0;

         for(Card card : hand) {
             total += card.getRankValue();
         }
         return total;
    }

    //Empty hand
    public void emptyHand() {
        this.hand.clear();
    }
}
