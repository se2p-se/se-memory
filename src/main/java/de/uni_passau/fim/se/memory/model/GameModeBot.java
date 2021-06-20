package de.uni_passau.fim.se.memory.model;

import java.util.ArrayList;
import java.util.Random;

public class GameModeBot extends Game {

	private ArrayList<Card> botKnownCards;

	public GameModeBot() {
		this.botKnownCards = new ArrayList<>();
	}

	private Card botPickPseudoRandomCard() {

		int diff = MainMenue.getBotDifficulty();
		Random r = new Random();
		int cardsLeft = 0;
		for (Card c : getCards()) cardsLeft += c.getValue() == null ? 0 : 1;
		if (cardsLeft > 0) cardsLeft--; // arrays start at 0

		switch (diff)
		{
			case 1:
			default:
			{
				int result = r.nextInt(cardsLeft);
				for (Card c : getCards()) if (c.getValue() != null && result-- == 0)
					return c;
			}
			case 2:
			case 3:
			{
				if (diff == 3)
				{
					boolean pickPair = r.nextInt(100) % 2 == 0;
					if (pickPair)
					{
						for (Card c : getCards())
						{
							if (c.getValue() != null && botKnownCards.stream().anyMatch(
									(p) -> p.getValue() == c.getValue() && p != c))
							{
								return c;
							}
						}
					}
				}

				if (cardsLeft > botKnownCards.size())
					cardsLeft -= botKnownCards.size();
				int result = r.nextInt(cardsLeft);
				for (Card c : getCards())
					if (c.getValue() != null && botKnownCards.contains(c) == false
							&& result-- == 0)
						return c;
			}

		}



		return null;
	}

	public Character botMove() {

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
			Character ret = c1.getValue();
			c1.setValue(null);
			c2.setValue(null);
			return ret;
		}

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

		return null;
	}
}
