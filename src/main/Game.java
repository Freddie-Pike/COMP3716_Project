package main;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private Team[] teams;
	private int[] scores;
	
	public Game() {
		this.teams = new Team[2];
		scores = new int[2];
	}

	public Game(Team team1, Team team2) {
		this.teams = new Team[2];
		teams[0] = team1;
		teams[1] = team2;
		scores = new int[2];
	}
	
	public void setTeams(Team team1, Team team2) {
		teams[0] = team1;
		teams[1] = team2;
	}
	
	public Team determineWinner() {
		Random rand = new Random();
		scores[0] = rand.nextInt(100);
		scores[1] = rand.nextInt(100);
		if (scores[0] > scores[1]) {
			return teams[0];
		}
		else {
			return teams[1];
		}
	}
}
