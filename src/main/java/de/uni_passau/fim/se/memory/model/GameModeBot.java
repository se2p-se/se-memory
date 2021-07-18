package de.uni_passau.fim.se.memory.model;

import java.util.ArrayList;
import java.util.Random;

public class GameModeBot extends Game {

	/**
	 * The 'brain' of the bot. All known cards, used in the algo below.
	 */
	private ArrayList<Card> botKnownCards;

	/**
	 * Initializes the game mode bot.
	 */
	public GameModeBot() {
		this.botKnownCards = new ArrayList<>();
	}

	/**
	 * Picks a pseudo-random card based on the bot difficulty.
	 *
	 * @return A pseudo-random picked card.
	 */
	private Card botPickPseudoRandomCard(int diff) {
		Random r = new Random();
		int cardsLeft = 0;
		for (Card c : getCards()) cardsLeft += c.getValue() == null ? 0 : 1;

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
					if (c.getValue() != null && !botKnownCards.contains(c)
							&& result-- == 0)
						return c;
			}

		}



		return null;
	}

	/**
	 * Performs a bot move.
	 *
	 * @return Character if a matching pair was found.
	 */
	public Card botMove(Card previouslyPicked) {

		Card c1 = previouslyPicked, c2 = null;
		boolean hasMatch = false;

		if (previouslyPicked == null)
			c1 = botPickPseudoRandomCard(MainMenu.getBotDifficulty());
		if (c1 == null) {
			c1 = botPickPseudoRandomCard(1);
		}

		if (c1 == null)
			return null;

		if (previouslyPicked == null) {
			return c1;
		}

		for (Card c : botKnownCards) {
			if (c.getValue() == c1.getValue() && c != c1) {
				hasMatch = true;
				c2 = c;
				break;
			}
		}

		int maxTries = 3;
		if (botKnownCards.isEmpty() || !hasMatch)
		{
			do {
				c2 = botPickPseudoRandomCard(MainMenu.getBotDifficulty());
			} while (c1 == c2 && maxTries-- > 0);
		}

		hasMatch = false;
		for (Card c : botKnownCards) {
			if (c == c1) {
				hasMatch = true;
				break;
			}
		}
		if (!hasMatch) botKnownCards.add(c1);
		hasMatch = false;
		for (Card c : botKnownCards) {
			if (c == c2) {
				hasMatch = true;
				break;
			}
		}
		if (!hasMatch && c2 != null) botKnownCards.add(c2);

		return c2;
	}
}
