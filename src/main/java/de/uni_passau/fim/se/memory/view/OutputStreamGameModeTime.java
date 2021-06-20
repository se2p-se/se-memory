package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.SavingStats;

public class OutputStreamGameModeTime {
    public static void printEndOfGameModeTime(long time) {

        System.out.println("Your finished the game successfully in " + time/1000  + " seconds");
    }

    public static void printNewRecord(){
        System.out.println("Congratulation you played this game in record time!");
    }

    public static void printRecordNotBroken(){
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("You did not break your record of: " + (SavingStats.getSavingStats().statsReader()/1000) + " seconds");
    }
}