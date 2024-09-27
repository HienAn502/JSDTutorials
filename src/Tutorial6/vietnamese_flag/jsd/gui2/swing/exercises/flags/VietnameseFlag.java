package Tutorial6.vietnamese_flag.jsd.gui2.swing.exercises.flags;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class VietnameseFlag extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set the background to red
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the yellow star
        g2d.setColor(Color.YELLOW);

        // Get the center of the flag
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // The radius of the star (about 30% of the flag's height)
        int radius = (int) (getHeight() * 0.3);

        // Create the star shape
        GeneralPath star = createStar(centerX, centerY, radius, (int) ((int) getHeight() * 0.1));

        // Fill the star shape
        g2d.fill(star);
    }

    // Method to create a 5-pointed star
    private GeneralPath createStar(int centerX, int centerY, int outerRadius, int innerRadius) {
        GeneralPath star = new GeneralPath();
        double angle = Math.PI / 5; // Angle between points

        // Starting point of the star
        for (int i = 0; i < 10; i++) {
            double r = (i % 2 == 0) ? outerRadius : innerRadius;
            double x = centerX + r * Math.sin(i * angle);
            double y = centerY - r * Math.cos(i * angle);

            if (i == 0) {
                star.moveTo(x, y);
            } else {
                star.lineTo(x, y);
            }
        }
        star.closePath();
        return star;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vietnamese Flag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the VietnameseFlag panel to the frame
        VietnameseFlag flag = new VietnameseFlag();
        frame.add(flag);

        // Set the preferred size of the frame
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
