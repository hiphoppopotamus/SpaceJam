package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import food.Apple;
import main.Crew;
import medical.Cure;
import medical.LargeBandage;
import planets.Scorpius;

class CrewMemberTest {

	private Crew testCrew;
	
	@BeforeEach
	public void init() {
		testCrew = new Crew("Garmonbozia");
		testCrew.addCrewMember("Alicia", "Superhuman");
		testCrew.addCrewMember("Jill", "Hunger Buster");
		testCrew.setCrewCount(6);
		testCrew.setCurrentDay(2);
		testCrew.setCrewTransporterPieces(4);
		testCrew.setCurrentPlanet(new Scorpius());
	}
	
	@Test
	public void setCrewMemberTest() {
		testCrew.addCrewMember("Donald", "Fresher");
		testCrew.addCrewMember("Kawhi", "Builder");
		testCrew.addCrewMember("Jericho", "Immune");
		testCrew.addCrewMember("Jamilah", "Terminator");
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Alicia", testCrew.getCrewMembers().get(0).getName());
	}
	
	@Test
	public void getTypeTest() {
		assertEquals("Superhuman", testCrew.getCrewMembers().get(0).getType());

	}
	
	@Test
	public void getActionsTest() {
		assertEquals(0, testCrew.getCrewMembers().get(0).getActions());
	}
	
	@Test
	public void setActionsTest() {
		testCrew.getCrewMembers().get(0).setActions(1);
		assertEquals(1, testCrew.getCrewMembers().get(0).getActions());
	}
	
	@Test
	public void getHealthTest() {
		assertEquals(120, testCrew.getCrewMembers().get(0).getHealth());	
	}	
	
	@Test
	public void setHealthRateTest() {
		testCrew.getCrewMembers().get(0).setHealth(20);
		assertEquals(20, testCrew.getCrewMembers().get(0).getHealth());	
	}	
	
	@Test
	public void getHealthRateTest() {
		assertEquals(8, testCrew.getCrewMembers().get(0).getHealthRate());	
	}	

	@Test
	public void getHungerTest() {
		assertEquals(0, testCrew.getCrewMembers().get(0).getHunger());	
	}
	
	@Test
	public void setHungerTest() {
		testCrew.getCrewMembers().get(0).setHunger(10);
		assertEquals(10, testCrew.getCrewMembers().get(0).getHunger());	
	}
	
	@Test
	public void getHungerRateTest() {
		assertEquals(8, testCrew.getCrewMembers().get(0).getHungerRate());	
	}

	@Test
	public void getTirednessTest() {
		assertEquals(0, testCrew.getCrewMembers().get(0).getTiredness());	
	}
	
	@Test
	public void setTirednessTest() {
		testCrew.getCrewMembers().get(0).setTiredness(20);
		assertEquals(20, testCrew.getCrewMembers().get(0).getTiredness());	
	}
	
	@Test
	public void getTirednessRateTest() {
		assertEquals(8, testCrew.getCrewMembers().get(0).getTirednessRate());	
	}
		
	@Test
	public void getStatusTest() {
		assertEquals(true, testCrew.getCrewMembers().get(0).isAlive());
		assertEquals("Alive", testCrew.getCrewMembers().get(0).getStatus());
		testCrew.getCrewMembers().get(0).setAlive(false);
		assertEquals("Dead", testCrew.getCrewMembers().get(0).getStatus());
	}
	
	@Test
	public void infectCrewMemberTest() {
		testCrew.getCrewMembers().get(0).infectCrewMember();
		assertEquals(10, testCrew.getCrewMembers().get(0).getHealthRate());
		assertEquals(true, testCrew.getCrewMembers().get(0).isInfected());
	}
	
	@Test
	public void eatFoodItemTest() {
		testCrew.getCrewMembers().get(0).eatFoodItem(new Apple());
		assertEquals("Apple", testCrew.getCrewFoodItems().get(0).getName());
		assertEquals(120, testCrew.getCrewMembers().get(0).getHealth());
		assertEquals("Superhuman", testCrew.getCrewMembers().get(0).getType());
		testCrew.getCrewMembers().get(1).eatFoodItem(new Apple());
		assertEquals(100, testCrew.getCrewMembers().get(1).getHealth());
	}

	@Test
	public void useMedicalItemTest() {
		testCrew.getCrewMembers().get(0).useMedicalItem(new Cure());
		assertEquals(120, testCrew.getCrewMembers().get(0).getHealth());
		testCrew.getCrewMembers().get(0).useMedicalItem(new LargeBandage());
		assertEquals(120, testCrew.getCrewMembers().get(0).getHealth());
		testCrew.getCrewMembers().get(1).useMedicalItem(new LargeBandage());
		assertEquals(100, testCrew.getCrewMembers().get(1).getHealth());
	}

	@Test
	public void goToSleepTest() {
		testCrew.getCrewMembers().get(0).goToSleep();
		assertEquals(2, testCrew.getCrewMembers().get(0).getActions());
		testCrew.getCrewMembers().get(0).goToSleep();		
	}
	
	@Test
	public void setRepairRateTest() {
		assertEquals(5, testCrew.getCrewMembers().get(0).getRepairRate());	
		testCrew.getCrewMembers().get(0).repairSpaceship();
		assertEquals(1, testCrew.getCrewMembers().get(0).getActions());
		testCrew.getCrewMembers().get(0).setActions(2);
		assertEquals(false, testCrew.getCrewMembers().get(0).repairSpaceship());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Alicia", testCrew.getCrewMembers().get(0).toString());
	}
	
}
