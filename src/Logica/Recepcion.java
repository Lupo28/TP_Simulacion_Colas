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

    public void agregarCamionAcola(Camion c) {
        cola.add(c);
    }


    public Recepcion() {
        this.estado = EstadoRecepcion.Libre;
        this.cola = new LinkedList<Camion>();
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
        if (camion != null) {
            calcularTiempoAtencion();
            proximoFinDeATencion(Reloj.getInstancia().getTiempoActual());
        }
        else {
            this.tiempoAtencion = 0;
            this.proxFinAtencion = 0;
        }
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


    public void calcularTiempoAtencion() {
        double demora = 3 + Math.random() * 4;
        this.tiempoAtencion = (demora / 60);
    }

    public void proximoFinDeATencion(long relojActual) {
        setProxFinAtencion((long) getTiempoAtencion() + relojActual);
    }
}
