package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    protected Rectangle cursor;
    protected Grid myGrid;
    protected MyRectangle[][] rect;
    protected MyKeyboard myKeyboard;

    protected Color color;

    protected FileHelper fileHelper;

    public Cursor(Grid myGrid) {
        this.myGrid = myGrid;
        this.rect = myGrid.getRect();
        this.color = Color.BLACK;
    }

    protected void drawCursor() {
        cursor = new Rectangle(myGrid.PADDING, myGrid.PADDING, myGrid.CELL_SIZE, myGrid.CELL_SIZE);
        cursor.setColor(Color.BLACK);
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

    protected void paintErase() {

        MyRectangle selectedRectangle = rect[cursor.getY() / myGrid.CELL_SIZE][cursor.getX() / myGrid.CELL_SIZE];

        if (!selectedRectangle.isPainted()) {
            selectedRectangle.rectangleFill(color);
            selectedRectangle.setPainted(true);

        } else {
            selectedRectangle.rectangleDelete();
            selectedRectangle.setPainted(false);
            }

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getCursor() {
        return cursor;
    }
}


