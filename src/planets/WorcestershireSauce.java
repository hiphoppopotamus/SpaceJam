package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Noodles;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import medical.Cure;

public class WorcestershireSauce extends Planet {
	
	/**
	 * Constructs the planet WorcestershireSauce
	 */	
	public WorcestershireSauce() {
		super("Worcestershire Sauce", new ArrayList<FoodItem>(Arrays.asList(new Noodles())), 
				new ArrayList<MedicalItem>(Arrays.asList(new Cure())), 1, 5);
	}
}
