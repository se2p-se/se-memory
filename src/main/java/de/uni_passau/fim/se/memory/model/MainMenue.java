package de.uni_passau.fim.se.memory.model;

/**
 * Provides titles as strings for the game's main menu
 */
public class MainMenue {
    private static String titleGameMode = "Select Mode";
    private static String titleStartGame = "Start Game";
    private static String titleGameBoardSize = "Adapt Game-Board-Size";
    private static String titleActivateHelp = "Activate Help";
    private static String titleGameModeTime = "Play against Time";
    private static String titleGameModeBot = "Play against Computer";
    private static String titleComputerDifficulty = "Change Bot Difficulty";
    private static String titleEnd = "Quit";
    private static String titleEasyGameBoardSize = "Easy (like a 3x4 field)";
    private static String titleMediumGameBoardSize = "Medium (like a 4x4 field)";
    private static String titleDifficultGameBoardSize = "Difficult (like a 5x4 field)";
    private static String titleCostumGameBoardSize = "Costume";
    private boolean isGameModeBot = false;
    private boolean isGameModeTime = true;
    private static boolean isActivateHelp = false;
    private static int botDifficulty = 1;

    /**
     * Getter of titleActivateHelp
     * @return String of titleActivateHelp variable
     */
    public static String getTitleActivateHelp() {
        return titleActivateHelp;
    }

    /**
     * Getter of titleComputerDifficulty
     * @return String of titleComputerDifficulty variable
     */
    public static String getTitleComputerDifficulty() {
        return titleComputerDifficulty;
    }

    /**
     * Getter of titleGameBoardSize
     * @return String of titleGameBoardSize variable
     */
    public static String getTitleGameBoardSize() {
        return titleGameBoardSize;
    }

    /**
     * Getter of titleGameMode
     * @return String of titleGameMode variable
     */
    public static String getTitleGameMode() {
        return titleGameMode;
    }

    /**
     * Getter of titleGameModeBot
     * @return String of titleGameModeBot variable
     */
    public static String getTitleGameModeBot() {
        return titleGameModeBot;
    }

    /**
     * Getter of titleGameModeTime
     * @return String of titleGameModeTime variable
     */
    public static String getTitleGameModeTime() {
        return titleGameModeTime;
    }

    /**
     * Getter of titleStartGame
     * @return String of titleStartGame variable
     */
    public static String getTitleStartGame() {
        return titleStartGame;
    }

    /**
     * Getter of titleEnd
     * @return String of titleEnd variable
     */
    public static String getTitleEnd() {
        return titleEnd;
    }

    /**
     * Getter of titleEasyGameBoardSize
     * @return String of titleEasyGameBoardSize variable
     */
    public static String getTitleEasyGameBoardSize() {
        return titleEasyGameBoardSize;
    }

    /**
     * Getter of titleMediumGameBoardSize
     * @return String of titleMediumGameBoardSize variable
     */
    public static String getTitleMediumGameBoardSize() {
        return titleMediumGameBoardSize;
    }

    /**
     * Getter of titleDifficultGameBoardSize
     * @return String of titleDifficultGameBoardSize variable
     */
    public static String getTitleDifficultGameBoardSize() {
        return titleDifficultGameBoardSize;
    }

    /**
     * Getter of titleCostumGameBoardSize
     * @return String of titleCostumGameBoardSize variable
     */
    public static String getTitleCostumGameBoardSize() {
        return titleCostumGameBoardSize;
    }

    /**
     * Setter of titleGameMode
     * @param name sets the title of the game mode
     */
    public static void setTitleGameMode(String name) {
        titleGameMode = name;
    }

    /**
     * Setter of game mode time
     * @param gameModeTime sets the game mode time on (true) or off (false)
     */
    public void setGameModeTime(boolean gameModeTime) {
        isGameModeTime = gameModeTime;
    }

    /**
     * Setter of game mode time
     * @param gameModeBot sets the game mode bot on (true) or off (false)
     */
    public void setGameModeBot(boolean gameModeBot) {
        isGameModeBot = gameModeBot;
    }

    /**
     * Getter of game mode time boolean
     * @return true if game mode time is on, else false
     */
    public boolean getGameModeTime() {
        return isGameModeTime;
    }

    /**
     * Getter of game mode bot boolean
     * @return true if game mode bot is on, else false
     */
    public boolean getGameModeBot() {
        return isGameModeBot;
    }

    /**
     * Setter for activate help boolean
     * @param activateHelp set help mode on (true) or off (false)
     */
    public void setActivateHelp(boolean activateHelp) {
        isActivateHelp = activateHelp;
    }

    /**
     * Getter for activate help function
     * @return if help function is activated or not
     */
    public static boolean getActivateHelp() {
        return isActivateHelp;
    }

    /**
     * Sets the title in the main menu of the "De-/activate Help" button
     */
    public void setTitleActivateHelp() {
        if (isActivateHelp) {
            titleActivateHelp = "Deactivate Help";
        } else {
            titleActivateHelp = "Activate Help";
        }
    }

    /**
     * Sets the difficulty of the bot in game mode bot
     * @param diff sets the difficulty - easy, medium or hard
     */
    public static void setBotDifficulty(int diff) {
        botDifficulty = diff;
    }

    /**
     * Getter of the difficulty of the bot in game mode bot
     * @return the current difficulty of the bot
     */
    public static int getBotDifficulty() {
        return botDifficulty;
    }
}
