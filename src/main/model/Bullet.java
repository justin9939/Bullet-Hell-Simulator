package model;

import ui.GameFrame;

// hazardous bullets fired from enemy units
public class Bullet {

    // constants
    public static final int BULLET_DIMENSIONS = 20;
    public static final String BULLET_SPRITE = "data/bullet.png";
    public static final int UPPER_X = GameFrame.GAME_WINDOW_WIDTH - BULLET_DIMENSIONS;
    public static final int UPPER_Y = GameFrame.GAME_WINDOW_HEIGHT - BULLET_DIMENSIONS;

    // fields
    private int positionX;
    private int positionY;
    private int moveX;
    private int moveY;

    // REQUIRES: 0 <= posX <= width, 0 <= posY <= height
    // EFFECTS: creates a bullet at given posX and posY, with horizontal and vertical
    //          movement speed at 1
    public Bullet(int posX, int posY) {
        this.positionX = posX;
        this.positionY = posY;
        this.moveX = 1;
        this.moveY = 1;
    } // Bullet

    // MODIFIES: this
    // EFFECTS: moves the bullet across the screen by its moveX and moveY, bouncing off the walls if
    //          the bullet touches the boundaries
    public void move() {
        handleBoundary();
        this.positionX += this.moveX;
        this.positionY += this.moveY;
    } // move

    // MODIFIES: this
    // EFFECTS: makes the bullets bounce if they touch the boundaries
    public void handleBoundary() {
        if (this.positionX < 0 || this.positionX >= UPPER_X) {
            this.moveX *= -1;
        } // if

        if (this.positionY < 0 || this.positionY >= UPPER_Y) {
            this.moveY *= -1;
        } // if
    } // handleBoundary

    // MODIFIES: this
    // EFFECTS: manually sets horizontal and vertical speed of bullets
    public void setSpeed(int newSpeed) {
        this.moveX = newSpeed;
        this.moveY = newSpeed;
    } // speedUp

    public int getPositionX() {
        return this.positionX;
    } // getPositionX

    public int getPositionY() {
        return this.positionY;
    } // getPositionY

    public int getMoveX() {
        return this.moveX;
    } // getMoveX

    public int getMoveY() {
        return this.moveY;
    } // getMoveY

} // Bullet
