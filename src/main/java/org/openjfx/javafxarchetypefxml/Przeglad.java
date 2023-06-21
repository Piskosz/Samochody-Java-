package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;



import java.io.IOException;

/**
 * The main application class for Przeglad.
 */
public class Przeglad extends Application {
    private Stage primaryStage;
    @FXML
    private AnchorPane rootPane;
    /**
     * Default constructor.
     */
    public Przeglad() {
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
        primaryStage.setTitle("Wybór samochodów");
        createRootPane();
        showStartView();
    }

    /**
     * Creates the root pane by loading the FXML file.
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
     * Shows the start view by setting the root pane in the primary stage.
     */
    private void showStartView() {
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Performs the necessary changes to switch to Auto_nr_1 view.
     */
    private void zmiana1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Auto_nr_1.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void przycisk1() {
        zmiana1();
    }

    /**
     * Performs the necessary changes to switch to Auto_nr_2 view.
     */
    private void zmiana2() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Auto_nr_2.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void przycisk2() {
        zmiana2();
    }

    /**
     * Performs the necessary changes to switch to Auto_nr_3 view.
     */
    private void zmiana3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Auto_nr_3.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void przycisk3() {
        zmiana3();
    }
}




