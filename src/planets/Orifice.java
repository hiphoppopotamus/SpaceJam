package planets;

import java.util.ArrayList;
import java.util.Arrays;

import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import medical.LargeBandage;

public class Orifice extends Planet {
		
	/**
	 * Constructs the planet Orifice
	 */
	public Orifice() {
		super("Orifice", new ArrayList<FoodItem>(), 
				new ArrayList<MedicalItem>(Arrays.asList(new LargeBandage())), 1, 20);
	}
}
