package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.GameModeTime;
import de.uni_passau.fim.se.memory.model.GameState;
import de.uni_passau.fim.se.memory.model.SavingStats;
import de.uni_passau.fim.se.memory.view.OutputStream;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeTime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputStreamGameModeTime extends InputStreamPlayer {

    public InputStreamGameModeTime() {
        game = new GameModeTime();
    }

    @Override
    public GameModeTime getGame() {
        return (GameModeTime) game;
    }

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
        while (game.getGameState() == GameState.TIMEGAMESTART) {

            try {

                System.out.println(OutputStream.printSelectCol1());
                col1 = scanner.nextInt();

                if (col1 == 0) {
                    game.setGameState(GameState.INITIALIZING_GAME);
                    break;
                }

                System.out.println(OutputStream.printSelectRow1());
                row1 = scanner.nextInt();

                if (row1 == 0) {
                    game.setGameState(GameState.INITIALIZING_GAME);
                    break;
                }

                card1 = game.selectCard(row1, col1);


                if (card1.getValue() == null) {
                    System.out.println(OutputStream.chosenCard1IsNull());
                    return;
                }

                System.out.println(OutputStream.printSelectCol2());
                col2 = scanner.nextInt();

                if (col2 == 0) {
                    game.setGameState(GameState.INITIALIZING_GAME);
                    break;
                }

                System.out.println(OutputStream.printSelectRow2());
                row2 = scanner.nextInt();

                if (row2 == 0) {
                    game.setGameState(GameState.INITIALIZING_GAME);
                    break;
                }

                card2 = game.selectCard(row2, col2);


                if (card2.getValue() == null) {
                    System.out.println(OutputStream.chosenCard2IsNull());
                }

                if (row1 == row2 && col1 == col2) {
                    System.out.println(OutputStream.sameCardsChosen());
                    return;
                }

                card1.flipCard();
                card2.flipCard();

                if (card1.compareWith(card2)) {
                    System.out.println(OutputStream.pairFound(card1));
                    GameModeTime.removeCards(card1, card2);
                    if (game.isGameFinished()) {
                        game.setGameState(GameState.TIMEGAMEEND);
                    }

                } else {
                    System.out.println(OutputStream.noPairFound());

                }

                System.out.println(OutputStream.printBoard(game));
                card1.flipCard();
                card2.flipCard();

            } catch (IllegalArgumentException x) {
                System.out.println(OutputStream.wrongPick());
            } catch (InputMismatchException x) {
                System.out.println(OutputStream.invalidInput());
                scanner = new Scanner(System.in);
            }
        }
    }

    @Override
    public void gameLoop() {
        System.out.println(OutputStream.printBoard(game));

        while (!game.isGameFinished()) {
            if (game.getGameState() != GameState.TIMEGAMESTART) {
                break;
            }
            System.out.println(OutputStream.nextRound());
            startRound();

        }
        if (game.getGameState() == GameState.TIMEGAMEEND) {
            getGame().stopCountingTime();
            OutputStreamGameModeTime.printEndOfGameModeTime(getGame().getCurrentTime(getGame().getStart(), getGame().getEnd()));

            boolean gotRecord = gameModeTime.compareWithSavedTime(getGame().getCurrentTime(getGame().getStart(), getGame().getEnd()));
            if (gotRecord) {
                OutputStreamGameModeTime.printNewRecord();

            } else if (game.getGameState() == GameState.INITIALIZING_GAME) {

            }

        }


    }

    GameModeTime gameModeTime = new GameModeTime();
    SavingStats savingStats = SavingStats.getSavingStats();
}
