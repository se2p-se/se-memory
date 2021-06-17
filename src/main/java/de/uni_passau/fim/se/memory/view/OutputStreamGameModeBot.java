package de.uni_passau.fim.se.memory.view;

public class OutputStreamGameModeBot {
	public static void printBotPickedMatch(Character ch) {
		System.out.println("The bot picked a pair of " + ch  + "s!");
	}

	public static void printBotFoundNoPair() {
		System.out.println("The bot had not luck and found nothing.");
	}
}
