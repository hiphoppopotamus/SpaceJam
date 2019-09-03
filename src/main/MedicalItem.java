package main;


public class MedicalItem {
	
	/**
	 * Medical supply name
	 */
	private String name;
	/**
	 * Medical supply price
	 */
	private double price;
	/**
	 * Medical supply health level
	 */
	private double health;
	/**
	 * Medical supply cure ability (true if cures the space plague)
	 */
	private boolean cure;
	
	/**
	 * Constructs a medical item taking several parameters and setting 
	 * <br>the name, price, health, and cure variables
	 * @param name Medical item name
	 * @param price Medical item price
	 * @param health Medical item health level
	 * @param cure Medical item cure ability – true for "Cure"
	 */
	public MedicalItem(String name, double price, double health, boolean cure) {
		this.name = name;
		this.price = price;
		this.health = health;
		this.cure = cure;
	}
	
	/**
	 * Obtains a medical supply's name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Obtains a medical supply's price
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Obtains a medical supply's health level
	 * @return
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Returns true if medical supply cures the space plague
	 * @return
	 */
	public boolean getCure() {
		return cure;
	}
	
	/**
	 * Returns string representation of medical supply; name
	 */
	@Override
	public String toString() {
		return name;
	}
}