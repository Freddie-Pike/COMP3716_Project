package main.formats;

import java.util.ArrayList;

import main.Game;
import main.Team;
import main.schedule.Bracket;

public class SingleElimination extends TournamentFormat {

	public SingleElimination() {
		//Set the format's collection type to bracket
		this.setSchedule(new Bracket());
	}
	
	@Override
	public void sortTeamsToSchedule(ArrayList<Team> teams) {
		//Check to see if collection is not null
		if (schedule != null) {
			//Check to see if there are an even amount of teams
			if (teams.size() % 2 == 0) {
				schedule.resetSchedule();
				for (int i = 0; i < teams.size()/2; i++) {
					//Get the first team, and match them with mid team, grab second team, match them with mid + 1 team, etc
					schedule.addGameToSchedule(new Game(teams.get(i), teams.get(i+teams.size()/2)));
				}
			}
		}
	}
	
	@Override
	public void simulateGames() {
		System.out.println("SIMULATION STARTED");
		if (schedule.hasGames()) {
			int roundCount = 1;
			int gameCount = schedule.getNumberOfGames();
			// Keep going until there are no more games left to play
			while(gameCount != 0) {
				System.out.println("SIMULATION OF ROUND " + roundCount);
				//Advance current round, get current round's winners
				ArrayList<Team> winners = schedule.advanceTeams();
				//Sort the current winners into a new bracket
				this.sortTeamsToSchedule(winners);
				//Keep reducing the amount of games by half unless there is only 1 game left
				if ((gameCount/2) != 1) {
					gameCount/=2;
					roundCount++;
				}
				//If there's only one game left, then simulate the game, and break the loop
				else {
					System.out.println("SIMULATION OF ROUND " + (roundCount+1));
					System.out.println("WINNER IS: " + schedule.advanceTeams());
					gameCount = 0;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Single Elimination";
	}

}
