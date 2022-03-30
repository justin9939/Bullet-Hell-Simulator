package model;

import ui.GameFrame;

// represents the entity the player controls during the game
public class PlayerEntity {
// TODO: add handleboundary, add 4-directional movement, add all tests
    // constants
    public static final int SIZE_X = 42;
    public static final int SIZE_7 = 67;
    public static final int MOVE_SPEED = 5;
    public static final String PLAYER_SPRITE = "data/playerSprite.png";
    private int width = GameFrame.GAME_WINDOW_WIDTH;
    private int height = GameFrame.GAME_WINDOW_HEIGHT;

    // fields
    private int positionX;
    private int positionY;
    private boolean movingUp;
    private boolean movingDown;
    private boolean movingRight;
    private boolean movingLeft;

    // EFFECTS: creates a new PlayerEntity at given x and y that is not moving at all
    public PlayerEntity(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.movingUp = false;
        this.movingDown = false;
        this.movingRight = false;
        this.movingLeft = false;
    } // PlayerEntity

    // MODIFIES: this
    // EFFECTS: the player is now moving upwards
    public void moveUp() {
        this.movingUp = true;
    } // moveUp

    // MODIFIES: this
    // EFFECTS: the player is now moving downwards
    public void moveDown() {
        this.movingDown = true;
    } // moveDown

    // MODIFIES: this
    // EFFECTS: the player is now moving right
    public void moveRight() {
        this.movingRight = true;
    } // moveRight

    // MODIFIES: this
    // EFFECTS: the player is now moving left
    public void moveLeft() {
        this.movingLeft = true;
    } // moveLeft

    // EFFECTS: returns true if player is moving upwards, false otherwise
    public boolean isMovingUp() {
        return this.movingUp;
    } // isMovingUp

    // EFFECTS: returns true if player is moving downwards, false otherwise
    public boolean isMovingDown() {
        return this.movingDown;
    } // isMovingDown

    // EFFECTS: returns true if player is moving right, false otherwise
    public boolean isMovingRight() {
        return this.movingRight;
    } // isMovingRight

    // EFFECTS: returns true if player is moving left, false otherwise
    public boolean isMovingLeft() {
        return this.movingLeft;
    } // isMovingLeft

    // MODIFIES: this
    // EFFECTS: player is constrained to the boundaries of the game


    public int getPositionX() {
        return this.positionX;
    } // getPositionX

    public int getPositionY() {
        return this.positionY;
    } // getPositionY

} // PlayerEntity
