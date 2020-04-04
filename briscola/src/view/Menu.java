package view;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Menu {
	
	/**
	 * attribute for the input scan
	 */
	private Scanner input;
	
	/**
	 * the options list
	 */
	private ArrayList<Option> options;
	
	/**
	 * the menu's description 
	 */
	private String Description;
	
	/**
	 * the menu's name
	 */
	private String name;
	
	/**
	 * default constructor
	 * @param name
	 * the name of the menu
	 * @param description
	 * the description of the menu
	 */
	public Menu(String name,String description) {
		
		this.input=new Scanner(new InputStreamReader(System.in));
		this.name=name;
		this.Description=description;
		this.options=new ArrayList<Option>();
		
	}
	
	/**
	 * method for the option insert
	 * @param option the option to insert
	 */
	public void add(Option option) {
		
		option.setIndex(this.options.size()+1);
		try {
			this.options.add((Option)option.clone());
		} catch (CloneNotSupportedException e) {}
		
	}
	
	/**
	 * method for the question of an option to the user
	 * @return 
	 * the option selected
	 */
	public Option askForOption() {
		
		int chose;
		System.out.println(this.toString());
		do {
			chose=input.nextInt();
		}while(chose-1>=this.options.size() || chose-1<0 );
		return (Option) this.options.get(chose-1);
	
	}

	/**
	 * getter for the description attribute
	 * @return 
	 * the description value
	 */
	public String getDescription() {
		return Description;
	}
	
	/**
	 * getter for the name attribute
	 * @return 
	 * the name value
	 */
	public String getName() {
		return name;
	}
	
	
	public void close() {
		this.input.close();
	}
	
	@Override
	public String toString() {
		
		StringJoiner result=new StringJoiner(System.lineSeparator());
		result.add(this.getName());
		result.add(this.getDescription());
		for(Option option : this.options)result.add(option.toString());
		return result.toString();
		
	}
	

}
