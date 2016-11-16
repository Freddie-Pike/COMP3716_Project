package main.io;

/**A class that compares performance of teo symbol table implementations
 * @author Fred
 *
 */
import java.io.*;
import java.util.Scanner;

public class LoginMain {
    public static void main(String [] args) {
        
        // Testing out the new class. 
        TournamentSystemManager tournamentSystemManager = new TournamentSystemManager("Tournament_Information.txt");
        tournamentSystemManager.PrintContents();
        
        /**
        System.out.println("What do you want to search by: Continent[0] Format[1] ");
        int userSearchDecision = in.nextInt();
        if (userSearchDecision == 0) {
        	System.out.println("You are searching by continent");
        	System.out.println("Select a continent: North America[0] Europe[1]");
        	int continentDecision = in.nextInt();
        	if (continentDecision == 0) {
        		tournaments.PrintContentsBySearchValue("NorthAmerica", userSearchDecision);
        	}
        	else if (continentDecision == 1) {
        		tournaments.PrintContentsBySearchValue("Europe", userSearchDecision);
        	}
        	
        }
        else if (userSearchDecision == 1) {
        	System.out.println("You are searching by Format");
        }
        else {
        	System.out.println("Incorrect Input");
        }
        */
    }
}
