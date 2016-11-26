package main.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Brackets {
	
	private JFrame frame;
	private JLabel[] fields;
	private int longestLine = 0;

	/**
	 * Launch the application.
	 */
	public static void brackets(String title, Pair[] lines) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brackets window = new Brackets(title, lines);
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
	public Brackets(String title, Pair[] lines) {
		fields = new JLabel[lines.length];
		initialize(title, lines);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String title, Pair[] lines) {
		frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		int height = (int) ((11.5 * lines.length * 2 * 2.5) + 115); // we multiply by 11 because each line is roughly 11 pixels. themultiplication by 2 is because each "line" now is actually two lines, the 3 is because of the spaces and the "vs" text. the 112 ensures that we have enough room for other components
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("<html><div style='text-align: center;'>" + title + "</div></html>", SwingConstants.CENTER);
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitle);
		frame.getContentPane().add(new JLabel(" ")); // add a blank label to space things out
		frame.getContentPane().add(new JLabel(" ")); // add a blank label to space things out
		
		for (int i = 0;i < lines.length;i++) {
			String line = "<html>" + lines[i].firstString + "<br> vs <br>" + lines[i].secondString + "</html>";
			JLabel textField = new JLabel();
			textField.setText(line);
			if (lines[i].firstString == null) break;
			if (lines[i].secondString == null) break;
			longestLine = Math.max(longestLine, lines[i].firstString.length());
			longestLine = Math.max(longestLine, lines[i].secondString.length());
			fields[i] = textField;
			frame.getContentPane().add(fields[i]);
			frame.getContentPane().add(new JLabel(" ")); // add a blank label to space things out
		}
		
		double dblWidth = (longestLine * 7.6);
		int width = (int) dblWidth;
		if (width < 300) width = 300;
		frame.setBounds(100, 100, width, height);
		
		JButton btnStartTournament = new JButton("Generate Matchups");
		frame.getContentPane().add(btnStartTournament);
	}

}