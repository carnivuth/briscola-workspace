package view;

public class Option implements Cloneable{
	
	/**
	 * default constructor for the Option class
	 * @param name the name of the option
	 */
	public Option(String name) {
		
		this.name = name;
	}

	/**
	 * the attribute for the option name
	 */
	private String name;
	
	/**
	 * the attribute for the integer value of the option
	 */
	private int index;

	/**
	 * getter method for the index attribute
	 * @return
	 * the index value
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * setter method for the index attribute
	 * @param index
	 * the index value
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * getter method for the name attribute
	 * @return
	 * the name value
	 */
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getIndex()+") "+this.getName();
	}
	
	

}
