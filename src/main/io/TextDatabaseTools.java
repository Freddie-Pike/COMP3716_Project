import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class TextDatabaseTools implements DatabaseTools {
	private String fileName;
	private String[][] arrayData = new String[9001][9001]; // IT"S OVER 9000!!!!!!!!!!!
	
	/** 
	 * A constructor for TextDatabaseTools. IMPORTANT:If a file doesn't exist it will create one.
	 */
	public TextDatabaseTools(String fileName) {
		fileName += ".txt";
		this.fileName = fileName;
		try {
		    File textFile = new File(fileName);

		    if ( textFile.exists() && !textFile.isDirectory() ) {
		        System.out.println(fileName + " already Exists"); // If a text file already exists then use then
		    }
		    else {
		    	System.out.println(fileName + " is created");
		    	PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		    	writer.close();
		    }
		} catch (Exception exception) {
		   System.out.println("There was an error: ");
		   exception.printStackTrace();
		}
	}
		
	/**
	 * Print out the entire contents of the text file.
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
	        	splitLine = line.split("/");
	        	System.out.print("Row = " + rowCount + " ");
	        	for (int i = 0; i < splitLine.length; i++) {
	        		System.out.print(splitLine[i] + " ");
	        		// Another way to print: System.out.print("Column " + i + " value = " + splitLine[i] + " ");
	        	}
	        	System.out.println();
	        	rowCount++;
	        }
	        // Always close files.
	        bufferedReader.close();
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
        }
	}
	
	
	/**
	 * Print out the contents of a column of information from the text file.
	 * @param column - The column to print out
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
	        	splitLine = line.split("/");
        		System.out.println(splitLine[column]);
	        	
	        }
	        // Always close files.
	        bufferedReader.close();
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
        }
	}

	/**
	 * Add a line to the text file.
	 * @param line - line to be added at end of text file
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
            ex.printStackTrace();
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            ex.printStackTrace();
        }
	}
	
	/**
	 * Remove an entire line from text database.
	 * @param line - The line to be removed from the text file
	 */
	public void removeRow(String deleteLine) {
		/**
		 * This implementation will be in the final project, it is not necessary for displaying the 
		 * executable architecture. 
		 */
		try {
			// Name of tempfile
			File textFile = new File(fileName);
			File tempFile = new File("tempTable.txt");
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
			
			String line; 
			
			boolean lineNotDeleted = true;
			
			while((line = bufferedReader.readLine()) != null) 
	        {
        		if (line.equals(deleteLine) && lineNotDeleted ) {
        			lineNotDeleted = false;
        			continue; 
        		}
        		bufferedWriter.write(line);
        		bufferedWriter.newLine();
	        }
			
			boolean isFileRenamed = tempFile.renameTo(textFile);
			
			if (isFileRenamed) {
				System.out.println("File Was Renamed");
			} else {
				System.out.println("File Wasn't Renamed");
			}
			
			bufferedWriter.close(); 
			bufferedReader.close(); 
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
        }
	}
	
	/**
	 * Remove line from text database.
	 * @param line - The line to be removed from the text file
	 */
	public void removeRowByStartingColumnValue(String deleteLine) {
		/**
		 * This implementation will be in the final project, it is not necessary for displaying the 
		 * executable architecture. 
		 */
		try {
			// Name of temptable.txt 
			File textFile = new File(fileName);
			File tempFile = new File("tempTable.txt");
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
			
			String line; 
			boolean lineNotDeleted = true;
			
			while((line = bufferedReader.readLine()) != null) 
	        {
        		if (line.startsWith(deleteLine) && lineNotDeleted ) {
        			lineNotDeleted = false;
        			continue; 
        		}
        		bufferedWriter.write(line);
        		bufferedWriter.newLine();
	        }
			
			boolean isFileRenamed = tempFile.renameTo(textFile);
			
			if (isFileRenamed) {
				System.out.println("File Was Renamed");
			} else {
				System.out.println("File Wasn't Renamed");
			}
			
			bufferedWriter.close(); 
			bufferedReader.close(); 
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
        }
	}
	
	/**
	 * Remove an entire line from text database.
	 * @param line - The line to be removed from the textfile
	 */
	public void removeRowByColumn(String deleteLine, int column) {
		try {
			// Name of tempfile
			File textFile = new File(fileName);
			File tempFile = new File("tempTable.txt");
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
			
			String line; 
			String splitLine[];
			
			boolean lineNotDeleted = true;
			
			while((line = bufferedReader.readLine()) != null) 
	        {
				splitLine = line.split("/");
        		if (splitLine[column].equals(deleteLine) && lineNotDeleted ) {
        			lineNotDeleted = false;
        			continue; 
        		}
        		bufferedWriter.write(line);
        		bufferedWriter.newLine();
	        }
			
			boolean isFileRenamed = tempFile.renameTo(textFile);
			
			if (isFileRenamed) {
				System.out.println("File Was Renamed");
			} else {
				System.out.println("File Wasn't Renamed");
			}
			
			bufferedWriter.close(); 
			bufferedReader.close(); 
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
        }
	}
	
	// Methods - Get all data as array
	public String[][] returnTextFileAsArray() {
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
	        	splitLine = line.split("/");
	        	// System.out.print("Row = " + rowCount + " ");
	        	for (int i = 0; i < splitLine.length; i++) {
	        		arrayData[rowCount][i] = splitLine[i];
	        		// System.out.println(arrayData[rowCount][i]);// Another way to print: System.out.print("Column " + i + " value = " + splitLine[i] + " ");
	        	}
	        	rowCount++;
	        }
	        // Always close files.
	        bufferedReader.close();
	        return arrayData;
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
            return arrayData;
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
            return arrayData;
        }
	}
	
	public void updateTextFileUsingArray(String[][] updateArray) {
		try {
			// 
			File textFile = new File(fileName);
			File tempFile = new File("tempTable.txt");
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
			
			for (int i = 0; i < updateArray.length; i++) {
	    		for (int j = 0; j < updateArray.length; j++) {
	    			if (updateArray[i][j] == null) break;
	    			bufferedWriter.write(updateArray[i][j] + "/");
	    		}
	    		if (updateArray[i][0] == null) break;
	    		bufferedWriter.newLine();
	    	}		
			boolean isFileRenamed = tempFile.renameTo(textFile);
			
			if (isFileRenamed) {
				System.out.println("File Was Renamed");
			} else {
				System.out.println("File Wasn't Renamed");
			}
			
			bufferedWriter.close(); 
			bufferedReader.close(); 
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
            ex.printStackTrace();
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            ex.printStackTrace();
        }
		
	}
	
	public ArrayList<String> grabRowDataAsArray(int row) {
		String line = null;
		String[] splitLine = null;
		ArrayList<String> tempList = new ArrayList();
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        int rowTemp = 0;
	        
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	if (rowTemp == row) {
	        		splitLine = line.split("/");
	        		for (int i = 0; i < splitLine.length; i++) {
	        			tempList.add(splitLine[i]);
	        		}
	        		break;
	        	}
	        	rowTemp++;
	        }
	        // Always close files.
	        bufferedReader.close();
	        return tempList;
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
            return tempList;
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
            return tempList;
        }
	}
	
	public ArrayList<String> grabColumnDataAsArray(int column) {
		String line = null;
		String[] splitLine = null;
		ArrayList<String> tempList = new ArrayList();
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        int rowTemp = 0;
	        
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	splitLine = line.split("/");
	        	tempList.add(splitLine[column]);
	        	System.out.println("Column " + column + " " + splitLine[column]);
	        }
	        // Always close files.
	        bufferedReader.close();
	        return tempList;
		}
		catch(FileNotFoundException exception) {
            System.out.println("Unable to open file '" + fileName + "'");
            exception.printStackTrace();
            return tempList;
        }
        catch(IOException exception) {
            System.out.println("Error reading file '" + fileName + "'");
            exception.printStackTrace();
            return tempList;
        }
	}
	
	/**
	 * This method updates a column of a textfile using an ArrayList. ***NOT FINISHED.
	 * @param updateArray - The array that updates the column
	 * @param column - update this column.
	 */
	public void updateColumnUsingArrayList(ArrayList<String> updateArray, int column) {
		try {
			// Name of tempfile
			File textFile = new File(fileName);
			File tempFile = new File("tempTable.txt");
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
			
			String line; 
			String splitLine[];
			
			while((line = bufferedReader.readLine()) != null) 
	        {
				splitLine = line.split("/");
        		bufferedWriter.write(line);
        		bufferedWriter.newLine();
	        }
			
			boolean isFileRenamed = tempFile.renameTo(textFile);
			
			if (isFileRenamed) {
				System.out.println("File Was Renamed");
			} else {
				System.out.println("File Wasn't Renamed");
			}
			
			bufferedWriter.close(); 
			bufferedReader.close(); 
		}
		catch(FileNotFoundException exception) {
            		System.out.println("Unable to open file '" + fileName + "'");
            		exception.printStackTrace();
        	}
        	catch(IOException exception) {
            		System.out.println("Error reading file '" + fileName + "'");
            		exception.printStackTrace();
        	}
	}
	
	
	
	/**
	 * A method that sorts the text file. TO BE IMPLEMENETED IN 2ND ITERATION. 
	 */
	public void sort() {
		
	}
	
	/**
	 * A method that sorts the text file by a specified column. TO BE IMPLEMENETED IN 2ND ITERATION. 
	 * @param - column - an int value that specifies what column the text file is going to be sorted by.
	 */
	public void sortByColumn(int column) {
		
	}
	
	/**
	 * Print out all the class name and the name of the textfile.
	 */
	@Override
	public String toString() {
		return "TextDatabaseManager [fileName=" + fileName + "]";
	}
}
