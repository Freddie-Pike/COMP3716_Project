package main.schedule;

import java.util.ArrayList;

import main.Game;
import main.Team;

public abstract class Schedule {

	protected ArrayList<Game> games;
	
	public Schedule() {
		this.games = new ArrayList<Game>();
	}
	
	//Add game to schedule
	public void addGameToSchedule(Game game) {
		this.games.add(game);
	}
	
	public void resetSchedule() {
		this.games = new ArrayList<Game>();
	}
	
	public boolean hasGames() {
		return this.games.size() > 0 ? true : false;
	}
	
	public int getNumberOfGames() {
		return this.games.size();
	}
	
	// Returns winners
	public abstract ArrayList<Team> advanceTeams();
	

}
