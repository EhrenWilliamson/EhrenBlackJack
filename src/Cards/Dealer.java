package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
	Hand dealerHand = new Hand();
	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	Deck newDeck = new Deck();

	public Deck getNewDeck() {
		return newDeck;
	}

	public void setNewDeck(Deck newDeck) {
		this.newDeck = newDeck;
	}

	
	public Deck getGameDeck() {
		newDeck.createDeck();
		return newDeck;
	}

	public Card draw() {
		return newDeck.getDeck().remove(0);
	}

	public void shuffle() {
		Collections.shuffle(newDeck.getDeck());
	}

	
}
