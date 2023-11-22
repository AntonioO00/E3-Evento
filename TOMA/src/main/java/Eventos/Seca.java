package Eventos;

public class Seca extends Evento{
    private int estiagem;

    public Seca(String codigo, String data, double longitude, double latitude, int estiagem) {
        super(codigo, data, longitude, latitude);
        this.estiagem = estiagem;
    }

    public int getEstiagem() {
        return estiagem;
    }
}
