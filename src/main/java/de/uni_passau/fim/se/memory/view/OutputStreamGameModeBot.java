package de.uni_passau.fim.se.memory.view;

public class OutputStreamGameModeBot {
	public static String printBotPickedMatch(Character ch) {
		return "The bot picked a pair of " + ch  + "s!";
	}

	public static String printBotFoundNoPair() {
		return "The bot had not luck and found nothing.";
	}
	public static String printAgainstBot(){
		return "You are now playing against a bot";
	}
}
