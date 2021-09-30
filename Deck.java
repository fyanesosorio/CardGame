package game.awt;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int currentTop = 0;
	GrokBin emojis = new GrokBin();
	public Deck(boolean shuffle) {
		super();
		for(Suit suit : Suit.values()) {
			for(Face face : Face.values()) {
				cards.add(new Card(suit, face));
			}
			shuffle = false;
		}
		if(shuffle) {
			Collections.shuffle(cards);
		}
	}
	public Card draw() {
		if(currentTop >= cards.size()) {
			currentTop = 0;
			Collections.shuffle(cards);
		}
		return cards.get(currentTop++);
	}
	public int cardLeft() {
		return cards.size() - currentTop;
	}
}
