package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import okhttp3.*;

import java.io.IOException;

public class Start2 extends Application {
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField hasloTextField;

    @FXML
    private TextField mailTextField;

    private OkHttpClient client;

    @FXML
    private void handleZarejestrujButtonAction() {
        String login = loginTextField.getText().trim();
        String haslo = hasloTextField.getText().trim();
        String mail = mailTextField.getText().trim();

        if (isValidInput(login, haslo, mail)) {
            registerUser(login, haslo, mail);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start2.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Start2");
            primaryStage.show();



            // Pobranie kontrolerów z pliku FXML
            Start2 controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPrimaryStage(Stage primaryStage) {
        // Inicjalizacja pól tekstowych i przycisku za pomocą kontrolek z FXML
        loginTextField = new TextField();
        hasloTextField = new TextField();
        mailTextField = new TextField();

        Button button = new Button("Zarejestruj");
        button.setOnAction(event -> handleZarejestrujButtonAction());

        // Dodanie kontrolek do rodzica (AnchorPane) z FXML
        AnchorPane rootPane = (AnchorPane) loginTextField.getParent().getParent();
        rootPane.getChildren().addAll(loginTextField, hasloTextField, mailTextField, button);

        // Inicjalizacja klienta OkHttp
        client = new OkHttpClient();
    }

    private boolean isValidInput(String login, String haslo, String mail) {
        if (login.isEmpty() || haslo.isEmpty() || mail.isEmpty()) {
            showAlert("Wprowadź wszystkie dane");
            return false;
        }
        return true;
    }

    private void registerUser(String login, String haslo, String mail) {
        client = new OkHttpClient();
        String json = "[{\"login\": \"" + login + "\", \"haslo\": \"" + haslo + "\", \"mail\": \"" + mail + "\"}]";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080/Rejestracja/dodawanie/")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                showAlert("Błąd podczas rejestracji");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    showAlert("Rejestracja zakończona sukcesem");
                    openLogowanie2();
                } else {
                    showAlert("Błąd podczas rejestracji");
                }
            }
        });
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

    private void openLogowanie2() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Start3.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Logowanie");
                stage.show();

                Stage primaryStage = (Stage) loginTextField.getScene().getWindow();
                primaryStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}