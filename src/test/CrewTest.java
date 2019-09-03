package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.CrewMember;
import main.Spaceship;
import planets.Scorpius;
import main.FoodItem;
import main.MedicalItem;

class CrewTest {
	
	private Crew testCrew;
	
	@BeforeEach
	public void init() {
		testCrew = new Crew("Woozy");
		testCrew.setCrewCount(4);
		testCrew.setCurrentDay(3);
		testCrew.setCrewTransporterPieces(4);
		testCrew.setCurrentPlanet(new Scorpius());
	}
	
	@Test
	public void getCrewNameTest() {
		assertEquals("Woozy", testCrew.getCrewName());
	} 
	
	@Test
	public void getCrewCountTest() {
		assertEquals(4, testCrew.getCrewCount());
	}

	@Test
	public void getCurrentDayTest() {
		assertEquals(3, testCrew.getCurrentDay());
		
	} 

	@Test
	public void getCrewTransporterPiecesTest() {
		assertEquals(4, testCrew.getCrewTransporterPieces());
	} 

	@Test
	public void addCrewTransporterPiecesTest() {
		testCrew.addCrewTransporterPiece(1);
		assertEquals(5, testCrew.getCrewTransporterPieces());
	} 
	
	@Test
	public void addCrewMembersTest() {
		testCrew.addCrewMember("Micah", "Hunger Buster");
		testCrew.addCrewMember("Mila", "Terminator");
		ArrayList<CrewMember> testMembers = new ArrayList<CrewMember>();
		testMembers.add(testCrew.getCrewMembers().get(0));
		testMembers.add(testCrew.getCrewMembers().get(1));
		assertEquals(testMembers, testCrew.getCrewMembers());
	}
	
	@Test
	public void checkCrewMemberStatusTest() {
		testCrew.addCrewMember("Micah", "Hunger Buster");
		CrewMember member = testCrew.getCrewMembers().get(0);
		assertEquals(true, testCrew.checkCrewMemberStatus(member));
		member.setHealth(0);
		testCrew.setCrewMemberStatus(member);
		assertEquals(false, testCrew.checkCrewMemberStatus(member));

	}
	
	@Test
	public void setCrewMemberStatusTest() {
		testCrew.addCrewMember("Micah", "Hunger Buster");
		CrewMember member1 = testCrew.getCrewMembers().get(0);
		member1.setHunger(60);
		testCrew.setCrewMemberStatus(member1);
		assertEquals(false, member1.isAlive());
	}
	
	@Test
	public void isAllDeadTest() {
		testCrew.addCrewMember("Micah", "Hunger Buster");
		testCrew.addCrewMember("Mila", "Terminator");
		CrewMember member1 = testCrew.getCrewMembers().get(0);
		CrewMember member2 = testCrew.getCrewMembers().get(1);
		member1.setAlive(false);
		assertEquals(false, testCrew.isAllDead());
		member2.setAlive(false);
		assertEquals(true, testCrew.isAllDead());
	}

	@Test
	public void eatCrewFoodItemTest() {
		FoodItem testFood = testCrew.getCrewFoodItems().get(0);
		assertEquals("Apple", testFood.getName());
		assertEquals(5, testFood.getPrice());
		assertEquals(5, testFood.getHunger());
		assertEquals(10, testFood.getHealth());
		assertEquals("Apple", testFood.toString());
		testCrew.eatCrewFoodItem(testFood);
		assertEquals(1, testCrew.getCrewFoodItems().size());
	}
	
	@Test
	public void stealCrewFoodItemTest() {
		testCrew.stealCrewFoodItem(0);
		assertEquals(1, testCrew.getCrewFoodItems().size());
	}
	
	@Test
	public void buyOutpostFoodItems() {
		assertEquals(50.0, testCrew.getCrewFunds());
		testCrew.buyOutpostFoodItem(testCrew.getOutpostFoodItems().get(0));
		assertEquals(45.0, testCrew.getCrewFunds());
	}
	
	@Test
	public void useCrewMedicalItemTest() {
		MedicalItem testMedical = testCrew.getCrewMedicalItems().get(0);
		
		assertEquals("Small Bandage", testMedical.getName());
		assertEquals(10, testMedical.getPrice());
		assertEquals(10, testMedical.getHealth());
		assertEquals(false, testMedical.getCure());
		assertEquals("Small Bandage", testMedical.toString());
		
		testCrew.useCrewMedicalItem(testMedical);
		assertEquals(1, testCrew.getCrewMedicalItems().size());
	}
	
	@Test
	public void stealCrewMedicalItemTest() {
		testCrew.stealCrewMedicalItem(0);
		assertEquals(1, testCrew.getCrewMedicalItems().size());
	}
	
	@Test
	public void buyOutpostMedicalItems() {
		assertEquals(50.0, testCrew.getCrewFunds());
		testCrew.buyOutpostMedicalItem(testCrew.getOutpostMedicalItems().get(0));
		assertEquals(40.0, testCrew.getCrewFunds());
	}

	@Test
	public void isTerminatorPresentTest() {
		testCrew.addCrewMember("Mila", "Terminator");
		testCrew.setTerminatorPresent(true);
		assertEquals(true, testCrew.isTerminatorPresent());

	}
	
	@Test
	public void nextDayTest() {
		testCrew.nextDay();
		assertEquals(4, testCrew.getCurrentDay());
	}
	
	@Test
	public void getCurrentPlanetTest() {
		assertEquals("Scorpius", testCrew.getCurrentPlanet().getName());
	}
	
	@Test
	public void getPlanetItemsTest() {
		testCrew.addCrewMember("Mila", "Terminator");
		testCrew.getPlanetItems(testCrew.getCrewMembers().get(0));
		assertEquals(3, testCrew.getCrewFoodItems().size());
		assertEquals(3, testCrew.getCrewFoodItems().size());
	}
	
	@Test
	public void flyToPlanetTest() {
		Spaceship spaceship = new Spaceship();
		testCrew.addCrewMember("Micah", "Hunger Buster");
		testCrew.addCrewMember("Mila", "Terminator");
		CrewMember member1 = testCrew.getCrewMembers().get(0);
		CrewMember member2 = testCrew.getCrewMembers().get(1);
		testCrew.flyToPlanet(testCrew.getCurrentPlanet(), member1, member2, spaceship);
		assertEquals("Scorpius", testCrew.getCurrentPlanet().getName());
	}
	
	@Test
	public void leavePlanetTest() {
		testCrew.leavePlanet();
		assertEquals(null, testCrew.getCurrentPlanet());
	}
	
	
	
	
	
	
	
	
	
	
	
}
