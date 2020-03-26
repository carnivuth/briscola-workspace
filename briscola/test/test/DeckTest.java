package test;
import deck.Deck;


import static org.junit.Assert.*;



import org.junit.jupiter.api.*;
public class DeckTest {
	private static Deck d;
	@BeforeEach
	public  void init() {
		d=new Deck();
	}
	@Test
	public void deckTest() {
		
		assertEquals(40,d.getCardNumber());
		assertEquals(39,d.getLastCard());
		
	}
	@Test
	public void removeDueTest() {
		d.removeDue();
		assertEquals(39,d.getCardNumber());
		assertEquals(38,d.getLastCard());
		
	}
	@Test
	public void getFirstCardTest() {
		d.getFirstCard();
		d.getFirstCard();
		assertEquals(38,d.getCardNumber());
		assertEquals(37,d.getLastCard());
		
	}
	
	
}
