import java.io.*;

public class TextDatabaseManager implements DatabaseManager {
	private String fileName;
	
	public TextDatabaseManager(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Print out entire contents of the text file.
	 */
	public void printContents() {
		String line = null;
		String[] splitLine = null;
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        int rowCount = 0;
	        
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	splitLine = line.split(" ");
	        	System.out.print("Row = " + rowCount + " ");
	        	for (int i = 0; i < splitLine.length; i++) {
	        		System.out.print("Column " + i + " value = " + splitLine[i] + " ");
	        	}
	        	System.out.println();
	        	rowCount++;
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
	
	/**
	 * Print out the contents of a column of information from the text file.
	 * @param column
	 */
	public void printContentsByColumn(int column) {
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
        		System.out.println(splitLine[column]);
	        	
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

	/**
	 * Add line to text database.
	 * @param line - line to be added at end of textfile
	 */
	public void addRow(String line) {
		try {
			// FileWriter writes text files.
	        FileWriter fileWriter = new FileWriter(fileName, true);
	        
	        fileWriter.write(line + "\n"); 
	        fileWriter.close();
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
	
	/**
	 * Remove line from text database.
	 * @param line - The line to be removed from the textfile
	 */
	public void removeRow(String line) {
		/**
		 * This implementation will be in the final project, it is not necessary for displaying the 
		 * executable architecture. 
		 */
	}
	
	@Override
	public String toString() {
		return "TextDatabaseManager [fileName=" + fileName + "]";
	}
}
