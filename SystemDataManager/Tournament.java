
public class Tournament {
	private int tournamentID;
	private String organizer;
	
	public Tournament(int tournamentID, String organizer) {
		this.tournamentID = tournamentID;
		this.organizer = organizer;
	}

	@Override
	public String toString() {
		return "Tournament [tournamentID=" + tournamentID + ", organizer="
				+ organizer + "]";
	}
	
	public int getTournamentID() {
		return tournamentID;
	}
	
	public String getOrganizer() {
		return organizer;
	}
	
	
}
