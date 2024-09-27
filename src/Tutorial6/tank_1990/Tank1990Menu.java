package Tutorial6.tank_1990;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tank1990Menu extends JFrame {
    private JPanel gamePanel;

    public Tank1990Menu() {
        // Set up the main game window
        setTitle("Tank 1990");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the game panel (where the game would be rendered)
        gamePanel = new JPanel();
        add(gamePanel);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Game Menu
        JMenu gameMenu = new JMenu("Game");

        JMenuItem newGameItem = new JMenuItem("New Game");
        newGameItem.addActionListener(e -> startNewGame());
        gameMenu.add(newGameItem);

        JMenuItem pauseItem = new JMenuItem("Pause");
        pauseItem.addActionListener(e -> pauseGame());
        gameMenu.add(pauseItem);

        JMenuItem resumeItem = new JMenuItem("Resume");
        resumeItem.addActionListener(e -> resumeGame());
        gameMenu.add(resumeItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        gameMenu.add(exitItem);

        menuBar.add(gameMenu);

        // Settings Menu
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem difficultyItem = new JMenuItem("Change Difficulty");
        difficultyItem.addActionListener(e -> changeDifficulty());
        settingsMenu.add(difficultyItem);

        JMenuItem controlsItem = new JMenuItem("Controls");
        controlsItem.addActionListener(e -> showControls());
        settingsMenu.add(controlsItem);

        menuBar.add(settingsMenu);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        // Add the menu bar to the frame
        setJMenuBar(menuBar);

        // Make the frame visible
        setVisible(true);
    }

    // Placeholder for starting a new game
    private void startNewGame() {
        JOptionPane.showMessageDialog(this, "New Game Started!");
    }

    // Placeholder for pausing the game
    private void pauseGame() {
        JOptionPane.showMessageDialog(this, "Game Paused.");
    }

    // Placeholder for resuming the game
    private void resumeGame() {
        JOptionPane.showMessageDialog(this, "Game Resumed.");
    }

    // Placeholder for changing difficulty
    private void changeDifficulty() {
        String[] difficulties = {"Easy", "Medium", "Hard"};
        String difficulty = (String) JOptionPane.showInputDialog(this,
                "Select Difficulty Level:", "Change Difficulty",
                JOptionPane.QUESTION_MESSAGE, null, difficulties, difficulties[0]);

        if (difficulty != null) {
            JOptionPane.showMessageDialog(this, "Difficulty set to: " + difficulty);
        }
    }

    // Placeholder for showing controls
    private void showControls() {
        JOptionPane.showMessageDialog(this, "Controls:\nW - Move Up\nA - Move Left\nS - Move Down\nD - Move Right");
    }

    // Placeholder for showing About dialog
    private void showAbout() {
        JOptionPane.showMessageDialog(this, "Tank 1990\nVersion 1.0\nCreated by Your Name.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tank1990Menu());
    }
}

