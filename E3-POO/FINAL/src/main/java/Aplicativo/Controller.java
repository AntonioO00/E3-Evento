package Aplicativo;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Eventos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;

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
    @FXML
    private Label labelCodigo;
    @FXML
    private Label labelLatitude;
    @FXML
    private Label labelLongitude;
    @FXML
    private Label labelData;
    @FXML
    private Label labelPrint;
    @FXML
    private ScrollPane pane;


    Gerenciador gerenciador = new Gerenciador();
    Alert alert = new Alert(AlertType.INFORMATION);
    Alert erro = new Alert(AlertType.ERROR);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Clear();
        eventBox.getItems().addAll(evento);
        eventBox.setOnAction(event -> eventoBox());
    }

    public void eventoBox() {
        String selectedEvent = eventBox.getValue();
        Clear();
        Toma();
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

    public void systemPrint(String x) {
        labelExibe.setText(x);
    }


    public void Clear() {
        labelCodigo.setVisible(false);
        labelLatitude.setVisible(false);
        labelLongitude.setVisible(false);
        labelData.setVisible(false);
        dataPicker.setVisible(false);
        labelEstiagem.setVisible(false);
        labelMagnitude.setVisible(false);
        labelVelocidade.setVisible(false);
        labelPrecipitacao.setVisible(false);

        textCodigo.setVisible(false);
        textLatitude.setVisible(false);
        textLongitude.setVisible(false);
        textExtra.setVisible(false);
        textExtra2.setVisible(false);

        cadastrarButton.setVisible(false);
        limparButton.setVisible(false);
        exibirButton.setVisible(false);

    }

    public void Toma() {

        labelCodigo.setVisible(true);
        labelLatitude.setVisible(true);
        labelLongitude.setVisible(true);
        labelData.setVisible(true);
        dataPicker.setVisible(true);

        textCodigo.setVisible(true);
        textLatitude.setVisible(true);
        textLongitude.setVisible(true);

        cadastrarButton.setVisible(true);
        limparButton.setVisible(true);
        exibirButton.setVisible(true);


    }

    public void Limpa() {
        textCodigo.setText(null);
        textLatitude.setText(null);
        textLongitude.setText(null);
        textExtra.setText(null);
        textExtra2.setText(null);
        dataPicker.getEditor().clear();
        labelExibe.setText(null);
    }


    public void clickButton() {
        try {


            String codigo = textCodigo.getText();
            String data = dataPicker.getEditor().getText();
            double longitude = Double.parseDouble(textLongitude.getText());
            double latitude = Double.parseDouble(textLatitude.getText());
            String selectedEvent = eventBox.getValue();

            Evento e = null;

            if (selectedEvent.equals("Terremoto")) {
                double magnitude = Double.parseDouble(textExtra.getText());
                e = new Terremoto(codigo, data, longitude, latitude, magnitude);
                if (gerenciador.addE(e)) {
                    Limpa();
                    alert.setTitle("STATUS");
                    alert.setHeaderText(null);
                    alert.setContentText("CADASTRADO COM SUCESSO");
                    alert.showAndWait();

                } else {
                    Limpa();
                    erro.setTitle("STATUS");
                    erro.setHeaderText(null);
                    erro.setContentText("ERRO: NÃO FOI POSSIVEL REALIZAR O CADASTRO");
                    erro.showAndWait();
                }

            } else if (selectedEvent.equals("Ciclone")) {
                double velocidade = Double.parseDouble(textExtra.getText());
                double precipitacao = Double.parseDouble(textExtra2.getText());
                e = new Ciclone(codigo, data, longitude, latitude, velocidade, precipitacao);
                if (gerenciador.addE(e)) {
                    Limpa();
                    alert.setTitle("STATUS");
                    alert.setHeaderText(null);
                    alert.setContentText("CADASTRADO COM SUCESSO");
                    alert.showAndWait();

                } else {
                    Limpa();
                    erro.setTitle("STATUS");
                    erro.setHeaderText(null);
                    erro.setContentText("ERRO: NÃO FOI POSSIVEL REALIZAR O CADASTRO");
                    erro.showAndWait();
                }


            } else if (selectedEvent.equals("Seca")) {
                int estiagem = Integer.parseInt(textExtra.getText());
                e = new Seca(codigo, data, longitude, latitude, estiagem);
                if (gerenciador.addE(e)) {
                    Limpa();
                    alert.setTitle("STATUS");
                    alert.setHeaderText(null);
                    alert.setContentText("CADASTRADO COM SUCESSO");
                    alert.showAndWait();

                } else {
                    Limpa();
                    erro.setTitle("STATUS");
                    erro.setHeaderText(null);
                    erro.setContentText("ERRO: NÃO FOI POSSIVEL REALIZAR O CADASTRO");
                    erro.showAndWait();
                }
            }
        } catch (NumberFormatException e) {
            Limpa();
            systemPrint("ERRO: você digitou algo de forma errada Tente novamente");

        } catch (NullPointerException e) {
            Limpa();
            systemPrint("Erro: Espaço vazio encontrado." + "\n" + "Tente novamente ");

        } catch (Exception e) {
            labelExibe.setText("Erro :" + e.getMessage());
        }


    }

    public void exibeTodos() {
        ArrayList<Evento> eves = gerenciador.getEventos();

        for (Evento e : eves) {
            alert.setTitle("EVENTO");
            alert.setHeaderText("MOSTRANDO EVENTO INDIVUDUALMENTE");
            alert.setContentText(gerenciador.toString(e));
            alert.showAndWait();

        }
    }


}