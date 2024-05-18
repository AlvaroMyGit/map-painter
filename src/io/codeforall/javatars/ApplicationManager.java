package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    private final Grid GRID;
    private final int COLS;
    private final int ROWS;

    private MyRectangle rect;

    // Map to map color codes to colors
    private final Map<String, Color> codeToColor = new HashMap<>();
    // Map to map colors to color codes
    private final Map<Color, String> colorToCode = new HashMap<>();

    public ApplicationManager(Grid grid) {
        this.GRID = grid;
        this.COLS = grid.getCol();
        this.ROWS = grid.getRow();

        // Initialize the color mappings
        initColorMappings();
    }

    // Initialize color mappings
    private void initColorMappings() {
        codeToColor.put("0", Color.BLACK);
        codeToColor.put("1", Color.GREEN);
        codeToColor.put("2", Color.BLUE);
        codeToColor.put("3", Color.RED);
        codeToColor.put("4", Color.GRAY);
        codeToColor.put("5", Color.CYAN);
        codeToColor.put("6", Color.MAGENTA);
        codeToColor.put("7", Color.YELLOW);
        codeToColor.put("8", Color.PINK);
        codeToColor.put("9", Color.ORANGE);

        // Reverse the mapping
        for (Map.Entry<String, Color> entry : codeToColor.entrySet()) {
            colorToCode.put(entry.getValue(), entry.getKey());
        }
    }

    // Saves the current Grid and gives the user the ability to choose the directory and the name of the file
    public void save() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();

            FileWriter writer = new FileWriter(fileName);
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    Color color = GRID.getRect()[col][row].getColor();
                    String code = colorToCode.getOrDefault(color, "n");
                    writer.write(code + (col < COLS - 1 ? "," : "")); // Avoid trailing comma
                    System.out.print(code + " "); // Debug
                }
                writer.write("\n");
                System.out.println(); // Debug
            }
            writer.close();
        }
    }


    // Loads a previously saved Grid, the user can navigate to a directory and choose a file
    public void load() throws IOException {
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int row = 0;

            while ((line = reader.readLine()) != null && row < ROWS) {
                // Split the line by the delimiter
                String[] codes = line.split(",");

                for (int col = 0; col < COLS; col++) {
                    String code = (col < codes.length) ? codes[col] : "n";
                    Color color = codeToColor.getOrDefault(code, Color.WHITE);
                    if (code.equals("n")) {
                        // Draw a rectangle with default color for unpainted squares
                        GRID.getRect()[col][row].rectangleDraw();
                    } else {
                        // Draw the rectangle with the color
                        GRID.getRect()[col][row].rectangleFill(color);
                    }
                }
                row++;
            }
            reader.close();
        }
    }

    // Just a method to quit the program, but before it quits asks the user to save the current grid
    public void quit() throws IOException {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            save();
            System.exit(0);
        }
    }
}