package ui;

import javax.swing.*;

// Image background reused for the main menu, controls, and gameplay
public class BackgroundPanel extends JPanel {
    private int width = GameFrame.GAME_WINDOW_WIDTH;
    private int height = GameFrame.GAME_WINDOW_HEIGHT;
    private JLabel background;

    public BackgroundPanel(String filename) {
        ImageIcon backgroundIcon = new ImageIcon(filename);
        background = new JLabel();
        background.setIcon(backgroundIcon);

        this.setBounds(0, 0, width, height);
        this.add(background);
    } // ImageBackground

} // ImageBackground
