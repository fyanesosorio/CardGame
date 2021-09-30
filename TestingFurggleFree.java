package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.awt.Card;
import game.awt.Emoji;
import game.awt.Face;
import game.awt.Player;
import game.awt.Suit;

class TestingFurggleFree {
	Card card = new Card(Suit.Hearts, Face.Ten);
	@Test
	void testDoubleDown() {
		Player p = new Player("name");
		p.addEmoji(Emoji.Smiley, card);
		p.addEmoji(Emoji.Smiley, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 25;
		assertEquals(expected, p.getTotal());
	}
	
	@Test
	void testTripsUp() {
		Player p = new Player("name");
		p.addEmoji(Emoji.Smiley, card);
		p.addEmoji(Emoji.Smiley, card);
		p.addEmoji(Emoji.Smiley, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 100;
		assertEquals(expected, p.getTotal());
	}
	@Test
	void testCakeLoss() {
		Player p = new Player("name");
		p.addEmoji(Emoji.Ernie, card);
		p.addEmoji(Emoji.TastyCake, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 40;
		assertEquals(expected, p.getTotal());
	}
	@Test
	void testSooTheBeast() {
		Player p = new Player("name");
		p.addEmoji(Emoji.Harpsicord, card);
		p.addEmoji(Emoji.SwarmpThing, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 65;
		assertEquals(expected, p.getTotal());
	}
	
	@Test
	void testSooTheBeastSwitched() {
		Player p = new Player("name");
		p.addEmoji(Emoji.SwarmpThing, card);
		p.addEmoji(Emoji.Harpsicord, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 65;
		assertEquals(expected, p.getTotal());
	}
	@Test
	void testFishFight() {
		Player p = new Player("name");
		p.addEmoji(Emoji.BlueTuna, card);
		p.addEmoji(Emoji.Dogfish, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 40;
		assertEquals(expected, p.getTotal());
	}
	@Test
	void testQuadvark() {
		Player p = new Player("name");
		p.addEmoji(Emoji.DoubleAardvark, card);
		p.addEmoji(Emoji.DoubleAardvark, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		p.addEmoji(Emoji.Furggle, card);
		int expected = 200;
		assertEquals(expected, p.getTotal());
	}
}
