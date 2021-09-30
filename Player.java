package game.awt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner(System.in);
	
	private ArrayList<Emoji> hand = new ArrayList<Emoji>();
	private ArrayList<Integer> values = new ArrayList<Integer>();
	private String name;


	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addEmoji(Emoji emoji, Card card) {
		hand.add(emoji);
		values.add(card.getFace().getValue());
	}

	public ArrayList<Emoji> getHand() {
		return hand;
	}


	public String getHandString() {
		String rtn = "";
		for (Emoji emoji : hand) {
			if (emoji.equals(Emoji.BlueTuna)) {
				rtn += "Blue Tuna ";
			}
			else if (emoji.equals(Emoji.DoubleAardvark)) {
				rtn += "Double Aardvark ";
			}
			else if (emoji.equals(Emoji.SwarmpThing)) {
				rtn += "Swarmp Thing ";
			} else {
				rtn += emoji + " ";
			}
		}
		return rtn;
	}
	
	public boolean hasFurggle() {
		return hand.contains(Emoji.Furggle);
	}
	
	public boolean cakeLoss() {
		return hand.contains(Emoji.Ernie) && hand.contains(Emoji.TastyCake);
	}
	
	public int cakeValue() {
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i) == Emoji.TastyCake) {
				return values.get(i);
			}
		}
		return 0;
	}
	
	public boolean doubleDown() {
		int count = 0;
		for (Emoji emoji : hand) {
			if (emoji.equals(Emoji.Smiley)) {
				count++;
			}
		}
		return count == 2;
	}

	public boolean tripsUp() {
		int count = 0;
		for (Emoji emoji : hand) {
			if (emoji.equals(Emoji.Smiley)) {
				count++;
			}
		}
		return count >= 3;
	}

	public boolean fishFight() {
		if (hand.contains(Emoji.BlueTuna) && hand.contains(Emoji.Dogfish)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sooTheBeast() {
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i) == Emoji.Harpsicord && hand.get(i + 1) == Emoji.SwarmpThing) {
				return true;
			}
			if (hand.get(i+1) == Emoji.Harpsicord && hand.get(i) == Emoji.SwarmpThing) {
				return true;
			}
		}
		return false;
	}

	public boolean quadvark() {
		int count = 0;
		for (Emoji emoji : hand) {
			if (emoji == Emoji.DoubleAardvark) {
				count++;
			}
		}
		return count == 2;
	}

	public int subTotal() {
		int count = 0;
		for(int value : values) {
			count += value;
		}
		return count;
	}

	public int getTotal() {
		int points = subTotal();
		if(cakeLoss()) {
			points = points - cakeValue();
		}
		if(doubleDown()) {
			points = points / 2;
		}
		if(tripsUp()) {
			points = points * 2;
		}
		if(sooTheBeast()) {
			points = points + 15;
		}
		if(fishFight()) {
			points = points - 10;
		} 
		if(quadvark()) {
			points = points * 4;
		}
		return points;
	}

	public int compareTo(Player player2) {
		if(this.subTotal() > player2.subTotal()) {
			return 1;
		} else if(this.subTotal() < player2.subTotal()) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
}
