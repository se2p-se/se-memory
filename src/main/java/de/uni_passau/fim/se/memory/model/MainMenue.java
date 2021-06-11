package de.uni_passau.fim.se.memory.model;

public class MainMenue {
    private String titleGameMode = "Select Mode";
    private String titleStartGame = "Start Game";
    private String titleGameBoardSize = "Adapt Game-Board-Size";
    private String titleActivateHelp = "Activate Help";
    private String titleGameModeTime = "Play against Time" ;
    private String titleGameModeBot = "Play against Computer";
    private boolean isGameModeBot = false ;
    private boolean isGameModeTime = true ;
    private boolean isActivateHelp = false ;

    public String getTitleActivateHelp() {
        return titleActivateHelp;
    }

    public String getTitleGameBoardSize() {
        return titleGameBoardSize;
    }

    public String getTitleGameMode() {
        return titleGameMode;
    }

    public String getTitleGameModeBot() {
        return titleGameModeBot;
    }

    public String getTitleGameModeTime() {
        return titleGameModeTime;
    }

    public String getTitleStartGame() {
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
}
