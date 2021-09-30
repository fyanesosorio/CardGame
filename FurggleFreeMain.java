package game.awt;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FurggleFreeMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Deck deck = new Deck(true);
		String player1Name;
		String player2Name;

		System.out.print("Enter a name, player 1: ");
		player1Name = scan.nextLine();
		System.out.print("Enter a name, player 2: ");
		player2Name = scan.nextLine();

		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player(player1Name));
		players.add(new Player(player2Name));

		// main Game
		Random die = new Random();
		int i = 1;
		while (players.get(1).getHand().size() < 5) {
			System.out.println("Round: " + i + " ---------");
			i++;
			if(i == 5) {
				System.out.print("Final Round \n");
			}
			for (Player player : players) {
				int roll = die.nextInt(3);
				Card card = deck.draw();
				Emoji emoji = GrokBin.emoji(roll, card);
				System.out.println("This emoji is: " + emoji + "\nValue: " + card.getFace().getValue());
				if (emoji != Emoji.Furggle && !player.hasFurggle()) {
					System.out.println("Would you like to reject this card? y/n");
					String response = scan.nextLine().toLowerCase().trim();
					if (response.equals("y")) {
						roll = die.nextInt(3);
						card = deck.draw();
						emoji = GrokBin.emoji(roll, card);
						System.out.println("The new emoji is: " + emoji + "\nValue: " + card.getFace().getValue());
					}
				}
				player.addEmoji(emoji, card);
				System.out.println(player.getHandString());
				System.out.println("Points: " + player.subTotal());
				System.out.println("------------------------------");
			}
		}
		for(Player player: players) {
			System.out.println("-------------<" + player.getName() + ">--------------");
			System.out.println(player.getHandString());
			System.out.println("Points: "+ player.subTotal());
		}
		System.out.println("------------------------------------------------");
		if(players.get(0).compareTo(players.get(1)) == 1) {
			System.out.println("Winner: " + players.get(0).getName());
		}else if(players.get(0).compareTo(players.get(1)) == -1) {
			System.out.println("Winner: " + players.get(1).getName());
		}else {
			System.out.println("My golly, we have a draw!");
		}
	}
}
