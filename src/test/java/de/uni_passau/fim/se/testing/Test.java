package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.GameModeBot;
import de.uni_passau.fim.se.memory.model.MainMenue;
import de.uni_passau.fim.se.memory.view.OutputStream;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeBot;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeTime;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestView {


    /**
     * #297
     */
    @Test
    void testMain() {
        // !!!Main-Methode muss erst noch in GUI.java verschoben werden!!!
    }

    /**
     * #298
     */
    @Test
    void testOutputStreamPrintBoard() {
        Game game = new Game();
        assertEquals(game.toString(), OutputStream.printBoard(game));
    }

    /**
     * #341
     */
    @Test
    void testOutputStreamPrintOpenBoard() {
        Game game = new Game();
        assertEquals(game.getCards().toString(), OutputStream.printOpenBoard(game)); // !!!Test wirft Fehler...WARUM?!!!
    }


    /**
     * #299
     */
    @Test
    void testOutputStreamGameModeBot() {
        GameModeBot game = new GameModeBot();
        Character ch = game.botMove();
        assertEquals("The bot picked a pair of " + ch + "s!", OutputStreamGameModeBot.printBotPickedMatch(ch));
    }


    /**
     * #300
     */
    @Test
    void testOutputStreamGameModeTime() {
        long timeInMs = 1000;
        long timeInSec = 1;
        assertEquals("Your finished the game successfully in " + timeInSec + " seconds", OutputStreamGameModeTime.printEndOfGameModeTime(timeInMs));
    }

    /**
     * #301
     */
    @Test
    void testOutputStreamMainMenu() {
        MainMenue.setTitleGameMode("Modus");
        String expected = "You are in the Main Menue! Choose an Option!\n"
                + "(1) for " + MainMenue.getTitleStartGame() + "\n"
                + "(2) for Modus\n" // oben veränderter String
                + "(3) for " + MainMenue.getTitleGameBoardSize() + "\n"
                + "(4) for " + MainMenue.getTitleActivateHelp() + "\n"
                + "(5) for " + MainMenue.getTitleComputerDifficulty() + "\n"
                + "(6) for " + MainMenue.getTitleEnd() + "\n";
        assertEquals(expected, OutputStreamMainMenu.showMainMenu());
    }

}
