package de.uni_passau.fim.se.memory.model;

public class MainMenue {
    private static String titleGameMode = "Select Mode";
    private static String titleStartGame = "Start Game";
    private static String titleGameBoardSize = "Adapt Game-Board-Size";
    private static String titleActivateHelp = "Activate Help";
    private static String titleGameModeTime = "Play against Time" ;
    private static String titleGameModeBot = "Play against Computer";
    private boolean isGameModeBot = false ;
    private boolean isGameModeTime = true ;
    private boolean isActivateHelp = false ;

    public static String getTitleActivateHelp() {
        return titleActivateHelp;
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

    public void setGameModeTime(boolean gameModeTime) {
        isGameModeTime = gameModeTime;
    }

    public void setGameModeBot(boolean gameModeBot) {
        isGameModeBot = gameModeBot;
    }
    public boolean getGameModeTime () {
        return isGameModeTime;
    }
    public boolean getGameModeBot () {
        return isGameModeBot ;
    }

    public void setActivateHelp(boolean activateHelp) {
        isActivateHelp = activateHelp;
    }

    public boolean getActivateHelp () {
        return isActivateHelp;
    }
    public void setTitleActivateHelp () {
        if (isActivateHelp) {
            titleActivateHelp = "Deactivate Help";
        }
        else {
            titleActivateHelp = "Activate Help" ;
        }
    }
}
