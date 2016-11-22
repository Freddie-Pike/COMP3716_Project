package tester;

import main.io.TextDatabaseTools;

/**
 * A class that tests out the maining system information part of the architecture. It adds a row to a textfile 
 * database and the prints out the contents of the database.
 * @author Freddie Pike
 */

public class DatabaseTester {
    public static void main(String [] args) {
        TextDatabaseTools tournamentDatabase = new TextDatabaseTools("Tournament_Information.txt");
        
        // tournamentDatabase.printContents();
        // TextDatabaseManager fileManager = new TextDatabaseManager();
        // fileManager.deleteFile("Game_123456.txt");
       
        tournamentDatabase.removeRowByStartingColumnValue("1");
        
        //LocalDate today = LocalDate.now();
    }
}
