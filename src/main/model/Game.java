package model;

import ui.GameFrame;

import org.json.*;
import persistence.Writable;

import java.util.ArrayList;
// TODO: add bullet bouncing, add an update method, add player entity,
//       update testing after all that is done, overhaul json (save bullets, save player)

//  TODO: rework how adding bullet speed works - have a check to see if it is negative or not

// represents the game state
public class Game implements Writable {

    // constants
    public static final int MAX_FIREWALLS = 3;
    public static final int MAX_BULLET_SPEED = 8;
    public static final int SPAWN_LOWER_BOUND_X = 50;
    public static final int SPAWN_UPPER_BOUND_X = 500;
    private int width = GameFrame.GAME_WINDOW_WIDTH;
    private int height = GameFrame.GAME_WINDOW_HEIGHT;

    // fields
    private ArrayList<Bullet> hazards;
    private Bullet enemyShot;
    private int bulletSpeed;
    private int firewalls;

    // EFFECTS: creates a new game, where the game starts with no bullets, one bullet speed, and no firewalls
    public Game() {
        this.hazards = new ArrayList<>();
        this.bulletSpeed = 1;
        this.firewalls = 0;
    } // Game

    // MODIFIES: this
    // EFFECTS: an enemy attacks from the top of the screen, firing a hazardous bullet
    public void enemyFire() {
        int x = (int) ((Math.random() * (SPAWN_UPPER_BOUND_X - SPAWN_LOWER_BOUND_X)) + SPAWN_LOWER_BOUND_X);
        enemyShot = new Bullet(x, 0);
        this.hazards.add(enemyShot);
    } // enemyFire

    // REQUIRES: firewallAmount > 0
    // MODIFIES: this
    // EFFECTS: uses the firewall, damaging all enemies and erasing all bullets on screen,
    //          fails if the player has no firewalls
    public boolean useFirewall() {
        if (this.firewalls >= 1) {
            this.hazards.clear();
            this.firewalls -= 1;
            return true;
        } // if
        return false;
    } // useFirewall

    // MODIFIES: this
    // EFFECTS: increases the bullet speed by 1, up to a max of 8
    //          no effect if bullet speed is already 8
    public void increaseBulletSpeed() {
        if (this.bulletSpeed < MAX_BULLET_SPEED) {
            this.bulletSpeed += 1;
        } // if
    } // increaseBulletSpeed

    // MODIFIES: this
    // EFFECTS: increases the amount of firewalls by 1, up to a max of 3
    //          immediately uses a firewall if firewall amount is already 3
    public void collectFirewall() {
        if (this.firewalls == MAX_FIREWALLS) {
            // cannot fit any more firewalls, so use one and immediately restore it afterwards
            useFirewall();
        } // if
        this.firewalls += 1;
    } // collectFirewall

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bulletSpeed", getBulletSpeed());
        jsonObject.put("firewalls", getFirewalls());
        jsonObject.put("hazards", getHazards().size());
        return jsonObject; // stub
    } // toJson

    // MODIFIES: this
    // EFFECTS: resets all relevant fields in game to their initial states for a new game
    public void newGame() {
        this.hazards.clear();
        this.bulletSpeed = 1;
        this.firewalls = 0;
    } // newGame

    public int getBulletSpeed() {
        return this.bulletSpeed;
    } // getUpgrades

    public ArrayList<Bullet> getHazards() {
        return this.hazards;
    } // getBullets

    public int getFirewalls() {
        return this.firewalls;
    } // getFirewalls
} // Game
