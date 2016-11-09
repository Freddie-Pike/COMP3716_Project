package main;

import java.util.ArrayList;

public abstract class CollectionType {

	protected ArrayList<Game> games;
	
	public CollectionType() {
		this.games = new ArrayList<Game>();
	}
	
	//Add game to collection
	public void addGameToCollection(Game game) {
		this.games.add(game);
	}
	
	public abstract void advanceTeams();
	

}
