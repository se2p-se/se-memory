package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.GameModeBot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameModeBotTest {

	@Test
	void testBotCanFinishGame() {
		GameModeBot game = new GameModeBot();

		int tries = 0;
		while (!game.isGameFinished() && tries < 1000000) {
			game.botMove();
			tries++;
		}

		assertEquals(true,
				game.isGameFinished(), "The bot should be able to finish the "
						+ "game on its own.");
	}
}