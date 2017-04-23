package blackjack;

import blackjack.Card;
import blackjack.Rank;
import blackjack.Suit;

public class Card {
	private Rank rank;
	private Suit suit;

	public void card(){}

	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}
