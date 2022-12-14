package ui;

import javax.swing.*;

// Image background reused for the main menu, controls, and gameplay
public class BackgroundPanel extends JPanel {
    private JLabel background;

    // EFFECTS: creates a new background image from given file with dimensions of given width and height
    public BackgroundPanel(String filename, int width, int height) {
        ImageIcon backgroundIcon = new ImageIcon(filename);
        background = new JLabel();
        background.setIcon(backgroundIcon);

        this.setBounds(0, 0, width, height);
        this.add(background);
    } // ImageBackground

} // ImageBackground
