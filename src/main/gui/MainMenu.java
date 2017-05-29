package main.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	/**
	 * Launch the application.
	 */
	public static void launchMainMenu(USER currentUser, JFrame prevFrame, ArrayList<String> databaseIDs) {
        MainMenu panel = new MainMenu(currentUser, prevFrame, databaseIDs);
        panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.frame.setSize(300, 275);
        panel.frame.setResizable(false); // let's not allow this
        panel.frame.setLocationRelativeTo(null); // center the window
        panel.setBackground(Color.LIGHT_GRAY);
        panel.frame.getContentPane().add(panel);
        panel.frame.setVisible(true);
	}

    private JButton myTournamentButton;
    private JButton createTournamentButton;
    private JLabel Header;
    private JButton viewTournamentsButton;
    private JButton logoutButton;
    JFrame frame = new JFrame("Main Menu");
    public String userName;
    public JFrame prevFrame;
    public USER currentUser;
    private ArrayList<String> databaseIDs;
    
	public enum USER {
		MANAGER, COACH, REFEREE, SPECTATOR
	}


    private MainMenu(USER currentUser, JFrame prevFrame, ArrayList<String> databaseIDs)
    {
    	this.prevFrame = prevFrame;
    	this.currentUser = currentUser;
    	this.databaseIDs = databaseIDs;
    	
    	System.out.println(databaseIDs);
        setBackground(Color.LIGHT_GRAY);
        Header = new JLabel("Volleyball Tournament v0.1");
        Header.setFont(new Font("Georgia", Font.BOLD, 16));
        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CreateTournamentPage.launchPage(databaseIDs);
        		frame.setVisible(false);
        	}
        });
        viewTournamentsButton = new JButton("View Tournaments");
        viewTournamentsButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		TournamentListing.launchPage(currentUser, prevFrame, databaseIDs);
        		frame.setVisible(false);
        	}
        });
        logoutButton = new JButton("Switch " + currentUser);
        logoutButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		LoginPagePanel panel = new LoginPagePanel();
        		panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel.frame.setSize(300, 275);
                panel.frame.setResizable(false); // let's not allow this shitshow
                panel.frame.setLocationRelativeTo(null); // center the window
                panel.setBackground(Color.LIGHT_GRAY);
                panel.frame.getContentPane().add(panel);
                panel.frame.setVisible(true);
        		frame.setVisible(false);
        	}
        });
        JPanel createTournamentPanel = new JPanel();
        JPanel viewTournamentsPanel = new JPanel();
        JPanel logoutPanel = new JPanel();
        createTournamentPanel.setPreferredSize(new Dimension(200,35));
        viewTournamentsPanel.setPreferredSize(new Dimension(200,35));
        logoutPanel.setPreferredSize(new Dimension(200,35));
        
        createTournamentPanel.add(createTournamentButton);
        viewTournamentsPanel.add(viewTournamentsButton);
        logoutPanel.add(logoutButton);
        add(Header);
        if (currentUser == USER.MANAGER) {add(createTournamentPanel);} // only add a "create tournament" menu for organizers
        add(viewTournamentsPanel);
        add(logoutPanel);
    }

}