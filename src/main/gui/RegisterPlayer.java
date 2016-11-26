package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterPlayer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPlayer window = new RegisterPlayer();
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
	public RegisterPlayer() {
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
		
		JLabel lblRegisterPlayer = new JLabel("Register Player");
		lblRegisterPlayer.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRegisterPlayer.setBounds(167, 11, 110, 14);
		frame.getContentPane().add(lblRegisterPlayer);
		
		JLabel lblPlayerId = new JLabel("Player ID:");
		lblPlayerId.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPlayerId.setBounds(47, 43, 69, 14);
		frame.getContentPane().add(lblPlayerId);
		
		textField = new JTextField();
		textField.setBounds(167, 41, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPlayerName.setBounds(47, 79, 102, 14);
		frame.getContentPane().add(lblPlayerName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 77, 167, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStarRating = new JLabel("Star Rating:");
		lblStarRating.setFont(new Font("Dialog", Font.BOLD, 12));
		lblStarRating.setBounds(47, 120, 102, 14);
		frame.getContentPane().add(lblStarRating);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 118, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnRegisterPlayer = new JButton("Register Player");
		btnRegisterPlayer.setFont(new Font("Dialog", Font.BOLD, 12));
		btnRegisterPlayer.setBounds(134, 166, 153, 23);
		frame.getContentPane().add(btnRegisterPlayer);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Dialog", Font.BOLD, 12));
		btnReturn.setBounds(167, 204, 89, 23);
		frame.getContentPane().add(btnReturn);
	}

}