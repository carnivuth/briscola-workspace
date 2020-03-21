package deck;

public class CardTest {
	public static void main(String[] args) {
		Card c1=Card.ASSO_BASTONI;
		Card c2, c3, c4;
		c2=Card.RE_BASTONI;
		c3=Card.TRE_DENARI;
		c4=Card.DUE_COPPE;
		String briscola="BASTONI";
		assert(c2.takes(c1, briscola)==false);
		assert(c4.takes(c1, briscola)==false);
		assert(c2.takes(c3, briscola)==true);
		assert(c4.takes(c3, briscola)==true);
		
		briscola="COPPE";
		
		assert(c1.takes(c2,  briscola)==true);
		return;
	}
}
