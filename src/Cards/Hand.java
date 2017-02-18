package Cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> hand = new ArrayList<>();

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
}
