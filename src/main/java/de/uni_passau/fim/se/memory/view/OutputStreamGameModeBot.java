package de.uni_passau.fim.se.memory.view;

public class OutputStreamGameModeBot {

    /**
     * Only needed for Terminal-Version
     *
     * @param ch
     * @return notice, when bot picked equal cards
     */
    public static String printBotPickedMatch(Character ch) {
        return "The bot picked a pair of " + ch + "s!";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when bot did not pick equal cards
     */
    public static String printBotFoundNoPair() {
        return "The bot had not luck and found nothing.";
    }

    /**
     * @return label, when mode "against bot" is chosen
     */
    public static String printAgainstBot() {
        return "You are now playing against a bot";
    }
}
