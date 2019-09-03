package main;

import events.AsteroidBelt;

public class Spaceship {
	
	/**
	 * Spaceship name
	 */
	private String spaceshipName;
	/**
	 * Default shield health
	 */
	private double shieldHealth = 100.0;
	/**
	 * Asteroid collision; default is false
	 */
	private boolean isAsteroid = false;
	/**
	 * Spaceship explosion; default is false
	 */
	private boolean isExploded = false;
	/**
	 * Asteroid belt (constructor)
	 */
	private AsteroidBelt asteroidBelt = new AsteroidBelt();

	/**
	 * Obtains a spaceship's name
	 * @return String Spaceship name
	 */
	public String getSpaceshipName() {
		return spaceshipName;
	}
	
	/**
	 * Sets up a spaceship's name
	 * @param spaceshipName Spaceship name
	 */
	public void setSpaceshipName(String spaceshipName) {
		this.spaceshipName = spaceshipName;
	}

	/**
	 * Obtains a spaceship's shield health
	 * @return double Spaceship health
	 */
	public double getSpaceshipHealth() {
		return shieldHealth;
	}
	
	/**
	 * Takes a crew member and repairs the spaceship's shield
	 * <br>Shield health is increased by the crew member's repair rate
	 * <br>If shield health is over 100%, set shield health to 100%
	 * @param crewMember
	 */
	public void repairSpaceship(CrewMember crewMember) {
		shieldHealth += crewMember.getRepairRate();
		if (shieldHealth > 100) {
			shieldHealth = 100;
		}
	}
	
	/**
	 * Obtains the status of a spaceship; i.e. if the spaceship is fine or has exploded
	 * @return boolean Spaceship explosion
	 */
	public boolean isExploded() {
		return isExploded;
	}
	
	/**
	 * Called to check the spaceship's shield health
	 * <br>If health is less than or equals to 0, sets spaceship
	 * <br>status (isExplosion) to true; spaceship has exploded
	 */
	public void spaceshipExplodes() {
		if (shieldHealth <= 0) {
			isExploded = true;
		}
	}

	/**
	 * Called when spaceship flies to another planet
	 * <br>Additionally, calls a method from AsteroidBelt class 
	 * <br>that checks if the spaceship enters an asteroid belt,
	 * <br>and if so it will damage the ship
	 * <br>Also calls spaceshipExplodes() to check if the spaceship has exploded
	 * @param planet Planet object to traverse to
	 * @param crewMember1 Pilot member 1
	 * @param crewMember2 Pilot member 2
	 */
	public void flyToPlanet(Planet planet, CrewMember crewMember1, CrewMember crewMember2) {
		crewMember1.pilotSpaceship();
		crewMember2.pilotSpaceship();
		asteroidBelt.enterAsteroidBelt(this);
		spaceshipExplodes();
	}
	
	/**
	 * Obtains status of asteroid collision, returns true of collision
	 * @return boolean Asteroid collision
	 */
	public boolean isAsteroid() {
		return isAsteroid;
	}

	/**
	 * Sets up boolean asteroid collision, if asteroid collision occurs
	 * @param isAsteroid Asteroid collision
	 */
	public void setAsteroid(boolean isAsteroid) {
		this.isAsteroid = isAsteroid;
	}
	
	/**
	 * Called through the AsteroidBelt class when an asteroid collision occurs
	 * <br>Decreases the spaceship health by an amount:
	 * <br>– If shield health is over (or equals to) 50 %, scales shield health by 4.2%
	 * <br>– If shield health is under 50%, then decreases it by 19%
	 * <br>– If shield is at 0% or under, set shield health to 0
	 */
	public void asteroidCollision() {
		if (shieldHealth < 50) {
			shieldHealth -= 19;
		} else {
			shieldHealth -= shieldHealth / 4.2;
			shieldHealth = Math.round(shieldHealth);
		}
		if (shieldHealth <= 0) {
			shieldHealth = 0;
		}
	}
}
