package main.schedule;

import java.util.ArrayList;

import main.Game;
import main.Team;

public class Bracket extends Schedule {
	
	public Bracket() {}

	//For single elimination we only care about advancing the winners
	@Override
	public ArrayList<Team> advanceTeams() {
		return simulateRound();
	}
	
	//Test method to simulate round winners, returns the winners
	private ArrayList<Team> simulateRound() {
		ArrayList<Team> winners = new ArrayList<Team>();
		for (int i = 0; i < games.size(); i++) {
			winners.add(games.get(i).determineWinner());
			System.out.println("Game " + (i+1) + ": Winner: " + winners.get(i).getName());
		}
		return winners;
	}
	
	@Override
	public String toString() {
		return "Bracket";
	}
}
