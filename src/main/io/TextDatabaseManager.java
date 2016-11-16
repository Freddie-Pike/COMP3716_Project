package main.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Tournament;

public class TextDatabaseManager implements IDatabaseManager {
	private String fileName;
	private FileReader fileReader;
	private String line;
	private String[] splitLine;
	
	public TextDatabaseManager(String fileName) {
		this.fileName = fileName;
	}
	
	public void putDataInObjects() {
		try {
			List<Object> genericList = new ArrayList<Object>();
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	splitLine = line.split(" ");
	        	Tournament temp = new Tournament(Integer.parseInt(splitLine[0]), splitLine[1]);
	        	genericList.add(temp);
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
	 * Print out entire contents of the text file.
	 */
	public void PrintContents() {
		line = null;
		splitLine = null;
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	System.out.println("Line = " + line);
	        	splitLine = line.split(" ");
	        	for (int i = 0; i < splitLine.length; i++) {
	        		System.out.println("splitLine " + i + " = " + splitLine[i]);
	        	}
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
	public void PrintContentsByColumn(int column) {
		line = null;
		splitLine = null;
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
	 * Print out the contents of the text file if this name is found in the textfile.
	 * @param column
	 */
	public void PrintContentsBySearchValue(String searchValue, int column) {
		line = null;
		splitLine = null;
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	splitLine = line.split(" ");
        		if (splitLine[column].equals(searchValue)) {
        			System.out.println(line);
        		}
	        	
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
	
	
	
	public boolean FindMatchByColumn(String searchValue, int column) {
		line = null;
		splitLine = null;
		try {
			// FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            
			// Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	        // Read through the text document. 
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	splitLine = line.split(" ");
        		if (splitLine[column].equals(searchValue)) {
        	        bufferedReader.close();
        			return true;
        		}
	        }
	        // Always close files.
	        bufferedReader.close();
	        return false;
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
            return false;
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            return false;
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}

	@Override
	public String toString() {
		return "TextDatabaseManager [fileName=" + fileName + ", fileReader="
				+ fileReader + ", line=" + line + ", splitLine="
				+ Arrays.toString(splitLine) + "]";
	}

	/**
	 * Add line to text database.
	 * @param line
	 */
	public void addLine(String line) {
		
	}
	
	/**
	 * Remove line from text database.
	 * @param line
	 */
	public void removeLine(String line) {
		
	}
}
