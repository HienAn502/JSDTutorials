package SwingPractice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PracticeFrame extends JFrame {
    public PracticeFrame() {
        ImageIcon icon = new ImageIcon("src/SwingPractice/cat.jpg");
        // Set size
//        this.setSize(400, 500);
        this.setTitle("Title");
        this.setIconImage(icon.getImage()); // change icon of window
//        this.setResizable(false); // prevent frame from resize


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // exit program when close window
        // Make frame visible
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xffdddd));
//        this.setLayout(null);

        JLabel label = getjLabel(icon);

        this.add(label);
        this.pack();

    }

    private static JLabel getjLabel(ImageIcon icon) {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        JLabel label = new JLabel(); // create a label
        label.setText("HI");
        label.setIcon(icon);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setForeground(Color.BLUE);
        label.setBackground(new Color(0xffffff));
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setIconTextGap(10);
        label.setOpaque(true); // to display background color (it takes whole screen)
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
//        label.setBounds(0, 0, 200, 250);
        return label;
    }
}
