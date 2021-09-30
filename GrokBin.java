package game.awt;

public class GrokBin {
	
	public static Emoji emoji(int dice, Card c) {
		if(dice == 0) {
			if(c.getSuit() == Suit.Hearts)
				return Emoji.Smiley;
			if(c.getSuit() == Suit.Clubs)
				return Emoji.Harpsicord;
			if(c.getSuit() == Suit.Diamonds)
				return Emoji.Dogfish;
			if(c.getSuit() == Suit.Spades)
				return Emoji.TastyCake;
		}
		else if(dice == 1) {
			if(c.getSuit() == Suit.Hearts)
				return Emoji.BlueTuna;
			if(c.getSuit() == Suit.Clubs)
				return Emoji.Smiley;
			if(c.getSuit() == Suit.Diamonds)
				return Emoji.DoubleAardvark;
			if(c.getSuit() == Suit.Spades)
				return Emoji.Smiley;
		}
		else if(dice == 2) {
			if(c.getSuit() == Suit.Hearts)
				return Emoji.Ernie;
			if(c.getSuit() == Suit.Clubs)
				return Emoji.Furggle;
			if(c.getSuit() == Suit.Diamonds)
				return Emoji.Smiley;
			if(c.getSuit() == Suit.Spades)
				return Emoji.SwarmpThing;
		}
		return Emoji.Error;
	}

}
