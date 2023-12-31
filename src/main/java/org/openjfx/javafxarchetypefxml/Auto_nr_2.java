package org.openjfx.javafxarchetypefxml;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * The main application class for Auto_nr_2.
 */
public class Auto_nr_2 extends Application {
    private TextArea dataTextArea;
    @FXML
    private AnchorPane rootPane;
    /**
     * Default constructor.
     */
    public Auto_nr_2() {
        // Default constructor
    }
    /**
     * The entry point for the JavaFX application.
     *
     * @param primaryStage the primary stage for the application
     */
    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button("Zrezygnuj");
        Button button2 = new Button("Wypożycz");
        dataTextArea = new TextArea();

        button1.setOnAction(event -> openWybor2());
        button2.setOnAction(event -> openData());

        VBox root = new VBox(button1, button2, dataTextArea);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        OkHttpClient client = new OkHttpClient();

        Task<String> fetchDataTask = new Task<>() {
            @Override
            protected String call() {
                Request request = new Request.Builder()
                        .url("http://localhost:8080/AUTA")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    return response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void succeeded() {
                String result = getValue();
                processResult(result);
            }
        };

        Thread fetchDataThread = new Thread(fetchDataTask);
        fetchDataThread.start();
    }

    /**
     * Opens the wybor2 view.
     */
    public void openWybor2() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Przeglad.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the data view.
     */
    public void openData() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Auto_wyp_1.fxml"));
            AnchorPane rejestracjaPane = loader.load();
            rootPane.getChildren().setAll(rejestracjaPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the fetched result from the server.
     *
     * @param result the fetched result as a string
     */
    private void processResult(String result) {
        JSONArray jsonArray = new JSONArray(result);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("id");

            if (id == 2) {
                String marka = jsonObject.getString("marka");
                int rocznik = jsonObject.getInt("rocznik");
                String model = jsonObject.getString("model");

                String data = "Marka: " + marka + "\n"
                        + "Rocznik: " + rocznik + "\n"
                        + "Model: " + model + "\n";

                dataTextArea.setText(data);
                break;
            }
        }
    }

    /**
     * The entry point for the Java application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}