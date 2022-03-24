package ui;

import javax.swing.*;
import java.awt.*;

// separate window for controls, so players can refer to controls while playing
public class ControlsFrame extends JFrame {
    private int width = GameFrame.GAME_WINDOW_WIDTH;
    private int height = GameFrame.GAME_WINDOW_HEIGHT;

    public ControlsFrame() {
        super("Controls");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);

        this.add(new BackgroundPanel("data/controlsImage.jpg"));
        this.setVisible(true);
    } // ControlsFrame
} // ControlsFrame
