package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Burger;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;

public class Morpheus extends Planet {
		
	/**
	 * Constructs the planet Morpheus
	 */
	public Morpheus() {
		super("Morpheus", new ArrayList<FoodItem>(Arrays.asList(new Burger())), 
				new ArrayList<MedicalItem>(), 1, 10);
	}
}
