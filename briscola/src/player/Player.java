package player;

import deck.Card;

public abstract class Player {
	/**
	 * attribute for the hand representation
	 */
	protected Hand hand;
	/**
	 * 
	 * constructor for the player class
	 * @param dimension the physical dimension of the hand
	 */
	public Player(int dimension) {
		hand=new Hand(dimension);
	}
	/**
	 * method for the draw of a card
	 * @param card the card drawn
	 */
	public void draw(Card card) {
		
	}
	/**
	 * get method for the hand attribute
	 * @return a copy of the hand attribute
	 */
	public Hand getHand() {
		return new Hand(hand);
	}
	/**
	 * Abstract method play
	 * @param card the index of the card
	 * @return the card player
	 */
	public abstract Card play(int card);

}
