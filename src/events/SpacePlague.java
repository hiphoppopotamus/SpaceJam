package events;

import java.util.ArrayList;
import java.util.Random;

import main.Crew;
import main.CrewMember;

public class SpacePlague {
	
	/**
	 * Living crew members
	 */
	private ArrayList<CrewMember> livingMembers = new ArrayList<CrewMember>();
			
	/**
	 * Called to infect crew member(s)
	 * <br>Event is set up by a random generator and members of type immune cannot get infected
	 * <br>– If number is 9, then everyone in the crew gets infected
	 * <br>– If number is over 4 but not over 9, a crew member will be randomly selected to get infected
	 * <br>(using a random number generator)
	 * <br>– If there is only 1 living member left, then he/she will get infected
	 * <br><br>Note: Crew members are only infected if they are alive
	 * @param crew Crew 
	 */
	public void infectCrewMembers(Crew crew) {
		Random randomGenerator = new Random();
		int eventNumber = randomGenerator.nextInt(10);
		int randomCrewMemberIndex = randomGenerator.nextInt(crew.getCrewCount() - 1);
		for (CrewMember crewMember: crew.getCrewMembers()) {
			if (crewMember.isAlive()) {
				livingMembers.add(crewMember);
				if (eventNumber == 9 && crewMember.getType() != "Immune") {
					crewMember.infectCrewMember();
					//crew.addInfectedMember(crewMember)
				} else if (eventNumber > 4) {
					if (crew.getCrewMembers().indexOf(crewMember) == randomCrewMemberIndex && crewMember.getType() != "Immune") {
						crewMember.infectCrewMember();
					}
				}
			}
		}
		
		if (livingMembers.size() == 1) {
			CrewMember crewMember = livingMembers.get(0);
			if (crewMember.getType() != "Immune") {
				crewMember.infectCrewMember();
			}
		}
	}
}
