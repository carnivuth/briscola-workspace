package test;
import static org.junit.jupiter.api.Assertions.*;
import exceptions.MaxCardNubmerExceededException;
import deck.Card;
import player.Hand;
public class HandTest {
	private Hand hand;
	@BeforeEach
	public void init() {
	hand=new Hand(3);
	}
	@Test
	public void handTest() {
		assertEquals(0, hand.getNumberCards());
	}
	@Test
	public void drawTest() {
		try {
		hand.add(Card.ASSO_BASTONI);
		assertEquals(1, hand.getNumberCards());
		hand.add(Card.ASSO_COPPE);
		assertEquals(2, hand.getNumberCards());
		hand.add(Card.ASSO_DENARI);
		assertEquals(3, hand.getNumberCards());
		assertThrows(MaxCardNubmerExceededException.class, ()->{hand.add(Card.ASSO_SPADI);});
		}
		catch(MaxCardNubmerExceededException exception) {};
		}
	@Test
	public void copyConstructorTest() {
		hand.add(Card.ASSO_BASTONI);
		hand.add(Card.ASSO_COPPE);
		hand.add(Card.ASSO_DENARI);
		Hand copy=new Hand(hand);
		assertEquals(3, hand.getNumberCards());
		for(int i=0;i<copy.getNumberCards();i++) {
			assertTrue(copy.getCard(i).equals(hand.getCard(i)));
		}
		
		}
	
	
	
	

}
