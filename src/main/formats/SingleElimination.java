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
				for (int i = 0; i < teams.size()/2; i++) {
					//Get the first team, and match them with mid team, grab second team, match them with mid + 1 team, etc
					schedule.addGameToSchedule(new Game(teams.get(i), teams.get(i+teams.size()/2)));
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Single Elimination";
	}

}
