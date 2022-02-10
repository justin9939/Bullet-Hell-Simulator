package model;

import java.util.ArrayList;

// represents the game state
public class Game {

    // fields go here
    private ArrayList<Bullet> hazards;
    private Bullet enemyShot;
    private String weaponType;
    private int upgradeLevel;
    private int firewalls;

    // EFFECTS: creates a new game, where the game starts with no bullets, and the player starts with streamlined
    //          weapon type, one upgrade level, and no firewalls
    public Game() {
        this.hazards = new ArrayList<Bullet>();
        this.weaponType = "streamlined";
        this.upgradeLevel = 1;
        this.firewalls = 0;
    } // Game

    // MODIFIES: this
    // EFFECTS: an enemy attacks from the top left corner, firing a hazardous bullet dealing 1 damage
    public void enemyFire() {
        enemyShot = new Bullet(0, 0, 1);
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
    // EFFECTS: increases the upgrade level by 1, up to a max of 8
    //          no effect if upgrade level is already 8
    public void collectUpgrade() {
        if (this.upgradeLevel < 8) {
            this.upgradeLevel += 1;
        } // if
    } // collectUpgrade

    // MODIFIES: this
    // EFFECTS: increases the amount of firewalls by 1, up to a max of 3
    //          immediately uses a firewall if firewall amount is already 3
    public void collectFirewall() {
        if (this.firewalls < 3) {
            this.firewalls += 1;
        } else {
            // cannot fit any more firewalls, so use one and immediately restore it
            useFirewall();
            this.firewalls += 1;
        } // if... else
    } // collectFirewall

    // MODIFIES: this
    // EFFECTS: changes player's weapon to the opposite type
    public void changeWeaponType() {
        if (this.weaponType.equals("streamlined")) {
            this.weaponType = "spread";
        } else {
            this.weaponType = "streamlined";
        } // if... else
    } // changeWeaponType

    public int getUpgrades() {
        return this.upgradeLevel;
    } // getUpgrades

    public ArrayList<Bullet> getHazards() {
        return this.hazards; // stub
    } // getBullets

    public int getFirewalls() {
        return this.firewalls; // stub
    }

    public String getWeaponType() {
        return this.weaponType; // stub
    }
} // Game
