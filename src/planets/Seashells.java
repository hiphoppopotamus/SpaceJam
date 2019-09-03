package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Chocolate;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;

public class Seashells extends Planet {
		
	/**
	 * Constructs the planet Seashells
	 */
	public Seashells() {
		super("Seashells", new ArrayList<FoodItem>(Arrays.asList(new Chocolate())), 
				new ArrayList<MedicalItem>(), 0, 0);
	}
}
