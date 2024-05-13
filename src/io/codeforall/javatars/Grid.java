package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    protected final int CELL_SIZE = 20;
    protected final int PADDING = 10;

    protected int row;

    protected int col;
    protected MyRectangle[][] rect;
    protected Cursor cursor;
    protected MyKeyboard myKeyboard;


    public Grid(int col, int row) {
        this.row = row;
        this.col = col;
        rect = new MyRectangle[col][row];
        cursor = new Cursor(this, rect);
        myKeyboard = new MyKeyboard(cursor);

    }

    protected void start() {
        drawGrid();
        cursor.drawCursor();
        myKeyboard.addKeyboard();
    }

    protected void drawGrid() {
        int x = PADDING;
        int y = PADDING;
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect.length; j++) {
                rect[i][j] = new MyRectangle(x, y, CELL_SIZE, CELL_SIZE);
                rect[i][j].rectangleDraw();
                x += CELL_SIZE;
            }
            x = PADDING;
            y += CELL_SIZE;
        }
    }


}
