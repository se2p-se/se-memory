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
    OutputStreamMainMenue outputStreamMainMenue= new OutputStreamMainMenue() ;

    /**
     * user can pick an option
     */
    public void pickMainMenueOptioin () {
        int option = menueScanner.nextInt() ;
        switch (option) {
            case 1 :
                player.gameLoop();
                break ;
            case 2 :
                outputStreamMainMenue.showModeTime();
                outputStreamMainMenue.showModeBot();
                int modeOption = modeScanner.nextInt();
                switch (modeOption) {
                    case 1:
                        mainMenue.setGameModeTime(true);
                        break ;
                    case 2 :
                        mainMenue.setGameModeBot(true);
                        break ;
                }
                break;
            case 3 :
                int x = setGameBoardSize.nextInt();
                int y = setGameBoardSize.nextInt();
                game.setGameBoardSize(x, y);
                break ;
            case 4 :
                if (mainMenue.getActivateHelp() == true) {
                    mainMenue.setActivateHelp(false);
                    outputStreamMainMenue.showActivateHelpSetFalse();
                }
                else {
                    mainMenue.setActivateHelp(true);
                    outputStreamMainMenue.showActivateHelpSetTrue();
                }
                break ;
        }
        OutputStreamMainMenue.showMainMenue();
        pickMainMenueOptioin();
    }
}
