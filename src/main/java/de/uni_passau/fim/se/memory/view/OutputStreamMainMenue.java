package de.uni_passau.fim.se.memory.view;

import de.uni_passau.fim.se.memory.model.MainMenue;

public class OutputStreamMainMenue {
    MainMenue mainMenue = new MainMenue();
    public void showMainMenue () {
        System.out.println("You are in the Main Menue! Choose an Option");
        System.out.println("(1) for " + mainMenue.getTitleStartGame());
        System.out.println("(2) for " + mainMenue.getTitleGameMode());
        System.out.println("(3) for " + mainMenue.getTitleGameBoardSize());
        System.out.println("(4) for " + mainMenue.getTitleActivateHelp());
    }
    public void showModeBot () {
        System.out.println("(1) for " + mainMenue.getTitleGameModeTime());
    }
    public void showModeTime () {
        System.out.println("(2) for " + mainMenue.getTitleGameModeBot());
    }
    public void showActivateHelpSetFalse () {
            System.out.println("You just disabled help");
        }

    public void showActivateHelpSetTrue () {
        System.out.println("You just enabled help");
    }
}
