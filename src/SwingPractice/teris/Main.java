package SwingPractice.teris;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Teris");

        // Window closed then program ended.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Window size is fixed
        window.setResizable(false);

        // Don't set specific location on the screen
        window.setLocationRelativeTo(null);

        // Window is visible (required for window to display)
        window.setVisible(true);


    }
}
