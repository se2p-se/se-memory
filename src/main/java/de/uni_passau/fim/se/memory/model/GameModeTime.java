package de.uni_passau.fim.se.memory.model;

import de.uni_passau.fim.se.memory.view.OutputStreamGameModeTime;

public class GameModeTime extends Game {
    private long currentTime;
    private long start;
    private long end;


    public GameModeTime() {
        super();
        this.setGameState(GameState.TIMEGAMESTART);
        countTime();
    }

    public long getEnd() {
        return end;
    }

    public long getStart() {
        return start;
    }

    public void countTime() {
        start = System.currentTimeMillis();
    }

    public void stopCountingTime() {
        end = System.currentTimeMillis();
    }

    public long getCurrentTime(long start, long end) {
        currentTime = end - start;
        return currentTime;
    }

    public boolean compareWithSavedTime(long currentTime) {
        if (this.getGameBoardSize().length == 4)
            if (SavingStats.getSavingStats().statsReaderMedium() > currentTime) {
                SavingStats.getSavingStats().statsWriterMedium(currentTime);
                return true;
            } else if (this.getGameBoardSize().length == 5)
                if (SavingStats.getSavingStats().statsReaderDifficult() > currentTime) {
                    SavingStats.getSavingStats().statsWriterDifficult(currentTime);
                    return true;
                } else {
                    if (SavingStats.getSavingStats().statsReaderEasy() > currentTime)
                        SavingStats.getSavingStats().statsWriterEasy(currentTime);
                    return true;

                }


        OutputStreamGameModeTime.printRecordNotBroken();
        return false;
    }
}
