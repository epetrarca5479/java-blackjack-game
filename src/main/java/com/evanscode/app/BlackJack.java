package com.evanscode.app;

import com.evanscode.engine.*;

import java.util.Scanner;

public class BlackJack {

    // loop variable to continue playing
    static boolean keepPlaying = true;

    // Main method for BlackJack game
    public static void main(String[] args) {

        //Initialize scanner
        Scanner scan = new Scanner(System.in);

        //Create new table
        Table table = new Table();

        //Pick number of decks to use and build a Shoe
        System.out.println("How many decks to play with?");
        final int numDecks = scan.nextInt();
        table.createNewShoe(numDecks);

        //Create initial players at a Table
        System.out.println("How many players entering the table");
        int numCurrentPlayers = scan.nextInt();
        for (int i = 0; i < numCurrentPlayers; i++) {
            System.out.println("Player Name: ");
            String playerName = scan.next();
            System.out.println("Player Wallet: ");
            int playerWallet = scan.nextInt();
            table.addPlayer(new Player(playerName, playerWallet));
        }

        // Get bets
        System.out.println("Current betting limits\nMin: " + table.getBetLimit("min") + "\nMax: " + table.getBetLimit("max"));
        for (int i = 0; i < numCurrentPlayers; i++) {
            //Set each player back to active
            table.getPlayer(i).changeActive(true);

            //Check if player has enough money in wallet for minimum bet.
            if (table.getPlayer(i).getChips() < table.getBetLimit("min")) {
                System.out.println(table.getPlayer(i).getName() + " has insufficient chips");
                table.getPlayer(i).changeActive(false);
            }
            else {
                System.out.println(table.getPlayer(i).getName() + " please place your bet: ");
                final int bet = scan.nextInt();
                table.setBets(i, bet);
            }
            return;
        }

        //Deal first card to player(s) then the dealer, then the second card to each player
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < numCurrentPlayers; i++) {
                table.dealCard(i, 0);
            }
            table.dealDealerCard();
        }

        //If dealer shows an ace ask if player wants insurance
        if (table.showDealerCard().getCardRank() == "A") {
            for (int i = 0; i < table.)
        }

        //Check Dealer 21
        final Hand potentialDealerBJ = table.getDealerCards();

        //Dealer has BJ
        if (potentialDealerBJ.hasBlackJack()) {
            //Check if player has blackjack
            for (int i = 0; i < numCurrentPlayers; i++) {
                //Player has BJ
                if (table.getPlayer(i).getHand(0).hasBlackJack()) {
                    //PUSH; Player breaks even.
                    System.out.println("Push for: " + table.getPlayer(i).getName());
                }
                //Player missing a BJ
                else {
                    //Dealer Wins; Check for insurance / Remove chips from player hand
                    table.getPlayer(i).removeChips(table.getPlayer(i).getBet());
                }
            }

            //Clear Hands
            table.clearDealerHand();
            for (int i = 0; i < numCurrentPlayers; i++) {
                for (int j = 0; j < table.getPlayer(j).getHandCount(); j++)
                    table.getPlayer(i).clearHand(j);
            }
        } else {
            //Each player plays round
            for (int i = 0; i < numCurrentPlayers; i++) {
                boolean keepPlaying = true;

                //Check player blackjack
                if (table.getPlayer(i).getHand(0).hasBlackJack()) {
                    //Award player chips immediately, player turn ends
                    double winnings = 1.5 * table.getPlayer(i).getBet();
                    keepPlaying = false;
                }

                //Player plays hand(s)
                for (int j = 0; j < table.getPlayer(i).getHandCount(); j++) {
                    while (keepPlaying) {
                        if (table.getPlayer(i).getHandCount() == 1) {
                            System.out.println("Player Turn: " + table.getPlayer(i).getName());
                            System.out.println("Cards: " + table.getPlayer(i).getHand(j).getCards());
                            System.out.println("Hand Total: " + table.getPlayer(i).getHand(j).getHandTotal());
                            System.out.println("Dealers Card: " + table.showDealerCard());
                        } else {
                            //Check for possible split
                            //if(splitIsPossible) {
                            System.out.println("Test");
                        }
                    }

                    //Decide to keep playing
                    System.out.println("Press 'Y' to continue playing or 'N' to stop playing.");
                    String continueChar = scan.next();
                    keepPlaying = continueChar.equalsIgnoreCase("Y");
                }
            }
        }
    }
}
