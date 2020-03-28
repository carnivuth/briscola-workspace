package player;

import java.util.ArrayList;

import deck.Card;

public class PlayerBriscola extends Player {
	private int team;
	private ArrayList<Card> cardsWon;
	public PlayerBriscola(int dimension,int team) {
		super(dimension);
		this.setTeam(team);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Card play(int card) throws ArrayIndexOutOfBoundsException {
		return this.hand.getCard(card);
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

}
