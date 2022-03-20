package ui;

import javax.swing.*;
import java.awt.*;

// main menu screen, start game and access controls from here
public class MenuPanel extends JPanel {
    JLabel greeting = new JLabel("Welcome to Windows Fighter x64!");
    JButton newGame = new JButton("New Game");
    JButton loadGame = new JButton("Load Game");
    JButton controls = new JButton("Controls");

    public MenuPanel() {
        this.setBorder(BorderFactory.createEmptyBorder(150, 100, 150, 100));
        this.setBackground(Color.blue);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(greeting, BorderLayout.CENTER);
        this.add(Box.createRigidArea(new Dimension(100, 30)));
        this.add(newGame, BorderLayout.CENTER);
        this.add(Box.createRigidArea(new Dimension(100, 30)));
        this.add(loadGame, BorderLayout.CENTER);
        this.add(Box.createRigidArea(new Dimension(100, 30)));
        this.add(controls, BorderLayout.CENTER);
    }
}