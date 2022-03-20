package ui;

import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;

// starts the entire program, creating a new instance of the game console
public class Main extends JFrame {
    public Main() {
        super("Windows Fighter x64");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MenuPanel());
        this.pack();
        this.setVisible(true);

        /*try {
            new GamePlayer();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run game: File not found");
        } // try... catch*/
    }

    public static void main(String[] args) {
        new Main();
    } // main
} // Main
