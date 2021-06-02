package de.uni_passau.fim.se.memory.model;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

	private ArrayList<Card> cards;
	private int[] gameBoardSize;

	/**
	 * Getter for cards
	 * @return ArrayList<Card> cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	/**
	 * Getter for cards
	 * @return int[] gameBoardSize
	 */
	public int[] getGameBoardSize() {
		return gameBoardSize;
	}

	/**
	 * Initializes a new game object.
	 */
	public Game() {
		this.cards = new ArrayList<>();
		this.gameBoardSize = new int[]{5,4};

		generateCards();
		mixCards();
	}

	/**
	 * Generates @amountPairs card pairs and places them in first positions
	 * of the card array.
	 */
	private void generateCards() {
		int amountPairs = gameBoardSize[0] * gameBoardSize[1] / 2;
		for (int i = 1; i < amountPairs * 2 + 1; ++i) {
			cards.add(new Card((char)('A' + (i-1)/2)));
		}
		while (cards.size() < gameBoardSize[0] * gameBoardSize[1]) {
			cards.add(null);
		}
	}

	/**
	 * Mixes all cards around the game board.
	 */
	private void mixCards() {
		Collections.shuffle(cards);
	}

	/**
	 * Transforms this board instance into a readable string.
	 *
	 * @return A human readable string representation of the memory game.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int element = 0;

		for (int i = 0; i < (gameBoardSize[1] + 1) * (gameBoardSize[0] + 1); ++i) {

			if (i <= gameBoardSize[0])			{
				sb.append(i);
			} else {
				if (i % (gameBoardSize[0]+1) == 0) {
					sb.append(i / (gameBoardSize[0] + 1));
				} else {
					sb.append(cards.get(element) == null ? " "
							: cards.get(element).getValue());
					element++;
				}
			}

			if ((i+1) % (gameBoardSize[0]+1) == 0 ||
					i == (gameBoardSize[1]+1) * (gameBoardSize[0]+1) - 1) {
				sb.append(System.lineSeparator());
			} else {
				sb.append(' ');
			}
		}

		return sb.toString();
	}

	/**
	 * Compares the values of @param card1 and @param card2
	 * If the values are identical call remove on these cards and @return true, otherwise false.
	 */
	public static boolean compareCards(Card card1, Card card2) {
		if (card1.getValue() == card2.getValue()) {
			removeCards(card1, card2);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Selects the card at @param position of @param game
	 * @return the selected Card
	 */
	public Card selectCard(Game game, int position) {
		return this.getCards().get(position);
	}

	/**
	 * Removes @param card by setting its value to null
	 */
	public static void removeCards(Card card1, Card card2) {
		card1.setValue(null);
		card2.setValue(null);
	}
}
