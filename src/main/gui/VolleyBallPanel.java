package main.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VolleyBallPanel extends JPanel
{

    private JButton CreateBrack;
    private JButton CreateTourn;
    private JLabel Header;
    private JButton AddTeam;
    private JButton Login;
    private JLabel CT;
    private JLabel CB;
    private JLabel AT;
    private JLabel SI;


    public VolleyBallPanel()
    {
        setBackground(Color.blue);
        Header = new JLabel("Welcome to our Volley Ball Tournament Main Menu");
        CT = new JLabel("Click to create a tournament");
        CB = new JLabel("Click to create a Bracket");
        AT = new JLabel("Click to create a new team");
        SI = new JLabel("Click to log in here");
        Font f = new Font("Comic Sans MS", Font.BOLD, 16);
        Header.setFont(f);
        CT.setFont(f);
        CB.setFont(f);
        AT.setFont(f);
        SI.setFont(f);
        CreateBrack = new JButton("Create A Bracket");
        CreateTourn = new JButton("Create A New Tournament");
        AddTeam = new JButton("Add a Team");
        Login = new JButton("Login Here");
        JPanel CreateTournamentPanel = new JPanel();
        JPanel CreateBracket = new JPanel();
        JPanel AddTeamPanel = new JPanel();
        JPanel LoginPanel = new JPanel();
        CreateTournamentPanel.setPreferredSize(new Dimension(280,80));
        CreateBracket.setPreferredSize(new Dimension(280,80));
        AddTeamPanel.setPreferredSize(new Dimension(280,80));
        LoginPanel.setPreferredSize(new Dimension(220,80));
        CreateBracket.add(CB);
        CreateBracket.add(CreateBrack);
        CreateTournamentPanel.add(CT);
        CreateTournamentPanel.add(CreateTourn);
        AddTeamPanel.add(AT);
        AddTeamPanel.add(AddTeam);
        LoginPanel.add(SI);
        LoginPanel.add(Login);
        add(Header);
        add(CreateBracket);
        add(CreateTournamentPanel);
        add(AddTeamPanel);
        add(LoginPanel);
    }
}