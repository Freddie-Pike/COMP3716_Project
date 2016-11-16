import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TournamentSystemManager {
	List<Tournament> tournamentList = new ArrayList<Tournament>();
	String fileNameaa;

	public TournamentSystemManager(String fileName) {
		TextDatabaseManager textDatabase = new TextDatabaseManager(fileName);
		String line = null;
		String[] splitLine = null;
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	splitLine = line.split(" ");
	        	Tournament temp = new Tournament(Integer.parseInt(splitLine[0]), splitLine[1]);
	        	tournamentList.add(temp);
	        }
	        // Always close files.
	        bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	
	public void PrintContents() {
		for (int i = 0; i < tournamentList.size(); i++) {
			System.out.println( tournamentList.get(i).toString() );
		}
	}
	
	public void sortTournaments() {
		/**
		 * This is will sort tournaments
		 */
	}
	
	public void sortTournamentsByColumn(int column) {
		/**
		 * 
		 */
	}
}
