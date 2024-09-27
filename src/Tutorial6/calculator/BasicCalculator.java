package Tutorial6.calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator extends JFrame {

    private JTextField display;
    private double result = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public BasicCalculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the display
        display = new JTextField("0", 15);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Create the number and operator buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            addButton(buttonPanel, label);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Options Menu
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clear());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        optionsMenu.add(clearItem);
        optionsMenu.add(exitItem);
        menuBar.add(optionsMenu);

        // Window Menu (Look and Feel)
        JMenu windowMenu = new JMenu("Window");
        String[] looks = { "Metal", "Nimbus", "Windows" };
        for (String look : looks) {
            JMenuItem lookItem = new JMenuItem(look);
            lookItem.addActionListener(e -> changeLookAndFeel(look));
            windowMenu.add(lookItem);
        }
        menuBar.add(windowMenu);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        // Add the menu bar to the frame
        setJMenuBar(menuBar);
    }

    // Method to add a button to the panel
    private void addButton(JPanel panel, String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.addActionListener(new ButtonListener());
        panel.add(button);
    }

    // Method to handle button clicks
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                if (startNewNumber) {
                    display.setText(command);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if ("+-*/".contains(command)) {
                calculate(Double.parseDouble(display.getText()));
                operator = command;
                startNewNumber = true;
            } else if (command.equals("=")) {
                calculate(Double.parseDouble(display.getText()));
                operator = "";
                startNewNumber = true;
            }
        }
    }

    // Method to perform calculations
    private void calculate(double x) {
        switch (operator) {
            case "+" -> result += x;
            case "-" -> result -= x;
            case "*" -> result *= x;
            case "/" -> result /= x;
            default -> result = x;
        }
        display.setText("" + result);
    }

    // Clear the display and reset
    private void clear() {
        result = 0;
        operator = "";
        display.setText("0");
        startNewNumber = true;
    }

    // Change the look and feel of the application
    private void changeLookAndFeel(String look) {
        try {
            switch (look) {
                case "Metal" -> UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                case "Nimbus" -> UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                case "Windows" -> UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Show the About dialog
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this,
                "Basic Calculator\nVersion 1.0\nCreated using Java Swing",
                "About Basic Calculator",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BasicCalculator calculator = new BasicCalculator();
            calculator.setVisible(true);
        });
    }
}
