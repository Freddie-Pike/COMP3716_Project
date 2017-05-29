package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.gui.MainMenu.USER;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TournamentListing {

	private JFrame frame;
	private JTable table;
	
	private JFrame prevFrame;
    private USER currentUser;
    private ArrayList<String> databaseIDs;

	/**
	 * Launch the application.
	 */
	public static void launchPage(USER currentUser, JFrame prevFrame, ArrayList<String> databaseIDs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TournamentListing window = new TournamentListing(currentUser, prevFrame, databaseIDs);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private TournamentListing(USER currentUser, JFrame prevFrame, ArrayList<String> databaseIDs) {
		this.currentUser = currentUser;
		this.prevFrame = prevFrame; 
		this.databaseIDs = databaseIDs;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String[] columns = new String[] {"Tournament Name", "Organizer Name", "Min. Teams" ,"Max. Teams", "Deadline"};
		
		TextDatabaseTools dataTextFile = new TextDatabaseTools("Tournament_Listing");
		
		ArrayList<String> tournamentNameList = dataTextFile.grabColumnDataAsArrayList(1);
		ArrayList<String> organizerNameList = dataTextFile.grabColumnDataAsArrayList(2);
		ArrayList<String> minTeamsList = dataTextFile.grabColumnDataAsArrayList(3);
		ArrayList<String> maxTeamsList = dataTextFile.grabColumnDataAsArrayList(4);
		ArrayList<String> deadLineList = dataTextFile.grabColumnDataAsArrayList(columns.length);
		
		System.out.println(deadLineList);
		
		String[][] data = new String[deadLineList.size()+1][5];
		
		
        for (int i = 0; i < tournamentNameList.size(); i++) {
        	data[i][0] = tournamentNameList.get(i);
			data[i][1] = organizerNameList.get(i);
			data[i][2] = minTeamsList.get(i);
			data[i][3] = maxTeamsList.get(i);
			data[i][4] = deadLineList.get(i);
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 50, 435, 325);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblTournamentListing = new JLabel("Tournament Listing");
		lblTournamentListing.setBounds(145, 12, 138, 15);
		frame.getContentPane().add(lblTournamentListing);
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu.launchMainMenu(currentUser, prevFrame, deadLineList);
				frame.setVisible(false);
			}
		});
		btnReturn.setBounds(135, 388, 194, 25);
		frame.getContentPane().add(btnReturn);
	}
}
