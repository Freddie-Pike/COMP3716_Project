package main.gui;

import javax.swing.JFrame;

public class VolleyBallRunner
{
    /**
     Creates the main frame of the program.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        VolleyBallPanel panel = new VolleyBallPanel();
        frame.add(panel);
        frame.setVisible(true);

    }
}
