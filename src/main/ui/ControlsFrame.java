package ui;

import javax.swing.*;
import java.awt.*;

// separate window for controls, so players can refer to controls while playing
public class ControlsFrame extends JFrame {
    private int controlsWidth = GameFrame.GAME_WINDOW_WIDTH;
    private int controlsHeight = GameFrame.GAME_WINDOW_HEIGHT;

    public ControlsFrame() {
        super("Controls");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(controlsWidth, controlsHeight);
        this.setResizable(false);

        this.add(new BackgroundPanel("data/controlsImage.jpg", controlsWidth, controlsHeight));
        this.setVisible(true);
    } // ControlsFrame
} // ControlsFrame
