package de.uni_passau.fim.se.memory.model;

/**
 * Describing the current state of the game
 */
public enum GameState {
    /**
     * Game is being initialised
     */
    INITIALIZING_GAME,
    /**
     * time game has started
     */
    TIMEGAMESTART,
    /**
     * time game has ended
     */
    TIMEGAMEEND,
    /**
     * The game is running
     */
    RUNNING,
    /**
     * The game is over
     */
    END
}
