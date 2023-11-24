package Eventos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.text.DecimalFormat;

public class Gerenciador {
    private ArrayList<Evento> eventos;
    private Evento evento;
    private Terremoto terremoto;
    private Seca seca;
    private Ciclone ciclone;


    public Gerenciador() {
        eventos = new ArrayList<Evento>();
    }

    public ArrayList<Evento> getEventos(){
        return eventos;
    }

    public boolean consultaCod(String codigo) {
        for (Evento evento : eventos) {
            if (evento.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean addE(Evento evento) {
        if (consultaCod(evento.getCodigo())){
            return false;
        }
        eventos.add(evento);
        ordenaE();
        return true;
    }

    public void ordenaE() {
        Collections.sort(eventos, Comparator.comparing(Evento::getCodigo));
    }


    public double Double(double valor) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return Double.parseDouble(decimal.format(valor));
    }

    public String toString(Evento evento) {
        if (evento instanceof Terremoto) {
            Terremoto e = (Terremoto) evento;
            return  "Codigo: "+e.getCodigo() + "\n"+
                    "Latitude: "+e.getLatitude()+"\n"+
                    "Longitude "+e.getLongitude()+"\n"+
                    "Data: "+e.getData()+"\n"+
                    "Magnitude: "+e.getMagnitude()+"\n" ;


        }
        if (evento instanceof Ciclone) {
            Ciclone e = (Ciclone) evento;
            return "Codigo: "+e.getCodigo() + "\n"+
                    "Latitude: "+e.getLatitude()+"\n"+
                    "Longitude "+e.getLongitude()+"\n"+
                    "Data: "+e.getData()+"\n"+
                    "Precipitação: "+e.getPrecipitacao()+"\n";


        }
        if (evento instanceof Seca) {
            Seca e = (Seca) evento;
            return "Codigo: "+e.getCodigo() + "\n"+
                    "Latitude: "+e.getLatitude()+"\n"+
                    "Longitude "+e.getLongitude()+"\n"+
                    "Data: "+e.getData()+"\n"+
                    "Estiagem: "+e.getEstiagem()+"\n";
        }

        return null;
    }


}
