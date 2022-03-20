package ui;

import model.Game;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// user interface of the game - what the user will see when playing
public class GamePlayer {
    private static final String JSON_STORE = "./data/savedGame.json";
    private Game gameInstance;
    private Scanner input;
    private boolean continueGame;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs an instance of the entire game
    public GamePlayer() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runGame();
    } // GameConsole

    // MODIFIES: this
    // EFFECTS: runs an instance of the entire game, and processes user input
    // code is based on the runTeller method in TellerApp.java
    // checkstyle warning suppressed because the length is mostly due to the range of user input options
    @SuppressWarnings("methodlength")
    public void runGame() {
        continueGame = true;
        String userInput;

        init();

        while (continueGame) {
            displayMenu();
            userInput = input.next();

            switch (userInput) {
                case "q":
                    continueGame = false;
                    break;
                case "c":
                    runControls();
                    break;
                case "s":
                    gameInstance.newGame();
                    playGame();
                    break;
                case "l":
                    loadGame();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            } // switch
        } // while

        System.out.println("\nGame Over. Thank you for playing.");
    } // runGame

    // MODIFIES: this
    // EFFECTS: initializes the game state and the user input
    public void init() {
        gameInstance = new Game();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    } // init

    // EFFECTS: displays the main menu on the console, with instructions and controls
    public void displayMenu() {
        System.out.println("\nWelcome to Windows Fighter x64!");
        System.out.println("Remember to press enter to submit your input!");
        System.out.println("\t Type in 'c' for the controls.");
        System.out.println("\t Type in 's' to start a new game.");
        System.out.println("\t Type in 'l' to load a previous save, if one exists.");
        System.out.println("\t Type in 'q' to quit.");
    } // displayMenu

    // MODIFIES: this
    // EFFECTS: runs the controls screen, and processes different user inputs than normal
    public void runControls() {
        boolean onControls = true;
        String userInput;

        while (onControls) {
            displayControls();
            userInput = input.next();

            switch (userInput) {
                case "m":
                    onControls = false;
                    break;
                case "q":
                    onControls = false;
                    continueGame = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            } // switch
        } // while
    } // runControls

    // EFFECTS: displays the controls screen on the console
    public void displayControls() {
        System.out.println("\nRight now, the only possible actions to take are all by typed input, "
                + "so these controls are unavailable.");
        System.out.println("However, in the final game, the controls will be as follows:");
        System.out.println("\t Move around with your mouse. You fire automatically.");
        System.out.println("\t Press the space bar to use a firewall, if you have any.");
        System.out.println("\t Press p to pause.");
        System.out.println("Now, type in q to quit, or m to return to the main menu.");
    } // displayControls

    // MODIFIES: this
    // EFFECTS: runs an instance of the playable part of the game, and processes a wider variety of user inputs
    // checkstyle warning suppressed because the length is mostly due to the range of user input options
    @SuppressWarnings("methodlength")
    public void playGame() {
        boolean onGame = true;
        String userInput;

        while (onGame) {
            displayGame();
            userInput = input.next();

            switch (userInput) {
                case "m":
                    saveGame();
                    onGame = false;
                    break;
                case "q":
                    onGame = false;
                    continueGame = false;
                    break;
                case "shoot":
                    doEnemyFire();
                    break;
                case "cf":
                    doCollectFirewall();
                    break;
                case "cu":
                    doCollectUpgrade();
                    break;
                case "firewall":
                    doUseFirewall();
                    break;
                case "cw":
                    doChangeWeaponType();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            } // switch
        } // while
    } // playGame

    // EFFECTS: displays the "playable" part of the (console-based for now) game
    public void displayGame() {
        System.out.println("\nYou are cruising through cyberspace."); // stub
        System.out.println("\t m - Save and return to main menu");
        System.out.println("\t q - Quit the game without saving");
        System.out.println("\t shoot - Simulate an enemy shooting at you");
        System.out.println("\t cf - Collect a firewall");
        System.out.println("\t cu - Collect an upgrade");
        System.out.println("\t firewall - Use a firewall");
        System.out.println("\t cw - Change your weapon type");
    } // displayGame

    // MODIFIES: this
    // EFFECTS: simulates an enemy firing a bullet
    public void doEnemyFire() {
        System.out.println("An enemy fires a bullet at you from the corner of the screen!"
                + " That's one more hazard to avoid.");
        gameInstance.enemyFire();
        printHazards(gameInstance);
    } // doEnemyFire

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
        printFirewalls(gameInstance);
        printHazards(gameInstance);
    } // doCollectFirewall

    // MODIFIES: this
    // EFFECTS: collects an upgrade, and has no effect if player already is at upgrade level 8
    public void doCollectUpgrade() {
        if (gameInstance.getUpgradeLevel() < Game.MAX_UPGRADE_LEVEL) {
            System.out.println("Wow! You collected an upgrade, increasing your upgrade level!");
        } else {
            System.out.println("You're already at max upgrade level; it had no effect!");
        } // if... else
        gameInstance.collectUpgrade();
        printUpgradeLevel(gameInstance);
    } // doCollectUpgrade

    // MODIFIES: this
    // EFFECTS: uses a Firewall, clearing all hazards currently in the game
    //          fails if the player has on firewalls
    public void doUseFirewall() {
        if (gameInstance.useFirewall()) {
            System.out.println("You used a firewall, clearing the screen of all hazards.");
            printFirewalls(gameInstance);
            printHazards(gameInstance);
        } else {
            System.out.println("You have no firewalls to use.");
        } // if... else
    } // doUseFirewall

    // MODIFIES: this
    // EFFECTS: changes the player's current weapon type to the opposite type
    public void doChangeWeaponType() {
        System.out.println("You changed your weapon type.");
        gameInstance.changeWeaponType();
        printWeaponType(gameInstance);
    } // doChangeWeaponType

    // EFFECTS: prints the amount of hazards currently in the game
    public void printHazards(Game game) {
        System.out.println("Amount of hazards (only bullets for now) on screen: "
                + game.getHazards().size());
    } // printHazards

    // EFFECTS: prints the player's current upgrade level
    public void printUpgradeLevel(Game game) {
        System.out.println("Your current upgrade level: " + game.getUpgradeLevel());
    } // printUpgradeLevel

    // EFFECTS: prints the amount of firewalls the player has
    public void printFirewalls(Game game) {
        System.out.println("You have " + game.getFirewalls() + " firewalls.");
    } // printFirewalls

    // EFFECTS: prints the player's current weapon type
    public void printWeaponType(Game game) {
        System.out.println("Your weapon type is: " + game.getWeaponType());
    } // printWeaponType

    // EFFECTS: saves the current game state to file
    private void saveGame() {
        try {
            jsonWriter.open();
            jsonWriter.write(gameInstance);
            jsonWriter.close();
            System.out.println("Saved game to: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        } // try... catch
    } // saveGame

    // MODIFIES: this
    // EFFECTS: loads game state from file
    private void loadGame() {
        try {
            gameInstance = jsonReader.read();
            System.out.println("Loaded game from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        } // try... catch

        playGame();
    } // loadGame

} // GameConsole
