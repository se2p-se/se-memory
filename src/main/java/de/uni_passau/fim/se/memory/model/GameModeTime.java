package de.uni_passau.fim.se.memory.model;
import de.uni_passau.fim.se.memory.view.OutputStreamGameModeTime;

/**
 * Extends the Game class and implements the form of the game in a time mode
 */
public class GameModeTime extends Game {
    private long currentTime;
    private long start;
    private long end;


    /**
     * GameModeTime constructor
     * Creates a new instance of the class which is inherited by its super class
     * Also the gameState is properly set and time starts to be counted
     */
    public GameModeTime() {
        super();
        this.setGameState(GameState.TIMEGAMESTART);
        countTime();
    }

    /**
     * Getter of end variable
     * @return current value of end time
     */
    public long getEnd() {
        return end;
    }

    /**
     * Getter of start variable
     * @return current value of start time
     */
    public long getStart() {
        return start;
    }

    /**
     * Memorizes the current time at the beginning of a time game
     */
    public void countTime() {
        start = System.currentTimeMillis();
    }

    /**
     * Memorizes the current time in the end of a time game
     */
    public void stopCountingTime() {
        end = System.currentTimeMillis();
    }

    /**
     * Calculates the duration of a time game
     * @param start time at the start of the time game
     * @param end time in the end of the time game
     * @return duration of the game
     */
    public long getCurrentTime(long start, long end) {
        currentTime = end - start;
        return currentTime;
    }

    /**
     * Compares the time of the current finished game with the values in the highscore list
     * @param currentTime time of the last finished time game
     * @return True, when record was broken. False if not.
     */
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
