package main;

import java.util.ArrayList;

public abstract class TournamentFormat {
	
	//How are matches stored? EX: Bracket, Division, etc
	protected CollectionType collectionType;
	
	public TournamentFormat() {}
	
	//Custom logic to sort teams into the collection. Should use collection's addGameToCollection methods
	public abstract void sortTeamsToCollection(ArrayList<Team> teams);
	
	public void setCollectionType(CollectionType type) {
		this.collectionType = type;
	}
	
	public CollectionType getCollectionType() {
		return this.collectionType;
	}
	
	public void simulateGames() {
		collectionType.advanceTeams();
	}
	
}
