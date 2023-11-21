package Aplicativo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    @FXML
    private ChoiceBox<String> eventbox;
    private String[] evento = {"Ciclone","Terremoto", "Seca"};



    public void initialize(URL url, ResourceBundle resourceBundle) {
        eventbox.getItems().addAll(evento);
        eventbox.setOnAction(event -> choiceBoxChange());
    }
    public void getEvento(ActionEvent event){
        String myEvento = eventbox.getValue();
    }
    public void choiceBoxChange() {
        String selectedEvent = eventbox.getValue();
        if ("Ciclone".equals(selectedEvent)) {
            System.out.println("teste");
        } else if ("Terremoto".equals(selectedEvent)) {
            System.out.println("vai");
        } else if ("Seca".equals(selectedEvent)) {
            System.out.println("lsakfjla");
        }
    }



}