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
     * Player is selecting Cards
     */
    PLAYER_SELECTING_CARDS,
    /**
     * The game is over
     */
    END
}
