package player;

import deck.Card;

public abstract class Player {
	protected Hand hand;
	public Player(int dimension) {
		hand=new Hand(dimension);
	}
	public void draw(Card card) {
		
	}
	public Hand getHand() {
		return new Hand(hand);
	}
	public abstract Card play(int card);

}
