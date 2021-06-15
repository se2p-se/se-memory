package de.uni_passau.fim.se.memory.model;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

	private ArrayList<Card> cards;
	private int[] gameBoardSize;


	public void setGameBoardSize(int x, int y) {
		this.gameBoardSize = new int[]{x,y};
	}

	public int[] getGameBoardSize() {
		return gameBoardSize;
	}

	/**
	 * Getter for cards
	 * @return ArrayList<Card> cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
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
					sb.append(
							cards.get(element) == null ? ' '
							: cards.get(element).getValue() == null ? ' ' :
							cards.get(element).getIsHidden() ? Card.hiddenValue :
							cards.get(element).getValue());
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
	 * Gets a card by its row and column.
	 *
	 * @param row - The Row.
	 * @param col - The Column.
	 *
	 * @return The Card.
	 */
	public Card selectCard(int row, int col) {
		if (row <= 0 || col <= 0 || col > gameBoardSize[0] || row > gameBoardSize[1]) {
			throw new IllegalArgumentException();
		}
		
		return cards.get((row-1)*gameBoardSize[0]+(col-1));
	}

	/**
	 * Removes a pair by setting its value to null.
	 *
	 * @param card1 The first card to be removed.
	 * @param card2 The second card to be removed.
	 */
	public static void removeCards(Card card1, Card card2) {
		card1.setValue(null);
		card2.setValue(null);
	}

	/**
	 * Check if all cards have been opened.
	 *
	 * @return True if all cards have been opened.
	 */
	public boolean isGameFinished() {
		return cards.stream().allMatch((c) -> c.getValue() == null);
	}

	public void timer(int duration){
		long endTime = System.currentTimeMillis() + duration;
		while (System.currentTimeMillis() < endTime) {

		}
	}


	public String openBoardToString() {
		StringBuilder sb = new StringBuilder();
		int element = 0;

		for (int i = 0; i < (gameBoardSize[1] + 1) * (gameBoardSize[0] + 1); ++i) {

			if (i <= gameBoardSize[0])			{
				sb.append(i);
			} else {
				if (i % (gameBoardSize[0]+1) == 0) {
					sb.append(i / (gameBoardSize[0] + 1));
				} else {
					sb.append(
							cards.get(element) == null ? ' '
									: cards.get(element).getValue() == null ? ' ' :
									cards.get(element).getValue());
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