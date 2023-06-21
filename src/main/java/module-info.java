/**
 * Provides the module declaration for the JavaFX Archetype FXML application.
 * Requires JavaFX, OkHttp, and JSON libraries.
 * Opens the package to JavaFX for FXML loading and exports the package for external use.
 */
module org.openjfx.javafxarchetypefxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires json;
    //requires gson;


    opens org.openjfx.javafxarchetypefxml to javafx.fxml;
    exports org.openjfx.javafxarchetypefxml;
}