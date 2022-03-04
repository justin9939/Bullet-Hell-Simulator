package ui;

import java.io.FileNotFoundException;

// starts the entire program, creating a new instance of the game console
public class Main {
    public static void main(String[] args) {
        try {
            new GameConsole();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run game: File not found");
        } // try... catch
    } // main
} // Main
