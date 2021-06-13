package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenue;

import java.util.Scanner;

public class InputStreamMainMenue {
    Scanner menueScanner = new Scanner(System.in) ;
    Scanner modeScanner = new Scanner(System.in) ;
    Scanner setGameBoardSize = new Scanner (System.in) ;
    MainMenue mainMenue = new MainMenue() ;
    InputStreamPlayer player = new InputStreamPlayer() ;
    Game game = new Game ();

    /**
     * user can pick an option
     */
    public void pickMainMenueOption () {
        int option = menueScanner.nextInt() ;
        if (option == 5) {
        }
        else {
            switch (option) {
                case 1:
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
                    while (x*y > 20 || (x*y) % 2 != 0)  {
                        OutputStreamMainMenue.showSizetoBig();
                        OutputStreamMainMenue.showPleaseInsertGameBoardSizeX();
                        x = setGameBoardSize.nextInt();
                        OutputStreamMainMenue.showPleaseInsertGameBoardSizeY();
                        y = setGameBoardSize.nextInt();
                    }
                    if (x<=0 || y<= 0) {
                        game.setGameBoardSize(3,3);
                    }
                    else {
                        game.setGameBoardSize(x, y);
                    }
                    break;

                case 4:
                    if (mainMenue.getActivateHelp() == true) {
                        mainMenue.setActivateHelp(false);
                        OutputStreamMainMenue.showActivateHelpSetFalse();
                    } else {
                        mainMenue.setActivateHelp(true);
                        OutputStreamMainMenue.showActivateHelpSetTrue();
                    }
                    mainMenue.setTitleActivateHelp();
                    break;
            }
            OutputStreamMainMenue.showMainMenue();
            pickMainMenueOption();
        }
    }
}
