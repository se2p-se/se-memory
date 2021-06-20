package de.uni_passau.fim.se.memory.model;

public class GameModeTime extends Game {
    private long currentTime;
    private long start;
    private long end;

    public GameModeTime(){
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
}
