package de.uni_passau.fim.se.memory.model;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

	private ArrayList<Card> cards;
	private int[] gameBoardSize;
	private int amountPairs;

	/**
	 * Initializes a new game object.
	 *
	 * @param size size in X Y lengths of the board.
	 */
	public Game(int[] size) {
		this.cards = new ArrayList<>();
		this.gameBoardSize = size;
		this.amountPairs = 1 + (size[0] * size[1]) / 8;

		generateCards();
		mixCards();
	}

	/**
	 * Generates @amountPairs card pairs and places them in first positions
	 * of the card array.
	 */
	private void generateCards() {
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
}
