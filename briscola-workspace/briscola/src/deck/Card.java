package deck;

public enum Card {
	ASSO_SPADI("ASSO","SPADI",10,11), 										 
	DUE_SPADI("DUE","SPADI",1,0),
	TRE_SPADI("TRE","SPADI",9,10),
	QUATTRO_SPADI("QUATTRO","SPADI",2,0),
	CINQUE_SPADI("CINQUE","SPADI",3,0),
	SEI_SPADI("SEI","SPADI",4,0),
	SETTE_SPADI("SETTE","SPADI",5,0),
	FANTE_SPADI("FANTE","SPADI",6,2), 
	CAVALLO_SPADI("CAVALLO","SPADI",7,3),
	RE_SPADI("RE","SPADI",8,4),
	
	ASSO_BASTONI("ASSO","BASTONI",10,11), 										 
	DUE_BASTONI("DUE","BASTONI",1,0),
	TRE_BASTONI("TRE","BASTONI",9,10),
	QUATTRO_BASTONI("QUATTRO","BASTONI",2,0),
	CINQUE_BASTONI("CINQUE","BASTONI",3,0),
	SEI_BASTONI("SEI","BASTONI",4,0),
	SETTE_BASTONI("SETTE","BASTONI",5,0),
	FANTE_BASTONI("FANTE","BASTONI",6,2), 
	CAVALLO_BASTONI("CAVALLO","BASTONI",7,3),
	RE_BASTONI("RE","BASTONI",8,4),
	
	ASSO_DENARI("ASSO","DENARI",10,11), 										 
	DUE_DENARI("DUE","DENARI",1,0),
	TRE_DENARI("TRE","DENARI",9,10),
	QUATTRO_DENARI("QUATTRO","DENARI",2,0),
	CINQUE_DENARI("CINQUE","DENARI",3,0),
	SEI_DENARI("SEI","DENARI",4,0),
	SETTE_DENARI("SETTE","DENARI",5,0),
	FANTE_DENARI("FANTE","DENARI",6,2), 
	CAVALLO_DENARI("CAVALLO","DENARI",7,3),
	RE_DENARI("RE","DENARI",8,4),
	
	ASSO_COPPE("ASSO","COPPE",10,11), 										 
	DUE_COPPE("DUE","COPPE",1,0),
	TRE_COPPE("TRE","COPPE",9,10),
	QUATTRO_COPPE("QUATTRO","COPPE",2,0),
	CINQUE_COPPE("CINQUE","COPPE",3,0),
	SEI_COPPE("SEI","COPPE",4,0),
	SETTE_COPPE("SETTE","COPPE",5,0),
	FANTE_COPPE("FANTE","COPPE",6,2), 
	CAVALLO_COPPE("CAVALLO","COPPE",7,3),
	RE_COPPE("RE","COPPE",8,4);
	
	private String figure;
	private String seed;
	private int value;
	private int points;
	private Card(String figure,String seed,int value,int points) {
		this.figure=figure;
		this.seed=seed;
		this.value=value;
		this.points=points;
	}
	public int getPoints() {
		return points;
	}
	public int getValue() {
		return value;
	}
	public String getSeed() {
		return seed;
	}
	public String getFigure() {
		return figure;
	}
	public boolean takes(Card card,String BriscolaSeed) {
		return true;
	}
	
}
