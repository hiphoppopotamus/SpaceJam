package planets;

import java.util.ArrayList;
import java.util.Arrays;

import food.Noodles;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import medical.SmallBandage;

public class Scorpius extends Planet {
	
	/**
	 * Constructs the planet Scorpius
	 */
	public Scorpius() {
		super("Scorpius", new ArrayList<FoodItem>(Arrays.asList(new Noodles())), 
				new ArrayList<MedicalItem>(Arrays.asList(new SmallBandage())), 0, 10);
	}
}


