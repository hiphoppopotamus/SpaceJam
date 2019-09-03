package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import food.Apple;
import main.Crew;
import main.FoodItem;

class FoodItemTest {
	
	private FoodItem foodTest;
	
	
	@BeforeEach
	public void init() {
		foodTest = new FoodItem("Apple", 5.0, 5, 10);
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Apple", foodTest.getName());
	}

}
