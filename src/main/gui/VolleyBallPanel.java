package main.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VolleyBallPanel extends JPanel {
	
	private String[] dummyOptions = {"Freddie", "Canberk", "Josh", "Caroline", "Devin", "Tyler"};

    private JButton managerButton;
    private JButton coachButton;
    private JLabel Header;
    private JButton refereeButton;
    private JButton playerButton;
    private enum USER {
    	 MANAGER, COACH, REFEREE, PLAYER
    	}
    private JLabel spacer = new JLabel("     ");
    private USER userType;
    JFrame frame = new JFrame("Main Menu");
    public String userName;
    
    private JTextField newUserName = new JTextField(10); // used in drop down menu


    public VolleyBallPanel()
    {
        setBackground(Color.LIGHT_GRAY);
        Header = new JLabel("Volleyball Tournament v0.1");
        Header.setFont(new Font("Georgia", Font.BOLD, 16));
        managerButton = new JButton("Manager");
        managerButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		userType = USER.MANAGER;
        		dropDownMenu(dummyOptions);
        	}
        });
        coachButton = new JButton("Coach");
        coachButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		userType = USER.COACH;
        		dropDownMenu(dummyOptions);
        	}
        });
        refereeButton = new JButton("Referee");
        refereeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		userType = USER.REFEREE;
        		dropDownMenu(dummyOptions);
        	}
        });
        playerButton = new JButton("Player");
        playerButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		userType = USER.PLAYER;
        		dropDownMenu(dummyOptions);
        	}
        });
        JPanel coachPanel = new JPanel();
        JPanel managerPanel = new JPanel();
        JPanel refereePanel = new JPanel();
        JPanel playerPanel = new JPanel();
        coachPanel.setPreferredSize(new Dimension(200,35));
        managerPanel.setPreferredSize(new Dimension(200,35));
        refereePanel.setPreferredSize(new Dimension(200,35));
        playerPanel.setPreferredSize(new Dimension(200,35));
        managerPanel.add(managerButton);
        coachPanel.add(coachButton);
        refereePanel.add(refereeButton);
        playerPanel.add(playerButton);
        add(Header);
        add(managerPanel);
        add(coachPanel);
        add(refereePanel);
        add(playerPanel);
    }
    
    public void dropDownMenu(String[] options) {
    	
    	removeAll();
    	repaint();
    	revalidate();
    	
    	// Logging in to existing user panel is created here
    	
    	JLabel existingUserHeader;
        JLabel existingUsernameLabel;
        JLabel existingPasswordLabel;
        JTextField existingUserPassword;
        JComboBox existingUserComboBox = new JComboBox();
        JButton existingUserButton;
        JPanel existingUserPanel = new JPanel();
    	
        for(int i = 0; i < options.length; i++)
        	existingUserComboBox.addItem(options[i]);
        existingUserHeader = new JLabel("Please log in to continue!");
        existingUserPanel.setPreferredSize(new Dimension(280,100));
        existingUserHeader.setFont(new Font("Georgia", Font.BOLD, 16));
        existingUsernameLabel = new JLabel("Username: ");
        existingPasswordLabel = new JLabel("Password: ");
        existingUserButton = new JButton("Log in!");
        existingUserButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String selectedUser = String.valueOf(existingUserComboBox.getSelectedItem());
        		launchInterface(selectedUser);
        	}
        });
        // existingUserPassword = new JTextField(15);
        existingUserComboBox.setSelectedIndex(0);
        existingUserPanel.add(existingUsernameLabel);
        existingUserPanel.add(existingUserComboBox);
        existingUserPanel.add(spacer, "span, grow");
        // existingUserPanel.add(existingPasswordLabel);
        // existingUserPanel.add(existingUserPassword);
        existingUserPanel.add(existingUserButton);
        add(existingUserHeader);
        add(existingUserPanel);
    	
    	// User creation panel is created here
    	
    	JLabel createUserHeader;
        JLabel createUserLabel;
        JButton createUserButton;
    	
        createUserHeader = new JLabel("Don't see your name here?");
        JPanel createUserPanel = new JPanel();
        createUserPanel.setPreferredSize(new Dimension(280,75));
        createUserHeader.setFont(new Font("Georgia", Font.BOLD, 16));
        createUserLabel = new JLabel("Username:");
        createUserButton = new JButton("Create User!");
        createUserButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String selectedUser = newUserName.getText();
        		createUser(selectedUser);
        	}
        });
        createUserPanel.add(createUserLabel);
        createUserPanel.add(newUserName);
        createUserPanel.add(createUserButton);
        add(createUserHeader);
        add(createUserPanel);
    	
    }
    
    public void launchInterface(String name) {
    	
    	userName = name;
    	
    	switch(userType) {
    	
    	case MANAGER: 
    		ManagerPanel managerPanel = new ManagerPanel();
    		managerPanel.managerPanel();
    		frame.setVisible(false);
    		break;
    		
    	case COACH:
    		System.out.println("launchInterface(" + name + ") as a COACH called.");
    		break;
    		
    	case REFEREE:
    		System.out.println("launchInterface(" + name + ") as a REFEREE called.");
    		break;
    	
    	case PLAYER:
    		System.out.println("launchInterface(" + name + ") as a PLAYER called.");
    		break;
    	
    	}
    	
    }
    
    public void createUser(String name) {
    	
    	System.out.println("createUser(" + name + ") called.");
    	launchInterface(name);
    	
    }
}
