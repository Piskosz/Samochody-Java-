module org.openjfx.javafxarchetypefxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires json;


    opens org.openjfx.javafxarchetypefxml to javafx.fxml;
    exports org.openjfx.javafxarchetypefxml;
}