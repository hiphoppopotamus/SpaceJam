package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Banana;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import medical.SmallBandage;

public class Dorpheus extends Planet {
		
	/**
	 * Constructs the planet Dorpheus
	 */
	public Dorpheus() {
		super("Dorpheus", new ArrayList<FoodItem>(Arrays.asList(new Banana())), 
				new ArrayList<MedicalItem>(Arrays.asList(new SmallBandage())), 0, 2);
	}
}
