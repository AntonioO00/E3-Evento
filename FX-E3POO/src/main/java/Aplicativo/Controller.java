package Aplicativo;

import Eventos.Ciclone;
import Eventos.Seca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private ChoiceBox<String> eventBox;
    private String[] evento = {"Terremoto", "Seca", "Ciclone"};

    @FXML
    private Button backButton;

    @FXML
    private TextField textCodigo;

    @FXML
    private TextField textLatitude;

    @FXML
    private TextField textLongitude;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private Button limparButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button exibirButton;

    @FXML
    private Label labelExibe;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eventBox.getItems().addAll(evento);
    }
    public void choiceBoxChange() {
        String selectedEvent = eventBox.getValue();

        if ("Ciclone".equals(selectedEvent)) {

        } else if ("Terremoto".equals(selectedEvent)) {

        } else if ("Seca".equals(selectedEvent)) {

        }
    }





    public void Exibir(String mensagem){
        labelExibe.setVisible(true);
        labelExibe.setText(mensagem);
    }


}