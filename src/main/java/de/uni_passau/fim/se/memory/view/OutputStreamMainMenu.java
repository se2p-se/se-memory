package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.MainMenu;

public class OutputStreamMainMenu {

    /**
     * Only needed for Terminal-Version
     *
     * @return Main-Menu on Terminal
     */
    public static String showMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are in the Main Menu! Choose an Option!\n");
        sb.append("(1) for " + MainMenu.getTitleStartGame() + "\n");
        sb.append("(2) for " + MainMenu.getTitleGameMode() + "\n");
        sb.append("(3) for " + MainMenu.getTitleGameBoardSize() + "\n");
        sb.append("(4) for " + MainMenu.getTitleActivateHelp() + "\n");
        sb.append("(5) for " + MainMenu.getTitleComputerDifficulty() + "\n");
        sb.append("(6) for " + MainMenu.getTitleEnd() + "\n");
        return sb.toString();
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return SubmenuGameBoardSize
     */
    public static String showSubmenuGameBoardSize() {
        StringBuilder sb = new StringBuilder();
        sb.append("Which game board size do you want?\n");
        sb.append("(1) for " + MainMenu.getTitleEasyGameBoardSize() + "\n");
        sb.append("(2) for " + MainMenu.getTitleMediumGameBoardSize() + "\n");
        sb.append("(3) for " + MainMenu.getTitleDifficultGameBoardSize() + "\n");
        sb.append("(4) for " + MainMenu.getTitleCostumGameBoardSize() + "\n");
        return sb.toString();
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return Title of Mode against Time
     */
    public static String showModeTime() {
        return "(1) for " + MainMenu.getTitleGameModeTime();
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return Title of Mode against Bot
     */
    public static String showModeBot() {
        return "(2) for " + MainMenu.getTitleGameModeBot();
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return different Bot-Difficulties
     */
    public static String showBotDifficulty() {
        return "(1) for Easy\n(2) for Normal\n(3) for Hard";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return Help disabled
     */
    public static String showActivateHelpSetFalse() {
        return "You just disabled Help!";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return Help enabled
     */
    public static String showActivateHelpSetTrue() {
        return "You just enabled Help!";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return User should choose number of Cols
     */
    public static String showPleaseInsertGameBoardSizeX() {
        return "How many Cols do you want to have?";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return User should choose number of Rows
     */
    public static String showPleaseInsertGameBoardSizeY() {
        return "How many Rows do you want to have?";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return "Button" for Back
     */
    public static String showBackButton() {
        return "(An other Int) for Back";
    }

    /**
     * Only needed for Terminal-Version
     *
     * @return Error, when choosen Game-Board-Size is to big
     */
    public static String showSizeNotPossible() {
        return "Not possible! Please choose a field-size with max. 10 and min. 2 Pairs!";
    }

    /**
     * @return Name of Button when Help is acitvated
     */
    public static String showHelpActivated() {
        return "Deactivate Help";
    }

    /**
     * @return Name of Button when Help is deactivated
     */
    public static String showHelpDectivated() {
        return "Activate Help";
    }

    /**
     * @return notice, when difficult Game-Board-Size is choosen
     */
    public static String printDifficultSize() {
        return "You switched to difficult sized gameboard";
    }

    /**
     * @return notice, when medium Game-Board-Size is choosen
     */
    public static String printMediumSize() {
        return "You switched to medium sized gameboard";
    }

    /**
     * @return notice, when easy Game-Board-Size is choosen
     */
    public static String printEasySize() {
        return "You switched to easy sized gameboard";
    }

    /**
     * @return notice, when difficult Bot is choosen
     */
    public static String printDifficultBot() {
        return "You switched to a difficult bot";
    }

    /**
     * @return notice, when medium Bot is choosen
     */
    public static String printMediumBot() {
        return "You switched to a medium bot";
    }

    /**
     * @return notice, when easy Bot is choosen
     */
    public static String printEasyBot() {
        return "You switched to an easy bot";
    }
}
