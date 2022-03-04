package model;

import org.json.JSONObject;
import persistence.Writable;

// hazardous bullets fired from enemy units
public class Bullet {

    private int damage;
    private int positionX;
    private int positionY;

    // REQUIRES: 0 <= posX <= 600, 0 <= posY <= 900, dmg >= 1
    // EFFECTS: creates a bullet at given positionX and positionY that deals a certain amount of damage
    public Bullet(int posX, int posY, int dmg) {
        this.positionX = posX;
        this.positionY = posY;
        this.damage = dmg;
    } // Bullet

    public int getPositionX() {
        return this.positionX;
    } // getPositionX

    public int getPositionY() {
        return this.positionY;
    } // getPositionY

    public int getDamage() {
        return this.damage;
    } // getDamage
} // Bullet
