package io.codeforall.javatars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboard implements KeyboardHandler {


    protected Keyboard myKeyboard;

    protected Cursor cursor;

    protected boolean pressed;

    protected Grid grid;

    protected ApplicationManager applicationManager;

    public MyKeyboard(Grid grid, Cursor cursor, ApplicationManager applicationManager) {
        this.grid = grid;
        this.cursor = cursor;
        this.applicationManager = applicationManager;
        this.myKeyboard = new Keyboard(this);
    }


    // Using the library to map the keyboard keys to the corresponding methods
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

        KeyboardEvent black = new KeyboardEvent();
        black.setKey(KeyboardEvent.KEY_4);
        black.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(black);

        KeyboardEvent cyan = new KeyboardEvent();
        cyan.setKey(KeyboardEvent.KEY_5);
        cyan.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(cyan);

        KeyboardEvent gray = new KeyboardEvent();
        gray.setKey(KeyboardEvent.KEY_6);
        gray.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(gray);

        KeyboardEvent magenta = new KeyboardEvent();
        magenta.setKey(KeyboardEvent.KEY_7);
        magenta.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(magenta);

        KeyboardEvent yellow = new KeyboardEvent();
        yellow.setKey(KeyboardEvent.KEY_8);
        yellow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(yellow);

        KeyboardEvent pink = new KeyboardEvent();
        pink.setKey(KeyboardEvent.KEY_9);
        pink.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(pink);

        KeyboardEvent orange = new KeyboardEvent();
        orange.setKey(KeyboardEvent.KEY_0);
        orange.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(orange);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(load);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(quit);
    }

    // Triggering the methods that are mapped to their respective keys
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
                    applicationManager.save();
                } catch (IOException e) {
                    System.err.println("Failed to save the file: " + e.getMessage());
                }
            }

            case 76 -> {
                try {
                    applicationManager.load();
                } catch (IOException e) {
                    System.err.println("Failed to load the file: " + e.getMessage());
                }
            }

            case 81 -> {
                try {
                    applicationManager.quit();
                } catch (IOException e) {
                    System.err.println("Failed to save the file: " + e.getMessage());
                }
            }

            case 52 -> cursor.setColor(Color.BLACK);
            case 49 -> cursor.setColor(Color.GREEN);
            case 50 -> cursor.setColor(Color.BLUE);
            case 51 -> cursor.setColor(Color.RED);
            case 54 -> cursor.setColor(Color.GRAY);
            case 53 -> cursor.setColor(Color.CYAN);
            case 55 -> cursor.setColor(Color.MAGENTA);
            case 56 -> cursor.setColor(Color.YELLOW);
            case 57 -> cursor.setColor(Color.PINK);
            case 48 -> cursor.setColor(Color.ORANGE);
        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        if (key == 32) {
            pressed = false;
        }
    }
}
