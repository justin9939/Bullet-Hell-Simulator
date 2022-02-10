package model;

import java.util.List;

// represents the game state
public class Game {

    // fields go here

    // EFFECTS: creates a new game, where the game starts with no bullets, and the player starts with streamlined
    //          weapon type, one upgrade level, and no firewalls
    public Game() {
        // stub
    } // Game

    // MODIFIES: this
    // EFFECTS: an enemy attacks from the top left corner, firing a bullet dealing 1 damage that is added to the game
    public void enemyFire() {
        // stub
    } // enemyFire

    // REQUIRES: firewallAmount > 0
    // MODIFIES: this
    // EFFECTS: uses the firewall, damaging all enemies and erasing all bullets on screen,
    //          fails if the player has no firewalls
    public boolean useFirewall() {
        return false; // stub
    } // useFirewall

    // MODIFIES: this
    // EFFECTS: increases the upgrade level by 1, up to a max of 8
    //          no effect if upgrade level is already 8
    public void collectUpgrade() {
        // stub
    } // collectUpgrade

    // MODIFIES: this
    // EFFECTS: increases the amount of firewalls by 1, up to a max of 3
    //          immediately uses a firewall if firewall amount is already 3
    public void collectFirewall() {
        // stub
    } // collectFirewall

    // MODIFIES: this
    // EFFECTS: changes player's weapon to the opposite type
    public void changeWeaponType() {
        // stub
    } // changeWeaponType

    public int getUpgrades() {
        return 0; // stub
    } // getUpgrades

    public List<Bullet> getBullets() {
        return null; // stub
    } // getBullets

    public int getFirewalls() {
        return 0; // stub
    }

    public String getWeaponType() {
        return ""; // stub
    }
} // Game
