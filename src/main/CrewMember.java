package main;
public class CrewMember {
	
	/**
	 * Name of crew member
	 */
	private String name;
	/**
	 * Type of crew member
	 */
	private String type;
	/**
	 * Default action available for crew member
	 */
	private int actions = 0;
	/**
	 * Default health of crew member
	 */
	private double health = 100;
	/**
	 * Default hunger of crew member
	 */
	private double hunger = 0;
	/**
	 * Default tiredness of crew member
	 */
	private double tiredness = 0;
	/**
	 * Status of space plague's presence in crew member; default is false
	 */
	private boolean isInfected = false;
	/**
	 * Status of crew member; default is true
	 */
	private boolean isAlive = true;
	
	/**
	 * Default health rate of crew member
	 */
	private double healthRate = 8;
	/**
	 * Default hunger rate of crew member
	 */
	private double hungerRate = 8;
	/**
	 * Default tiredness rate of crew member
	 */
	private double tirednessRate = 8;
	/**
	 * Default repair rate of crew member
	 */
	private double repairRate = 5;
	
	
	/**
	 * This function constructs a crew member 
	 * with a name and a type
	 * <br> There are six different types to choose from each with different skills:
	 * <br> –Superhuman: Default health of 120%
	 * <br> –Hunger Buster: Hunger rate is 5%
	 * <br> –Fresher: Tiredness rate is 5%
	 * <br> –Builder: Repair rate is 15%
	 * <br> –Immune: Unaffected by the space plague
	 * <br> –Terminator: Ability to prevent alien pirates from stealing items, but takes 10% damage in doing so
	 * @param name Crew Member's name
	 * @param type Crew Member's type
	 */
	public CrewMember(String name, String type) {
		this.name = name;
		this.type = type;
		switch(type) {
			case "Superhuman":
		    	health = 120;
		    	break;
			case "Hunger Buster":
				hungerRate = 5;
		    	break;
		    case "Fresher":
		    	tirednessRate = 5;
		    	break;
		    case "Builder":
		    	repairRate = 15;
		    	break;
		    case "Immune":
		    	break;
		    case "Terminator":
		    	break;
		}
	}
	
	/**
	 * Obtains a crew member's name
	 * @return String Name of crew member
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Obtains a crew member's type
	 * @return String Type of crew member
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Obtains the amount of action a crew member has done during the day
	 * @return int Actions
	 */
	public int getActions() {
		return actions;
	}
	
	/**
	 * Sets the amount of actions a crew member has done during the day
	 * @param actions Actions
	 */
	public void setActions(int actions) {
		this.actions = actions;
	}
	
	 /**
	  * Obtains a numeric amount of a crew member's health level.
	  * @return double Health of crew member.
	  */
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}
	
	public double getHealthRate() {
		return healthRate;
	}
	
	/**
	  * Obtains a numeric amount of a crew member's hunger level.
	  * @return Hunger of crew member.
	  */
	public double getHunger() {
		return hunger;
	}
	
	public void setHunger(double hunger) {
		this.hunger = hunger;
	}
	
	public double getHungerRate() {
		return hungerRate;
	}
	
	/**
	  * Obtains a numeric amount of a crew member's tiredness level.
	  * @return Tiredness of crew member.
	  */
	public double getTiredness() {
		return tiredness;
	}
	
	public void setTiredness(double tiredness) {
		this.tiredness = tiredness;
	}
	
	public double getTirednessRate() {
		return tirednessRate;
	}
	
	/**
	 * Returns a boolean true if crew member is infected by the space plague
	 * <br>Otherwise return false
	 * @return boolean Infected
	 */
	public boolean isInfected() {
		return isInfected;
	}
	
	/**
	 * Returns a boolean true if crew member is alive
	 * <br>Otherwise return false
	 * @return boolean Alive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Sets a crew member's status, 
	 * <br>true if alive, false if dead
	 * @param isAlive Alive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * Obtains a string representation of a crew member's status,
	 * <br>i.e. if alive, returns "Alive" otherwise returns "Dead"
	 * @return String Status
	 */
	public String getStatus() {
		if (isAlive) {
			return "Alive";
		} else {
			return "Dead";
		}
	}

	/**
	 * Infects a crew member with the space plague
	 * <br>Sets isInfected to true
	 * <br>Sets health rate to 10%
	 */
	public void infectCrewMember() {
		isInfected = true;
		healthRate = 10;
	}

	/**
	 * Take a food item and feeds it to a crew member; member can only eat if actions aren't maxed
	 * <br><br>Adds the member's health by the food item's health attribute
	 * <br>If health is maxed, set health to default health; 
	 * <br>120% for Superhumans, 100% for other types
	 * <br><br>Decreases a member's hunger level by the food item's hunger attribute
	 * <br>If hunger is less than 0, hunger is set to 0
	 * <br><br>Since eating is considered an action, adds 1 to actions
	 * @param foodItem
	 */
	public void eatFoodItem(FoodItem foodItem) {	
		health += foodItem.getHealth();		
		if (type == "Superhuman" && health > 120) {
			health = 120;
		} else if (type != "Superhuman" && health > 100) {
			health = 100;
		}
		
		hunger -= foodItem.getHunger();
		if (hunger < 0) {
			hunger = 0;
		}	
		actions += 1;
	}
	
	/**
	 * Take a medical item and uses it to a crew member; member can only heal if actions aren't maxed
	 * <br><br>Adds the member's health by the medical item's health attribute
	 * <br>If health is maxed, set health to default health; 
	 * <br>120% for Superhumans, 100% for other types
	 * <br><br>If a cure is used, sets a member's infected status to false
	 * <br>and sets their health rate back to default; 5%
	 * <br><br>Since healing is considered an action, adds 1 to actions
	 * @param medicalItem
	 */
	public void useMedicalItem(MedicalItem medicalItem) {
		health += medicalItem.getHealth();
		if (type == "Superhuman" && health > 120) {
			health = 120;
		} else if (type != "Superhuman" && health > 100) {
			health = 100;
		}
		
		if (medicalItem.getCure() == true) {
			isInfected = false;
			healthRate = 5;
		}
		actions += 1;
	}
	
	/**
	 * Allows crew member go to sleep if actions are not maxed
	 * <br>Sleeping decreases tiredness by 12%
	 * <br>If tiredness is less than 0, set to default; 0%
	 * <br>Sleeping maximises actions and member will not be able to do anything unless it is the next day
	 */
	public void goToSleep() {
		if (actions < 2) {
			tiredness -= 12;
			if (tiredness < 0) {
				tiredness = 0;
			}
			actions = 2;
		} 
	}
	
	/**
	 * Obtains a crew member's repair rate
	 * @return double Repair rate
	 */
	public double getRepairRate() {
		return repairRate;
	}
	
	/**
	 * Returns a boolean and ;ets a crew member repair a spaceship's shield if their actions are not maxed
	 * <br>Repairing adds an action to a member's actions
	 * <br>Returns true if there are still actions left, otherwise returns false
	 * @return
	 */
	public boolean repairSpaceship() {
		if (actions < 2) {
			actions += 1;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Adds an action when a crew member obtains planet items
	 */
	public void getPlanetItems() {
		actions += 1;
	}
	
	/**
	 * Adds an action when a crew member pilots spaceship
	 */
	public void pilotSpaceship() {
		actions += 1;
	}
	
	/**
	 * toString method for Crew Member and returns a string representation of an object;
	 * <br>in this case the crew member's name
	 */
	@Override
	public String toString() {
		return name;
	}

}
