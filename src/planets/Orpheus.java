package planets;

import java.util.ArrayList;
import java.util.Arrays;

import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import medical.Cure;

public class Orpheus extends Planet {
		
	/**
	 * Constructs the planet Orpheus
	 */
	public Orpheus() {
		super("Orpheus", new ArrayList<FoodItem>(), 
				new ArrayList<MedicalItem>(Arrays.asList(new Cure())), 1, 10);
	}
}
