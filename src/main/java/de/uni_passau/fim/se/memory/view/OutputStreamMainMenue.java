package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.MainMenue;

public class OutputStreamMainMenue {
    public static void showMainMenue () {
        System.out.println("You are in the Main Menue! Choose an Option");
        System.out.println("(1) for " + MainMenue.getTitleStartGame());
        System.out.println("(2) for " + MainMenue.getTitleGameMode());
        System.out.println("(3) for " + MainMenue.getTitleGameBoardSize());
        System.out.println("(4) for " + MainMenue.getTitleActivateHelp());
    }
    public static void showModeBot () {
        System.out.println("(1) for " + MainMenue.getTitleGameModeTime());
    }
    public static void showModeTime () {
        System.out.println("(2) for " + MainMenue.getTitleGameModeBot());
    }
    public static void showActivateHelpSetFalse () {
            System.out.println("You just disabled help");
        }

    public static void showActivateHelpSetTrue () {
        System.out.println("You just enabled help");
    }
}
