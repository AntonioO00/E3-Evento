module com.example.eventofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens Aplicativo to javafx.fxml;
    exports Aplicativo;
}