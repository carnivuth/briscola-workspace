package test;

import deck.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeckTest {
    private static Deck d;

    @BeforeEach
    public void init() {
        d = new Deck();
    }

    @Test
    public void deckTest() {

        assertEquals(40, d.getCardNumber());
    }

    @Test
    public void removeDueTest() {

        d.removeDue();
        assertEquals(39, d.getCardNumber());
    }

    @Test
    public void getFirstCardTest() {

        d.getFirstCard();
        d.getFirstCard();
        assertEquals(38, d.getCardNumber());
    }


}
