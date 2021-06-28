package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;

public class OutputStream {

    public static String printBoard(Game board) {
        return board.toString();
    }

    public static String printOpenBoard(Game board){
        return board.openBoardToString();
    }

    /**
     * printSightBlockade is only a temporary method which should avoid the player from seeing the open field.
     * This method is gonna be deleted and replaced by a proper GUI implementation.
     */


    public static void printSigthBlockade(){
        for (int i = 0; i < 60; i++) {
            System.out.println("*");
        }
    }

        public static String printIntro () {
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

        public static String printEndOfGame () {
            return "Your game of Memory is over. You uncovered all pairs." +
                    " Hope you have had a lot of fun and come back soon";
        }

        public static String printSelectCol1 () {
            return "Choose card 1 and write the corresponding col (Only choose Ints between 1 - 5 or 0 to quit) : ";
        }

        public static String printSelectRow1 () {
            return "Choose card 1 and write the corresponding row (Only choose Ints between 1 - 4 or 0 to quit) : ";
        }

        public static String printSelectCol2 () {
            return "Choose card 2 and write the corresponding col (Only choose Ints between 1 - 5 or 0 to quit) : ";
        }

        public static String printSelectRow2 () {
          return "Choose card 2 and write the corresponding row (Only choose Ints between 1 - 4 or 0 to quit) : ";
        }

        public static String sameCardsChosen () {
            return "You chose the same cards, pleas choose the second card again: ";
        }

        public static String chosenCard2IsNull () {
          return "The second card you chose is invalid, please "
                    + "select again:";
        }

        public static String chosenCard1IsNull () {
            return "The first card you chose is invalid, please "
                    + "select again: ";
        }

        public static String pairFound (Card card){
            return "Congrats you found a pair with the value " + card.getValue() + "!";
        }

        public static String noPairFound () {
            return "No pair found, try again.";
        }

        public static String nextRound () {
            return "Starting next round.";
        }

        public static String wrongPick () {
        return "Wrong column or row picked!" ;
        }

        public static String invalidInput () {
        return "Invalid input!" ;
        }
    }
