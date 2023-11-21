package Eventos;

public class Ciclone extends Evento{
    private double velocidade;
    private double precipitacao;

    public Ciclone(String codigo, String data, double longitude, double latitude, double velocidade, double precipitacao) {
        super(codigo, data, longitude, latitude);
        this.velocidade = velocidade;
        this.precipitacao = precipitacao;
    }

    public double getPrecipitacao() {
        return precipitacao;
    }

    public double getVelocidade() {
        return velocidade;
    }
}
