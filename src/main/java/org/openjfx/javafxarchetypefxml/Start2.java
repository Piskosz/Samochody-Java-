package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Start2 extends Application {
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField hasloTextField;

    @FXML
    private TextField mailTextField;
    @FXML
    private AnchorPane rootPane;
    private OkHttpClient client;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start2.fxml"));
            rootPane = loader.load();

            loginTextField = new TextField();
            hasloTextField = new TextField();
            mailTextField = new TextField();

            Button button = new Button("Zarejestruj");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String login = loginTextField.getText().trim();
                    String haslo = hasloTextField.getText().trim();
                    String mail = mailTextField.getText().trim();

                    if (isValidInput(login, haslo, mail)) {
                        registerUser(login, haslo, mail);
                    }
                }
            });

            VBox root = new VBox(10);
            root.setPadding(new Insets(10));
            root.getChildren().addAll(loginTextField, hasloTextField, mailTextField, button);

            rootPane.getChildren().add(root);

            Scene scene = new Scene(rootPane, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Start2");
            primaryStage.show();

            // Inicjalizacja klienta OkHttp
            client = new OkHttpClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidInput(String login, String haslo, String mail) {
        if (login.isEmpty() || haslo.isEmpty() || mail.isEmpty()) {
            Platform.runLater(() -> showAlert("Wprowadź wszystkie dane"));
            return false;
        }

        return true;
    }

    private void registerUser(String login, String haslo, String mail) {
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
                Platform.runLater(() -> showAlert("Błąd podczas rejestracji"));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Platform.runLater(() -> {
                        showAlert("Rejestracja zakończona sukcesem");
                        openLogowanie2();
                    });
                } else {
                    Platform.runLater(() -> showAlert("Błąd rejestracji: " + response.code() + " " + response.message()));
                }
            }
        });
    }

    public void openLogowanie2() {
        if (isValidInput(loginTextField.getText(), hasloTextField.getText(), mailTextField.getText())) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Start3.fxml"));
                Parent root = loader.load();
                Scene scene = rootPane.getScene();
                scene.setRoot(root);
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

    @FXML
    public void ZarejestrujB(ActionEvent actionEvent) {
        openLogowanie2();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
