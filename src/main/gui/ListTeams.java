package main.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ListTeams {
	
	private JFrame frame;
	private JLabel[] fields;
	private int longestLine = 0;

	/**
	 * Launch the application.
	 */
	public static void listTeams(String[] lines) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListTeams window = new ListTeams(lines);
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
	public ListTeams(String[] lines) {
		fields = new JLabel[lines.length];
		initialize(lines);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] lines) {
		frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		int height = (int) ((11 * lines.length) + 110);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int i = 0;i < lines.length;i++) {
			String line = lines[i];
			if (line == null) break;
			JLabel textField = new JLabel();
			textField.setText(line);
			if (longestLine < line.length()) longestLine = line.length();
			fields[i] = textField;
			frame.getContentPane().add(fields[i]);
		}
		
		double dblWidth = (longestLine * 7.6);
		int width = (int) dblWidth;
		if (width < 300) width = 300;
		frame.setBounds(100, 100, width, height);
		
		frame.getContentPane().add(new JLabel(" ")); // add a blank label to space things out
		
		JLabel lblTheDeadlineHas = new JLabel("The deadline has not been met yet.");
		frame.getContentPane().add(lblTheDeadlineHas);
		
		JButton btnSubmitTournament = new JButton("Submit Tournament");
        btnSubmitTournament.setBounds(128, 255, 206, 25);
        frame.getContentPane().add(btnSubmitTournament);
        btnSubmitTournament.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		Pair[] stuffArray = new Pair[4];
            	stuffArray[0] = new Pair();
            	stuffArray[1] = new Pair();
            	stuffArray[2] = new Pair();
            	stuffArray[3] = new Pair();
            	stuffArray[0].firstString = "Thedf,gsdjrghskjlergh kjlearhglesrghkjlsdagfjlarfiu";
            	stuffArray[0].secondString = "StuffThedf,gakjfehfkrjgbsajdbfetlgaerhlgvvvvvvvvjaelaerjlkgaerj;ighe;akrjgjaewhgkjaerarkjhaegtsdjrghskjlergh kjlearhglesrghkjlsdagfjlarfiulewagfasgfjlaerw wiulfguiaewlfgae";
            	stuffArray[1].firstString = "test";
            	stuffArray[1].secondString = "testtest";
            	stuffArray[2].firstString = "test tes tetesttest";
            	stuffArray[2].secondString = "kietjhwaiuetrh";
            	stuffArray[3].firstString = "aewothaierhtendIndex";
            	stuffArray[3].secondString = "oiajgrioerhgiashfiuaerhg";
            	Brackets.brackets("Tournament Name Title", stuffArray);

        	}
        });

	}

}
