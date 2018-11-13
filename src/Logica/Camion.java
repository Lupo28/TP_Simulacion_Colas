package Logica;

public class Camion
{
    private int numero;
    private EstadoCamion estado;
    private double tiempoDeEntrada;
    private double tiempoFinAtRecepcion;
    private double tiempoFinAtBalanza;


    public Camion(int numero, EstadoCamion estado, double tiempoEntrada)
    {
        this.numero = numero;
        this.estado=estado;
        this.tiempoDeEntrada = tiempoEntrada;
    }

    public Camion(EstadoCamion estado, double tiempoDeEntrada){
        this.numero = 0;
        this.estado = estado;
        this.tiempoDeEntrada = tiempoDeEntrada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoCamion getEstado() {
        return estado;
    }

    public void setEstado(EstadoCamion estado) {
        this.estado = estado;
    }

    public double getTiempoDeEntrada() {
        return tiempoDeEntrada;
    }

    public void setTiempoDeEntrada(double tiempoDeEntrada) {
        this.tiempoDeEntrada = tiempoDeEntrada;
    }

    public double getTiempoFinAtRecepcion() {
        return tiempoFinAtRecepcion;
    }

    public void setTiempoFinAtRecepcion(double tiempoFinAtRecepcion) {
        this.tiempoFinAtRecepcion = tiempoFinAtRecepcion;
    }

    public double getTiempoFinAtBalanza() {
        return tiempoFinAtBalanza;
    }

    public void setTiempoFinAtBalanza(double tiempoFinAtBalanza) {
        this.tiempoFinAtBalanza = tiempoFinAtBalanza;
    }

    public String getNumeroString() {

        return (this.numero != 0) ? Integer.toString(getNumero()) : "-";
    }
}
