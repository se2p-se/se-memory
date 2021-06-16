package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;

public class OutputStream {

    public static void printBoard(Game board) {
        System.out.println(board.toString());
    }

        public static void printIntro () {
            System.out.println(
                    " /$$      /$$ /$$$$$$$$ /$$      /$$  /$$$$$$  /$$$$$$$  /$$     /$$\n"
                            + "| $$$    /$$$| $$_____/| $$$    /$$$ /$$__  $$| $$__  $$|  $$   /$$/\n"
                            + "| $$$$  /$$$$| $$      | $$$$  /$$$$| $$  \\ $$| $$  \\ $$ \\  $$ /$$/ \n"
                            + "| $$ $$/$$ $$| $$$$$   | $$ $$/$$ $$| $$  | $$| $$$$$$$/  \\  $$$$/  \n"
                            + "| $$  $$$| $$| $$__/   | $$  $$$| $$| $$  | $$| $$__  $$   \\  $$/   \n"
                            + "| $$\\  $ | $$| $$      | $$\\  $ | $$| $$  | $$| $$  \\ $$    | $$    \n"
                            + "| $$ \\/  | $$| $$$$$$$$| $$ \\/  | $$|  $$$$$$/| $$  | $$    | $$    \n"
                            + "|__/     |__/|________/|__/     |__/ \\______/ |__/  |__/    |__/    \n"
                            + "                                                                    \n");
        }

        public static void printEndOfGame () {
            System.out.println("Your game of Memory is over. You uncovered all pairs." +
                    " Hope you have had a lot of fun and come back soon");
        }

        public static void printInvalidInput () {
            System.out.println("Your input was invalid. Please try again: ");
        }

        public static void printSelectCol1 () {
            System.out.println("Choose card 1 and write the corresponding col (Only choose Ints between 1 - 5 or 0 to quit) : ");
        }

        public static void printSelectRow1 () {
            System.out.println("Choose card 1 and write the corresponding row (Only choose Ints between 1 - 4 or 0 to quit) : ");
        }

        public static void printSelectCol2 () {
            System.out.println("Choose card 2 and write the corresponding col (Only choose Ints between 1 - 5 or 0 to quit) : ");
        }

        public static void printSelectRow2 () {
            System.out.println("Choose card 2 and write the corresponding row (Only choose Ints between 1 - 4 or 0 to quit) : ");
        }

        public static void sameCardsChosen () {
            System.out.println("You chose the same cards, pleas choose the second card again: ");
        }

        public static void chosenCard2IsNull () {
            System.out.println("The second card you chose is invalid, please "
                    + "select again:");
        }

        public static void chosenCard1IsNull () {
            System.out.println("The first card you chose is invalid, please "
                    + "select again: ");
        }

        public static void pairFound (Card card){
            System.out.println("Congrats you found a pair with the value " + card.getValue() + "!");
        }

        public static void noPairFound () {
            System.out.println("No pair found, try again.");
        }

        public static void nextRound () {
            System.out.println("Starting next round.");
        }

        public static void wrongPick () {
        System.out.println ("Wrong column or row picked!") ;
        }

        public static void invalidInput () {
        System.out.println ("Invalid input!") ;
        }
    }
