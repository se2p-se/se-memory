package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.MainMenu;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMainMenu {

    /**
     * #261
     */
    @Test
    void testOutputStreamMainMenu() {
        String expected = "You are in the Main Menue! Choose an Option!\n"
                + "(1) for " + MainMenu.getTitleStartGame() + "\n"
                + "(2) for " + MainMenu.getTitleGameMode() + "\n"
                + "(3) for " + MainMenu.getTitleGameBoardSize() + "\n"
                + "(4) for " + MainMenu.getTitleActivateHelp() + "\n"
                + "(5) for " + MainMenu.getTitleComputerDifficulty() + "\n"
                + "(6) for " + MainMenu.getTitleEnd() + "\n";
        assertEquals(expected, OutputStreamMainMenu.showMainMenu());
    }

}