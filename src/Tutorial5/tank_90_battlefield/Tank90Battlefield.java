package Tutorial5.tank_90_battlefield;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tank90Battlefield {
    private final String BASEURL = "src/Tutorial5/tank_90_battlefield/";
    private final JPanel battlefieldPanel;
    private JLayeredPane layeredPane;

    private final int MAP_ROWS = 24;  // Number of rows in the map
    private final int MAP_COLS = 26;  // Number of columns in the map
    private final int CELL_SIZE = 20; // Size of each map block in pixels
    private final int TANK_SIZE = CELL_SIZE * 4; // Tank size (4x4 blocks)

    // Paths to your images
    private final String BRICK_IMAGE = BASEURL + "images/map_blocks/brick.gif";
    private final String GRASS_IMAGE = BASEURL + "images/map_blocks/grass.gif";
    private final String STONE_IMAGE = BASEURL + "images/map_blocks/stone.gif";
    private final String WATER_IMAGE = BASEURL + "images/map_blocks/water.gif";
    private final String TANK_IMAGE = BASEURL + "images/tanks/green-tank-up.gif"; // Tank image (80x80)

    private JLabel tankLabel;  // JLabel to represent the tank

    public Tank90Battlefield() {
        // Set up the main game window
        JFrame frame = new JFrame("Tank 90 Battlefield");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 520); // Adjust the size according to the map size

        // Create a layered pane to hold the map and the tank
        layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        // Set up the battlefield panel
        battlefieldPanel = new JPanel(new GridLayout(MAP_ROWS, MAP_COLS));
        battlefieldPanel.setBounds(0, 0, MAP_COLS * CELL_SIZE, MAP_ROWS * CELL_SIZE);

        // Set the panel background to black
        battlefieldPanel.setBackground(Color.BLACK);

        // Load the map from the .map file and render it
        loadMap("src/Tutorial5/tank_90_battlefield/battlefield.map");

        // Add the map to the lowest layer of the layered pane
        layeredPane.add(battlefieldPanel, JLayeredPane.DEFAULT_LAYER);

        // Add the tank on a valid position on the map
        addTankToMap(170, 420);  // Example starting position

        // Display the frame
        frame.setVisible(true);
    }

    // Method to load the map and render it on the battlefield
    private void loadMap(String mapFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(mapFilePath))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < MAP_ROWS) {
                for (int col = 0; col < Math.min(line.length(), MAP_COLS); col++) {
                    char cell = line.charAt(col);
                    JLabel mapCell = new JLabel();
                    mapCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));

                    // Set different components (brick, grass, stone, water) based on the map file
                    switch (cell) {
                        case 'B': // Brick
                            mapCell.setIcon(new ImageIcon(BRICK_IMAGE));
                            break;
                        case 'G': // Grass
                            mapCell.setIcon(new ImageIcon(GRASS_IMAGE));
                            break;
                        case 'S': // Stone
                            mapCell.setIcon(new ImageIcon(STONE_IMAGE));
                            break;
                        case 'W': // Water
                            mapCell.setIcon(new ImageIcon(WATER_IMAGE));
                            break;
                        default: // Empty space
                            mapCell.setOpaque(true);
                            mapCell.setBackground(Color.BLACK);
                            break;
                    }
                    battlefieldPanel.add(mapCell); // Add the JLabel to the battlefield panel
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add the tank to a valid position
    private void addTankToMap(int xPos, int yPos) {
        tankLabel = new JLabel();
        tankLabel.setIcon(new ImageIcon(TANK_IMAGE));  // Load tank image
        tankLabel.setBounds(xPos, yPos, TANK_SIZE, TANK_SIZE);  // Set tank position and size

        // Add the tank to a higher layer, so it appears on top of the map
        layeredPane.add(tankLabel, JLayeredPane.PALETTE_LAYER);

        // Repaint the panel to update the display
        layeredPane.repaint();
    }


    // Main method to start the game interface
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tank90Battlefield(); // Initialize the game interface
            }
        });
    }
}
