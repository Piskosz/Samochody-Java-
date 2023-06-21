package com.example.samochody_desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller class for the Hello.fxml file.
 * Handles events and updates the welcome text label.
 */
public class HelloController {
    @FXML
    private Label welcomeText;
    /**
     * Default constructor.
     */
    public HelloController() {
        // Default constructor
    }

    /**
     * Event handler for the helloButton click event.
     * Updates the welcome text label with a welcome message.
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}