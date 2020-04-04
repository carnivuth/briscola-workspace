package deck;

/**
 * @author Longhi Matteo
 * @author Mirko Legnini
 * enumeration for the card representation
 */
public enum Card {
    /**
     * creation of the <code>Card</code> values
     */
    ASSO_SPADI("ASSO", "SPADI", 10, 11),
    DUE_SPADI("DUE", "SPADI", 1, 0),
    TRE_SPADI("TRE", "SPADI", 9, 10),
    QUATTRO_SPADI("QUATTRO", "SPADI", 2, 0),
    CINQUE_SPADI("CINQUE", "SPADI", 3, 0),
    SEI_SPADI("SEI", "SPADI", 4, 0),
    SETTE_SPADI("SETTE", "SPADI", 5, 0),
    FANTE_SPADI("FANTE", "SPADI", 6, 2),
    CAVALLO_SPADI("CAVALLO", "SPADI", 7, 3),
    RE_SPADI("RE", "SPADI", 8, 4),

    ASSO_BASTONI("ASSO", "BASTONI", 10, 11),
    DUE_BASTONI("DUE", "BASTONI", 1, 0),
    TRE_BASTONI("TRE", "BASTONI", 9, 10),
    QUATTRO_BASTONI("QUATTRO", "BASTONI", 2, 0),
    CINQUE_BASTONI("CINQUE", "BASTONI", 3, 0),
    SEI_BASTONI("SEI", "BASTONI", 4, 0),
    SETTE_BASTONI("SETTE", "BASTONI", 5, 0),
    FANTE_BASTONI("FANTE", "BASTONI", 6, 2),
    CAVALLO_BASTONI("CAVALLO", "BASTONI", 7, 3),
    RE_BASTONI("RE", "BASTONI", 8, 4),

    ASSO_DENARI("ASSO", "DENARI", 10, 11),
    DUE_DENARI("DUE", "DENARI", 1, 0),
    TRE_DENARI("TRE", "DENARI", 9, 10),
    QUATTRO_DENARI("QUATTRO", "DENARI", 2, 0),
    CINQUE_DENARI("CINQUE", "DENARI", 3, 0),
    SEI_DENARI("SEI", "DENARI", 4, 0),
    SETTE_DENARI("SETTE", "DENARI", 5, 0),
    FANTE_DENARI("FANTE", "DENARI", 6, 2),
    CAVALLO_DENARI("CAVALLO", "DENARI", 7, 3),
    RE_DENARI("RE", "DENARI", 8, 4),

    ASSO_COPPE("ASSO", "COPPE", 10, 11),
    DUE_COPPE("DUE", "COPPE", 1, 0),
    TRE_COPPE("TRE", "COPPE", 9, 10),
    QUATTRO_COPPE("QUATTRO", "COPPE", 2, 0),
    CINQUE_COPPE("CINQUE", "COPPE", 3, 0),
    SEI_COPPE("SEI", "COPPE", 4, 0),
    SETTE_COPPE("SETTE", "COPPE", 5, 0),
    FANTE_COPPE("FANTE", "COPPE", 6, 2),
    CAVALLO_COPPE("CAVALLO", "COPPE", 7, 3),
    RE_COPPE("RE", "COPPE", 8, 4);
    /**
     * attribute for the card figure representation
     */
    private String figure;
    /**
     * attribute for the card seed representation
     */
    private String seed;
    /**
     * attribute for the card value representation in the briscola card's hierarchy
     */
    private int value;
    /**
     * attribute for the card point representation in the briscola card's hierarchy
     */
    private int points;

    /*
     *
     * main constructor for the card enumeration
     * @param figure
     * the figure of the card
     * @param seed
     * the seed of the card
     * @param value
     * the card value in the briscola card's hierarchy
     * @param points
     * the card point in the briscola card's hierarchy
     *
     */
    private Card(String figure, String seed, int value, int points) {
        this.figure = figure;
        this.seed = seed;
        this.value = value;
        this.points = points;
    }

    /**
     * getter for points attribute
     *
     * @return the points of the card
     */
    public int getPoints() {
        return points;
    }

    /**
     * getter for value attribute
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * getter for seed attribute
     *
     * @return the seed of the card
     */
    public String getSeed() {
        return seed;
    }

    /**
     * getter for figure attribute
     *
     * @return the figure of the card
     */
    public String getFigure() {
        return figure;
    }

    /**
     * @param that the card to compare to
     * @return the difference between the card value
     */
    public int compareValue(Card that) {
        return this.value - that.value;
    }

    /**
     * swap method
     *
     * @param a the first card to swap
     * @param b the second card to swap
     */
    public static void swap(Card a, Card b) {
        Card c;
        c = a;
        a = b;
        b = c;
    }

    /**
     * method for the comparison of two card in one hand
     *
     * @param card         the card of the second player
     * @param BriscolaSeed the briscola seed
     * @return the winner card of the hand, true for the first card, false otherwise
     */
    public boolean takes(Card card, String BriscolaSeed) {
        if (card.getSeed().contentEquals(BriscolaSeed) && !this.getSeed().contentEquals(BriscolaSeed))
            return false;
		return !this.getSeed().contentEquals(card.getSeed()) || this.compareValue(card) >= 0;
	}

    /**
     * equals method for the <code>card</code> comparison
     *
     * @param card the target <code>card</code> for the comparison
     * @return the result of the comparison true if the two cards are equals false instead
     */
    public boolean equals(Card card) {
        if (!(this.getFigure().equals(card.getFigure()))) return false;

        if (this.getPoints() != card.getPoints()) return false;
        if (this.getValue() != card.getValue()) return false;
        return this.getSeed().equals(card.getSeed());
    }

}
