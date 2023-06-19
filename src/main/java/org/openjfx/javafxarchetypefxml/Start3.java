package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Start3 extends Application {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField hasloTextField;

    @FXML
    private Button odzyskiwanieButton;

    @FXML
    private Button loginButton;

    private OkHttpClient client;

    @FXML
    private void loginUser() {
        if (client == null) {
            client = new OkHttpClient();
        }
        String login = loginTextField.getText().trim();
        String haslo = hasloTextField.getText().trim();

        String url = "http://127.0.0.1:8080/Rejestracja?login=" + login + "&haslo=" + haslo;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Platform.runLater(() -> showAlert("Błąd podczas logowania"));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();

                Platform.runLater(() -> {
                    try {
                        if (responseData != null && !responseData.isEmpty()) {
                            openWybor1();
                        } else {
                            showAlert("Nieprawidłowy login lub hasło");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        showAlert("Błąd podczas logowania");
                    }
                });
            }
        });
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("start3.fxml"));
            rootPane = loader.load();

            loginTextField = new TextField();
            hasloTextField = new TextField();

            // Inicjalizacja klienta OkHttp
            client = new OkHttpClient();


            Button zalogujButton = new Button("Zaloguj");
            zalogujButton.setOnAction(event -> {
                if (isValidInput()) {
                    loginUser();
                }
            });

            VBox root = new VBox(10);
            root.setPadding(new Insets(10));
            root.getChildren().addAll(loginTextField, hasloTextField,  zalogujButton);

            rootPane.getChildren().add(root);

            Scene scene = new Scene(rootPane, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Start3");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidInput() {
        String login = loginTextField.getText().trim();
        String haslo = hasloTextField.getText().trim();

        if (login.isEmpty() && haslo.isEmpty()) {
            Platform.runLater(() -> showAlert("Wprowadź login i hasło"));
            return false;
        }

        if (login.isEmpty()) {
            Platform.runLater(() -> showAlert("Wprowadź login"));
            return false;
        }

        if (haslo.isEmpty()) {
            Platform.runLater(() -> showAlert("Wprowadź hasło"));
            return false;
        }

        return true;
    }


    public void openWybor1() {
        String login = loginTextField.getText().trim();
        String haslo = hasloTextField.getText().trim();

        if (isValidInput()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Przeglad.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
