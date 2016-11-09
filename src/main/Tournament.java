package main;

import java.util.ArrayList;

public class Tournament {

	private int id;
	private ArrayList<Team> teams;
	private TournamentFormat format;
	
	public Tournament(int id) {
		this.id = id;
	}
	
	public void setFormat(TournamentFormat format) {
		this.format = format;
	}
	
	//If format is selected, then call the formats sortTeams method.
	public void generateTeams() {
		if (format != null) {
			format.sortTeamsToCollection(teams);
		}
		else {
			return;
		}
	}
}
