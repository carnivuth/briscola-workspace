package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.*;

import exceptions.MaxCardNubmerExceededException;
import deck.Card;
import player.Hand;
public class HandTest {
	private  Hand hand;
	@BeforeEach
	public void init() {
		hand=new Hand(3);
	}
	@Test
	public void handTest() {
		hand=new Hand(3);
		assertEquals(0, hand.getNumberCards());
	}
	@Test
	public void drawTest() {
		try {
			hand=new Hand(3);
			hand.add(Card.ASSO_BASTONI);
			assertEquals(1, hand.getNumberCards());
			hand.add(Card.ASSO_COPPE);
			assertEquals(2, hand.getNumberCards());
			hand.add(Card.ASSO_DENARI);
			assertEquals(3, hand.getNumberCards());
			assertThrows(MaxCardNubmerExceededException.class, ()->{hand.add(Card.ASSO_SPADI);});
		}catch(MaxCardNubmerExceededException exception) {};
	}
	@Test
	public void copyConstructorTest() {
		try {
			hand=new Hand(3);
			hand.add(Card.ASSO_BASTONI);
			hand.add(Card.ASSO_COPPE);
			hand.add(Card.ASSO_DENARI);
		}catch(MaxCardNubmerExceededException exception) {};
		Hand copy=new Hand(hand);
		assertEquals(3, hand.getNumberCards());
		for(int i=0;i<copy.getNumberCards();i++) {
			assertTrue(copy.getCard(i).equals(hand.getCard(i)));
		}
		
	}
	
	public void getCardTest() {
		try {
			hand=new Hand(3);
			hand.add(Card.ASSO_BASTONI);
			hand.add(Card.ASSO_COPPE);
			hand.add(Card.ASSO_DENARI);
		}catch(MaxCardNubmerExceededException exception) {};
		
		try {
			Card prova=hand.getCard(1);
			assertTrue(Card.ASSO_COPPE.equals(prova));
			assertEquals(2, hand.getNumberCards());
			prova=hand.getCard(1);
			assertTrue(Card.ASSO_DENARI.equals(prova));
			assertEquals(1, hand.getNumberCards());
			assertThrows(ArrayIndexOutOfBoundsException.class, ()->{hand.getCard(1);});
		}catch(ArrayIndexOutOfBoundsException exceptions) {};
	}
	
	
	
	

}
