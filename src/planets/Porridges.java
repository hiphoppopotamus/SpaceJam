package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Chocolate;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;

public class Porridges extends Planet {
		
	/**
	 * Constructs the planet Morpheus
	 */
	public Porridges() {
		super("Porridges", new ArrayList<FoodItem>(Arrays.asList(new Chocolate())), 
				new ArrayList<MedicalItem>(), 1, 10);
	}
}
