package main.gui;

import javax.swing.JFrame;

public class LoginRunner
{
    /**
     Creates the main frame of the program.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        LoginPanel panel = new LoginPanel();
        frame.add(panel);
        frame.setVisible(true);

    }
}
