package ui;

import model.Game;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

// main frame where the entire program is displayed
public class GameFrame extends JFrame {
    public static final int GAME_WINDOW_WIDTH = 550;
    public static final int GAME_WINDOW_HEIGHT = 650;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 30;
    private static final int FONT_SIZE = 10;
    private static final String JSON_STORE = "./data/savedGame.json";

    private Game gameInstance;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JPanel menuScreen;
    private JPanel controlsScreen;
    private JPanel gameScreen;
    private JPanel operationsBar;
    private JPanel statsBar;

    private JButton newGame = new JButton("New Game");
    private JButton loadGame = new JButton("Load Game");
    private JButton controls = new JButton("Controls");
    private JButton enemyFire = new JButton("Enemy Fire");
    private JButton upgrade = new JButton("Collect Upgrade");
    private JButton collectFirewall = new JButton("Collect Firewall");
    private JButton useFirewall = new JButton("Use Firewall");
    private JButton changeWeapon = new JButton("Change Weapon");
    private JButton saveAndExit = new JButton("Save and Exit");

    private JLabel hazardsOnScreen;
    private JLabel upgradeLevel;
    private JLabel weaponType;
    private JLabel firewallAmount;

    // TODO: for saving, put the try catch only around the code when you do it
    // TODO: implement all JPanels in the frame class, "one class per frame"

    // EFFECTS: creates a new game window where everything takes place
    public GameFrame() {
        super("Windows Fighter x64");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        this.setResizable(false);

        loadGame();
        this.setVisible(true);
    } // GameFrame

    // MODIFIES: this
    // EFFECTS: loads the main menu and its buttons
    public void loadMenu() {
        // System.out.println("Loaded menu");
        this.getContentPane().removeAll();
        this.add(new BackgroundPanel("data/menuImage.jpg"));
        createMenu();
        this.add(menuScreen);
        this.repaint();
    } // loadMenu

    // EFFECTS: creates the menu screen with formatted buttons
    public void createMenu() {
        menuScreen = new JPanel();
        menuScreen.setBounds(0, 0, GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        menuScreen.setLayout(null);
        addButton(menuScreen, newGame, 200, 220);
        addButton(menuScreen, loadGame, 200, 310); // bug - load and controls only appears when mouse hover
        addButton(menuScreen, controls, 200, 400);
    } // createMenu

    // EFFECTS: adds action listeners to all buttons on the menu
    public void initializeMenuButtons() {
        // TODO: need help for adding multiple action listeners
    }

    // MODIFIES: this
    // EFFECTS: loads the controls screen and its text and buttons
    public void loadControls() {
        //System.out.println("Loaded controls"); // stub
        new ControlsFrame();
    } // loadControls

    // MODIFIES: this
    // EFFECTS: loads the game screen and its buttons
    public void loadGame() {
        //System.out.println("Loaded game"); // stub
        this.getContentPane().removeAll();
        //this.add(new BackgroundPanel("data/gameImage.jpg"));
        createGame();
        this.add(gameScreen);
        this.repaint();
    } // loadGame

    // EFFECTS: creates the game screen where the gameplay takes place
    public void createGame() {
        gameScreen = new JPanel();
        gameScreen.setBounds(0, 0, GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        gameScreen.setLayout(new BorderLayout());
        createStats();
        gameScreen.add(statsBar, BorderLayout.NORTH);

        createOperations();
        gameScreen.add(operationsBar, BorderLayout.SOUTH);
    } // createGame

    // EFFECTS: creates the bar showing player stats in the game on the top edge
    // based on ScorePanel() from Space Invaders
    public void createStats() {
        statsBar = new JPanel();
        statsBar.setBackground(new Color(180, 180, 180));
        statsBar.setLayout(new FlowLayout());
        hazardsOnScreen = new JLabel("Enemy bullets: " /*+ gameInstance.getHazards()*/);
        hazardsOnScreen.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        hazardsOnScreen.setForeground(Color.red);
        upgradeLevel = new JLabel("Upgrade level: " /*+ gameInstance.getUpgradeLevel()*/);
        upgradeLevel.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        upgradeLevel.setForeground(Color.yellow);
        weaponType = new JLabel("Weapon type: " /*+ gameInstance.getWeaponType()*/);
        weaponType.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        weaponType.setForeground(Color.green);
        firewallAmount = new JLabel("Firewalls: " /*+ gameInstance.getFirewalls()*/);
        firewallAmount.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        firewallAmount.setForeground(Color.orange);

        statsBar.add(hazardsOnScreen);
        statsBar.add(Box.createHorizontalStrut(10));
        statsBar.add(upgradeLevel);
        statsBar.add(Box.createHorizontalStrut(10));
        statsBar.add(weaponType);
        statsBar.add(Box.createHorizontalStrut(10));
        statsBar.add(firewallAmount);
    } // createOperations

    // EFFECTS: creates the button panel for operations in the game on the bottom edge
    public void createOperations() {
        operationsBar = new JPanel();
        operationsBar.setLayout(new BoxLayout(operationsBar, 1));

        operationsBar.add(enemyFire);
        operationsBar.add(upgrade);
        operationsBar.add(changeWeapon);
        operationsBar.add(collectFirewall);
        operationsBar.add(useFirewall);
        operationsBar.add(saveAndExit);
    } // createOperations

    // REQUIRES: panel needs to have null layout
    // MODIFIES: this
    // EFFECTS: adds button to panel at given x and y positions
    public void addButton(JPanel panel, JButton button, int x, int y) {
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(button);
        panel.repaint();
    } // addButton

} // GameFrame
