package de.uni_passau.fim.se.memory.model;

import java.util.ArrayList;
import java.util.Random;

public class GameModeBot extends Game {

	private ArrayList<Card> botKnownCards;

	public GameModeBot() {
		this.botKnownCards = new ArrayList<>();
	}

	private Card botPickPseudoRandomCard() {
		Random r = new Random();
		int cardsLeft = 0;
		for (Card c : getCards()) cardsLeft += c.getValue() == null ? 0 : 1;
		if (cardsLeft > 0) cardsLeft--; // arrays start at 0
		int result = r.nextInt(cardsLeft);
		for (Card c : getCards()) if (c.getValue() != null && result-- == 0)
			return c;
		return null;
	}

	public void botMove() {

		Card c1 = null, c2 = null;
		boolean hasMatch = false;

		c1 = botPickPseudoRandomCard();

		for (Card c : botKnownCards) {
			if (c.getValue() == c1.getValue() && c != c1) {
				hasMatch = true;
				c2 = c;
				break;
			}
		}

		if (botKnownCards.isEmpty() || hasMatch == false)
		{
			do {
				c2 = botPickPseudoRandomCard();
			} while (c1 == c2);
		}

		if (c1.getValue() == c2.getValue()) {
			c1.setValue(null);
			c2.setValue(null);
		} else {
			hasMatch = false;
			for (Card c : botKnownCards) {
				if (c == c1) {
					hasMatch = true;
					break;
				}
			}
			if (hasMatch == false) botKnownCards.add(c1);
			hasMatch = false;
			for (Card c : botKnownCards) {
				if (c == c2) {
					hasMatch = true;
					break;
				}
			}
			if (hasMatch == false) botKnownCards.add(c2);
		}
	}
}
