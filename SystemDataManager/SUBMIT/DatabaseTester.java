/**
 * A class that tests out the maining system information part of the architecture. It adds a row to a textfile 
 * database and the prints out the contents of the database.
 * @author Freddie Pike
 */
public class DatabaseTester {
    public static void main(String [] args) {
        DatabaseManager tournamentDatabase = new TextDatabaseManager("Tournament_Information.txt");
        tournamentDatabase.addRow("3 Tyler");
        tournamentDatabase.printContents();
    }
}
