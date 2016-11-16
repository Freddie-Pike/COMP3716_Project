package main.formats;

import java.util.ArrayList;

import main.Team;
import main.schedule.Schedule;

public abstract class TournamentFormat {
	
	//How are matches stored? EX: Bracket, Division, etc
	protected Schedule schedule;
	
	public TournamentFormat() {}
	
	//Custom logic to sort teams into the collection. Should use schedule's addGameToSchedule methods
	public abstract void sortTeamsToSchedule(ArrayList<Team> teams);
	
	public void setSchedule(Schedule type) {
		this.schedule = type;
	}
	
	public Schedule getSchedule() {
		return this.schedule;
	}
	
	public void simulateGames() {
		schedule.advanceTeams();
	}
	
}
