package main;

import java.util.ArrayList;

import planets.*;
import screens.*;

public class GameEnvironment {
	
	private Crew crew;
	private Spaceship spaceship = new Spaceship();
	private int numberOfDays;
	private int numberOfPieces;
	private int planetCounter = 0;
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	
	/**
	 * Calls the Crew constructor through the Crew class
	 * @param crewName Name of crew
	 */
	public void setCrew(String crewName) {
		Crew crew = new Crew(crewName);
		this.crew = crew;
	}
	
	/**
	 * Obtains the name of the crew through the crew class
	 * @return String Name of crew
	 */
	public String getCrewName() {
		return crew.getCrewName();
	}
	
	/**
	 * Obtains the number of crew members through the Crew class
	 * @return int Number of crew members
	 */
	public int getCrewCount() {
		return crew.getCrewCount();
	}
	
	/** 
	 * Sets the number of crew members through the Crew class
	 * @param crewCount Amount of crew members
	 */
	public void setCrewCount(int crewCount) {
		crew.setCrewCount(crewCount);
	}
	
	/**
	 * Obtains the number of days player is playing for
	 * @return int Number of days
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	
	/**
	 * Sets the number of days player is playing for
	 * @param int Number of days
	 */
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	/**
	 * Obtains the number of transporter pieces needed to win the game
	 * @return int Number of pieces
	 */
	public int getNumberOfPieces() {
		return numberOfPieces;
	}	
	
	/**
	 * Sets the amount of transporter pieces needed to win the game
	 * scaled by the number of days
	 */
	public void setNumberOfPieces() {
		numberOfPieces = numberOfDays * 2/3;
	}

	/**
	 * Obtains the amount of transporter pieces that a player had found through the Crew class
	 * @return int Transporter pieces of a crew
	 */
	public int getCrewTransporterPieces() {
		return crew.getCrewTransporterPieces();
	}	
	
	/**
	 * Sets the amount of transporter pieces a player had found
	 * <br>Only called before and after leaving the planet Scorpius through the Crew class
	 * @param int Transporter pieces of a crew
	 */
	public void setCrewTransporterPieces(int crewTransporterPiece) {
		crew.setCrewTransporterPieces(crewTransporterPiece);
	}
	
	/**
	 * Sets the amount of transporter pieces a player owns as full (only in the beginning)
	 */
	public void setPrologueCrewTransporterPieces() {
		setCrewTransporterPieces(getNumberOfPieces());
	}
	
	/**
	 * Obtains the index of the current planet from the list of planets
	 * @return int Planet counter 
	 */
	public int getPlanetCounter() {
		return planetCounter;
	}

//	/**
//	 * 
//	 * @param planetCounter
//	 */
//	public void setPlanetCounter(int planetCounter) {
//		this.planetCounter = planetCounter;
//	}
	
	/**
	 * Obtains an ArrayList of planets to traverse to
	 * @return ArrayList<Planet> Planets
	 */
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	/**
	 * Sets up the planets for the spaceship to traverse to
	 */
	public void setPlanets() {
		planets.add(new Scorpius());
		planets.add(new Morpheus());
		planets.add(new Dorpheus());
		planets.add(new Orpheus());
		planets.add(new Walrus());
		planets.add(new Orifice());
		planets.add(new Porridges());
		planets.add(new Corpseses());
		planets.add(new WorcestershireSauce());
		planets.add(new Seashells());
		planets.add(new Seashorpheus());
	}

	/**
	 * Obtains the current day
	 * @return int Current day
	 */
	public int getCurrentDay() {
		return crew.getCurrentDay();
	}

	/**
	 * Obtains the current spaceship of type Spaceship
	 * @return Spaceship spaceship
	 */
	public Spaceship getSpaceship() {
		return spaceship;
	}
	
	/**
	 * Obtains the spaceship's name
	 * @return String Name of spaceship
	 */
	public String getSpaceshipName() {
		return spaceship.getSpaceshipName();
	}
	
	/**
	 * Sets the spaceship name
	 * @param spaceshipName Name of spaceship
	 */
	public void setSpaceshipName(String spaceshipName) {
		spaceship.setSpaceshipName(spaceshipName);
	}
	
	/**
	 * Obtains an int indicating the spaceship's health.
	 * @return
	 */
	public double getSpaceshipHealth() {
		return spaceship.getSpaceshipHealth();
	}
	
	/**
	 * Takes a crew member of type CrewMember and repairs a spaceship
	 * <br>If the crew member's actions are not maxed
	 * @param crewMember Crew member
	 */
	public void repairSpaceship(CrewMember crewMember) {
		if (crewMember.repairSpaceship() == true) {
    		spaceship.repairSpaceship(crewMember);
    	}
	}
	
	/**
	 * Checks if spaceship has blown up through the spaceship class
	 * <br>If spaceship has exploded, return true
	 * <br>Otherwise return false
	 * @return boolean Spaceship explodes
	 */
	public boolean isExploded() {
		return spaceship.isExploded();
	}
	
	/**
	 * Obtains a list of crew members through the Crew class.
	 * @return ArrayList<CrewMember> Crew members.
	 */
	public ArrayList<CrewMember> getCrewMembers() {
		return crew.getCrewMembers();
	}
	
	/**
	 * Adds a crew member to the list of crew members through the Crew class.
	 * @param name Name of crew member.
	 * @param type Type of crew member.
	 */
	public void addCrewMember(String name, String type) {
		crew.addCrewMember(name, type);
	}
	
	/**
	 * Obtains an list of dead crew members through the crew class
	 * @return ArrayList<CrewMember> Dead members
	 */
	public ArrayList<CrewMember> getDeadMembers() {
		return crew.getDeadMembers();
	}

	/**
	 * Adds a member to the dead members list
	 * @param crewMember Dead crew member
	 */
	public void addDeadMember(CrewMember crewMember) {
		crew.addDeadMember(crewMember);
	}
	
	/**
	 * Obtains an list of unhealthy crew members through the crew class
	 * @return ArrayList<CrewMember> Unhealthy members
	 */
	public ArrayList<CrewMember> getUnhealthyMembers() {
		return crew.getUnhealthyMembers();
	}
	
	/**
	 * Adds a member to the unhealthy members list
	 * <br>Members are unhealthy when health <= 30%
	 * @param crewMember Unhealthy crew member
	 */
	public void addUnhealthyMember(CrewMember crewMember) {
		crew.addUnhealthyMember(crewMember);
	}
	
	/**
	 * Removes a member from the unhealthy members list
	 * <br>Members are removed when health > 30%
	 * @param crewMember Unhealthy crew member
	 */
	public void removeUnhealthyMember(CrewMember crewMember) {
		crew.removeUnhealthyMember(crewMember);
	}
	
	/**
	 * Obtains an list of hungry crew members through the crew class
	 * @return ArrayList<CrewMember> Hungry members
	 */
	public ArrayList<CrewMember> getHungryMembers() {
		return crew.getHungryMembers();
	}

	/**
	 * Adds a member to the hungry members list
	 * <br>Members are hungry when hunger >= 25%
	 * @param crewMember hungry crew member
	 */
	public void addHungryMember(CrewMember crewMember) {
		crew.addHungryMember(crewMember);
	}
	
	/**
	 * Removes a member from the hungry members list
	 * <br>Members are removed when hunger < 25%
	 * @param crewMember hungry crew member
	 */
	public void removeHungryMember(CrewMember crewMember) {
		crew.removeHungryMember(crewMember);
	}
	
	/**
	 * Obtains an list of tired crew members through the crew class
	 * @return ArrayList<CrewMember> Tired members
	 */
	public ArrayList<CrewMember> getTiredMembers() {
		return crew.getTiredMembers();
	}

	/**
	 * Adds a member to the tired members list
	 * <br>Members are tired when tiredness >= 25%
	 * @param crewMember tired crew member
	 */
	public void addTiredMember(CrewMember crewMember) {
		crew.addTiredMember(crewMember);
	}
	
	/**
	 * Removes a member from the tired members list
	 * <br>Members are removed when tiredness >= 25%
	 * @param crewMember tired crew member
	 */
	public void removeTiredMember(CrewMember crewMember) {
		crew.removeTiredMember(crewMember);
	}
	
	/**
	 * Obtains an list of infected crew members through the crew class
	 * @return ArrayList<CrewMember> Infected members
	 */
	public ArrayList<CrewMember> getInfectedMembers() {
		return crew.getInfectedMembers();
	}

	/**
	 * Adds a member to the infected members list
	 * <br>Members are tired when infected = true
	 * @param crewMember infected crew member
	 */
	public void addInfectedMember(CrewMember crewMember) {
		crew.addInfectedMember(crewMember);
	}

	/**
	 * Removes a member from the infected members list
	 * <br>Members are removed when infected = false
	 * @param crewMember infected crew member
	 */
	public void removeInfectedMember(CrewMember crewMember) {
		crew.removeInfectedMember(crewMember);
	}
	

	// check for in window if dead cant do nothin
	/**
	 * Obtains a crew member's status, returns true if alive, otherwise returns false
	 * @param crewMember 
	 * @return boolean Crew Member's status
	 */
	public boolean checkCrewMemberStatus(CrewMember crewMember) {
		return crew.checkCrewMemberStatus(crewMember);
	}
	
	/**
	 * Obtains a boolean indicating a crew's status
	 * <br>Returns true of they are all dead, otherwise returns false
	 * @return boolean Crew's status
	 */
	public boolean isAllDead() {
		return crew.isAllDead();
	}
	
	
	public double getCrewFunds() {
		return crew.getCrewFunds();
	}
	
	public ArrayList<FoodItem> getCrewFoodItems() {
		return crew.getCrewFoodItems();
	}
	
	/**
	 * Obtains an ArrayList of food items available in outpost
	 * @return ArrayList<FoodItem> Outpost food items
	 */
	public ArrayList<FoodItem> getOutpostFoodItems() {
		return crew.getOutpostFoodItems();
	}
	
	/**
	 * Purchases a food item from outpost
	 * @param foodItem Foodstuff
	 */
	public void buyOutpostFoodItem(FoodItem foodItem) {
		crew.buyOutpostFoodItem(foodItem);
	}
	
	public ArrayList<MedicalItem> getCrewMedicalItems() {
		return crew.getCrewMedicalItems();
	}
	
	public ArrayList<MedicalItem> getOutpostMedicalItems() {
		return crew.getOutpostMedicalItems();
	}
	
	public void buyOutpostMedicalItem(MedicalItem medicalItem) {
		crew.buyOutpostMedicalItem(medicalItem);
	}
	
	/**
	 * Sets day to next day
	 */
	public void nextDay() {
	crew.nextDay();
	}
	
	public boolean isAlien() {
		return crew.isAlien();
	}
	
	public void setAlien(boolean isAlien) {
		crew.setAlien(isAlien);
	}
	
	public boolean isTerminatorPresent() {
		return crew.isTerminatorPresent();
	}

	public void setTerminatorPresent(boolean terminatorPresent) {
		crew.setTerminatorPresent(terminatorPresent);
	}
	
	public CrewMember getTerminator() {
		return crew.getTerminator();
	}
	
	public void setTerminator(CrewMember crewMember) {
		crew.setTerminator(crewMember);
	}
	
	public FoodItem getStolenFoodItem() {
		return crew.getStolenFoodItem();
	}

	public void setStolenFoodItem(FoodItem stolenFoodItem) {
		crew.setStolenFoodItem(stolenFoodItem);;
	}

	public MedicalItem getStolenMedicalItem() {
		return crew.getStolenMedicalItem();
	}

	public void setStolenMedicalItem(MedicalItem stolenMedicalItem) {
		crew.setStolenMedicalItem(stolenMedicalItem);
	}
	
	
	// PAGE 4 actions
	
	/**
	 * Feeds crew member if actions are not maxed
	 * @param crewMember Crew member
	 * @param foodItem Foodstuff
	 */
	public void feedCrewMember(CrewMember crewMember, FoodItem foodItem) {
		if (crewMember.getActions() < 2) {
			crew.eatCrewFoodItem(foodItem);
			crewMember.eatFoodItem(foodItem);
		}
	}
	
	/**
	 * Heals a crea member if actions are not maxed
	 * @param crewMember
	 * @param medicalItem
	 */
	public void healCrewMember(CrewMember crewMember, MedicalItem medicalItem) {
		if (crewMember.getActions() < 2) {
			crew.useCrewMedicalItem(medicalItem);
			crewMember.useMedicalItem(medicalItem);
		}
	}
	
	/**
	 * Called when crew member goes to sleep
	 * @param crewMember
	 */
	public void sleep(CrewMember crewMember) {
		crewMember.goToSleep();
	}
	
	/**
	 * Called when setting up start planet: Planet Scorpius
	 */
	public void setStartPlanet() {
		crew.setCurrentPlanet(new Scorpius());
	}
	
	/**
	 * Obtains current planet crew is on
	 * @return Planet Current planet
	 */
	public Planet getCurrentPlanet() {
		return crew.getCurrentPlanet();
	}
		
	/**
	 * Obtains a string representation of foodstuffs available on a planet
	 * <br>Uses the toString() method in FoodItem class
	 * @return String Planet food names
	 */
	public String getPlanetFoodNames() {
		return crew.getCurrentPlanet().getPlanetFoodNames();
	}

	/**
	 * Obtains a string representation of medical supplies available on a planet
	 * <br>Uses the toString() method in MedicalItem class
	 * @return String Planet medical names
	 */
	public String getPlanetMedicalNames() {
		return crew.getCurrentPlanet().getPlanetMedicalNames();
	}
	
	/**
	 * Called when ransacking a planet, takes a crew member
	 * @param crewMember Crew member
	 */
	public void getPlanetItems(CrewMember crewMember) {
		crew.getPlanetItems(crewMember);
	}
	
	/**
	 * Called to travel to another planet
	 * @param planet Planet
	 * @param crewMember1 Crew member pilot 1
	 * @param crewMember2 Crew member pilot 2
	 * @param spaceship Spaceship
	 */
	public void flyToPlanet(Planet planet, CrewMember crewMember1, CrewMember crewMember2, Spaceship spaceship) {
		crew.flyToPlanet(planet, crewMember1, crewMember2, spaceship);
	}
	
	/**
	 * Obtains the status of asteroid collision
	 * @return boolean Asteroid presence
	 */
	public boolean isAsteroid() {
		return spaceship.isAsteroid();
	}

	/**
	 * Sets the status of asteroid collision with a boolean
	 * @param isAsteroid Asteroid presence
	 */
	public void setAsteroid(boolean isAsteroid) {
		spaceship.setAsteroid(isAsteroid);
	}
	
	/**
	 * Leaves a planet and increments the planet counter
	 */
	public void leavePlanet() {
		planetCounter += 1;
		crew.leavePlanet();
	}
	


	public void launchTitleScreen() {
		TitleScreen titleWindow = new TitleScreen(this);
	}
	
	public void closeTitleScreen(TitleScreen titleWindow) {
		titleWindow.closeWindow();
		launchSetupScreen();
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchSetupCrewMembersScreen();
	}
	
	public void launchSetupCrewMembersScreen() {
		SetupCrewMembersScreen setupCrewMembersWindow = new SetupCrewMembersScreen(this);
	}
	
	public void closeSetupCrewMembersScreen(SetupCrewMembersScreen setupCrewMembersWindow) {
		setupCrewMembersWindow.closeWindow();
		launchSummaryScreen();
	}
	
	public void launchSummaryScreen() {
		SummaryScreen summaryWindow = new SummaryScreen(this);
	}
	
	public void closeSummaryScreen(SummaryScreen summaryWindow) {
		summaryWindow.closeWindow();		
	}
	
	public void launchPlanetIntroScreen() {
		PlanetIntroScreen introductionWindow = new PlanetIntroScreen(this);
	}
	
	public void closePlanetIntroScreen(PlanetIntroScreen introductionWindow) {
		introductionWindow.closeWindow();
		launchPlanetScreen();
	}
	
	public void launchPlanetScreen() {
		PlanetScreen planetWindow = new PlanetScreen(this);
	}
	
	public void closePlanetScreen(PlanetScreen planetWindow) {
		planetWindow.closeWindow();
	}
	
	public void launchScorpiusStrikesScreen() {
		ScorpiusStrikesScreen scorpiusStrikesWindow = new ScorpiusStrikesScreen(this);
	}
	
	public void closeScorpiusStrikesScreen(ScorpiusStrikesScreen scorpiusStrikesWindow) {
		scorpiusStrikesWindow.closeWindow();
	}
	
	public void launchScorpiusDeathScreen() {
		ScorpiusDeathScreen scorpiusDeathWindow = new ScorpiusDeathScreen(this);
	}
	
	public void closeScorpiusDeathScreen(ScorpiusDeathScreen scorpiusDeathWindow) {
		scorpiusDeathWindow.closeWindow();
	}
	
	public void launchSpaceshipScreen() {
		SpaceshipScreen spaceshipWindow = new SpaceshipScreen(this);
	}
	
	public void closeSpaceshipScreen(SpaceshipScreen spaceshipWindow) {
		spaceshipWindow.closeWindow();
	}
	
	public void launchAlienPiratesScreen() {
		AlienPiratesScreen alienPiratesWindow = new AlienPiratesScreen(this);
	}
	
	public void closeAlienPiratesScreen(AlienPiratesScreen alienPiratesWindow) {
		alienPiratesWindow.closeWindow();
	}
	
	public void launchInventoryScreen() {
		InventoryScreen inventoryWindow = new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
	}
	
	public void launchOutpostScreen() {
		OutpostScreen outpostWindow = new OutpostScreen(this);
	}
	
	public void closeOutpostScreen(OutpostScreen outpostWindow) {
		outpostWindow.closeWindow();
	}
	
	public void launchPilotScreen() {
		PilotScreen pilotWindow = new PilotScreen(this);
	}
	
	public void closePilotScreen(PilotScreen pilotWindow) {
		pilotWindow.closeWindow();
	}
	
	public void launchAsteroidScreen() {
		AsteroidScreen asteroidWindow = new AsteroidScreen(this);
	}
	
	public void closeAsteroidScreen(AsteroidScreen asteroidWindow) {
		asteroidWindow.closeWindow();
		launchPlanetIntroScreen();
	}
	
	public void launchWarningMemberScreen() {
		WarningMemberScreen warningMemberWindow = new WarningMemberScreen(this);
	}
	
	public void closeWarningMemberScreen(WarningMemberScreen warningMemberWindow) {
		warningMemberWindow.closeWindow();
	}
	
	public void launchCrewMemberDeathScreen(CrewMember crewMember) {
		CrewMemberDeathScreen crewMemberDeathWindow = new CrewMemberDeathScreen(this, crewMember);
	}
	
	public void closeCrewMemberDeathScreen(CrewMemberDeathScreen crewMemberDeathWindow) {
		crewMemberDeathWindow.closeWindow();
	}
	
	public void launchCrewMemberInfectedScreen(CrewMember crewMember) {
		CrewMemberInfectedScreen crewMemberInfectedWindow = new CrewMemberInfectedScreen(this, crewMember);
	}
	
	public void closeCrewMemberInfectedScreen(CrewMemberInfectedScreen crewMemberInfectedWindow) {
		crewMemberInfectedWindow.closeWindow();
	}
	
	public void launchWarningScreen() {
		WarningScreen warningWindow = new WarningScreen(this);
	}
	
	public void closeWarningScreen(WarningScreen warningWindow) {
		warningWindow.closeWindow();
	}
	
	public void launchGameOverScreen() {
		GameOverScreen gameOverWindow = new GameOverScreen(this);
	}
	
	public void closeGameOverScreen(GameOverScreen gameOverWindow) {
		gameOverWindow.closeWindow();
	}
	
	public static void main(String[] args) {
		// start adventure
		GameEnvironment game = new GameEnvironment();
		game.launchTitleScreen();
	}
}