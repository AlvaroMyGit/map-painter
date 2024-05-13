package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;

public class FileHelper {

    private final String FILENAME;
    private final Grid GRID;
    private final int COLS;
    private final int ROWS;

    private FileHelper fileHelper;

    public FileHelper(Grid grid) {
        this.GRID = grid;
        this.COLS = grid.getCol();
        this.ROWS = grid.getRow();
        this.FILENAME = "src/io/codeforall/javatars/save.txt";
    }

    public void save() throws IOException {

        System.out.println("AAA");

        FileOutputStream outputStream = new FileOutputStream(FILENAME);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                if ((GRID.getRect()[j][i].getColor() == Color.BLACK)) {
                    outputStream.write(("0").getBytes());
                } else if ((GRID.getRect()[j][i].getColor() == Color.GREEN)) {
                    outputStream.write(("1").getBytes());
                } else if ((GRID.getRect()[j][i].getColor() == Color.BLUE)) {
                    outputStream.write(("2").getBytes());
                } else if ((GRID.getRect()[j][i].getColor() == Color.RED)) {
                    outputStream.write(("3").getBytes());
                } else {
                    outputStream.write(("n").getBytes());
                }
            }
            outputStream.write("\n".getBytes());
        }
        outputStream.close();
    }

    public void load() throws IOException {

        FileReader reader = new FileReader(FILENAME);
        BufferedReader bReader = new BufferedReader(reader);

        String line;
        String result = "";

        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }

        reader.close();
        bReader.close();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                char character = result.charAt(j + (i * COLS + i));

                if (character == '0') {
                    GRID.getRect()[j][i].rectangleFill(Color.BLACK);
                } else if (character == '1') {
                    GRID.getRect()[j][i].rectangleFill(Color.GREEN);
                } else if (character == '2') {
                    GRID.getRect()[j][i].rectangleFill(Color.BLUE);
                } else if (character == '3') {
                    GRID.getRect()[j][i].rectangleFill(Color.RED);
                } else {
                    GRID.getRect()[j][i].rectangleDelete();
                }
            }
        }
    }

}