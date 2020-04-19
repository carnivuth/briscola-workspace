package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;

import exceptions.MaxCardNubmerExceededException;
import deck.Card;
import org.junit.jupiter.api.function.Executable;
import player.Hand;

public class HandTest {
    private Hand hand;

    @BeforeEach
    public void init() {
        hand = new Hand();
    }

    @Test
    public void handTest() {
        hand = new Hand();
        assertEquals(0, hand.getNumberCards());
    }

    @Test
    public void drawTest() {
        try {
            hand = new Hand();
            hand.add(Card.ASSO_BASTONI);
            assertEquals(1, hand.getNumberCards());
            hand.add(Card.ASSO_COPPE);
            assertEquals(2, hand.getNumberCards());
            hand.add(Card.ASSO_DENARI);
            assertEquals(3, hand.getNumberCards());
            assertThrows(MaxCardNubmerExceededException.class, new Executable() {
                @Override
                public void execute() throws Throwable {
                    hand.add(Card.ASSO_SPADI);
                }
            });
        } catch (MaxCardNubmerExceededException ignored) {
        }
    }

    @Test
    public void copyConstructorTest() {
        try {
            hand = new Hand();
            hand.add(Card.ASSO_BASTONI);
            hand.add(Card.ASSO_COPPE);
            hand.add(Card.ASSO_DENARI);
        } catch (MaxCardNubmerExceededException exception) {
        }
        Hand copy = new Hand(hand);
        assertEquals(3, hand.getNumberCards());
        for (int i = 0; i < copy.getNumberCards(); i++) {
            assertTrue(copy.getCard(i).equals(hand.getCard(i)));
        }

    }

    public void getCardTest() {
        try {
            hand = new Hand();
            hand.add(Card.ASSO_BASTONI);
            hand.add(Card.ASSO_COPPE);
            hand.add(Card.ASSO_DENARI);
        } catch (MaxCardNubmerExceededException ignored) {
        }

        try {
            Card prova = hand.getCard(1);
            assertTrue(Card.ASSO_COPPE.equals(prova));
            assertEquals(2, hand.getNumberCards());
            prova = hand.getCard(1);
            assertTrue(Card.ASSO_DENARI.equals(prova));
            assertEquals(1, hand.getNumberCards());
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                hand.getCard(1);
            });
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }


}
