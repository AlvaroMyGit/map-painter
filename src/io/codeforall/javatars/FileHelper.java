package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileHelper {

    private final Grid GRID;
    private final int COLS;
    private final int ROWS;


    public FileHelper(Grid grid) {
        this.GRID = grid;
        this.COLS = grid.getCol();
        this.ROWS = grid.getRow();
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

            FileOutputStream outputStream = new FileOutputStream(fileName);

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if ((GRID.getRect()[j][i].getColor() == Color.BLACK)) {
                        outputStream.write(("0,").getBytes());
                    } else if ((GRID.getRect()[j][i].getColor() == Color.GREEN)) {
                        outputStream.write(("1,").getBytes());
                    } else if ((GRID.getRect()[j][i].getColor() == Color.BLUE)) {
                        outputStream.write(("2,").getBytes());
                    } else if ((GRID.getRect()[j][i].getColor() == Color.RED)) {
                        outputStream.write(("3,").getBytes());
                    } else {
                        outputStream.write(("n,").getBytes());
                    }
                }
                outputStream.write("\n".getBytes()); // Add a newline character after each row
            }
            outputStream.close();
        }

    }

    // Loads a previously saved Grid, the user can navigate to a directory and choose a file
    public void load() throws IOException {

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files","txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();


            FileReader reader = new FileReader(fileName);
            BufferedReader bReader = new BufferedReader(reader);

            String line;

            int row = 0;
            while ((line = bReader.readLine()) != null) {
                String[] colors = line.split(","); // Split the line by the delimiter

                for (int col = 0; col < COLS && col < colors.length; col++) {
                    char character = colors[col].charAt(0); // Get the first character
                    switch (character) {
                        case '0':
                            GRID.getRect()[col][row].rectangleFill(Color.BLACK);
                            break;
                        case '1':
                            GRID.getRect()[col][row].rectangleFill(Color.GREEN);
                            break;
                        case '2':
                            GRID.getRect()[col][row].rectangleFill(Color.BLUE);
                            break;
                        case '3':
                            GRID.getRect()[col][row].rectangleFill(Color.RED);
                            break;
                        default:
                            GRID.getRect()[col][row].rectangleDelete();
                            break;
                    }
                }
                row++;
            }

            reader.close();
            bReader.close();
        }

    }
}