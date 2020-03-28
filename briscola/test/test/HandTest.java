package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.*;

import exceptions.CardNotFoundException;
import exceptions.MaxCardNumberExceededException;
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
			assertThrows(MaxCardNumberExceededException.class, ()->{hand.add(Card.ASSO_SPADI);});
		}catch(MaxCardNumberExceededException exception) {};
	}
	@Test
	public void copyConstructorTest() {
		try {
			hand=new Hand(3);
			hand.add(Card.ASSO_BASTONI);
			hand.add(Card.ASSO_COPPE);
			hand.add(Card.ASSO_DENARI);
		}catch(MaxCardNumberExceededException exception) {};
		Hand copy=new Hand(hand);
		assertEquals(3, hand.getNumberCards());
		for(int i=0;i<copy.getNumberCards();i++) {
			try {
			assertTrue(copy.getCard(i).equals(hand.getCard(i)));
			}catch(CardNotFoundException exception) {}
		}
		
	}
	
	public void getCardTest() {
		try {
			hand=new Hand(3);
			hand.add(Card.ASSO_BASTONI);
			hand.add(Card.ASSO_COPPE);
			hand.add(Card.ASSO_DENARI);
		}catch(MaxCardNumberExceededException exception) {};
		
		try {
			Card prova=hand.getCard(1);
			assertTrue(Card.ASSO_COPPE.equals(prova));
			assertEquals(2, hand.getNumberCards());
			prova=hand.getCard(1);
			assertTrue(Card.ASSO_DENARI.equals(prova));
			assertEquals(1, hand.getNumberCards());
			assertThrows(ArrayIndexOutOfBoundsException.class, ()->{hand.getCard(1);});
		}catch(ArrayIndexOutOfBoundsException exceptions) {
			
		}catch(CardNotFoundException exception) {}
	}
	
	
	
	

}
