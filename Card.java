package game.awt;

public class Card {

	public final Suit suit;
	
	public final Face face;
	
	public Card(Suit suit, Face face) {
		super();
		this.suit = suit;
		this.face = face;
	}
	
	public Suit getSuit() {
		return suit;
	}

	public Face getFace() {
		return face;
	}

}
