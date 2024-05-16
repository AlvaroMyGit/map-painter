package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MyRectangle {



    protected boolean isPainted;

    protected Rectangle rectangle;

    protected Color color;

    public MyRectangle(int x,int y,int width,int height) {
        this.rectangle = new Rectangle(x, y, width, height);
    }

    // Changes the boolean value of that specific square
    // This is the way we keep track of which squares are painted
    public void setPainted(boolean painted) {
        this.isPainted = painted;
    }

    // Returns the value of isPainted, this is the way we check if it is painted or not
    // We use it in the paintErase() to decide if we paint it or if we erase it
    public boolean isPainted() {
        return isPainted;
    }

    // The method we use to paint the squares
    public void rectangleFill(Color color) {
        this.color = color;
        rectangle.setColor(color);
        rectangle.fill();
    }

    // The method we use to erase the painted squares
    public void rectangleDelete() {
        rectangle.delete();
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

    // Basically a wrapper so I can use this method on MyRectangle type of Object
    public void rectangleDraw() {
        rectangle.draw();
    }


    public Color getColor() {
        return color;
    }
}
