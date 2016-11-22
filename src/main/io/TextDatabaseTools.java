package main.io;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class TextDatabaseTools implements IDatabaseTools {
	private String fileName;
	
	/** 
	 * A constructor for TextDatabaseTools. If a file doesn't exist it will create one.
	 */
	public TextDatabaseTools(String fileName) {
		this.fileName = fileName;
		try {
		    File textFile = new File(fileName);

		    if ( textFile.exists() && !textFile.isDirectory() ) {
		        System.out.println(fileName + " already Exists");
		        
		    }
		    else {
		    	System.out.println(fileName + " is created");
		    	PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		    	writer.close();
		    }
		} catch (Exception e) {
		   // do something
		}
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
	 * Remove an entire line from text database.
	 * @param line - The line to be removed from the textfile
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
			
			// TextDatabaseManager deleteOriginalFile = new TextDatabaseManager();
			
			
			boolean isFileRenamed = tempFile.renameTo(textFile);
			// deleteOriginalFile.deleteFile(fileName);
			
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
	public void removeRowByStartingColumnValue(String deleteLine) {
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
        		if (line.startsWith(deleteLine) && lineNotDeleted ) {
        			lineNotDeleted = false;
        			continue; 
        		}
        		bufferedWriter.write(line);
        		bufferedWriter.newLine();
	        }
			
			// TextDatabaseManager deleteOriginalFile = new TextDatabaseManager();
			
			
			boolean isFileRenamed = tempFile.renameTo(textFile);
			// deleteOriginalFile.deleteFile(fileName);
			
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
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	
	public ArrayList<String> getRow(int row) {
		ArrayList<String> tempList = new ArrayList();
		return tempList;
	}
	
	public void sortByColumn(int row) {
		
	}
	
	@Override
	public String toString() {
		return "TextDatabaseManager [fileName=" + fileName + "]";
	}
}
