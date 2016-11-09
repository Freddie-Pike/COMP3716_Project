package main;

import java.util.ArrayList;

public class Tournament {

	private int id;
	private ArrayList<Team> teams;
	private TournamentFormat format;
	
	public Tournament(int id) {
		this.id = id;
		this.teams = new ArrayList<Team>();
	}
	
	public void setFormat(TournamentFormat format) {
		this.format = format;
	}
	
	//If format is selected, then call the formats sortTeams method.
	public void generateTeamCollection() {
		if (format != null) {
			format.sortTeamsToCollection(teams);
		}
		else {
			return;
		}
	}
	
	public int getNumOfTeams() {
		return this.teams.size();
	}
	
	public void addTeam(String name) {
		teams.add(new Team(name));
	}
	
	public void simulateTour() {
		format.simulateGames();
	}
}
