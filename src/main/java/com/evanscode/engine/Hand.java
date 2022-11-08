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

    //
    public void addCardToHand(Card newCard) {
        hand.add(newCard);
    }

    public int getHandTotal() {
         int total = 0;

         for(Card card : hand) {
             total = total + card.getRankValue();
         }
         return total;
    }
}
