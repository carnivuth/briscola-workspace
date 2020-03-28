package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import deck.Card;
import exceptions.CardNotFoundException;
import exceptions.MaxCardNumberExceededException;
import player.PlayerBriscola;
public class PlayerTest {
	@Test
	public void playerTest() {
		PlayerBriscola p=new PlayerBriscola(3,1);
		assertEquals(p.getHand().getNumberCards(),0);
		assertEquals(p.getTeam(),1);
		assertTrue(p.getCardsWon().isEmpty());
	}
	@Test
	public void drawTest() {
		PlayerBriscola p=new PlayerBriscola(3,1);
		try {
		p.draw(Card.ASSO_BASTONI);
		assertEquals(p.getHand().getNumberCards(),1);
		p.draw(Card.ASSO_COPPE);
		assertEquals(p.getHand().getNumberCards(),2);
		p.draw(Card.ASSO_DENARI);
		assertEquals(p.getHand().getNumberCards(),3);
		assertThrows(MaxCardNumberExceededException.class,()->{p.draw(Card.ASSO_SPADI);});
		}catch(MaxCardNumberExceededException exception) {}
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
			assertThrows(ArrayIndexOutOfBoundsException.class,()->{p.play(-1);});
			assertThrows(CardNotFoundException.class,()->{p.play(0);});
		}catch(MaxCardNumberExceededException exception) {
			
		}catch(ArrayIndexOutOfBoundsException exception) {
			
		}catch(CardNotFoundException exception) {}
		
	}
	@Test
	public void wonTest() {
		PlayerBriscola p=new PlayerBriscola(3,1);
		Card[] array= {Card.DUE_COPPE,Card.CAVALLO_DENARI};
		p.won(array);
		assertTrue(p.getCardsWon().contains(Card.DUE_COPPE));
		assertTrue(p.getCardsWon().contains(Card.CAVALLO_DENARI));
	}

}
