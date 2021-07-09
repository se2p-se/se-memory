package de.uni_passau.fim.se.memory.controller;

import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.OutputStream;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenu;

import java.util.Scanner;

public class InputStreamMainMenue {
    private Scanner menueScanner = new Scanner(System.in) ;
    private Scanner modeScanner = new Scanner(System.in) ;
    private Scanner setGameBoardSize = new Scanner (System.in) ;
    private MainMenue mainMenue = new MainMenue() ;
    private InputStreamPlayer player = new InputStreamPlayer() ;

    int[] gameBoardSize = new int[]{5, 4};

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

                    player.game.setGameBoardSize(gameBoardSize[0],
                            gameBoardSize[1]);

                    if (MainMenue.getActivateHelp()) {
                        System.out.println(OutputStream.printOpenBoard(player.getGame()));
                        player.getGame().timer(5000);
                        OutputStream.printSigthBlockade();
                    }

                    player.gameLoop();
                    break;
                case 2:
                    OutputStreamMainMenu.showModeTime();
                    OutputStreamMainMenu.showModeBot();
                    OutputStreamMainMenu.showBackButton();
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
                        OutputStreamMainMenu.showSubmenuGameBoardSize();
                        int difficulty = setGameBoardSize.nextInt();

                        if (difficulty == 1) {
                            gameBoardSize = new int[]{3, 4};
                            break;
                        } else if (difficulty == 2) {
                            gameBoardSize = new int[]{4, 4};
                            break;
                        } else if (difficulty == 3) {
                            gameBoardSize = new int[]{5, 4};
                            break;
                        } else if (difficulty == 4) {
                            OutputStreamMainMenu.showPleaseInsertGameBoardSizeX();
                            int x = setGameBoardSize.nextInt();
                            OutputStreamMainMenu.showPleaseInsertGameBoardSizeY();
                            int y = setGameBoardSize.nextInt();
                            while (x * y > 20 || (x * y) % 2 != 0 || x <= 0 || y <= 0) {
                                OutputStreamMainMenu.showSizeNotPossible();
                                OutputStreamMainMenu.showPleaseInsertGameBoardSizeX();
                                x = setGameBoardSize.nextInt();
                                OutputStreamMainMenu.showPleaseInsertGameBoardSizeY();
                                y = setGameBoardSize.nextInt();
                            }
                            gameBoardSize = new int[]{x, y};
                            break;
                        }
                    }
                    break;

                case 4:
                    if (mainMenue.getActivateHelp()) {
                        mainMenue.setActivateHelp(false);
                        OutputStreamMainMenu.showActivateHelpSetFalse();
                    } else {
                        mainMenue.setActivateHelp(true);
                        OutputStreamMainMenu.showActivateHelpSetTrue();
                    }
                    mainMenue.setTitleActivateHelp();
                    break;
                case 5:
                    OutputStreamMainMenu.showBotDifficulty();
                    int diffi = modeScanner.nextInt();
                    if (diffi >= 1 && diffi <= 3)
                        mainMenue.setBotDifficulty(diffi);
                    break;
            }
            OutputStreamMainMenu.showMainMenu();
            pickMainMenueOption();
        }
    }
}
