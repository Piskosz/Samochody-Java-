package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Przeglad extends Application {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Auto_nr_1.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void przycisk1(ActionEvent event) {
        zmiana1();
    }
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
    private void przycisk2(ActionEvent event) {
        zmiana2();
    }
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
    private void przycisk3(ActionEvent event) {
        zmiana3();
    }
}




