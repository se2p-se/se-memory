package de.uni_passau.fim.se.memory.controller;


import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.GameModeBot;
import de.uni_passau.fim.se.memory.model.GameState;
import de.uni_passau.fim.se.memory.view.OutputStream;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeBot;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputStreamGameModeBot extends InputStreamPlayer {

	public InputStreamGameModeBot() {
		game = new GameModeBot();
	}

	@Override
	public GameModeBot getGame() {
		return (GameModeBot)game;
	}

	/**
	 * startRound() method for the controlling of the game
	 */
	@Override
	public void startRound() {

		/**
		 * printing the covered Board for the game start
		 */
		Card card1;
		Card card2;


		int row1, row2;
		int col1, col2;

		/**
		 * Scanning the input of the players
		 */
		while (game.getGameState() == GameState.RUNNING) {

			try {

				OutputStream.printSelectCol1();
				col1 = scanner.nextInt();

				if (col1 == 0) {
					game.setGameState(GameState.INITIALIZING_GAME);
					break;
				}

				OutputStream.printSelectRow1();
				row1 = scanner.nextInt();

				if (row1 == 0) {
					game.setGameState(GameState.INITIALIZING_GAME);
					break;
				}

				card1 = game.selectCard(row1, col1);



				if (card1.getValue() == null) {
					OutputStream.chosenCard1IsNull();
					return;
				}

				OutputStream.printSelectCol2();
				col2 = scanner.nextInt();

				if (col2 == 0) {
					game.setGameState(GameState.INITIALIZING_GAME);
					break;
				}

				OutputStream.printSelectRow2();
				row2 = scanner.nextInt();

				if (row2 == 0) {
					game.setGameState(GameState.INITIALIZING_GAME);
					break;
				}

				card2 = game.selectCard(row2, col2);



				if (card2.getValue() == null) {
					OutputStream.chosenCard2IsNull();
				}

				if (row1 == row2 && col1 == col2) {
					OutputStream.sameCardsChosen();
					return;
				}

				card1.flipCard();
				card2.flipCard();

				if (card1.compareWith(card2)) {
					OutputStream.pairFound(card1);
					Game.removeCards(card1, card2);
					if (game.isGameFinished()) {
						game.setGameState(GameState.END);
						return;
					}

				} else {
					OutputStream.noPairFound();
					Character ch = getGame().botMove();
					while (ch != null) {
						OutputStreamGameModeBot.printBotPickedMatch(ch);
						ch = getGame().botMove();
					}
					OutputStreamGameModeBot.printBotFoundNoPair();
				}

				OutputStream.printBoard(game);
				card1.flipCard();
				card2.flipCard();

			} catch (IllegalArgumentException x) {
				OutputStream.wrongPick();
			} catch (InputMismatchException x) {
				OutputStream.invalidInput();
				scanner = new Scanner(System.in);
			}
		}
	}
}

