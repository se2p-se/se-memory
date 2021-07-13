package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.GameModeTime;
import de.uni_passau.fim.se.memory.model.GameState;
import de.uni_passau.fim.se.memory.model.SavingStats;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class GameModeTimeTest {

    @Test
    void testTimeStart() throws InterruptedException {
        GameModeTime game = new GameModeTime();
        TimeUnit.SECONDS.sleep(1);
        game.stopCountingTime();
        assertEquals(1000, ((game.getCurrentTime(game.getStart(),game.getEnd()))/ 10) * 10);
    }

    @Test
    void testGameState() {
        GameModeTime game = new GameModeTime();
        assertEquals(game.getGameState(), GameState.TIMEGAMESTART, "Wrong GameState at initialization of the game in time mode");
    }

    @Test
    void testSavedTime() throws InterruptedException {
        GameModeTime game = new GameModeTime();
        SavingStats.getSavingStats().statsWriterEasy(1100);
        TimeUnit.MILLISECONDS.sleep(1100);
        game.stopCountingTime();

        assertEquals(((game.getCurrentTime(game.getStart(),game.getEnd()))/ 100) * 100,
                (SavingStats.getSavingStats().statsReaderEasy() / 100) * 100,
                "Wrong Record time is written into via the statsWriter");
    }
}