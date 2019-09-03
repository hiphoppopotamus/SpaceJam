package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Banana;
import food.Steak;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import medical.Cure;
import medical.LargeBandage;

public class Seashorpheus extends Planet {
	
	/**
	 * Constructs the planet Seashorpheus
	 */
	public Seashorpheus() {
		super("Seashorpheus", new ArrayList<FoodItem>(Arrays.asList(new Steak(), new Banana())), 
				new ArrayList<MedicalItem>(Arrays.asList(new Cure(), new LargeBandage())), 1, 50);
	}
}

