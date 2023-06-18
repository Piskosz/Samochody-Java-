package org.openjfx.javafxarchetypefxml;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Przeglad extends Application{
ListView<String>listView;
Scene scene;
Stage window;

    @Override
    public void start(Stage stage) throws Exception {

        listView = new ListView<>();
        listView.getItems().addAll("Auta1","Auta2","Auta");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView);

        scene = new Scene(layout,300,250);
        window.getScene(scene);
        window.show();

    }
}
