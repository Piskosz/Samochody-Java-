package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * The main application class for AutoWyp3.
 */
public class AutoWyp3 extends Application {
    private Stage primaryStage;
    @FXML
    private AnchorPane rootPane;

    /**
     * Default constructor.
     */
    public AutoWyp3() {
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
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Wybór samochodów");
        createRootPane();
        showStartView();
    }

    /**
     * Creates the root pane for the application.
     */
    private void createRootPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Przeglad.fxml"));
            rootPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the start view of the application.
     */
    private void showStartView() {
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Performs the action for zmiana1.
     * It changes the view to Przeglad.fxml.
     */
    private void zmiana1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Przeglad.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for przycisk1.
     *
     * @param event the action event
     */
    @FXML
    private void przycisk1(ActionEvent event) {
        zmiana1();
    }
}