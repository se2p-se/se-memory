package de.uni_passau.fim.se.memory.controller;


import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.GameState;
import de.uni_passau.fim.se.memory.view.OutputStream;

import java.util.Scanner;

public class InputStreamPlayer {

    /**
     * Saving selected Cards
     */

    Game game = new Game();

    Scanner scanner = new Scanner(System.in);

    /**
     * startGame() method for the controlling of the game
     */

    public void startRound() {



        Card card1;
        Card card2;

        int row1, row2;
        int col1, col2;

        /**
         * Scanning the input of the players
         */

        OutputStream.printSelectCol1(); //Von Zeile 34 - 46 in eigene Methode? WEnn ja, wie ist dann die Überprüfung von Zeile 52?
        col1 = scanner.nextInt();
        OutputStream.printSelectRow1();
        row1 = scanner.nextInt();

        card1 = game.selectCard(row1, col1);

        OutputStream.printSelectCol2();
        col2 = scanner.nextInt();
        OutputStream.printSelectRow2();
        row2 = scanner.nextInt();

        card2 = game.selectCard(row2, col2);

        /**
         *  Checking the correctness of the Users-Input // !!!!!!!!!Exceptions fehlen noch!!!!!
         */


        while (row1 == row2 && col1 == col2 || card1 == null || card2 == null) {
            if (row1 == row2 && col1 == col2) {
                OutputStream.sameCardsChosen();
                OutputStream.printSelectCol2();
                col2 = scanner.nextInt();
                OutputStream.printSelectRow2();
                row2 = scanner.nextInt();

                card2 = game.selectCard(row2, col2);

            } else if (card1 == null) {
                OutputStream.chosenCard1IsNull();
                OutputStream.printSelectCol1();
                col1 = scanner.nextInt();
                OutputStream.printSelectRow1();
                row1 = scanner.nextInt();

                card1 = game.selectCard(row1, col1);

            } else {
                OutputStream.chosenCard2IsNull();
                OutputStream.printSelectCol2();
                col2 = scanner.nextInt();
                OutputStream.printSelectRow2();
                row2 = scanner.nextInt();

                card2 = game.selectCard(row2, col2);
            }


        }

        /**
         * comparingCards(card1, card2) compares the selected cards and removes them, if they match
         */

        card1.flipCard();
        card2.flipCard();


        if (Game.compareCards(card2, card1)) {
            Game.removeCards(card1, card2);
            OutputStream.pairFound(card1);
        } else {
            OutputStream.noPairFound();
        }

        System.out.println(game.toString());

        /**
         * checking the game state, if the games is not finished we use gameLoop to start a new round
         */


        gameLoop();


    }


    /**
     * gameLoop gives out text and starts new round
     */

    public void gameLoop() {

        while (!game.isGameFinished()) {
            OutputStream.nextRound();
            startRound();
        }
        OutputStream.printEndOfGame();

    }


}

