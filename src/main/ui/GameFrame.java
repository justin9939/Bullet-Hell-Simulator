package ui;

import model.Game;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

// main frame where the entire program is displayed
public class GameFrame extends JFrame implements ActionListener {
    public static final int GAME_WINDOW_WIDTH = 550;
    public static final int GAME_WINDOW_HEIGHT = 650;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 30;
    private static final int FONT_SIZE = 12;
    private static final String JSON_STORE = "./data/savedGame.json";

    private boolean loadSave;

    private Game gameInstance;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JPanel menuScreen;
    private JPanel gameScreen;
    private JPanel operations;
    private JPanel statsBar;

    private JButton newGame = new JButton("New Game");
    private JButton loadGame = new JButton("Load Game");
    private JButton controls = new JButton("Controls");
    private JButton enemyFire = new JButton("Fire Enemy Bullet");
    private JButton upgrade = new JButton("Collect Upgrade");
    private JButton collectFirewall = new JButton("Collect Firewall");
    private JButton useFirewall = new JButton("Use Firewall");
    private JButton changeWeapon = new JButton("Change Weapon Type");
    private JButton saveAndExit = new JButton("Save and Exit");

    private JLabel hazardsOnScreen;
    private JLabel upgradeLevel;
    private JLabel weaponType;
    private JLabel firewallAmount;

    // EFFECTS: creates a new game window where everything takes place
    public GameFrame() {
        super("Windows Fighter x64");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.out.println("\nEvent Log:");
                printEvents(EventLog.getInstance());
                System.exit(0);
            }
        });
        this.setSize(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        this.setResizable(false);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initializeButtons();
        loadMenu();
        this.setVisible(true);
    } // GameFrame

    // EFFECTS: adds action listeners and commands to all buttons
    public void initializeButtons() {
        newGame.setActionCommand("new");
        loadGame.setActionCommand("load");
        controls.setActionCommand("controls");
        enemyFire.setActionCommand("fire");
        upgrade.setActionCommand("upgrade");
        changeWeapon.setActionCommand("weapon");
        collectFirewall.setActionCommand("collect");
        useFirewall.setActionCommand("use");
        saveAndExit.setActionCommand("save");

        newGame.addActionListener(this);
        loadGame.addActionListener(this);
        controls.addActionListener(this);
        enemyFire.addActionListener(this);
        upgrade.addActionListener(this);
        changeWeapon.addActionListener(this);
        collectFirewall.addActionListener(this);
        useFirewall.addActionListener(this);
        saveAndExit.addActionListener(this);
    } // initializeButtons

    // MODIFIES: this
    // EFFECTS: determines and performs an action depending on what button is pressed
    // checkstyle warning suppressed because the length is mostly due to the range of user input options
    @SuppressWarnings("methodlength")
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "new":
                loadSave = false;
                try {
                    loadGame();
                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to run game: File not found");
                } // try... catch
                break;
            case "load":
                loadSave = true;
                try {
                    loadGame();
                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to run game: File not found");
                } // try... catch
                break;
            case "controls":
                loadControls();
                break;
            case "fire":
                doEnemyFire();
                break;
            case "upgrade":
                doUpgrade();
                break;
            case "collect":
                doCollectFirewall();
                break;
            case "use":
                doUseFirewall();
                break;
            case "weapon":
                doChangeWeaponType();
                break;
            case "save":
                doSaveAndExit();
        } // switch
    } // actionPerformed

    // MODIFIES: this
    // EFFECTS: loads the main menu and its buttons
    public void loadMenu() {
        // System.out.println("Loaded menu");
        this.getContentPane().removeAll();
        this.add(new BackgroundPanel("data/menuImage.jpg", GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT));

        createMenu();
        this.add(menuScreen);
        this.revalidate();
        this.repaint();
    } // loadMenu

    // EFFECTS: creates the menu screen with formatted buttons
    public void createMenu() {
        menuScreen = new JPanel();
        menuScreen.setBounds(0, 0, GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        menuScreen.setLayout(null);
        addButton(menuScreen, newGame, 200, 225, BUTTON_WIDTH, BUTTON_HEIGHT);
        addButton(menuScreen, loadGame, 200, 315, BUTTON_WIDTH + 20, BUTTON_HEIGHT);
        addButton(menuScreen, controls, 200, 405, BUTTON_WIDTH, BUTTON_HEIGHT);
        menuScreen.setOpaque(false);
    } // createMenu

    // MODIFIES: this
    // EFFECTS: loads the controls screen
    public void loadControls() {
        new ControlsFrame();
    } // loadControls

    // MODIFIES: this
    // EFFECTS: loads the game screen and its buttons
    //          loads a saved game if loadSave is true
    public void loadGame() throws FileNotFoundException {
        this.getContentPane().removeAll();
        this.add(new BackgroundPanel("data/gameImage.jpg", GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT - 65));

        if (loadSave) {
            try {
                gameInstance = jsonReader.read();
                System.out.println("Loaded game from " + JSON_STORE);
            } catch (IOException e) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            } // try... catch
        } else {
            gameInstance = new Game();
        } // if... else

        createGame();
        this.add(gameScreen);
        this.revalidate();
        this.repaint();
    } // loadGame

    // EFFECTS: creates the game screen where the gameplay takes place
    public void createGame() {
        gameScreen = new JPanel();
        gameScreen.setBounds(0, 0, GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        gameScreen.setLayout(new BorderLayout());
        createStats();
        gameScreen.add(statsBar, BorderLayout.SOUTH);

        createOperations();
        gameScreen.add(operations);
    } // createGame

    // EFFECTS: creates the bar showing player stats in the game on the top edge
    // based on ScorePanel() from Space Invaders
    // method length suppression because there's no way to simplify since each JLabel added needs
    // to call a specialized thing
    @SuppressWarnings("methodlength")
    public void createStats() {
        statsBar = new JPanel();
        statsBar.setBackground(new Color(180, 180, 180));
        statsBar.setLayout(new FlowLayout());

        hazardsOnScreen = new JLabel("Enemy bullets: " + gameInstance.getHazards().size());
        hazardsOnScreen.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        hazardsOnScreen.setForeground(Color.red);

        upgradeLevel = new JLabel("Upgrade level: " + gameInstance.getUpgradeLevel());
        upgradeLevel.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        upgradeLevel.setForeground(Color.yellow);

        weaponType = new JLabel("Weapon type: " + gameInstance.getWeaponType());
        weaponType.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        weaponType.setForeground(Color.green);

        firewallAmount = new JLabel("Firewalls: " + gameInstance.getFirewalls());
        firewallAmount.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        firewallAmount.setForeground(Color.orange);

        statsBar.add(hazardsOnScreen);
        statsBar.add(Box.createHorizontalStrut(30));
        statsBar.add(upgradeLevel);
        statsBar.add(Box.createHorizontalStrut(30));
        statsBar.add(weaponType);
        statsBar.add(Box.createHorizontalStrut(30));
        statsBar.add(firewallAmount);
    } // createOperations

    // EFFECTS: creates the button panel for operations in the game on the bottom edge
    public void createOperations() {
        operations = new JPanel();
        operations.setLayout(null);

        addButton(operations, controls, 175, 195, BUTTON_WIDTH, BUTTON_HEIGHT);
        addButton(operations, enemyFire, 175, 235, BUTTON_WIDTH + 55, BUTTON_HEIGHT);
        addButton(operations, upgrade, 175, 275, BUTTON_WIDTH + 40, BUTTON_HEIGHT);
        addButton(operations, collectFirewall, 175, 315, BUTTON_WIDTH + 45, BUTTON_HEIGHT);
        addButton(operations, useFirewall, 175, 355, BUTTON_WIDTH, BUTTON_HEIGHT);
        addButton(operations, changeWeapon, 175, 395, BUTTON_WIDTH + 70, BUTTON_HEIGHT);
        addButton(operations, saveAndExit, 175, 435, BUTTON_WIDTH + 7, BUTTON_HEIGHT);
    } // createOperations

    // MODIFIES: this
    // EFFECTS: simulates an enemy firing a bullet
    public void doEnemyFire() {
        System.out.println("An enemy fires a bullet at you from the corner of the screen!"
                + " That's one more hazard to avoid.");
        gameInstance.enemyFire();
        hazardsOnScreen.setText("Enemy bullets: " + gameInstance.getHazards().size());
        statsBar.repaint();
    } // doEnemyFire

    // MODIFIES: this
    // EFFECTS: collects an upgrade, and has no effect if player already is at upgrade level 8
    public void doUpgrade() {
        if (gameInstance.getUpgradeLevel() < Game.MAX_UPGRADE_LEVEL) {
            System.out.println("Wow! You collected an upgrade, increasing your upgrade level!");
        } else {
            System.out.println("You're already at max upgrade level; it had no effect!");
        } // if... else
        gameInstance.collectUpgrade();
        upgradeLevel.setText("Upgrade level: " + gameInstance.getUpgradeLevel());
        statsBar.repaint();
    } // doCollectUpgrade

    // MODIFIES: this
    // EFFECTS: changes the player's current weapon type to the opposite type
    public void doChangeWeaponType() {
        System.out.println("You changed your weapon type.");
        gameInstance.changeWeaponType();
        weaponType.setText("Weapon type: " + gameInstance.getWeaponType());
        statsBar.repaint();
    } // doChangeWeaponType

    // MODIFIES: this
    // EFFECTS: collects a Firewall, and uses a Firewall if player already has max amount of Firewalls
    public void doCollectFirewall() {
        if (gameInstance.getFirewalls() < Game.MAX_FIREWALLS) {
            System.out.println("Wow! You collected a firewall!");
        } else {
            System.out.println("You can't hold any more firewalls!"
                    + " The one you just collected was used.");
        } // if... else
        gameInstance.collectFirewall();
        firewallAmount.setText("Firewalls: " + gameInstance.getFirewalls());
        hazardsOnScreen.setText("Enemy bullets: " + gameInstance.getHazards().size());
        statsBar.repaint();
    } // doCollectFirewall

    // MODIFIES: this
    // EFFECTS: uses a Firewall, clearing all hazards currently in the game
    //          fails if the player has on firewalls
    public void doUseFirewall() {
        if (gameInstance.useFirewall()) {
            System.out.println("You used a firewall, clearing the screen of all hazards.");
            firewallAmount.setText("Firewalls: " + gameInstance.getFirewalls());
            hazardsOnScreen.setText("Enemy bullets: " + gameInstance.getHazards().size());
        } else {
            System.out.println("You have no firewalls to use.");
        } // if... else
        statsBar.repaint();
    } // doUseFirewall

    // MODIFIES: this
    // EFFECTS: saves the current game state to file and exits to main menu
    private void doSaveAndExit() {
        try {
            jsonWriter.open();
            jsonWriter.write(gameInstance);
            jsonWriter.close();
            System.out.println("Saved game to: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        } // try... catch

        loadMenu();
    } // saveGame

    // REQUIRES: panel needs to have null layout
    // MODIFIES: this
    // EFFECTS: adds button of given size to panel at given x and y positions
    public void addButton(JPanel panel, JButton button, int posX, int posY, int width, int height) {
        button.setBounds(posX, posY, width, height);
        panel.add(button);
    } // addButton

    // EFFECTS: prints out all events in the event log
    // based off AlarmSystem's printLog method
    public void printEvents(EventLog el) {
        for (Event nextEvent : el) {
            System.out.println(nextEvent.toString());
        } // for
    } // printEvents
} // GameFrame
