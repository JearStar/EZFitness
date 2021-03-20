package ui.gui;

import ui.FitnessApp;

import javax.swing.*;

import java.awt.*;

import static ui.FitnessApp.ADDING_TAB_LABEL;
import static ui.FitnessApp.VIEWING_TAB_LABEL;

public class TitleScreen extends Tab {
    public TitleScreen(FitnessApp controller) {
        super(controller);

        placeNavigationButtons();
    }

    private void placeNavigationButtons() {
        JButton b1 = new JButton(VIEWING_TAB_LABEL);
        JButton b2 = new JButton(ADDING_TAB_LABEL);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(169,169,169));
        mainPanel.setBounds(0,0, FitnessApp.WIDTH, FitnessApp.HEIGHT);
    }
}
