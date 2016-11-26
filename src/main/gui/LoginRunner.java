package main.gui;

import javax.swing.JFrame;
import java.awt.Color;

public class LoginRunner
{
    /**
     Creates the main frame of the program.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        LoginPanel panel = new LoginPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
}
