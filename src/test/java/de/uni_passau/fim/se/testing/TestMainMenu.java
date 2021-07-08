package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMainMenu {

    /**
     * #261
     */
    @Test
    void testOutputStreamMainMenu() {
        String expected = "You are in the Main Menue! Choose an Option!\n"
                + "(1) for " + MainMenue.getTitleStartGame() + "\n"
                + "(2) for " + MainMenue.getTitleGameMode() + "\n"
                + "(3) for " + MainMenue.getTitleGameBoardSize() + "\n"
                + "(4) for " + MainMenue.getTitleActivateHelp() + "\n"
                + "(5) for " + MainMenue.getTitleComputerDifficulty() + "\n"
                + "(6) for " + MainMenue.getTitleEnd() + "\n";
        assertEquals(expected, OutputStreamMainMenue.showMainMenue());
    }

}