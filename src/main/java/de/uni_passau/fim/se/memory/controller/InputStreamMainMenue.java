package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.OutputStream;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenue;

import java.util.Scanner;

public class InputStreamMainMenue {
    private Scanner menueScanner = new Scanner(System.in) ;
    private Scanner modeScanner = new Scanner(System.in) ;
    private Scanner setGameBoardSize = new Scanner (System.in) ;
    private MainMenue mainMenue = new MainMenue() ;
    private InputStreamPlayer player = new InputStreamPlayer() ;

    /**
     * user can pick an option
     */
    public void pickMainMenueOption () {
        int option = menueScanner.nextInt() ;
        if (option == 6) {
        }
        else {
            switch (option) {
                case 1:
                    if (mainMenue.getGameModeTime()) {
                        player = new InputStreamGameModeTime();
                    } else if (mainMenue.getGameModeBot()) {
                        player = new InputStreamGameModeBot();
                    } else {
                        player = new InputStreamPlayer();
                    }
  
                    if (MainMenue.getActivateHelp()) {
                        OutputStream.printOpenBoard(player.getGame());
                        player.getGame().timer(5000);
                        OutputStream.printSigthBlockade();
                    }

                    player.gameLoop();
                    break;
                case 2:
                    OutputStreamMainMenue.showModeTime();
                    OutputStreamMainMenue.showModeBot();
                    OutputStreamMainMenue.showBackButton();
                    int modeOption = modeScanner.nextInt();
                    switch (modeOption) {
                        case 1:
                            mainMenue.setGameModeTime(true);
                            mainMenue.setGameModeBot(false);
                            break;
                        case 2:
                            mainMenue.setGameModeBot(true);
                            mainMenue.setGameModeTime(false);
                            break;
                    }
                    break;
                case 3:
                    OutputStreamMainMenue.showPleaseInsertGameBoardSizeX();
                    int x = setGameBoardSize.nextInt();
                    OutputStreamMainMenue.showPleaseInsertGameBoardSizeY();
                    int y = setGameBoardSize.nextInt();
                    while (x*y > 20 || (x*y) % 2 != 0 || x<=0 || y<= 0)  {
                        OutputStreamMainMenue.showSizeNotPossible();
                        OutputStreamMainMenue.showPleaseInsertGameBoardSizeX();
                        x = setGameBoardSize.nextInt();
                        OutputStreamMainMenue.showPleaseInsertGameBoardSizeY();
                        y = setGameBoardSize.nextInt();
                    }
                    player.getGame().setGameBoardSize(x, y);
                    break;

                case 4:
                    if (mainMenue.getActivateHelp()) {
                        mainMenue.setActivateHelp(false);
                        OutputStreamMainMenue.showActivateHelpSetFalse();
                    } else {
                        mainMenue.setActivateHelp(true);
                        OutputStreamMainMenue.showActivateHelpSetTrue();
                    }
                    mainMenue.setTitleActivateHelp();
                    break;
                case 5:
                    OutputStreamMainMenue.showBotDifficulty();
                    int diffi = modeScanner.nextInt();
                    if (diffi >= 1 && diffi <= 3)
                        mainMenue.setBotDifficulty(diffi);
                    break;
            }
            OutputStreamMainMenue.showMainMenue();
            pickMainMenueOption();
        }
    }
}
