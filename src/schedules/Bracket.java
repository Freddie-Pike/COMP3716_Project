package schedules;

import main.Game;

public class Bracket extends Schedule {
	
	public Bracket() {}

	//For single elimination we only care about advancing the winners
	@Override
	public void advanceTeams() {
		System.out.println("SIMULATION OF ROUND 1:");
		for (Game g : games) {
			System.out.println("Winner: " + g.determineWinner().toString());
		}
	}
	
	@Override
	public String toString() {
		return "Bracket";
	}
}
