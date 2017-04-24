package blackjack;

import java.util.Collections;

public class Dealer extends Player {
	Deck cardDeck = new Deck();
	Hand hand = new Hand();

	public void shuffleDeck() {
		cardDeck.createDeck();

		Collections.shuffle(cardDeck.getDeck());

	}

	public Card deal() {
		return cardDeck.getDeck().remove(0);
	}

	public Deck getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(Deck cardDeck) {
		this.cardDeck = cardDeck;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}