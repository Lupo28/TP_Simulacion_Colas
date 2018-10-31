package Logica;

import java.util.LinkedList;

public class Recepcion {
    private double tiempoAtencion;
    private long proxFinAtencion;
    private EstadoRecepcion estado;
    private Camion camion;
    private LinkedList<Camion> cola;


    public LinkedList<Camion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Camion> cola) {
        this.cola = cola;
    }

    public void agregarCamionAcola(Camion c)
    {
        cola.add(c);
    }


    public Recepcion(){}

    public Recepcion( EstadoRecepcion estado, Camion camion) {

        this.tiempoAtencion = calcularTiempoAtencion();
        this.estado = estado;
        this.camion= camion;
        this.cola=null;
    }

    public double getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(long tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public EstadoRecepcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecepcion estado) {
        this.estado = estado;
    }

    public long getProxFinAtencion() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(long proxFinAtencion) {
        this.proxFinAtencion = proxFinAtencion;
    }

    public void atenderCamion()
    {

    }

    public long calcularTiempoAtencion()
    {
        double demora = 3 + Math.random() * 4;
        this.tiempoAtencion= (demora/60);
        return (long)getTiempoAtencion();
    }

    public long proximoFinDeATencion(long relojActual)
    {

        setProxFinAtencion((long)getTiempoAtencion() + relojActual);
        return getProxFinAtencion();
    }
}
