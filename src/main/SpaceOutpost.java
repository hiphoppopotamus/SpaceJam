package main;

import java.util.ArrayList;

import food.Apple;
import food.Banana;
import food.Burger;
import food.Chocolate;
import food.Noodles;
import food.Steak;
import medical.Cure;
import medical.LargeBandage;
import medical.SmallBandage;

public class SpaceOutpost {
	
	/**
	 * Outpost food items
	 */
	private ArrayList<FoodItem> outpostFoodItems = new ArrayList<FoodItem>();
	/**
	 * Outpost medical items
	 */
	private ArrayList<MedicalItem> outpostMedicalItems = new ArrayList<MedicalItem>(); 
	
	/**
	 * A constructor for a space outpost
	 * <br>Sets up Outpost food items and outpost medical items
	 */
	public SpaceOutpost() {
		setOutpostFoodItems();
		setOutpostMedicalItems();
	}
	
	/**
	 * Obtains a space outpost's food items
	 * @return ArrayList<FoodItem> Outpost food items
	 */
	public ArrayList<FoodItem> getOutpostFoodItems(){
		return outpostFoodItems;
	}
	
	/**
	 * Sets an outpost's food items
	 */
	public void setOutpostFoodItems() {
		outpostFoodItems.add(new Apple());
		outpostFoodItems.add(new Banana());
		outpostFoodItems.add(new Burger());
		outpostFoodItems.add(new Chocolate());
		outpostFoodItems.add(new Noodles());
		outpostFoodItems.add(new Steak());
	}
	
	/**
	 * Obtains a space outpost's medical items
	 * @return ArrayList<MedicalItem> Outpost medical items
	 */
	public ArrayList<MedicalItem> getOutpostMedicalItems(){
		return outpostMedicalItems;
	}
	
	/**
	 * Sets an outpost's medical items
	 */
    public void setOutpostMedicalItems() {
    	outpostMedicalItems.add(new SmallBandage());
    	outpostMedicalItems.add(new LargeBandage());
    	outpostMedicalItems.add(new Cure());
	}
    
}
