package Tutorial5.current_time_clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CurrentTimeClock {
    private JFrame frame;
    private JLabel timeLabel;
    private Timer timer;

    public CurrentTimeClock() {
        // Create the main window (JFrame)
        frame = new JFrame("Current Time Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the time label (JLabel) with center alignment
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 48)); // Set font size for the clock
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the label to the frame
        frame.add(timeLabel, BorderLayout.CENTER);

        // Set the frame size and make it visible
        frame.setSize(400, 200);
        frame.setVisible(true);

        // Start the clock timer to update the time every second
        startClock();
    }

    // Method to start the timer that updates the time every second
    private void startClock() {
        // Define the timer action to update the time label
        ActionListener updateClockAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current time and format it as HH:mm:ss
                LocalTime currentTime = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String timeString = currentTime.format(formatter);

                // Update the time label with the current time
                timeLabel.setText(timeString);
            }
        };

        // Create a timer that triggers every 1000ms (1 second)
        timer = new Timer(1000, updateClockAction);
        timer.start(); // Start the timer
    }

    // Main method to run the clock application
    public static void main(String[] args) {
        // Run the program in the Swing event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrentTimeClock(); // Initialize the GUI
            }
        });
    }
}
