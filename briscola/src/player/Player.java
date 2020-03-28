package player;

import deck.Card;
import exceptions.CardNotFoundException;
import exceptions.MaxCardNumberExceededException;

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
	 * @throws MaxCardNumberExceededException if the array is full
	 */
	public void draw(Card card) throws MaxCardNumberExceededException {
		this.hand.add(card);
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
	 * @throws ArrayIndexOutOfBoundsException if the index is illegal
	 * @throws CardNotFoundException if there is no card in the specified index
	 */
	public abstract Card play(int card) throws ArrayIndexOutOfBoundsException,CardNotFoundException;

}
