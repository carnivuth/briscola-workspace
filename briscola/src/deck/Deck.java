package deck;
import java.util.Random;
public class Deck {
	private static final int BRISCOLA_NUMBER_CARDS=40;
	private Card[] cards;
	private int cardsleft;
	
	public Deck() {
		this.cards=new Card[BRISCOLA_NUMBER_CARDS];
		this.cards=Card.values();
		this.cardsleft=BRISCOLA_NUMBER_CARDS-1;
	}
	
	public void shuffle() {
		int i=cardsleft;
		int j;
		Random random=new Random();
		while(i>0)
		{
			j=random.nextInt(i);
			Card temp=this.cards[i];
			this.cards[i]=this.cards[j];
			this.cards[j]=temp;
			i--;
		}
	}
	private void decreaseCardsLeft() {
		this.cardsleft--;
	}
	
	public Card getFirstCard() {
		Card result=this.cards[this.cardsleft];
		this.cards[this.cardsleft]=null;
		this.decreaseCardsLeft();
		return result;
	}
	
	public int getCardsLeft() {
		return this.cardsleft+1;
	}
	
	public void removeDue() {
		int posDue=-1;
		int i=0;
		while(posDue<0) {
			if(cards[i].compareTo(Card.DUE_COPPE)==0 && cards[i].getSeed().contentEquals("COPPE")) posDue=i;
			i++;
		}
		this.cards[posDue]=this.cards[this.cardsleft];
		this.cards[this.cardsleft]=null;
		decreaseCardsLeft();
	}
}
