package de.uni_passau.fim.se.testing;

import de.uni_passau.fim.se.memory.model.Card;
import de.uni_passau.fim.se.memory.model.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Game game = new Game();
    Card card = game.selectCard(1,1);

    @Test
    void testCardNotHidden() {
        assertTrue(card.getIsHidden(),"Card is hidden but should be not");
    }

    @Test
    void testCardHidden() {
        card = game.getCards().get(0);
        assertTrue(card.getIsHidden(),"Card is not hidden but it should be");
    }

    @Test
    void testCardFlipped(){
        card.flipCard();
        assertFalse(card.getIsHidden(), "Card should be flipped");
    }

    @Test
    void testValuesSetCorrect() {
        card.setValue('A');
        assertEquals('A', card.getValue());
        assertTrue(card.getValue() >= 65 && card.getValue() <= 75, "Card has a wrong value");
    }
}