package Eventos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gerenciador {
    private ArrayList<Evento> eventos;

    public Gerenciador() {
        eventos = new ArrayList<Evento>();
    }

    public Evento consultaCod(String codigo) {
        for (Evento evento : eventos) {
            if (evento.getCodigo().equals(codigo)) {
                return evento;
            }
        }
        return null;
    }

    public void ordenaE() {
        Collections.sort(eventos, Comparator.comparing(Evento::getCodigo));
    }

    public boolean addE(Evento evento) {
        if (consultaCod(evento.getCodigo()) == null) {
            eventos.add(evento);
        }
        return false;
    }


    public boolean cadastraTerremoto(String codigo, String data, double longitude, double latitude, double magnitude) {
        Evento e = new Terremoto(codigo, data, longitude, latitude, magnitude);
        if (addE(e)) {
            ordenaE();
            return true;
        }
        return false;
    }
    public boolean cadastraCiclone(String codigo, String data, double longitude, double latitude, double velocidde, double precipitacao) {
       Evento e = new Ciclone(codigo, data, longitude, latitude, velocidde, precipitacao);
        if (addE(e)) {
            ordenaE();
            return true;
        }
        return false;
    }
    public boolean cadastraSeca(String codigo, String data, double longitude, double latitude, int estiagem) {
        Evento e = new Seca(codigo, data, longitude, latitude, estiagem);
        if (addE(e)) {
            ordenaE();
            return true;
        }
        return false;
    }


}
