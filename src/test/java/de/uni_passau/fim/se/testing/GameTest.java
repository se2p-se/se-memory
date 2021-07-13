package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import de.uni_passau.fim.se.memory.model.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testToString() {
        Game game = new Game();
        String first_row = game.toString().split("\n")[0].strip();

        assertEquals(first_row, "0 1 2 3 4 5");
    }

    @Test
    void openBoardToString() {
        Game game = new Game();
        String first_row = game.openBoardToString().split("\n")[0].strip();

        assertEquals(first_row, "0 1 2 3 4 5");
    }

    @Test
    void isGameFinished() {
        Game game = new Game();
        assertFalse(game.isGameFinished());
    }

    @Test
    void regenerateCards() {
        Game game = new Game();
        game.regenerateCards();
        assertEquals(game.getGameState(), GameState.RUNNING);
    }

    @Test
    void removeCards() {
        Card one = new Card('A');
        Card two = new Card('A');

        Game.removeCards(one, two);

        assertNull(one.getValue());
        assertNull(two.getValue());
    }

    @Test
    void selectCard() {
        Game game = new Game();
        assertEquals(game.selectCard(1, 1).getValue(), game.getCards().get(0).getValue());
    }
}