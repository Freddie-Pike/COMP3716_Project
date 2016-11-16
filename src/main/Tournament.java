package main;

import java.util.ArrayList;

import main.formats.TournamentFormat;

public class Tournament {

	private int id;
	private ArrayList<Team> teams;
	private TournamentFormat format;
	private String organizer;
	
	public Tournament(int id, String organizer) {
		this.id = id;
		this.organizer = organizer;
		this.teams = new ArrayList<Team>();
	}
	
	public void setFormat(TournamentFormat format) {
		this.format = format;
	}
	
	public TournamentFormat getFormat() {
		return this.format;
	}
	
	//If format is selected, then call the formats sortTeams method.
	public void generateTeamCollection() {
		if (format != null) {
			format.sortTeamsToSchedule(teams);
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
