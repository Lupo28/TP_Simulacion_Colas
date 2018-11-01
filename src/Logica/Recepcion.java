package Logica;

import java.util.LinkedList;

public class Recepcion {
    private double tiempoAtencion;
    private double proxFinAtencion;
    private double randomAtencion;
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


    public void setTiempoAtencion(double tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public double getRandomAtencion() {
        return randomAtencion;
    }

    public void setRandomAtencion(double randomAtencion) {
        this.randomAtencion = randomAtencion;
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

    public double getProxFinAtencion() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(double proxFinAtencion) {
        this.proxFinAtencion = proxFinAtencion;
    }


    public void calcularTiempoAtencion() {
        setRandomAtencion(Math.random());
        double demora = 3 + getRandomAtencion() * 4;
        this.tiempoAtencion = (demora / 60);
    }

    public void proximoFinDeATencion(double relojActual) {
        setProxFinAtencion(getTiempoAtencion() + relojActual);
    }

    @Override
    public String toString() {
        return "Recepcion{" +
                "tiempoAtencion=" + tiempoAtencion +
                ", proxFinAtencion=" + proxFinAtencion +
                ", estado=" + estado +
                ", camion=" + camion +
                ", cola=" + cola +
                '}';
    }
}
