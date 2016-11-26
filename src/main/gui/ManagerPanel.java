package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ManagerPanel {
	
	// TODO: onClick methods for all buttons.
	// TODO: Populating both combo boxes at runtime.
	// TODO: Maybe add a better way to get the two date fields?

	private JFrame frame;
	private JTextField tournamentName;
	private JTextField startDate;
	private JTextField registrationDeadline;
	private JLabel location;
	private JTextField minTeams;
	private JTextField maxTeams;
	private JComboBox tournamentType;

	/**
	 * Launch the application.
	 */
	public void managerPanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPanel window = new ManagerPanel();
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
	public ManagerPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTournamentName = new JLabel("Tournament Name:");
		lblTournamentName.setBounds(12, 12, 141, 15);
		frame.getContentPane().add(lblTournamentName);
		
		tournamentName = new JTextField();
		tournamentName.setBounds(159, 10, 277, 19);
		frame.getContentPane().add(tournamentName);
		tournamentName.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(12, 41, 141, 15);
		frame.getContentPane().add(lblStartDate);
		
		startDate = new JTextField();
		startDate.setColumns(10);
		startDate.setBounds(159, 39, 199, 19);
		frame.getContentPane().add(startDate);
		
		JLabel lblRegistrationDeadline = new JLabel("Registration Deadline: ");
		lblRegistrationDeadline.setBounds(12, 72, 174, 15);
		frame.getContentPane().add(lblRegistrationDeadline);
		
		registrationDeadline = new JTextField();
		registrationDeadline.setColumns(10);
		registrationDeadline.setBounds(204, 70, 154, 19);
		frame.getContentPane().add(registrationDeadline);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(12, 107, 141, 15);
		frame.getContentPane().add(lblLocation);
		
		location = new JLabel();
		location.setText("France");
		location.setBounds(159, 105, 277, 19);
		frame.getContentPane().add(location);
		
		JLabel lblMinNumberOf = new JLabel("Minimum Teams:");
		lblMinNumberOf.setBounds(12, 136, 141, 15);
		frame.getContentPane().add(lblMinNumberOf);
		
		minTeams = new JTextField();
		minTeams.setColumns(10);
		minTeams.setBounds(159, 134, 277, 19);
		frame.getContentPane().add(minTeams);
		
		JLabel lblMaximumTeams = new JLabel("Maximum Teams:");
		lblMaximumTeams.setBounds(12, 165, 141, 15);
		frame.getContentPane().add(lblMaximumTeams);
		
		maxTeams = new JTextField();
		maxTeams.setColumns(10);
		maxTeams.setBounds(159, 163, 277, 19);
		frame.getContentPane().add(maxTeams);
		
		JLabel lblTournamentType = new JLabel("Tournament Type:");
		lblTournamentType.setBounds(12, 194, 141, 15);
		frame.getContentPane().add(lblTournamentType);
		
		tournamentType = new JComboBox();
		tournamentType.setBounds(159, 192, 277, 19);
		frame.getContentPane().add(tournamentType);
		
		JLabel lblDdmmyy = new JLabel("dd/mm/yy");
		// lblDdmmyy.setBounds(364, 72, 72, 15);
		// frame.getContentPane().add(lblDdmmyy);
		
		JLabel label = new JLabel("dd/mm/yy");
		label.setBounds(364, 41, 72, 15);
		frame.getContentPane().add(label);
		
		JButton btnSubmitTournament = new JButton("Submit Tournament");
        btnSubmitTournament.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		String randomText = UUID.randomUUID().toString();
        		String tournamentRandomName = "Game_BasicInfo_" + randomText;
        		String tournamentNameContent = tournamentName.getText();
        		String minTeamsContent = minTeams.getText();
        		String maxTeamsContent = maxTeams.getText();
        		String registrationDeadlineContent = registrationDeadline.getText();
        		TextDatabaseTools tournamentListing = new TextDatabaseTools("Tournament_Listing");
        		tournamentListing.addRow(tournamentRandomName + "/" + tournamentNameContent + "/" + "Steve/" + minTeamsContent 
        				+ "/" + maxTeamsContent + "/" + registrationDeadlineContent);
        		ArrayList<String> tempArrayList = new ArrayList<String>();
        		TextDatabaseTools gameData = new TextDatabaseTools("Game_123");
        		tempArrayList = gameData.grabColumnDataAsArrayList(0);
        		
        		String[] tempArray = new String[10];
        		for (int i = 0; i < tempArrayList.size(); i++) {
        			tempArray[i] = tempArrayList.get(i);
        			System.out.println(tempArray[i]);
        		}
        		ListTeams.listTeams(tempArray);

        	}
        });
        btnSubmitTournament.setBounds(128, 255, 206, 25);
        frame.getContentPane().add(btnSubmitTournament);
	}
}