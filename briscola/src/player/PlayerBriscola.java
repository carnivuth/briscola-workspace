package player;

import java.util.ArrayList;

import deck.Card;
import exceptions.CardNotFoundException;
/**
 * 
 * @author Longhi Matteo
 * @author Legnini Mirko
 *
 */
public class PlayerBriscola extends Player {
	/**
	 * attribute for the team representation
	 */
	private int team;
	/**
	 * list attribute for the player's won cards
	 */
	private ArrayList<Card> cardsWon;
	/**
	 * constructor for the class <code>PlayerBriscola</code>
	 * @param dimension the physical dimension of the hand
	 * @param team the player's team
	 */
	public PlayerBriscola(int dimension,int team) {
		super(dimension);
		this.setTeam(team);
		cardsWon=new ArrayList<Card>();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	/**
	 * 
	 * play the card of the given index
	 * @param card the index of the card
	 * @throws  ArrayIndexOutOfBoundsException if the index parameter is illegal
	 * @return the card played 
	 */
	public Card play(int card) throws ArrayIndexOutOfBoundsException,CardNotFoundException {
		return this.hand.getCard(card);
	}
	/**
	 * getter for team attribute
	 * @return the team value
	 */
	public int getTeam() {
		return team;
	}
	/**
	 * 
	 * setter method for team attribute
	 * @param team the wonted value
	 */
	private void setTeam(int team) {
		this.team = team;
	}
	/**
	 * method for the add of the won cards in the won cards <code>arraylist</code>
	 * @param cards the won cards to add
	 */
	public void won(Card[] cards) {
		for(Card e:cards)this.cardsWon.add(e);
	}
	/**
	 * getter for the cards won <code>arraylist</code>
	 * @return the <code>ArrayList</code> of the won cards 
	 */
	public ArrayList<Card> getCardsWon() {
		return cardsWon;
	}
}
