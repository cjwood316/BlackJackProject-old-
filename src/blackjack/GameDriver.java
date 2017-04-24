package blackjack;

import java.util.Scanner;

public class GameDriver {

	Scanner kb = new Scanner(System.in);

	public void runGame() {
		Dealer dealer = new Dealer();
		dealer.shuffleDeck();
		Player player = new Player();
		player.getHand().addCard(dealer.deal());
		dealer.getHand().addCard(dealer.deal());
		player.getHand().addCard(dealer.deal());
		dealer.getHand().addCard(dealer.deal());
		showPlayerCards(player);
		System.out.println("Player Total " + playerTotal(player));
		showDealerCards(dealer);
		System.out.println("Dealer Total " + dealerTotal(dealer));
		blackJack(player, dealer);
		
		turnChoiceMenu();
		
		int turnChoice = kb.nextInt();

		if (turnChoice == 1) {
			playerHit(player, dealer);
			if (playerTotal(player) < 21) {
				
				turnChoiceMenu();
			}
				
		} else if (turnChoice == 2) {
			playerStay(player);
			dealer(dealer);
			stayWinCondition(player, dealer);
		} else {
			System.out.println("Input not valid. Try Again!");
		}

	}
	
	public void turnChoiceMenu(){
		System.out.println("|************************************************|");
		System.out.println("|                Hit or Stay                     |");
		System.out.println("|                  1. Hit                        |");
		System.out.println("|                  2. Stay                       |");
		System.out.println("|************************************************|");
		
		
	}

	public void playerHit(Player player, Dealer dealer) {
		player.getHand().addCard(dealer.deal());
		showPlayerCards(player);
		System.out.println("Player Total " + playerTotal(player));

		if (playerTotal(player) > 21) {
			System.out.println("Player Bust. You lose!!");
			System.exit(0);
		}
		if (playerTotal(player) == 21) {
			System.out.println("Player got 21. You win!!");
			System.exit(0);
		}
		if(playerTotal(player) < 21){
			turnChoiceMenu();
			int hitOrStay = kb.nextInt();
			
			if (hitOrStay == 1) {
				playerHit(player, dealer);
		}
			else if(hitOrStay == 2){
				playerStay(player);
				dealer(dealer);
				stayWinCondition(player, dealer);
				
			}
		}
	}

	public void stayWinCondition(Player player, Dealer dealer){
		if (playerTotal(player) > dealerTotal(dealer)) {
			System.out.println("Player has the higher hand");
			System.out.println("You win!!!!");
			System.exit(0);
		}
		if (dealerTotal(dealer) > playerTotal(player)) {
			System.out.println("Dealer has the higher hand");
			System.out.println("Dealer wins!!!!");
			System.exit(0);
		}
		if (dealerTotal(dealer) == playerTotal(player)) {
			System.out.println("The totals are equal.");
			System.out.println("Draw!!!!");
			System.exit(0);
		}
		
	}
	public void playerStay(Player player) {
		System.out.println("Player chooses to stay with: ");
		showPlayerCards(player);
		System.out.println("Player Total " + playerTotal(player));

	}

	public void dealer(Dealer dealer) {
		if (dealerTotal(dealer) <= 16) {
			System.out.println("Dealer hit and got: ");
			System.out.println();
			dealer.getHand().addCard(dealer.deal());
			showDealerCards(dealer);
			System.out.println("Dealer Total " + dealerTotal(dealer));
		} else if (dealerTotal(dealer) > 16) {
			System.out.println("Dealer choose to stay with: ");
			System.out.println();
			showDealerCards(dealer);
			System.out.println("Dealer Total " + dealerTotal(dealer));
		}
		if (dealerTotal(dealer) == 21) {
			System.out.println("Dealer has 21! Dealer Wins!");
			System.exit(0);
		}
		if (dealerTotal(dealer) > 21) {
			System.out.println("Dealer busted... Dealer Loses!");
			System.exit(0);
		}
	}

	public void blackJack(Player player, Dealer dealer) {
		if (playerTotal(player) == 21 || dealerTotal(dealer) == 21) {
			if (playerTotal(player) == 21) {
				System.out.println("Player got 21! Player win!");
				System.exit(0);
			} else {
				System.out.println("Dealer got 21! Dealer win!");
				System.exit(0);
			}
		}

	}

	public static void showPlayerCards(Player player) {
		for (Card card : player.getHand().getCards()) {
			System.out.println("Player: " + card);
		}
	}

	public static void showDealerCards(Dealer dealer) {
		for (Card card : dealer.getHand().getCards()) {
			System.out.println("Dealer: " + card);
		}
	}

	public static int playerTotal(Player player) {
		int total = 0;
		for (Card card : player.getHand().getCards()) {
			total = total + card.getValue();
		}
		return total;
	}

	public static int dealerTotal(Dealer dealer) {
		int total = 0;
		for (Card card : dealer.getHand().getCards()) {
			total = total + card.getValue();
		}
		return total;
	}
}