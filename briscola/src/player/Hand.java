package player;

import exceptions.MaxCardNubmerExceededException;

import java.util.ArrayList;

import deck.Card;

/**
 * @author Legnini Mirko
 * @author Longhi Matteo
 */
public class Hand {
    /**
     * constant value for the max dimension of the list
     */
    private static final int MAX_HAND_DIMENSION=3;

    /**
     * the cards array
     */
    private ArrayList<Card> cardsInHand;

    /**
     * main constructor for class <code>Hand</code>
     */
    public Hand() {

        this.cardsInHand = new ArrayList<Card>();
    }

    /**
     * copy constructor for the class <code>Hand</code>
     *
     * @param hand the object that we wont the copy of
     */
    public Hand(Hand hand) {

        this.cardsInHand=new ArrayList<Card>(hand.cardsInHand);
    }

    /**
     * getter for the <code>numberCards</code> value
     *
     * @return the number of cards in the hand
     */
    public int getNumberCards() {

        return this.cardsInHand.size();
    }

    /**
     * method for the insert of a card in the array
     *
     * @param card the card that have to be inserted in the array
     * @throws MaxCardNubmerExceededException if the hand is full
     */
    public void add(Card card) throws MaxCardNubmerExceededException {

        if (this.getNumberCards() >= MAX_HAND_DIMENSION)
            throw new MaxCardNubmerExceededException("hand array out of bounds too much cards in the hand");
        this.cardsInHand.add(card);
    }

    /**
     * remove a card from the array of the specified index
     *
     * @param index the index of the card that have to be removed
     * @return the card removed
     * @throws ArrayIndexOutOfBoundsException if the index is illegal for the array's dimension
     */
    public Card getCard(int index) throws ArrayIndexOutOfBoundsException {

        if (index<0||index>=this.cardsInHand.size())
            throw new ArrayIndexOutOfBoundsException("illegal index for the method getCard");
        return cardsInHand.remove(index);
    }
}
