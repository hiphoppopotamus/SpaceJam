package events;

import java.util.Random;

import main.Crew;
import main.CrewMember;

public class AlienPirates {
	
	/**
	 * Called when alien pirates steal foodstuff or medical item from a crew
	 * <br>Event is set up by a random generator out of 10,
	 * <br>– If number is over 5 then every alien pirates steal items
	 * <br><br>If a crew member of type Terminator is present within crew members,
	 * <br>then aliens will not be able to steal items but the particular
	 * <br> member of type Terminator will get 10% damage
	 * @param crew
	 */
	public void stealCrewItem(Crew crew) {
		Random randomGenerator = new Random();
		int eventNumber = randomGenerator.nextInt(10);
		if (eventNumber > 5) {
			crew.setAlien(true);
			for (CrewMember crewMember: crew.getCrewMembers()) {
				if (crewMember.getType() == "Terminator" && crewMember.isAlive()) {
					crew.setTerminatorPresent(true);
					crew.setTerminator(crewMember);
					crewMember.setHealth(crewMember.getHealth() - 10);
					if (crewMember.getHealth() <= 0) {
						crewMember.setHealth(0);
					}
				break;
				}
			}
			
			if (crew.isTerminatorPresent() == false) {
				crew.setTerminator(null);
				if (crew.getCrewFoodItems().size() > 1) {
					int index = randomGenerator.nextInt(crew.getCrewFoodItems().size() - 1);
					crew.setStolenFoodItem(crew.getCrewFoodItems().get(index));
					crew.stealCrewFoodItem(index);
				} else if (crew.getCrewFoodItems().size() == 1){
					crew.setStolenFoodItem(crew.getCrewFoodItems().get(0));
					crew.stealCrewFoodItem(0);
				}
				
				if (crew.getCrewMedicalItems().size() > 1) {
					int index = randomGenerator.nextInt(crew.getCrewMedicalItems().size() - 1);
					crew.setStolenMedicalItem(crew.getCrewMedicalItems().get(index));
					crew.stealCrewMedicalItem(index);
				} else if (crew.getCrewMedicalItems().size() == 1){
					crew.setStolenMedicalItem(crew.getCrewMedicalItems().get(0));
					crew.stealCrewMedicalItem(0);
				}
			}
		}
	}

}
