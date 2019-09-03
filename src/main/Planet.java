package main;

import java.util.ArrayList;

public class Planet {
	
	/**
	 * Planet name
	 */
	private String name;
	/**
	 * Foodstuff(s) available in a planet
	 */
	private ArrayList<FoodItem> planetFoodItems = new ArrayList<FoodItem>();
	/**
	 * Medical supplies available in a planet
	 */
	private ArrayList<MedicalItem> planetMedicalItems = new ArrayList<MedicalItem>();
	/**
	 * Transporter pieces available in a planet
	 */
	private int planetTransporterPiece;
	/**
	 * Funds available in a planet
	 */
	private double money;
	/**
	 * Planet status; default is false meaning that items have not been taken by crew
	 */
	private boolean cleansed = false;
	
	/**
	 * Planet constructor
	 * <br>Constructs a planet and its attributes
	 * @param name Name of planet
	 * @param foodItems Foodstuff(s) available in planet
	 * @param medicalItems Medical supply(ies) available in planet
	 * @param planetTransporterPiece Transporter pieces available in planet
	 * @param money Money available in planet
	 */
	public Planet(String name, ArrayList<FoodItem> foodItems, ArrayList<MedicalItem> medicalItems, int planetTransporterPiece, double money) {
		this.name = name;
		this.planetFoodItems = foodItems;
		this.planetMedicalItems = medicalItems;
		this.planetTransporterPiece = planetTransporterPiece;
		this.money = money;
	}
	
	/**
	 * Obtains a planet's name
	 * @return String Planet name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Obtains the foodstuffs available in a planet
	 * @return ArrayList<FoodItem> Planet food items
	 */
	public ArrayList<FoodItem> getPlanetFoodItems() {
		return planetFoodItems;
	}
	
	/**
	 * Sets foodstuffs available in a planet,
	 * @param planetFoodItems Planet food items
	 */
	public void setFoodItems(ArrayList<FoodItem> planetFoodItems) {
		this.planetFoodItems = planetFoodItems;
	}
	
	/**
	 * Obtains a string representation of a planet's food items
	 * @return String Planet food items
	 */
	public String getPlanetFoodNames() {
		ArrayList<String> planetFoodNames = new ArrayList<String>();
		for (FoodItem foodItem: planetFoodItems) {
			planetFoodNames.add(foodItem.getName());
		}
		String foodItems = String.join(", ", planetFoodNames);
		return foodItems;
	}
	
	/**
	 * Obrains a list of a planet's medical supplies
	 * @return ArrayList<MedicalItem> Planet medical items
	 */
	public ArrayList<MedicalItem> getPlanetMedicalItems() {
		return planetMedicalItems;
	}
	
	/**
	 * Sets medical supplies available in a planet,
	 * @param planetMedicalItems Planet medical items
	 */
	public void setMedicalItems(ArrayList<MedicalItem> planetMedicalItems) {
		this.planetMedicalItems = planetMedicalItems;
	}
	
	/**
	 * Obtains a string representation of a planet's medical items
	 * @return String Planet medical items
	 */
	public String getPlanetMedicalNames() {
		ArrayList<String> planetMedicalNames = new ArrayList<String>();
		for (MedicalItem medicalItem: planetMedicalItems) {
			planetMedicalNames.add(medicalItem.getName());
		}
		String medicalItems = String.join(", ", planetMedicalNames);
		return medicalItems;
	}
	
	/**
	 * Obtains a transporter piece that a planet has
	 * <br>Note that a planet can only have 1 transporter piece
	 * @return int Planet transporter piece
	 */
	public int getTransporterPiece() {
		return planetTransporterPiece;
	}
	
	/**
	 * Sets the amount of transporter piece a planet has
	 * @param planetTransporterPiece Planet transporter piece
	 */
	public void setTransporterPiece(int planetTransporterPiece) {
		this.planetTransporterPiece = planetTransporterPiece;
	}
		 
	/**
	 * Obtains the amount of money that a planet has
	 * @return double Planet money
	 */
	public double getMoney() {
		return money;
	}	
	
	/**
	 * Sets the amount of money that planet has
	 * @param money Planet money
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	
	/** 
	 * Checks if a crew member has obtained a planet's items
	 * <br>Returns a boolean true if planet has been 'cleansed otherwise returns false
	 * @return boolean Cleansed
	 */
	public boolean isCleansed() {
		return cleansed;
	}

	/**
	 * Sets up a boolean cleansed if a planet has or has not been cleansed
	 * @param cleansed Cleansed
	 */
	public void setCleansed(boolean cleansed) {
		this.cleansed = cleansed;
	}
}
