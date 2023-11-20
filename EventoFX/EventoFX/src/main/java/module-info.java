module com.example.eventofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.eventofx to javafx.fxml;
    exports com.example.eventofx;
}