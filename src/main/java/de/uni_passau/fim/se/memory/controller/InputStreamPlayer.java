package de.uni_passau.fim.se.memory.controller;


import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.view.OutputStream;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputStreamPlayer {

    /**
     * Saving selected Cards
     */

    Game game = new Game();

    Scanner scanner = new Scanner(System.in);

    /**
     * startRound() method for the controlling of the game
     */
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

        try {
            OutputStream.printSelectCol1();
            col1 = scanner.nextInt();
            OutputStream.printSelectRow1();
            row1 = scanner.nextInt();

            card1 = game.selectCard(row1, col1);

            if (card1.getValue() == null) {
                OutputStream.chosenCard1IsNull();

                return;
            }

            OutputStream.printSelectCol2();
            col2 = scanner.nextInt();
            OutputStream.printSelectRow2();
            row2 = scanner.nextInt();

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

            } else {
                OutputStream.noPairFound();

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


    /**
     * gameLoop gives out text and starts new round
     */
    public void gameLoop() {

        OutputStream.printBoard(game);

        while (!game.isGameFinished()) {
            OutputStream.nextRound();
            startRound();
        }

        OutputStream.printEndOfGame();
    }
}

