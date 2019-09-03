package main;


public class FoodItem {
	
	/**
	 * Foodstuff name
	 */
	private String name;
	/**
	 * Foodstuff price
	 */
	private double price;
	/**
	 * Foodstuff hunger level
	 */
	private double hunger;
	/**
	 * Foodstuff health level
	 */
	private double health;
	
	/**
	 * Constructs a food item taking several parameters and setting 
	 * <br>the name, price, hunger, and health variables
	 * @param name Food item name
	 * @param price Food item price
	 * @param hunger Food item hunger level
	 * @param health Food item health level
	 */
	public FoodItem(String name, double price, double hunger, double health) {
		this.name = name;
		this.price = price;
		this.hunger = hunger;
		this.health = health;
	}
	
	/**
	 * Obtains foodstuff name
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Obtains foodstuff price
	 * @return double price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Obtains foodstuff hunger level
	 * @return double Hunger level
	 */
	public double getHunger() {
		return hunger;
	}
	
	/**
	 * Obtains foodstuff health level
	 * @return double Health level
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Returns string representation of foodstuff; name
	 */
	@Override
	public String toString() {
		return name;
	}
}
