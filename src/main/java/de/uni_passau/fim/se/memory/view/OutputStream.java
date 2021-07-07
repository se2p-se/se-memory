package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;

public class OutputStream {

    /**
     * Only needed for Terminal-Version
     *
     * @param board
     * @return Game-Board as a String
     */
    public static String printBoard(Game board) {
        return board.toString();
    }

    /**
     * Only needed for Terminal-Version
     *
     * @param board
     * @return opened Game-Board as a String
     */
    public static String printOpenBoard(Game board) {
        return board.openBoardToString();
    }

    /**
     * printSightBlockade is only a temporary method which should avoid the player from seeing the open field.
     * This method is gonna be deleted and replaced by a proper GUI implementation.
     */
    public static void printSigthBlockade() {
        for (int i = 0; i < 60; i++) {
            System.out.println("*");
        }
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return Intro
     */
    public static String printIntro() {
        return
                " /$$      /$$ /$$$$$$$$ /$$      /$$  /$$$$$$  /$$$$$$$  /$$     /$$\n"
                        + "| $$$    /$$$| $$_____/| $$$    /$$$ /$$__  $$| $$__  $$|  $$   /$$/\n"
                        + "| $$$$  /$$$$| $$      | $$$$  /$$$$| $$  \\ $$| $$  \\ $$ \\  $$ /$$/ \n"
                        + "| $$ $$/$$ $$| $$$$$   | $$ $$/$$ $$| $$  | $$| $$$$$$$/  \\  $$$$/  \n"
                        + "| $$  $$$| $$| $$__/   | $$  $$$| $$| $$  | $$| $$__  $$   \\  $$/   \n"
                        + "| $$\\  $ | $$| $$      | $$\\  $ | $$| $$  | $$| $$  \\ $$    | $$    \n"
                        + "| $$ \\/  | $$| $$$$$$$$| $$ \\/  | $$|  $$$$$$/| $$  | $$    | $$    \n"
                        + "|__/     |__/|________/|__/     |__/ \\______/ |__/  |__/    |__/    \n"
                        + "                                                                    \n";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when game is over
     */
    public static String printEndOfGame() {
        return "Your game of Memory is over. You uncovered all pairs." +
                " Hope you have had a lot of fun and come back soon";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, to put in col for card 1
     */
    public static String printSelectCol1() {
        return "Choose card 1 and write the corresponding col (Only choose Ints between 1 - 5 or 0 to quit) : ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice to put in row for card 1
     */
    public static String printSelectRow1() {
        return "Choose card 1 and write the corresponding row (Only choose Ints between 1 - 4 or 0 to quit) : ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice to put in col for card 2
     */
    public static String printSelectCol2() {
        return "Choose card 2 and write the corresponding col (Only choose Ints between 1 - 5 or 0 to quit) : ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice to put in row for card 2
     */
    public static String printSelectRow2() {
        return "Choose card 2 and write the corresponding row (Only choose Ints between 1 - 4 or 0 to quit) : ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when same card is chosen
     */
    public static String sameCardsChosen() {
        return "You chose the same cards, pleas choose the second card again: ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when chosen card 2 is invalid
     */
    public static String chosenCard2IsNull() {
        return "The second card you chose is invalid, please select again: ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when chosen card 1 is invalid
     */
    public static String chosenCard1IsNull() {
        return "The first card you chose is invalid, please select again: ";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @param card
     * @return notice, when chosen cards are equal
     */
    public static String pairFound(Card card) {
        return "Congrats you found a pair with the value " + card.getValue() + "!";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when chosen cards are not equal
     */
    public static String noPairFound() {
        return "No pair found, try again.";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice that next round is starting
     */
    public static String nextRound() {
        return "Starting next round.";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, if chosen col or row is invalid
     */
    public static String wrongPick() {
        return "Wrong column or row picked!";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when input is not an Integer
     */
    public static String invalidInput() {
        return "Invalid input!";
    }
}
