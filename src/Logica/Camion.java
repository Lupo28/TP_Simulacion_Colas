package Logica;

public class Camion
{
    private int numero;
//    private long tiempoLlegada;
    private EstadoCamion estado;



    public Camion(int numero, EstadoCamion estado)
    {
        this.numero = numero;
//        this.tiempoLlegada = tiempoLlegada;
        this.estado=estado;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

//    public long getTiempoLlegada() {
//        return tiempoLlegada;
//    }

//    public void setTiempoLlegada(long tiempoLlegada) {
//        this.tiempoLlegada = tiempoLlegada;
//    }

    public EstadoCamion getEstado() {
        return estado;
    }

    public void setEstado(EstadoCamion estado) {
        this.estado = estado;
    }






}
