package model;

import org.json.*;
import persistence.Writable;

import java.util.ArrayList;

// represents the game state
public class Game implements Writable {

    // constants
    public static final int MAX_FIREWALLS = 3;
    public static final int MAX_UPGRADE_LEVEL = 8;

    // fields
    private ArrayList<Bullet> hazards;
    private Bullet enemyShot;
    private String weaponType;
    private int upgradeLevel;
    private int firewalls;

    // EFFECTS: creates a new game, where the game starts with no bullets, and the player starts with streamlined
    //          weapon type, one upgrade level, and no firewalls
    public Game() {
        this.hazards = new ArrayList<>();
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
        if (this.upgradeLevel < MAX_UPGRADE_LEVEL) {
            this.upgradeLevel += 1;
        } // if
    } // collectUpgrade

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

    // MODIFIES: this
    // EFFECTS: changes player's weapon to the opposite type
    public void changeWeaponType() {
        if (this.weaponType.equals("streamlined")) {
            this.weaponType = "spread";
        } else {
            this.weaponType = "streamlined";
        } // if... else
    } // changeWeaponType

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("weaponType", getWeaponType());
        jsonObject.put("upgradeLevel", getUpgradeLevel());
        jsonObject.put("firewalls", getFirewalls());
        jsonObject.put("hazards", getHazards().size());
        return jsonObject; // stub
    } // toJson

    // MODIFIES: this
    // EFFECTS: resets all relevant fields in game to their initial states for a new game
    public void newGame() {
        this.hazards.clear();
        this.weaponType = "streamlined";
        this.upgradeLevel = 1;
        this.firewalls = 0;
    } // newGame

    public int getUpgradeLevel() {
        return this.upgradeLevel;
    } // getUpgrades

    public ArrayList<Bullet> getHazards() {
        return this.hazards;
    } // getBullets

    public int getFirewalls() {
        return this.firewalls;
    } // getFirewalls

    public String getWeaponType() {
        return this.weaponType;
    } // getWeaponType
} // Game
