//Package
package com.evanscode.app;

//Imports

import com.evanscode.engine.*;

import java.util.Scanner;

//Main app class
public class BlackJack {

	//Create boolean Play loop
	static boolean keepPlaying = true;

	//Main method for BlackJack game
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


		//Loop game ADD CODE
		while (keepPlaying) {

			//Get bets
			for (int i = 0; i < numCurrentPlayers; i++) {
				System.out.println("Place your bets: ");
				final int bet = scan.nextInt();

				table.setBets(i, bet);
			}

			//Deal first card to players then the dealer, then the second card
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < numCurrentPlayers; i++) {
					table.dealCard(i);
				}
				table.dealDealerCard();
			}

			//insurance CODE LATER

			//Check Dealer 21
			final Hand potentialDealerBJ = table.getDealerCards();

			if (potentialDealerBJ.hasBlackJack()) {
				//Check if player has blackjack
				for (int i = 0; i < numCurrentPlayers; i++) {
					if (table.getPlayer(i).getHand().hasBlackJack()) {
						//PUSH
						System.out.println("Push for player: " + i + 1); // EDIT THIS
					} else {
						//Remove chips from player hand
						table.getPlayer(i).removeChips(table.getPlayer(i).getBet());
					}
				}

				//Clear Hands
				table.clearDealerHand();
				for (int i = 0; i < numCurrentPlayers; i++) {
					table.getPlayer(i).clearHand();
				}
			} else {
				//Each player plays round
				for (int i = 0; i < numCurrentPlayers; i++) {

					//Do something
					System.out.println("Do something");

				}
			}

			//Decide to keep playing
			System.out.println("Press 'Y' to continue playing or 'N' to stop playing.");
			String continueChar = scan.next();
			keepPlaying = continueChar.equalsIgnoreCase("Y");
		}
	}
}