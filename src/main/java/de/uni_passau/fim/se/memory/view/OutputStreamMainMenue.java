package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.MainMenue;

public class OutputStreamMainMenue {
    public static String showMainMenue () {
        StringBuilder sb = new StringBuilder();
        sb.append("You are in the Main Menue! Choose an Option!\n");
        sb.append("(1) for " + MainMenue.getTitleStartGame() + "\n");
        sb.append("(2) for " + MainMenue.getTitleGameMode() + "\n");
        sb.append("(3) for " + MainMenue.getTitleGameBoardSize() + "\n");
        sb.append("(4) for " + MainMenue.getTitleActivateHelp() + "\n");
        sb.append("(5) for " + MainMenue.getTitleComputerDifficulty() + "\n");
        sb.append("(6) for " + MainMenue.getTitleEnd() + "\n");
        return sb.toString();
    }
    public static String showGameBoardSizeSelectionMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Which game board size do you want?\n");
        sb.append("(1) for " + MainMenue.getTitleEasyGameBoardSize() + "\n");
        sb.append("(2) for " + MainMenue.getTitleMediumGameBoardSize() + "\n");
        sb.append("(3) for " + MainMenue.getTitleDifficultGameBoardSize() + "\n");
        sb.append("(4) for " + MainMenue.getTitleCostumGameBoardSize() + "\n");
        return sb.toString();
    }
    public static String showModeTime () {
        return "(1) for " + MainMenue.getTitleGameModeTime();
    }
    public static String showModeBot () {
        return "(2) for " + MainMenue.getTitleGameModeBot();
    }
    public static String showBotDifficulty () {
        return "(1) for Easy\n(2) for Normal\n(3) for Hard";
    }
    public static String showActivateHelpSetFalse () {
            return "You just disabled Help!";
        }
    public static String showActivateHelpSetTrue () {
        return "You just enabled Help!";
    }
    public static String showPleaseInsertGameBoardSizeX () {
        return "How many Cols do you want to have?";
    }
    public static String showPleaseInsertGameBoardSizeY () {
        return "How many Rows do you want to have?";
    }
    public static String showBackButton () {
        return "(An other Int) for Back";
    }
    public static String showSizeNotPossible () {
        return "Not possible! Please choose a field-size with max. 10 and min. 2 Pairs!";
    }
    public static String showHelpActivated () {
        return "Deactivate Help";
    }
    public static String showHelpDectivated () {
        return "Activate Help";
    }

    public static String printDifficultSize(){
        return "You switched to difficult sized gameboard";
    }

    public static String printMediumSize(){
        return "You switched to medium sized gameboard";
    }

    public static String printEasySize(){
        return "You switched to easy sized gameboard";
    }
}
