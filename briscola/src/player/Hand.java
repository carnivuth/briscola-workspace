package player;

import exceptions.MaxCardNubmerExceededException;

import java.util.Arrays;

import deck.Card;

/**
 * @author Legnini Mirko
 * @author Longhi Matteo
 */
public class Hand {
    /**
     * the cards array
     */
    private Card[] cardsInHand;
    /**
     * the logic dimension
     */
    private int numberCards;

    /**
     * main constructor for class <code>Hand</code>
     *
     * @param dimension the physical dimension of the <code>cardsInHand</code> array
     */
    public Hand(int dimension) {
        this.cardsInHand = new Card[dimension];
        this.numberCards = 0;
    }

    /**
     * copy constructor for the class <code>Hand</code>
     *
     * @param hand the object that we wont the copy of
     */
    public Hand(Hand hand) {
        this.numberCards = hand.getNumberCards();
        this.cardsInHand = Arrays.copyOf(hand.cardsInHand, hand.getNumberCards());
    }

    /**
     * getter for the <code>numberCards</code> value
     *
     * @return the number of cards in the hand
     */
    public int getNumberCards() {
        return numberCards;
    }

    /**
     * method for the insert of a card in the array
     *
     * @param card the card that have to be inserted in the array
     * @throws MaxCardNubmerExceededException if the hand is full
     */
    public void add(Card card) throws MaxCardNubmerExceededException {
        if (this.getNumberCards() >= cardsInHand.length)
            throw new MaxCardNubmerExceededException("hand array out of bounds too much cards in the hand");
        this.cardsInHand[this.getNumberCards()] = card;
        this.increaseNumberCards();
    }

    /**
     * method for the increase of the <code>numberCards</code> value
     */
    private void increaseNumberCards() {
        this.numberCards++;
    }

    /**
     * remove a card from the array of the specified index
     *
     * @param index the index of the card that have to be removed
     * @return the card removed
     * @throws ArrayIndexOutOfBoundsException if the index is illegal for the array's dimension
     */
    public Card getCard(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= this.getNumberCards() || index < 0)
            throw new ArrayIndexOutOfBoundsException("illegal index for the method getCard");
        Card result = cardsInHand[index];
        this.removeCard(index);
        return result;
    }

    /**
     * method for the elimination of a card in the hand
     *
     * @param index the index of the card that have to be removed
     * @throws ArrayIndexOutOfBoundsException if the index is illegal for the array's dimension
     */
    private void removeCard(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= this.getNumberCards() || index < 0)
            throw new ArrayIndexOutOfBoundsException("illegal index for the method getCard");
        cardsInHand[index] = null;
        this.compact();
    }

    /**
     * method for the elimination of empty spaces in the hand array
     */
    private void compact() {
        for (int i = 0; i < this.getNumberCards(); i++) {
            if (this.cardsInHand[i] == null) {
                for (int j = i; j < this.getNumberCards() - 1; j++) {
                    this.cardsInHand[j] = this.cardsInHand[j + 1];
                }
            }
        }
    }


}
