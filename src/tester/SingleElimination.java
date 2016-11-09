package tester;

import java.util.ArrayList;

import main.Game;
import main.Team;
import main.TournamentFormat;

public class SingleElimination extends TournamentFormat {

	public SingleElimination() {
		//Set the format's collection type to bracket
		this.setCollectionType(new Bracket());
	}
	
	@Override
	public void sortTeamsToCollection(ArrayList<Team> teams) {
		//Check to see if collection is not null
		if (collectionType != null) {
			//Check to see if there are an even amount of teams
			if (teams.size() % 2 == 0) {
				for (int i = 0; i < teams.size()/2; i++) {
					//Get the first team, and match them with mid team, grab second team, match them with mid + 1 team, etc
					collectionType.addGameToCollection(new Game(teams.get(i), teams.get(i+teams.size()/2)));
				}
			}
		}
	}

}
