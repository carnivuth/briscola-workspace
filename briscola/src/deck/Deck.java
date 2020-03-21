package deck;
import java.util.Random;
/**
 * @author Legnini Mirko 
 * @author Longhi Matteo
 * class for the deck representation 
 */
public class Deck {
	/**
	 * 
	 * constant attribute for the physical dimension of the card array
	 * 
	 */
	private static final int BRISCOLA_NUMBER_CARDS=40;
	/**
	 * 
	 * the card's array
	 *  
	 */
	private Card[] cards;
	/**
	 * 
	 * index attribute for the last card in the array
	 * 
	 */
	private int lastCard;
	/**
	 * 
	 * main constructor for the <code>deck</code> object
	 * the method set the physical dimension of the array to the value of the 
	 * <code>BRISCOLA_NUMBER_CARDS</code> constant and  load the <code>card</code> values in to the array 
	 *  
	 * 
	 */
	public Deck() {
		this.cards=new Card[BRISCOLA_NUMBER_CARDS];
		this.cards=Card.values();
		this.lastCard=BRISCOLA_NUMBER_CARDS-1;
	}
	/*
	 * 
	 * method for the shuffling of the deck that use the <i>Durstenfeld-Knuth<i> algorithm
	 * 
	 */
	public void shuffle() {
		int j;
		Random random=new Random();
		for(int i=this.getLastCard();i>0;i--){
			j=random.nextInt(i);
			Card.swap(cards[i],cards[j]);
			
		}
	}
	
	/**
	 * 
	 * method for the decrease of the <code>cardsLeft</code> attribute
	 * 
	 */
	private void decreaseLastCard() {
		this.lastCard--;
	}
	/**
	 * 
	 * method that return the first card of the deck that is the last card of the physical support
	 * @return the first card in the deck
	 */
	public Card getFirstCard() {
		Card result=this.cards[this.getLastCard()];
		this.removeLastCard();
		return result;
	}
	/**
	 * 
	 * getter for the <code>lastCard</code> attribute
	 * @return the index of the last card in the array
	 */
	public int getLastCard() {
		return this.lastCard;
	}
	/**
	 * 
	 * getter for the <code>cardNumber</code> attribute
	 * @return the number of the cards in the deck
	 */
	public int getCardNumber() {
		return this.lastCard+1;
	}
	/**
	 * 
	 * method for the last card elimination
	 * 
	 */
	private void removeLastCard(){
		this.cards[this.getLastCard()]=null;
		this.decreaseLastCard();
		
	}
	/**
	 * 
	 * method for the elimination of the <code>DUE_COPPE</code> card from the deck for 1v1v1 matches
	 * 
	 */
	public void removeDue() {
		int posDue=-1;
		int i=0;
		while(posDue<0) {
			if(cards[i].compareTo(Card.DUE_COPPE)==0 && cards[i].getSeed().contentEquals("COPPE")) posDue=i;
			i++;
		}
		Card.swap(this.cards[this.lastCard], this.cards[posDue]);
		this.removeLastCard();
	}
}
