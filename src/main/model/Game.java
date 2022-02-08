package model;

// represents the game state
public class Game {

    // fields go here

    // EFFECTS: creates a new game, where the game starts with no enemies or bullets,
    //          and the player starts with streamlined weapon type and zero upgrades
    public Game() {
        // stub
    } // Game

    // REQUIRES: level > 0, type either "streamline" or "spread"
    // MODIFIES: this
    // EFFECTS: fires different amounts of bullets depending on the player's upgrade
    //          level or weapon type.
    public void shoot(int level, String type) {
        // stub
    } // shoot

    // REQUIRES: firewallAmount > 0
    // MODIFIES: this
    // EFFECTS: uses the firewall, damaging all enemies and erasing all bullets on screen.
    public void useFirewall() {
        // stub
    } // useFirewall

    // MODIFIES: this
    // EFFECTS: increases the upgrade level by 1, up to a max of 8
    public void collectUpgrade() {
        // stub
    } // collectUpgrade

    // MODIFIES: this
    // EFFECTS: increases the amount of firewalls by 1, up to a max of 3
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

    public int getBullets() {
        return 0; // stub
    } // getBullets

    public int getFirewalls() {
        return 0; // stub
    }

    public String getWeaponType() {
        return ""; // stub
    }
} // Game
