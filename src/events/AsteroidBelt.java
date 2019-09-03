package events;

import java.util.Random;

import main.Spaceship;

public class AsteroidBelt {
	
	/**
	 * Called when spaceship enters an asteroid belt
	 * <br>Spaceship may enter an asteroid belt based on random number generator out of 10
	 * @param spaceship Spaceship
	 */
	public void enterAsteroidBelt(Spaceship spaceship) {
		Random randomGenerator = new Random();
		int eventNumber = randomGenerator.nextInt(10);
		if (eventNumber < 6) {
			spaceship.setAsteroid(true);
			spaceship.asteroidCollision();
		}
	}
}
