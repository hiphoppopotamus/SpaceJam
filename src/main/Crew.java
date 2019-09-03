package main;

import java.util.ArrayList;

import events.AlienPirates;
import events.SpacePlague;
import food.Apple;
import food.Burger;
import medical.LargeBandage;
import medical.SmallBandage;

public class Crew {
	
	/**
	 * Number of Crew Members
	 */
	private int crewCount;
	/**
	 * Name of crew
	 */
	private String crewName;
	/**
	 * Current day; default is 1
	 */
	private int currentDay = 1;
	/**
	 * Number of transporter pieces crew currently owns; default is 0
	 */
	private int crewTransporterPieces = 0;
	/**
	 * Crew members
	 */
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	/**
	 * Dead crew members
	 */
	private ArrayList<CrewMember> deadMembers = new ArrayList<CrewMember>();
	/**
	 * Unhealthy crew members
	 */
	private ArrayList<CrewMember> unhealthyMembers = new ArrayList<CrewMember>();
	/**
	 * Hungry crew members
	 */
	private ArrayList<CrewMember> hungryMembers = new ArrayList<CrewMember>();
	/**
	 * Tired crew members
	 */
	private ArrayList<CrewMember> tiredMembers = new ArrayList<CrewMember>();
	/**
	 * Infected crew members
	 */
	private ArrayList<CrewMember> infectedMembers = new ArrayList<CrewMember>();
	/**
	 * Foodstuffs crew currently owns
	 */
	private ArrayList<FoodItem> crewFoodItems = new ArrayList<FoodItem>();
	/**
	 * Medical supplies crew currently owns
	 */
	private ArrayList<MedicalItem> crewMedicalItems = new ArrayList<MedicalItem>();
	/**
	 * Space outpost for crew to purchase items
	 */
	private SpaceOutpost spaceOutpost = new SpaceOutpost();
	/**
	 * The amount of funds crew has; default is $50.0
	 */
	private double crewFunds = 50.0;
	/**
	 * Current planet crew is in
	 */
	private Planet currentPlanet; // start planet like for intro
	/**
	 * Alien pirates stealing the crew's items; default is false
	 */
	private boolean isAlien = false;
	/**
	 * A terminator's presence within the crew; default is false
	 */
	private boolean terminatorPresent = false;
	/**
	 * A terminator within the crew
	 */
	private CrewMember terminator;
	/**
	 * Foodstuff stolen by alien pirates
	 */
	private FoodItem stolenFoodItem;
	/**
	 * Medical supply stolen by alien pirates
	 */
	private MedicalItem stolenMedicalItem;
	
	/**
	 * Sets up a crew with a crew name
	 * <br>Simultaneously sets up foodstuffs and medical supplies the crew owns
	 * @param crewName Name of crew
	 */
	public Crew(String crewName) {
		this.crewName = crewName;
		setCrewFoodItems();
		setCrewMedicalItems();
	}
	
	/**
	 * Obtains name of crew
	 * @return String Crew name
	 */
	public String getCrewName() {
		return crewName;
	}

	/**
	 * Obtains the amount of crew members present in the start of game
	 * @return int Number of members
	 */
	public int getCrewCount() {
		return crewCount;
	}
	
	/**
	 * Sets the amount of crew members present int the start of the game
	 * <br>Only 2 to 4 members are allowed
	 * <br>This exception is noted from the SetupCrewMembersScreen class
	 * @param crewCount Number of members
	 */
	public void setCrewCount(int crewCount) {
		this.crewCount = crewCount;
	}
	
	/**
	 * Obtains the current day game is on
	 * @return int Current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}

	/**
	 * Sets the current day game is one
	 * @param currentDay Current day
	 */
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	
	/**
	 * Obtains the amount of transporter pieces a crew has
	 * @return
	 */
	public int getCrewTransporterPieces() {
		return crewTransporterPieces;
	}
	
	/**
	 * Sets the amount of transporter pieces a crew has
	 * @param crewTransporterPieces Number of pieces
	 */
	public void setCrewTransporterPieces(int crewTransporterPieces) {
		this.crewTransporterPieces = crewTransporterPieces;
	}
	
	/**
	 * Adds the amount of transporter pieces a crew has
	 * @param crewTransporterPieces Number of pieces
	 */
	public void addCrewTransporterPiece(int crewTransporterPieces) {
		this.crewTransporterPieces += crewTransporterPieces;
	}
	
	/**
	 * Obtains crew members within a crew, both alive and dead
	 * @return ArrayList<CrewMember> Crew members
	 */
	public ArrayList<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	
	/**
	 * Adds a crew member to the crew
	 * @param name String Member name
	 * @param type Member type
	 */
	public void addCrewMember(String name, String type) {
		CrewMember crewMember = new CrewMember(name, type);
		crewMembers.add(crewMember);
//		livingMembers.add(crewMember);
	}
	
	/**
	 * Obtains dead crew members from an arraylist of dead members
	 * @return ArrayList<CrewMember> Dead crew members
	 */
	public ArrayList<CrewMember> getDeadMembers() {
		return deadMembers;
	}

	/**
	 * Adds a dead crew member to an arraylist of dead members
	 * @param crewMember Crew member
	 */
	public void addDeadMember(CrewMember crewMember) {
		deadMembers.add(crewMember);
	}
//	
//	public ArrayList<CrewMember> getLivingMembers() {
//		return livingMembers;
//	}
//
//	public void removeLivingMember(CrewMember crewMember) {
//		livingMembers.remove(crewMember);
//	}

	/**
	 * Obtains unhealthy crew members from an arraylist of unhealthy members
	 * @return ArrayList<CrewMember> Unhealthy crew members
	 */
	public ArrayList<CrewMember> getUnhealthyMembers() {
		return unhealthyMembers;
	}

	/**
	 * Adds an unhealthy crew member to an arraylist of unhealthy members
	 * @param crewMember Crew member
	 */
	public void addUnhealthyMember(CrewMember crewMember) {
		unhealthyMembers.add(crewMember);
	}
	
	/**
	 * Removes an unhealthy crew member to an arraylist of unhealthy members
	 * @param crewMember Crew member
	 */
	public void removeUnhealthyMember(CrewMember crewMember) {
		unhealthyMembers.remove(crewMember);
	}
	
	/**
	 * Obtains hungry crew members from an arraylist of hungry members
	 * @return ArrayList<CrewMember> Hungry crew members
	 */
	public ArrayList<CrewMember> getHungryMembers() {
		return hungryMembers;
	}

	/**
	 * Adds a hungry crew member to an arraylist of hungry members
	 * @param crewMember Crew member
	 */
	public void addHungryMember(CrewMember crewMember) {
		hungryMembers.add(crewMember);
	}
	
	/**
	 * Removes a hungry crew member to an arraylist of hungry members
	 * @param crewMember Crew member
	 */
	public void removeHungryMember(CrewMember crewMember) {
		hungryMembers.remove(crewMember);
	}
	
	/**
	 * Obtains tired crew members from an arraylist of tired members
	 * @return ArrayList<CrewMember> Tired crew members
	 */
	public ArrayList<CrewMember> getTiredMembers() {
		return tiredMembers;
	}

	/**
	 * Adds a tired crew member to an arraylist of tired members
	 * @param crewMember Crew member
	 */
	public void addTiredMember(CrewMember crewMember) {
		tiredMembers.add(crewMember);
	}
	
	/**
	 * Removes a tired crew member to an arraylist of tired members
	 * @param crewMember Crew member
	 */
	public void removeTiredMember(CrewMember crewMember) {
		tiredMembers.remove(crewMember);
	}
	
	/**
	 * Obtains infected crew members from an arraylist of infected members
	 * @return ArrayList<CrewMember> Infected crew members
	 */
	public ArrayList<CrewMember> getInfectedMembers() {
		return infectedMembers;
	}

	/**
	 * Adds an infected crew member to an arraylist of infected members
	 * @param crewMember Crew member
	 */
	public void addInfectedMember(CrewMember crewMember) {
		infectedMembers.add(crewMember);
	}

	/**
	 * Removes an infected crew member to an arraylist of infected members
	 * @param crewMember Crew member
	 */
	public void removeInfectedMember(CrewMember crewMember) {
		infectedMembers.remove(crewMember);
	}
	
	/**
	 * Checks if a crew member's status
	 * <br>If alive, returns true, otherwise returns false
	 * @param crewMember Crew member
	 * @return boolean Crew member status
	 */
	public boolean checkCrewMemberStatus(CrewMember crewMember) {
		return crewMember.isAlive();
	}
	
	/**
	 * Sets a crew member's status (alive or dead) with some specified conditions:
	 * <br>– If health is under (or equals) 0%
	 * <br>– If hunger is maxed and over (or equals) 50%
	 * <br>– If tiredness is maxed and over (or equals) 50%
	 * <br>If any of these conditions are met crew member's status is set to false: dead
	 * @param crewMember Crew member
	 */
	public void setCrewMemberStatus(CrewMember crewMember) {
		if (crewMember.getHealth() <= 0 || crewMember.getHunger() >= 50 || crewMember.getTiredness() >= 50) {
			crewMember.setAlive(false);
		}
	}
	
	/**
	 * Checks if the crew members of a crew are all dead by checking each crew member's status
	 * <br>If they are all dead, returns a boolean true,
	 * <br>Otherwise returns false
	 * @return boolean Crew's status
	 */
	public boolean isAllDead() {
		boolean isAllDead = crewMembers.stream().allMatch(member -> member.isAlive() == false);
		return isAllDead;
	}
		
	/**
	 * Obtains a crew's foodstuffs from an arraylist of food items
	 * @return ArrayList<FoodItem> Crew food items
	 */
	public ArrayList<FoodItem> getCrewFoodItems() {
		return crewFoodItems;
	}
	
	/**
	 * Sets up a crew's initial food items
	 * <br>Called from the Crew constructor
	 */
	public void setCrewFoodItems() {
		crewFoodItems.add(new Apple());
		crewFoodItems.add(new Burger());
	}
	
	/**
	 * Removes a foodstuff from the arraylist of food items when feeding a crew member
	 * @param foodItem Foodstuff
	 */
	public void eatCrewFoodItem(FoodItem foodItem) {
		crewFoodItems.remove(foodItem);
	}
	
	/**
	 * Called when alien pirates steal a foodstuff from crew
	 * <br>Removes foodstuff at index of crew food item arraylist
	 * @param index Food item index
	 */
	public void stealCrewFoodItem(int index) {
		crewFoodItems.remove(index);
	}
	
	/**
	 * Obtains an arraylist of food items available in the space outpost
	 * @return ArrayList<FoodItem> Outpost food items
	 */
	public ArrayList<FoodItem> getOutpostFoodItems() {
    	// Attributes of objects already as part of the items
    	return spaceOutpost.getOutpostFoodItems();
    }
	
	/**
	 * Buys a food item from the space outpost
	 * <br>Decreases crew funds by the item's price
	 * @param foodItem Outpost food item
	 */
    public void buyOutpostFoodItem (FoodItem foodItem) {
    	crewFoodItems.add(foodItem);
    	crewFunds -= foodItem.getPrice();
    }
    
    
    /**
	 * Obtains a crew's medical supplies from an arraylist of medical items
	 * @return ArrayList<MedicalItem> Crew medical items
	 */
    public ArrayList<MedicalItem> getCrewMedicalItems() {
    	return crewMedicalItems;
    }
    
	/**
	 * Sets up a crew's initial medical items
	 * <br>Called from the Crew constructor
	 */
    public void setCrewMedicalItems() {
		crewMedicalItems.add(new SmallBandage());
		crewMedicalItems.add(new LargeBandage());
	}
    
    /**
	 * Removes a medical supply from the arraylist of medical items when healing a crew member
	 * @param medicalItem Medical supply
	 */
    public void useCrewMedicalItem(MedicalItem medicalItem) {
    	crewMedicalItems.remove(medicalItem);
    }
    
    /**
	 * Called when alien pirates steal a medical supply from crew
	 * <br>Removes medical supply at index of crew medical item arraylist
	 * @param index Medical item index
	 */
    public void stealCrewMedicalItem(int index) {
    	crewMedicalItems.remove(index);
    }
    
    /**
	 * Obtains an arraylist of medical items available in the space outpost
	 * @return ArrayList<MedicalItem> Outpost medical items
	 */
    public ArrayList<MedicalItem> getOutpostMedicalItems() {
    	// Attributes of objects already as part of the items
    	return spaceOutpost.getOutpostMedicalItems();
    }
    
	/**
	 * Buys a medical item from the space outpost
	 * <br>Decreases crew funds by the item's price
	 * @param medicalItem Outpost medical item
	 */
    public void buyOutpostMedicalItem (MedicalItem medicalItem) {
    	crewMedicalItems.add(medicalItem);
    	crewFunds -= medicalItem.getPrice();
    }
    
    /**
     * Checks if alien pirates has entered your ship
     * <br>Returns a boolean true if so, otherwise returns false
     * @return boolean Alien pirates 
     */
    public boolean isAlien() {
		return isAlien;
	}

    /**
     * Sets the status of alien pirates in ship,
     * <br>Called from the nextDay() function during an alien raid
     * <br>Also called exclusively from the SpaceshipScreen and PlanetScreen classes, 
     * <br>particularly after the player clicks the next day button
     * @param isAlien Alien pirates
     */
	public void setAlien(boolean isAlien) {
		this.isAlien = isAlien;
	}

	/**
	 * Checks if there is a type terminator present within the crew members
	 * <br>A terminator prevents alien pirates from stealing items from ship
	 * @return boolean Terminator present
	 */
	public boolean isTerminatorPresent() {
		return terminatorPresent;
	}

	/**
	 * Sets the presence of a type terminator in ship, 
	 * <br> if there is a terminator returns true, otherwise returns false
	 * @param terminatorPresent Terminator present
	 */
	public void setTerminatorPresent(boolean terminatorPresent) {
		this.terminatorPresent = terminatorPresent;
	}

	/**
	 * Obtains a crew member of type terminator
	 * <br>Only obtains the first instance of a terminator in crew members
	 * @return CrewMember Crew member
	 */
	public CrewMember getTerminator() {
		return terminator;
	}

	/**
	 * Sets a crew member of type terminator in ship
	 * @param terminator Terminator crew member
	 */
	public void setTerminator(CrewMember terminator) {
		this.terminator = terminator;
	}

	/**
	 * Obtains the food item stolen by alien pirates
	 * @return FoodItem Stolen food item
	 */
	public FoodItem getStolenFoodItem() {
		return stolenFoodItem;
	}

	/**
	 * Sets the stolen food item stolen by alien pirates
	 * @param stolenFoodItem Stolen food item
	 */
	public void setStolenFoodItem(FoodItem stolenFoodItem) {
		this.stolenFoodItem = stolenFoodItem;
	}

	/**
	 * Obtains the medical item stolen by alien pirates
	 * @return MedicalItem Stolen medical item
	 */
	public MedicalItem getStolenMedicalItem() {
		return stolenMedicalItem;
	}

	/**
	 * Sets the stolen food item stolen by alien pirates
	 * @param stolenFoodItem Stolen food item
	 */
	public void setStolenMedicalItem(MedicalItem stolenMedicalItem) {
		this.stolenMedicalItem = stolenMedicalItem;
	}

	/**
	 * Moves on to the next day
	 * <br>Sets adds 1 to current day
	 * <br>Alien pirates and the space plague events occurs when calling this function
	 * <br>If alien pirates occur, then a food item and/or a medical item may be stolen
	 * <br>If space plague succeeds in infecting crew member(s), then they will obviously get infected
	 * <br>Calls nextDayActions(); an extension of the function
	 */
	public void nextDay() {
		currentDay += 1;
		AlienPirates alienPirates = new AlienPirates();
		SpacePlague spacePlague = new SpacePlague();
		alienPirates.stealCrewItem(this);
		spacePlague.infectCrewMembers(this);
		nextDayActions();
	}
	
    /**
     * For each crew member, function does several things:
     * <br>– Decreases the health of a member by their specified health rate
     * <br>– Increases the hunger of a member by their specified hunger rate
     * <br>– Increases the tiredness of a member by their specified tiredness rate
	 * <br><br>Several if statements that adds or removes members 
	 * <br>if their health, hunger, tiredness is below or above a certain number
	 * <br><br>Additionally adds a crew member to dead crew members if they are dead
	 * <br><br>If crew member is still alive, their actions are resetted back to 0
     */
    public void nextDayActions() {
    	for (CrewMember crewMember: crewMembers) {
			crewMember.setHealth(crewMember.getHealth() - crewMember.getHealthRate());
			crewMember.setHunger(crewMember.getHunger() + crewMember.getHungerRate());
			crewMember.setTiredness(crewMember.getTiredness() + crewMember.getTirednessRate());
			
			if (crewMember.getHealth() <= 0) {
				crewMember.setHealth(0);
				if (unhealthyMembers.contains(crewMember)) {
					unhealthyMembers.remove(crewMember);
				}
			} else if (crewMember.getHealth() <= 30 && unhealthyMembers.contains(crewMember) == false) {
				unhealthyMembers.add(crewMember);
			} else if (crewMember.getHealth() > 30 && unhealthyMembers.contains(crewMember)) {
				unhealthyMembers.remove(crewMember);
			}
				
			if (crewMember.getHunger() >= 50) {
				crewMember.setHunger(50);
				if (hungryMembers.contains(crewMember)) {
					hungryMembers.remove(crewMember);
				}
			} else if (crewMember.getHunger() >= 25 && hungryMembers.contains(crewMember) == false) {
				hungryMembers.add(crewMember);
			} else if (crewMember.getHunger() < 25 && hungryMembers.contains(crewMember)) {
				hungryMembers.remove(crewMember);
			}
			
			if (crewMember.getTiredness() >= 50) {
				crewMember.setTiredness(50);
				if (tiredMembers.contains(crewMember)) {
					tiredMembers.remove(crewMember);
				}
			} else if (crewMember.getTiredness() >= 25  && tiredMembers.contains(crewMember) == false) {
				tiredMembers.add(crewMember);
			} else if (crewMember.getTiredness() < 25 && tiredMembers.contains(crewMember)) {
				tiredMembers.remove(crewMember);
			}
			
			setCrewMemberStatus(crewMember);
			if (crewMember.isAlive() == true) {
				crewMember.setActions(0);
			} else {
				
				crewMember.setActions(2);
			}
		}
    }
    
    /**
     * Obtains crew funds
     * @return double Crew funds
     */
    public double getCrewFunds() {
    	return crewFunds;
    }
    
    /**
     * Obtains current planet crew is in
     * @return Current planet
     */
    public Planet getCurrentPlanet() {
    	return currentPlanet;
    }
    
    /**
     * Sets current planet crew is in
     * @param planet Planet
     */
    public void setCurrentPlanet(Planet planet) {
    	currentPlanet = planet;
    }
   
    /**
     * Takes a crew member and obtains items available in a planet
     * <br>if a crew member's actions are not maxed (2 actions max).
     * <br>Items may include
     * <br>– Foodstuff
     * <br>– Medical supply
     * <br>– A transporter piece
     * <br>– Money
     * @param crewMember
     */
    public void getPlanetItems(CrewMember crewMember) {
    	if (crewMember.getActions() < 2) {   // maybe delete if since actions is already iffed at game envi
	    	for (FoodItem foodItem: currentPlanet.getPlanetFoodItems()) {
	    		crewFoodItems.add(foodItem);
	    		currentPlanet.setFoodItems(new ArrayList<FoodItem>());
	    	}
	    	for (MedicalItem medicalItem: currentPlanet.getPlanetMedicalItems()) {
	    		crewMedicalItems.add(medicalItem);
	    		currentPlanet.setMedicalItems(new ArrayList<MedicalItem>());
	    	}
	    	
	    	addCrewTransporterPiece(currentPlanet.getTransporterPiece());
	    	currentPlanet.setTransporterPiece(0);
	    	
	    	crewFunds += currentPlanet.getMoney();
	    	currentPlanet.setMoney(0);
	    	
	    	currentPlanet.setCleansed(true);
	    	crewMember.getPlanetItems();
    	}
    }
    
    /**
     * Takes a planet, two crew members with enough actions, and a spaceship 
     * <br>and traverses a crew to that planet, setting current planet to that particular planet
     * @param planet Planet
     * @param crewMember1 Crew member 1
     * @param crewMember2 Crew member 2
     * @param spaceship Spaceship
     */
    public void flyToPlanet(Planet planet, CrewMember crewMember1, CrewMember crewMember2, Spaceship spaceship) {
    	if (crewMember1.getActions() < 2 && crewMember2.getActions() < 2) {
    		spaceship.flyToPlanet(planet, crewMember1, crewMember2); 
    		setCurrentPlanet(planet);
    	}
    }
    
    /**
     * Sets current planet to null when leaving planet
     */
    public void leavePlanet() {
    	setCurrentPlanet(null);
    }
    
}
