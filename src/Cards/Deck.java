package Cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Deck {
	List<Card> deck = new ArrayList<>(52);
	public List<Card> createDeck() {
		int counter = 1;

		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				if (counter == 1) {
					deck.add(new Card(r, s, 11));
				} else if (counter < 10) {

					deck.add(new Card(r, s, counter));
				} else {

					deck.add(new Card(r, s, 10));
				}
			}
			counter++;
		}
		
		return deck;
	}
	
	public List<Card> getDeck() {
		return deck;
	}
	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
}