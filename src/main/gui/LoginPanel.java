package main.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel
{
	private JLabel Header;
    private JLabel Q;
    private JTextField UserName;
    private String[] languages = {
            "Player", "Tournament Organiser", "Referee", "Tournament Manager",
            "Coach"
    };
    private JComboBox comboBox = new JComboBox();
    private int count = 0;
    private JButton Submit;

    public LoginPanel()
    {
        setBackground(Color.LIGHT_GRAY);
        for(int i = 0; i < languages.length; i++)
            comboBox.addItem(languages[i]);
        Header = new JLabel("Welcome to the Login Page");
        Font f = new Font("Georgia", Font.BOLD, 16);
        JPanel DatLogin = new JPanel();
        DatLogin.setPreferredSize(new Dimension(280,110));
        Header.setFont(new Font("Georgia", Font.BOLD, 16));
        Q = new JLabel("Enter your name:");
        Submit = new JButton("Submit");
        UserName = new JTextField(15);
        DatLogin.add(Q);
        DatLogin.add(UserName);
        comboBox.setSelectedIndex(0);
        DatLogin.add(comboBox);
        DatLogin.add(Submit);
        add(Header);
        add(DatLogin);
    }
}