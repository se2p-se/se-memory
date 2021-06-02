package de.uni_passau.fim.se.memory.model;

public class Card {
	private Character value ;
	private boolean isHidden = true ;
	private static Character hiddenValue = '▯';


	public Card(Character ch) {
		this.value = ch ;
	}

	public Character getValue () {
		return value ;
	}
	public void setValue (Character val) {
		value = val ;
	}
	public void flipCard () {
		isHidden = !isHidden ;
	}

	/**
	 * Compares the values of @param card1 and @param card2
	 * If the values are identical call remove on these cards and @return true, otherwise false.
	 */
	public static boolean compareCards(Card card1, Card card2) {
		if (card1.value == card2.value) {
			removeCard(card1, card2);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Selects the card at @param position of @param game
	 * @return the selected Card
	 */
	public static Card selectCard(Game game, int position) {
		return game.getCards().get(position);
	}

	/**
	 * Removes @param card by setting its value to null
	 */
	public static void removeCard(Card card1, Card card2) {
		card1.value = null;
		card2.value = null;
	}
}

