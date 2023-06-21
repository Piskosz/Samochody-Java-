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
 * The main application class for Start1.
 */
public class Start1 extends Application {
    private Stage primaryStage;
    @FXML
    private AnchorPane rootPane;

    /**
     * Default constructor.
     */
    public Start1() {
        // Default constructor
    }
    /**
     * The entry point for the Java application.
     *
     * @param args the command-line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Car Rental");

        createRootPane();
        showStartView();
    }

    /**
     * Creates the root pane by loading the FXML file.
     */
    private void createRootPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start1.fxml"));
            rootPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the start view by setting the root pane in the primary stage.
     */
    private void showStartView() {
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Switches to the logowanie view by loading and displaying the Start2.fxml file.
     */
    private void showLogowanieView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start2.fxml"));
            AnchorPane logowaniePane = loader.load();
            rootPane.getChildren().setAll(logowaniePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to the rejestracja view by loading and displaying the Start3.fxml file.
     */
    private void showRejestracjaView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start3.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Event handler for the logowanie button click.
     *
     * @param event the action event
     */
    @FXML
    private void onLogowanieButtonClicked(ActionEvent event) {
        showLogowanieView();
    }

    /**
     * Event handler for the rejestracja button click.
     *
     * @param event the action event
     */
    @FXML
    private void onRejestracjaButtonClicked(ActionEvent event) {
        showRejestracjaView();
    }
}