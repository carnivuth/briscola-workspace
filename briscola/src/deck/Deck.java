package deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Legnini Mirko
 * @author Longhi Matteo
 */
public class Deck {

    /**
     * the card's arrayList
     */
    private ArrayList<Card> cards;

    /**
     * main constructor for the <code>deck</code> object
     * the method set the physical dimension of the array to the value of the
     * <code>BRISCOLA_NUMBER_CARDS</code> constant and  load the <code>card</code> values in to the array
     */
    public Deck() {

        this.cards = new ArrayList<Card>();
        this.cards.addAll(Arrays.asList(Card.values()));
    }

    /**
     * method for the shuffling of the deck that use the <i>Durstenfeld-Knuth</i> algorithm
     */
    public void shuffle() {

        int j;
        Random random = new Random();
        for (int i = this.cards.size(); i > 0; i--) {
            j = random.nextInt(i);
            Card.swap(cards.get(i), cards.get(j));
        }
    }

    /**
     * method that return the first card of the deck that is the last card of the physical support
     *
	 */
    public Card getFirstCard() {

        return this.cards.remove(this.cards.size()-1);
	}


    /**
     * getter for the <code>cardNumber</code> attribute
     *
     * @return the number of the cards in the deck
     */
    public int getCardNumber() {

        return this.cards.size();
    }

    /**
     * method for the elimination of the <code>DUE_COPPE</code> card from the deck for 1v1v1 matches
     */
    public void removeDue() {

        this.cards.remove(Card.DUE_COPPE);
    }
}
