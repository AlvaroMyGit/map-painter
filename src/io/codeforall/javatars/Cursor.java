package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    protected Rectangle cursor;
    protected Grid myGrid;
    protected MyRectangle[][] rect;
    protected Color color;

    public Cursor(Grid myGrid) {
        this.myGrid = myGrid;
        this.rect = myGrid.getGrid();
        this.color = Color.BLACK;
    }

    // Draws the initial cursor when the program runs in the upper left corner of the grid
    protected void drawCursor() {
        cursor = new Rectangle(myGrid.PADDING, myGrid.PADDING, myGrid.CELL_SIZE, myGrid.CELL_SIZE);
        cursor.setColor(getColor());
        cursor.fill();
    }

    // Method used to redraw the cursor when you change colors while painting
    // It will spawn in the position of the previous cursor
    protected void reDrawCursor() {
        cursor = new Rectangle(cursor.getX(), cursor.getY(), myGrid.CELL_SIZE, myGrid.CELL_SIZE);
        cursor.setColor(getColor());
        cursor.fill();
    }

    protected void moveUp() {
        if (cursor.getY() > myGrid.PADDING + 1) {
            cursor.translate(0, -myGrid.CELL_SIZE);
        }
    }

    protected void moveDown() {
        if (cursor.getY() < myGrid.row * myGrid.CELL_SIZE - myGrid.PADDING) {
            cursor.translate(0, myGrid.CELL_SIZE);
        }
    }

    protected void moveRight() {
        if (cursor.getX() < myGrid.col * myGrid.CELL_SIZE - myGrid.PADDING) {
            cursor.translate(myGrid.CELL_SIZE, 0);
        }
    }

    protected void moveLeft() {
        if (cursor.getX() > myGrid.PADDING + 1) {
            cursor.translate(-myGrid.CELL_SIZE, 0);
        }
    }

    // This method is responsible for painting and erasing painted squares based
    // on the condition if it is already painted or not
    protected void paintErase() {

        MyRectangle selectedRectangle = rect[cursor.getY() / myGrid.CELL_SIZE][cursor.getX() / myGrid.CELL_SIZE];

        if (!selectedRectangle.isPainted()) {
            selectedRectangle.rectangleFill(getColor());
            selectedRectangle.setPainted(true);
            return;
        }
        selectedRectangle.rectangleDelete();
        selectedRectangle.setPainted(false);
    }

    // Changes the color of the cursor, after the color is changed deletes the previous cursor/color
    // And redraws the new one in the position of the previous one
    public void setColor(Color color) {
        this.color = color;
        cursor.delete();
        reDrawCursor();
    }

    // Getter
    public Color getColor() {
        return this.color;
    }
}