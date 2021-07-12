package de.uni_passau.fim.se.memory.model;

public class MainMenu {
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
    private static String titleCostumGameBoardSize = "Costum";
    private boolean isGameModeBot = false;
    private boolean isGameModeTime = true;
    private static boolean isActivateHelp = false;
    private static int botDifficulty = 1;

    public static String getTitleActivateHelp() {
        return titleActivateHelp;
    }

    public static String getTitleComputerDifficulty() {
        return titleComputerDifficulty;
    }

    public static String getTitleGameBoardSize() {
        return titleGameBoardSize;
    }

    public static String getTitleGameMode() {
        return titleGameMode;
    }

    public static String getTitleGameModeBot() {
        return titleGameModeBot;
    }

    public static String getTitleGameModeTime() {
        return titleGameModeTime;
    }

    public static String getTitleStartGame() {
        return titleStartGame;
    }

    public static String getTitleEnd() {
        return titleEnd;
    }

    public static String getTitleEasyGameBoardSize() {
        return titleEasyGameBoardSize;
    }

    public static String getTitleMediumGameBoardSize() {
        return titleMediumGameBoardSize;
    }

    public static String getTitleDifficultGameBoardSize() {
        return titleDifficultGameBoardSize;
    }

    public static String getTitleCostumGameBoardSize() {
        return titleCostumGameBoardSize;
    }

    public static void setTitleGameMode(String name) {
        titleGameMode = name;
    }

    public void setGameModeTime(boolean gameModeTime) {
        isGameModeTime = gameModeTime;
    }

    public void setGameModeBot(boolean gameModeBot) {
        isGameModeBot = gameModeBot;
    }

    public boolean getGameModeTime() {
        return isGameModeTime;
    }

    public boolean getGameModeBot() {
        return isGameModeBot;
    }

    public void setActivateHelp(boolean activateHelp) {
        isActivateHelp = activateHelp;
    }

    public static boolean getActivateHelp() {
        return isActivateHelp;
    }

    public void setTitleActivateHelp() {
        if (isActivateHelp) {
            titleActivateHelp = "Deactivate Help";
        } else {
            titleActivateHelp = "Activate Help";
        }
    }

    public static void setBotDifficulty(int diff) {
        botDifficulty = diff;
    }

    public static int getBotDifficulty() {
        return botDifficulty;
    }

}
