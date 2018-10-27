package Logica;

public class Camion
{
    private int numero;
    private long tiempoLlegada;


    public Camion(int numero, long tiempoLlegada)
    {
        this.numero = numero;
        this.tiempoLlegada = tiempoLlegada;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(long tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }







}
