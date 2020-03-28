package table;
import deck.Card;
import exceptions.MaxCardNubmerExceededException;
public class Table {
	Card[] cards;
	int cardNumber;
	
	public Table(int playerNumber) {
		cards=new Card[playerNumber];
		this.cardNumber=0;
	}
	
	public int getCardNumber() {
		return this.cardNumber;
	}
	private void incrementCardNumber() {
		this.cardNumber++;
	}
	public void putCard(Card input) throws MaxCardNubmerExceededException {
		if(this.getCardNumber()>=this.cards.length) {
			throw new MaxCardNubmerExceededException("table array out of bounds too much cards on the table");
		}
		this.cards[this.getCardNumber()]=input;
		this.incrementCardNumber();
	}
	
	public Card[] getTable() {
		return this.cards;
	}
}