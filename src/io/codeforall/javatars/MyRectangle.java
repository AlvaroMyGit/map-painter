package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MyRectangle {



    protected boolean isPainted;

    protected Rectangle rectangle;

    protected Color color;

    protected Cursor cursor;
    public MyRectangle(int x,int y,int width,int height) {
        this.rectangle = new Rectangle(x, y, width, height);
    }

    public void setPainted(boolean painted) {
        this.isPainted = painted;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void rectangleFill(Color color) {
        rectangle.setColor(color);
        rectangle.fill();
    }

    public void rectangleDelete() {
        rectangle.delete();
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

    public void rectangleDraw() {
        rectangle.draw();
    }

    public void rectangleSetColor() {
        rectangle.setColor(Color.RED);
    }

    public void changeColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
