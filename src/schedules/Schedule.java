package schedules;

import java.util.ArrayList;

import main.Game;

public abstract class Schedule {

	protected ArrayList<Game> games;
	
	public Schedule() {
		this.games = new ArrayList<Game>();
	}
	
	//Add game to schedule
	public void addGameToSchedule(Game game) {
		this.games.add(game);
	}
	
	public abstract void advanceTeams();
	

}
