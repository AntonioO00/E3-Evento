package Aplicativo;

import Eventos.Ciclone;
import Eventos.Evento;
import Eventos.Gerenciador;
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

    @FXML
    private Label labelEstiagem;

    @FXML
    private Label labelVelocidade;

    @FXML
    private Label labelMagnitude;

    @FXML
    private Label labelPrecipitacao;

    @FXML
    private TextField textExtra;

    @FXML
    private TextField textExtra2;
    private Gerenciador gerenciador;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Clear();
        eventBox.getItems().addAll(evento);
        eventBox.setOnAction(event -> eventoBox());
    }

    public void eventoBox() {
        String selectedEvent = eventBox.getValue();
        Clear();
        if ("Ciclone".equals(selectedEvent)) {
            labelVelocidade.setVisible(true);
            textExtra.setVisible(true);
            labelPrecipitacao.setVisible(true);
            textExtra2.setVisible(true);
        } else if ("Terremoto".equals(selectedEvent)) {
            labelMagnitude.setVisible(true);
            textExtra.setVisible(true);
        } else if ("Seca".equals(selectedEvent)) {
            labelEstiagem.setVisible(true);
            textExtra.setVisible(true);
        }
    }

    public void Exibir(String mensagem) {
        labelExibe.setText(mensagem);
    }

    public void Clear() {
        labelEstiagem.setVisible(false);
        labelMagnitude.setVisible(false);
        labelVelocidade.setVisible(false);
        labelPrecipitacao.setVisible(false);
        textExtra.setVisible(false);
        textExtra2.setVisible(false);
    }

    public void Limpa() {
        textCodigo.setText(null);
        textLatitude.setText(null);
        textLongitude.setText(null);
        textExtra.setText(null);
        textExtra2.setText(null);
        dataPicker.getEditor().clear();

    }


    public void clickButton() {
        try {
            String codigo = textCodigo.getText();
            String data = dataPicker.getEditor().getText();
            double longitude = Double.parseDouble(textLongitude.getText());
            double latitude = Double.parseDouble(textLatitude.getText());


            String selectedEvent = eventBox.getValue();

            if (selectedEvent.equals("Terremoto")) {
                double magnitude = Double.parseDouble(textExtra.getText());
                gerenciador.cadastraTerremoto(codigo, data, longitude, latitude, magnitude);

            } else if (selectedEvent.equals("Ciclone")) {
                double velocidade = Double.parseDouble(textExtra.getText());
                double precipitacao = Double.parseDouble(textExtra2.getText());
                gerenciador.cadastraCiclone(codigo, data, longitude, latitude, velocidade, precipitacao);
            } else if (selectedEvent.equals("Seca")) {
                int estiagem = Integer.parseInt(textExtra.getText());
                gerenciador.cadastraSeca(codigo, data, longitude, latitude, estiagem);

            }
        } catch (Exception e) {
            labelExibe.setText("Erro :" + e.getMessage());

        }

    }


}