package com.evanscode.app;

import com.evanscode.engine.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    // loop variable to continue playing (add while loop later)
    static boolean keepPlaying = true;

    // Main method for BlackJack game
    public static void main(String[] args) {

        // Declare variables
        Scanner scan = new Scanner(System.in);
        NumberFormat formatCurrency = NumberFormat.getCurrencyInstance();
        House house = new House(10000);
        Table table = new Table();

        //Pick number of decks to use and build a Shoe (should be 1-4, and not based on player input, need to change later)
        System.out.println("How many decks to play in a shoe?");
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
        System.out.println("Current betting limits\nMin: " + formatCurrency.format(table.getBetMinimum()) + "\nMax: " + formatCurrency.format(table.getBetMaximum()));
        for (int i = 0; i < numCurrentPlayers; i++) {
            //Set each player back to active
            table.getPlayer(i).setActive(true);

            //Check if player has enough money in wallet for minimum bet.
            if (table.getPlayer(i).getChips() < table.getBetMinimum()) {
                System.out.println(table.getPlayer(i).getName() + " has insufficient chips. Skipping turn...");
                table.getPlayer(i).setActive(false);
            } else {
                System.out.println(table.getPlayer(i).getName() + " please place your bet: ");
                final int bet = scan.nextInt();
                table.setPlayerBet(i, bet);
                house.addChips(bet);
            }
        }

        //Deal cards to each active player and also the dealer
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < numCurrentPlayers; i++) {
                if (table.getPlayer(i).isActive()) {
                    table.dealCard(i, 0);
                }
            }
            table.dealDealerCard();
        }

        //If dealer shows an ace ask if player wants insurance
        if (table.showDealerCard().value() == 1) {
            for (int i = 0; i < numCurrentPlayers; i++) {
                if (table.getPlayer(i).isActive()) {
                    System.out.println(table.getPlayer(i).getName() + ", would you like to buy insurance? (Enter Y for yes and N for no)");
                    String answer = scan.next();
                    if (answer.equalsIgnoreCase("Y")) {
                        double insuranceBet = 0;
                        boolean valid = false;
                        while (!valid) {
                            System.out.print("Enter insurance bet (max $" + (table.getPlayer(i).getBet() / 2.0) + "): ");
                            insuranceBet = scan.nextDouble();
                            valid = table.getPlayer(i).isValidInsuranceBet(insuranceBet, table.getPlayer(i).getBet(), table.getPlayer(i).getChips());
                        }
                        table.getPlayer(i).buyInsurance(insuranceBet);
                        house.addChips(insuranceBet);
                    }
                }
            }
        }

        //Check Dealer 21
        final Hand potentialDealerBJ = table.getDealerHand();

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
                    //Dealer Wins; Check for insurance
                    if (table.getPlayer(i).getInsurance() != 0) {
                        double insurancePayout = table.getPlayer(i).getInsurance() * 2;
                        table.getPlayer(i).addChips(insurancePayout);
                        System.out.println("Balance: " + table.getPlayer(i).getChips());
                    }
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

                //Check player blackjack
                if (table.getPlayer(i).getHand(0).hasBlackJack()) {
                    //Award player chips immediately, player turn ends
                    double winnings = 2.5 * table.getPlayer(i).getBet(); //regular hand win pays 2:1, blackjack pays
                    table.getPlayer(i).addChips(winnings);
                    table.getPlayer(i).setActive(false);
                }

                //Player plays hand(s)
                for (int j = 0; j < table.getPlayer(i).getHandCount(); j++) {

                    //Initialize player options
                    ArrayList<String> options = new ArrayList<>() {{
                        add("hit");
                        add("stand");
                        add("split");
                        add("double down");
                    }};

                    //Check if able to split
                    if(!table.getPlayer(i).getHand(j).canSplit(table.getPlayer(i).getHandCount())) {
                        options.remove("split");
                    }
                    //Check if able to double down
                    if(table.getPlayer(i).getBet() < table.getPlayer(i).getChips()) {
                        options.remove("double");
                    }

                    while (keepPlaying) {
                        //Display current hands
                        System.out.println(
                            "Player: " + table.getPlayer(i).getName() +"\n" +
                            "Hand: " + table.getPlayer(i).getHand(j).getCards() + "\n" +
                            "Hand Total: " + table.getPlayer(i).getHand(j).getHandTotal() + "\n" +
                            "Dealers Card: " + table.showDealerCard() + "\n" +
                            "Dealer Total: " + table.showDealerCard().value() + "\n\n " +
                            "What would you like to do: " + options
                        );

                        //Get player options
                        //scan.next()
                    }
                }
            }
        }
        //Code to check if we should keep playing
    }
}
