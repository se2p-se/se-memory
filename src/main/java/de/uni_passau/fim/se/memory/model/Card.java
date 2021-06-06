package de.uni_passau.fim.se.memory.model;

public class Card {
	private Character value;
	private boolean isHidden = true;
	public static Character hiddenValue = '▯';

	/**
	 * Initializes a new Card.
	 *
	 * @param ch The initial value.
	 */
	public Card(Character ch) {
		this.value = ch ;
	}

	/**
	 * Returns whether the card is currently hidden.
	 *
	 * @return Whether the card is hidden or not.
	 */
	public boolean isHidden() {
		return isHidden;
	}

	/**
	 * Sets whether the card is currently hidden or not.
	 *
	 * @param hidden Whether to hide the card or not.
	 */
	public void setHidden(boolean hidden) {
		isHidden = hidden;
	}

	/**
	 * Gets the value of the card.
	 *
	 * @return The card value.
	 */
	public Character getValue () {
		return value;
	}

	/**
	 * Sets the value of the card.
	 *
	 * @param val The new value.
	 */
	public void setValue (Character val) {
		value = val;
	}

	/**
	 * Flips the card.
	 */
	public void flipCard () {
		isHidden = !isHidden;
	}

	/**
	 * Compares the values of this card with another one.
	 *
	 * @param card1 The card to compare with.
	 *
	 * @return True or false depending on if the cards have equal values.
	 */
	public boolean compareWith(Card card1) {
		return card1.getValue() == this.getValue();
	}
}

