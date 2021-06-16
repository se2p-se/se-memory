package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.MainMenue;

public class OutputStreamMainMenue {
    public static void showMainMenue () {
        System.out.println("You are in the Main Menue! Choose an Option!");
        System.out.println("(1) for " + MainMenue.getTitleStartGame());
        System.out.println("(2) for " + MainMenue.getTitleGameMode());
        System.out.println("(3) for " + MainMenue.getTitleGameBoardSize());
        System.out.println("(4) for " + MainMenue.getTitleActivateHelp());
        System.out.println("(5) for " + MainMenue.getTitleEnd());
    }
    public static void showGameBoardSizeSelectionMenu(){
        System.out.println("Which game board size do you want?");
        System.out.println("1) Easy (like a 3x4 field)");
        System.out.println("2) Medium (like a 4x4 field)");
        System.out.println("3) Difficult (like a 5x4 field)");
        System.out.println("4) Costum ");
    }
    public static void showModeTime () {
        System.out.println("(1) for " + MainMenue.getTitleGameModeTime());
    }
    public static void showModeBot () {
        System.out.println("(2) for " + MainMenue.getTitleGameModeBot());
    }
    public static void showActivateHelpSetFalse () {
            System.out.println("You just disabled Help!");
        }
    public static void showActivateHelpSetTrue () {
        System.out.println("You just enabled Help!");
    }
    public static void showPleaseInsertGameBoardSizeX () {
        System.out.println("How many Cols do you want to have?");
    }
    public static void showPleaseInsertGameBoardSizeY () {
        System.out.println("How many Rows do you want to have?");
    }
    public static void showBackButton () {
        System.out.println("(An other Int) for Back");
    }
    public static void showSizeNotPossible () {
        System.out.println("Not possible! Please choose a field-size with max. 10 and min. 2 Pairs!");
    }
}
