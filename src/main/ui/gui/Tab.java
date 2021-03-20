package ui.gui;

import ui.FitnessApp;

import javax.swing.*;
import java.awt.*;

public abstract class Tab extends JPanel {
    private FitnessApp controller;

    public Tab(FitnessApp controller) {
        this.controller = controller;
    }

    public FitnessApp getController() {
        return controller;
    }


}
