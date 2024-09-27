package Tutorial5.chess_board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessBoard {

    private JFrame frame;
    private JPanel chessBoardPanel, sidePanel;
    private JTextArea moveHistoryArea;
    private JLabel gameStatusLabel;

    public ChessBoard() {
        // Set up the main frame
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the chessboard panel and the side information panel
        chessBoardPanel = createChessBoard();
        sidePanel = createSidePanel();

        // Add panels to the frame
        frame.add(chessBoardPanel, BorderLayout.CENTER);
        frame.add(sidePanel, BorderLayout.EAST);

        // Set the frame size and make it visible
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    // Method to create the 8x8 chessboard
    private JPanel createChessBoard() {
        JPanel chessBoard = new JPanel(new GridLayout(8, 8));
        boolean isLight = true; // Flag to alternate colors

        // Create 64 squares for the chessboard
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel();

                // Alternate the colors: light (white) and dark (gray)
                if (isLight) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.GRAY);
                }

                chessBoard.add(square); // Add the square to the board
                isLight = !isLight; // Toggle color for next square
            }
            isLight = !isLight; // Toggle color for the next row
        }
        return chessBoard;
    }

    // Method to create the side panel with game information and controls
    private JPanel createSidePanel() {
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

        // Game guidance label
        gameStatusLabel = new JLabel("White's turn");
        gameStatusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(gameStatusLabel);

        // Move history text area
        moveHistoryArea = new JTextArea(10, 20);
        moveHistoryArea.setEditable(false); // Prevent editing
        JScrollPane scrollPane = new JScrollPane(moveHistoryArea); // Add scrolling
        sidePanel.add(scrollPane);

        // Add a small instruction label
        JLabel instructionsLabel = new JLabel("Instructions: Click on a piece to move.");
        instructionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePanel.add(instructionsLabel);

        // Add buttons for game control
        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        sidePanel.add(startButton);

        JButton surrenderButton = new JButton("Surrender");
        surrenderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        surrenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surrenderGame();
            }
        });
        sidePanel.add(surrenderButton);

        return sidePanel;
    }

    // Method to start a new game
    private void startGame() {
        gameStatusLabel.setText("White's turn");
        moveHistoryArea.setText(""); // Clear move history
    }

    // Method to handle surrendering the game
    private void surrenderGame() {
        gameStatusLabel.setText("Game over");
        moveHistoryArea.append("Player surrendered.\n");
    }

    // Main method to run the chessboard application
    public static void main(String[] args) {
        // Run the program in the Swing event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChessBoard(); // Initialize the GUI
            }
        });
    }
}

