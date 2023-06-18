module com.example.samochody_desktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.samochody_desktop to javafx.fxml;
    exports com.example.samochody_desktop;
    exports com.example.car_rental;
    opens com.example.car_rental to javafx.fxml;
}