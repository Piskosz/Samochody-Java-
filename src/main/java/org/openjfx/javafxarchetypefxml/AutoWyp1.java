package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoWyp1 extends Application {
    private Stage primaryStage;
    @FXML
    private AnchorPane rootPane;

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

    private void createRootPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Przeglad.fxml"));
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

    private void zmiana1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Przeglad.fxml"));
            showAlert("Pomyśłnie  Zarezerwowano");
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void showAlert(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    @FXML
    private void przycisk1(ActionEvent event) {
        zmiana1();
    }
}