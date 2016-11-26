package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterTeam {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void registerTeam() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterTeam window = new RegisterTeam();
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
	public RegisterTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegisterTeam = new JLabel("Register Team ");
		lblRegisterTeam.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRegisterTeam.setBounds(164, 11, 126, 14);
		frame.getContentPane().add(lblRegisterTeam);
		
		JLabel lblTeamId = new JLabel("Team ID");
		lblTeamId.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTeamId.setBounds(46, 46, 60, 14);
		frame.getContentPane().add(lblTeamId);
		
		textField = new JTextField();
		textField.setBounds(164, 44, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTeamName.setBounds(46, 88, 86, 14);
		frame.getContentPane().add(lblTeamName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 86, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Register");
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSubmit.setBounds(164, 130, 113, 23);
		frame.getContentPane().add(btnSubmit);
	}

}