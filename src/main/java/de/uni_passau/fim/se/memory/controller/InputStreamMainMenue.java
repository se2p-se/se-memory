package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.OutputStream;
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
                    while (true) {
                        OutputStreamMainMenue.showGameBoardSizeSelectionMenu();
                        int difficulty = setGameBoardSize.nextInt();

                        if (difficulty == 1) {
                            game.setGameBoardSize(3, 4);
                            break;
                        } else if (difficulty == 2) {
                            game.setGameBoardSize(4, 4);
                            break;
                        } else if (difficulty == 3) {
                            game.setGameBoardSize(5, 4);
                            break;
                        } else if (difficulty == 4) {
                            OutputStreamMainMenue.showPleaseInsertGameBoardSizeX();
                            int x = setGameBoardSize.nextInt();
                            OutputStreamMainMenue.showPleaseInsertGameBoardSizeY();
                            int y = setGameBoardSize.nextInt();
                            while (x * y > 20 || (x * y) % 2 != 0 || x <= 0 || y <= 0) {
                                OutputStreamMainMenue.showSizeNotPossible();
                                OutputStreamMainMenue.showPleaseInsertGameBoardSizeX();
                                x = setGameBoardSize.nextInt();
                                OutputStreamMainMenue.showPleaseInsertGameBoardSizeY();
                                y = setGameBoardSize.nextInt();
                            }
                            game.setGameBoardSize(x, y);
                            break;
                        }
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
