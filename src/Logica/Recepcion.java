package Logica;

import java.util.LinkedList;

public class Recepcion {
    private long tiempoAtencion;
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

    public Recepcion(long tiempoAtencion, EstadoRecepcion estado, Camion camion) {
        this.tiempoAtencion = tiempoAtencion;
        this.estado = estado;
        this.camion= camion;
        this.cola=null;
    }

    public long getTiempoAtencion() {
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
}
