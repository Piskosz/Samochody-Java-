package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Start1 extends Application {
    private Stage primaryStage;
    @FXML
    private AnchorPane rootPane;

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

    private void createRootPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start1.fxml"));
            rootPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStartView() {
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showLogowanieView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start2.fxml"));
            AnchorPane logowaniePane = loader.load();
            rootPane.getChildren().setAll(logowaniePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showRejestracjaView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start3.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onLogowanieButtonClicked(ActionEvent event) {
        showLogowanieView();
    }

    @FXML
    private void onRejestracjaButtonClicked(ActionEvent event) {
        showRejestracjaView();
    }
}
