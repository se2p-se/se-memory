package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.GameState;

public class OutputStream {

    public static void printBoard(String board) {
        System.out.println(board);
    }

    public static void printEndOfGame() {

        System.out.println("Your game of Memory is over. You uncovered all pairs." +
                " Hope you have had a lot of fun and come back soon");


    }

    public static void printSelectCol1() {
        System.out.println("Choose card 1 and write the corresponding col (Only chose Ints between 1 - 5) : ");
    }

    public static void printSelectRow1() {
        System.out.println("Choose card 1 and write the corresponding row (Only chose Ints between 1 - 4) : ");
    }

    public static void printSelectCol2() {
        System.out.println("Choose card 2 and write the corresponding col (Only chose Ints between 1 - 5) : ");
    }

    public static void printSelectRow2() {
        System.out.println("Choose card 2 and write the corresponding row (Only chose Ints between 1 - 4) : ");
    }

    public static void sameCardsChosen() {
        System.out.println("You chose the same cards, pleas choose the second card again: ");
    }

    public static void chosenCard2IsNull() {
        System.out.println("The second card you chose has the value null, please select again: ");
    }

    public static void chosenCard1IsNull() {
        System.out.println("The first card you chose has the value null, please select again: ");
    }

    public static void pairFound(Card card) {
        System.out.println("Congrats you found a pair with the value " + card.getValue() + "!");
    }

    public static void noPairFound() {
        System.out.println("No pair found, try again.");
    }

    public static void nextRound(){
        System.out.println("Starting next round.");
    }
}
