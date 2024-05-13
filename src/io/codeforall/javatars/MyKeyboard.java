package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboard implements KeyboardHandler {


    protected Keyboard myKeyboard = new Keyboard(this);

    protected Cursor cursor;

    protected boolean pressed;

    protected Grid grid;

    protected FileHelper fileHelper;

    public MyKeyboard(Grid grid, Cursor cursor, FileHelper fileHelper) {
        this.grid = grid;
        this.cursor = cursor;
        this.fileHelper = fileHelper;
    }

    protected void addKeyboard() {
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(moveDown);

        KeyboardEvent paintErase = new KeyboardEvent();
        paintErase.setKey(KeyboardEvent.KEY_SPACE);
        paintErase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(paintErase);

        KeyboardEvent release = new KeyboardEvent();
        release.setKey(KeyboardEvent.KEY_SPACE);
        release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        myKeyboard.addEventListener(release);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(clear);

        KeyboardEvent black = new KeyboardEvent();
        black.setKey(KeyboardEvent.KEY_4);
        black.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(black);

        KeyboardEvent green = new KeyboardEvent();
        green.setKey(KeyboardEvent.KEY_1);
        green.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(green);

        KeyboardEvent blue = new KeyboardEvent();
        blue.setKey(KeyboardEvent.KEY_2);
        blue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(blue);

        KeyboardEvent red = new KeyboardEvent();
        red.setKey(KeyboardEvent.KEY_3);
        red.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(red);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(load);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        switch (key) {
            case 39 -> {
                if (pressed) {
                    cursor.moveRight();
                    cursor.paintErase();
                } else {
                    cursor.moveRight();
                }
            }
            case 37 -> {
                if (pressed) {
                    cursor.moveLeft();
                    cursor.paintErase();
                } else {
                    cursor.moveLeft();
                }
            }
            case 38 -> {
                if (pressed) {
                    cursor.moveUp();
                    cursor.paintErase();
                } else {
                    cursor.moveUp();
                }
            }
            case 40 -> {
                if (pressed) {
                    cursor.moveDown();
                    cursor.paintErase();
                } else {
                    cursor.moveDown();
                }
            }
            case 32 -> {
                cursor.paintErase();
                pressed = true;
            }
            case 67 -> grid.clear();
            case 83 -> {
                try {
                    fileHelper.save();
                    System.out.println("SAVE");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            case 76 -> {
                try {
                    fileHelper.load();
                    System.out.println("LOAD");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            case 52 -> cursor.setColor(Color.BLACK);
            case 49 -> cursor.setColor(Color.GREEN);
            case 50 -> cursor.setColor(Color.BLUE);
            case 51 -> cursor.setColor(Color.RED);
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        if (key == 32) {
            pressed = false;
        }
    }

    public void setFileHelper(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }
}
