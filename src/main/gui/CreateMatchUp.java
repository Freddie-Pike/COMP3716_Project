package main.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
// import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;

public class CreateMatchUp {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMatchUp window = new CreateMatchUp();
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
	public CreateMatchUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateMatchup = new JLabel("Create Match-Up");
		lblCreateMatchup.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCreateMatchup.setBounds(167, 11, 137, 25);
		frame.getContentPane().add(lblCreateMatchup);
		
		JLabel lblSelectReferee = new JLabel("Location:");
		lblSelectReferee.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSelectReferee.setBounds(26, 86, 91, 19);
		frame.getContentPane().add(lblSelectReferee);
		
		JLabel lblSelectReferee_1 = new JLabel("Select Referee:");
		lblSelectReferee_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSelectReferee_1.setBounds(26, 56, 133, 19);
		frame.getContentPane().add(lblSelectReferee_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 57, 160, 19);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTime.setBounds(26, 136, 91, 19);
		frame.getContentPane().add(lblTime);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDate.setBounds(26, 166, 91, 19);
		frame.getContentPane().add(lblDate);
		
		/**
		JCalendar calendar = new JCalendar();
		calendar.setBounds(177, 166, 198, 153);
		frame.getContentPane().add(calendar);
		*/
		
		textField = new JTextField();
		textField.setBounds(177, 136, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(177, 338, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("France");
		lblNewLabel.setBounds(177, 86, 160, 19);
		frame.getContentPane().add(lblNewLabel);
	}
}