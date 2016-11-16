interface DatabaseManager {
	/**
	 * Print out entire contents of the text file.
	 */
	public void PrintContents();
	
	/**
	 * Print out the contents of a column of information from the text file.
	 * @param column
	 */
	public void PrintContentsByColumn(int column);
	
	/**
	 * Print out the contents of the text file if this name is found in the textfile.
	 * @param column
	 */
	public void PrintContentsBySearchValue(String searchValue, int column);

	/**
	 * Find match by search value. 
	 * @param searchValue
	 * @param column
	 * @return
	 */
	public boolean FindMatchByColumn(String searchValue, int column);

	/**
	 * Add line to text database.
	 * @param line
	 */
	public void addLine(String line);
	
	/**
	 * Remove line from text database.
	 * @param line
	 */
	public void removeLine(String line);
}
