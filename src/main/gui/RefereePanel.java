package main.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class RefereePanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void launchRefereePanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefereePanel window = new RefereePanel();
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
	public RefereePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        JFrame frame = new JFrame("Referee Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        LoginPanel panel = new LoginPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
	}

}
