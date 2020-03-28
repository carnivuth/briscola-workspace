package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import deck.Card;
import exceptions.MaxCardNubmerExceededException;
import player.PlayerBriscola;
public class PlayerTest {
	@Test
	public void playerTest() {
		PlayerBriscola p=new PlayerBriscola(3,1);
		assertEquals(p.getHand().getNumberCards(),3);
		assertEquals(p.getTeam(),1);
		assertTrue(p.getCardsWon().isEmpty());
		
	}
	@Test
	public void drawTest() {
		PlayerBriscola p=new PlayerBriscola(3,1);
		try {
		p.draw(Card.ASSO_BASTONI);
		p.draw(Card.ASSO_COPPE);
		p.draw(Card.ASSO_DENARI);
		assertThrows(MaxCardNubmerExceededException.class,()->{p.draw(Card.ASSO_SPADI);});
		}catch(MaxCardNubmerExceededException exception) {}
	}
	@Test
	public void playTest() {
		PlayerBriscola p=new PlayerBriscola(3,1);
		try {
			p.draw(Card.ASSO_BASTONI);
			p.draw(Card.ASSO_COPPE);
			p.draw(Card.ASSO_DENARI);
			assertTrue(p.play(0).equals(Card.ASSO_BASTONI));
			assertTrue(p.play(0).equals(Card.ASSO_COPPE));
			assertTrue(p.play(0).equals(Card.ASSO_DENARI));
			assertThrows(ArrayIndexOutOfBoundsException.class,()->{p.play(0);});
		}catch(MaxCardNubmerExceededException exception) {
			
		}catch(ArrayIndexOutOfBoundsException exception) {}
	}

}
