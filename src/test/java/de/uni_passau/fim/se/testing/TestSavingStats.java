package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.SavingStats;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSavingStats {

    SavingStats savingStats = SavingStats.getSavingStats();




    @Test
    public void testStatsWriterMedium() {
        long testRecord = 420;
        savingStats.statsWriterMedium(testRecord);
        assertEquals(testRecord, savingStats.statsReaderMedium());
    }

    @Test
    public void testStatsWriterEasy() {
        long testRecord = 420;
        savingStats.statsWriterEasy(testRecord);
        assertEquals(testRecord, savingStats.statsReaderEasy());
    }

    @Test
    public void testStatsWriterDifficult() {
        long testRecord = 420;
        savingStats.statsWriterDifficult(testRecord);
        assertEquals(testRecord, savingStats.statsReaderDifficult());
    }

    @Test
    public void testStatsReaderMedium() {
        long testRecord = 422;
        savingStats.statsWriterMedium(testRecord);
        assertEquals(testRecord, savingStats.statsReaderMedium());
    }

    @Test
    public void testStatsReaderDifficult() {
        long testRecord = 422;
        savingStats.statsWriterDifficult(testRecord);
        assertEquals(testRecord, savingStats.statsReaderDifficult());
    }

    @Test
    public void testStatsReaderEasy() {
        long testRecord = 422;
        savingStats.statsWriterEasy(testRecord);
        assertEquals(testRecord, savingStats.statsReaderEasy());
    }

}
