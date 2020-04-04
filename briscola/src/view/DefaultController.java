package view;

public abstract class DefaultController {
	
	/**
	 * attribute for the menu representation
	 */
	protected Menu menu;
	
	/**
	 * default constructor for the DefaultController class
	 * @param name 
	 * the menu's name
	 * @param description
	 * the menu's description
	 */
	public DefaultController(String name,String description) {
		
		this.menu=new Menu(name, description);
	
	}
	/**
	 * abstract method for the menu controller
	 */
	public abstract void start();

}
