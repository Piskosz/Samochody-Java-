package com.example.car_rental;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The main application class for Start1.
 */
public class Start1 extends Application {

    /**
     * Default constructor.
     */
    public Start1() {
        // Default constructor
    }
    /**
     * The entry point for the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the JavaFX application.
     *
     * @param primaryStage the primary stage for the application
     */
    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("Logowanie");
        Button button2 = new Button("Rejestracja");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openLogowanie();
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openRejestracja();
            }
        });

        VBox root = new VBox(button1, button2);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Opens the logowanie window.
     * TODO: Add code to open the logowanie window.
     */
    public void openLogowanie() {
        // TODO: Add code to open the logowanie window
    }

    /**
     * Opens the rejestracja window.
     * TODO: Add code to open the rejestracja window.
     */
    public void openRejestracja() {
        // TODO: Add code to open the rejestracja window
    }
}
