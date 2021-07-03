package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.SavingStats;

public class OutputStreamGameModeTime {
    public static String printEndOfGameModeTime(long time) {

        return "Your finished the game successfully in " + time/1000  + " seconds";
    }

    public static String printNewRecord(){
        return "Congratulation you played this game in record time!";
    }

    public static String printRecordNotBroken(){
        StringBuilder stringBuilder = new StringBuilder();
        return "You did not break your record of: " + (SavingStats.getSavingStats().statsReader()/1000) + " seconds";
    }

    public static String printAgainstTime(){
        return "You are now playing against the time";
    }

}