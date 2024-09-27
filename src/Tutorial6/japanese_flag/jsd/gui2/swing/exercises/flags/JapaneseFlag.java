package Tutorial6.japanese_flag.jsd.gui2.swing.exercises.flags;


import javax.swing.*;
import java.awt.*;

public class JapaneseFlag extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the red circle (the sun)
        g.setColor(Color.RED);

        // Calculate the center of the flag
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Diameter of the circle should be about 60% of the flag's height
        int diameter = (int) (getHeight() * 0.6);

        // Draw the circle
        g.fillOval(centerX - diameter / 2, centerY - diameter / 2, diameter, diameter);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Japanese Flag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the JapaneseFlag panel to the frame
        JapaneseFlag flag = new JapaneseFlag();
        frame.add(flag);

        // Set the preferred size of the frame
        frame.setSize(600, 400); // Wider than it is tall
        frame.setVisible(true);
    }
}