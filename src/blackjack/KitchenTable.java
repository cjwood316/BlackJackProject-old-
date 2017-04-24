package blackjack;

import java.util.Scanner;

public class KitchenTable {
	public static void main(String[] args) {
		KitchenTable kt = new KitchenTable();
		kt.runKitchenTable();
	}

	public void gameNight() {

		System.out.println("It's Friday Night Game Night! pick your card game.");
		System.out.println("|************************************************|");
		System.out.println("|**********        Card Games          **********|");
		System.out.println("|************************************************|");
		System.out.println("|                                                |");
		System.out.println("|               1. BlackJack                     |");
		System.out.println("|               2. Unavailable                   |");
		System.out.println("|               3. Unavailable                   |");
		System.out.println("|                                                |");
		System.out.println("|************************************************|");
		System.out.println("|************************************************|");
		System.out.println("\nWhat would you like to do?");
	}

	public void runKitchenTable() {
		gameNight();
		while (true) {
			Scanner input = new Scanner(System.in);
			int menuChoice = input.nextInt();

			if (menuChoice == 1) {
				welcomeBlackJack();
			} else {
				System.out.println("Function not valid at this time, Please Try Again!");

			}

		}
	}

	public void welcomeBlackJack() {
		System.out.println("|************************************************|");
		System.out.println("|**********      Black Jack Menu       **********|");
		System.out.println("|************************************************|");
		System.out.println("|                                                |");
		System.out.println("|    1. Play                                     |");
		System.out.println("|	 2. Quit                                     |");
		System.out.println("|                                                |");
		System.out.println("|************************************************|");
		System.out.println("|************************************************|");
		System.out.println("What would you like to do?");

		Scanner userChoice = new Scanner(System.in);
		int interfaceChoice = userChoice.nextInt();


	}

}