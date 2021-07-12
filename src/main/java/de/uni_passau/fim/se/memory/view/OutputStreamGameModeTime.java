package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.SavingStats;

public class OutputStreamGameModeTime {
    /**
     * Only needed for Terminal-Version
     *
     * @param time
     * @return notice, when game mode "against time" is finished
     */
    public static String printEndOfGameModeTime(long time) {
        return "Your finished the game successfully in " + time / 1000 + " seconds";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when record is broken
     */
    public static String printNewRecord() {
        return "Congratulation you played this game in record time!";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return notice, when record is not broken
     */
    public static String printRecordNotBroken() {
        return "You did not break your record. Try again! ";
    }

    /**
     * @return label, when game mode "against time" is chosen
     */
    public static String printAgainstTime() {
        return "You are now playing against the time";
    }

}