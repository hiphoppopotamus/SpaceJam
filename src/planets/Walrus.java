package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Steak;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;

public class Walrus extends Planet {
		
	/**
	 * Constructs the planet Walrus
	 */
	public Walrus() {
		super("Walrus", new ArrayList<FoodItem>(Arrays.asList(new Steak())), 
				new ArrayList<MedicalItem>(), 0, 0);
	}
}
