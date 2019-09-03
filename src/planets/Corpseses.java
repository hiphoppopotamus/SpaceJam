package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Apple;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;

public class Corpseses extends Planet {
		
	/**
	 * Constructs the planet Corpseses
	 */
	public Corpseses() {
		super("Corpseses", new ArrayList<FoodItem>(Arrays.asList(new Apple())), 
				new ArrayList<MedicalItem>(), 0, 10);
	}
}
