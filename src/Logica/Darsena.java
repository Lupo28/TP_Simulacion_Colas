package Logica;

import java.util.LinkedList;

public class Darsena {
    private int id;
    private long tiempoAtencion;
    private long proxFinAtencion;
    private Camion camion;
    private EstadoDarsena estadoDarsena;
    private LinkedList<Camion> cola;

    public Darsena() {
        this.cola = new LinkedList<Camion>();
        this.estadoDarsena = EstadoDarsena.Libre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(long tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public long getProxFinAtencion() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(long proxFinAtencion) {
        this.proxFinAtencion = proxFinAtencion;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public EstadoDarsena getEstadoDarsena() {
        return estadoDarsena;
    }

    public void setEstadoDarsena(EstadoDarsena estadoDarsena) {
        this.estadoDarsena = estadoDarsena;
    }

    public LinkedList<Camion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Camion> cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        return "Darsena ("+ id +") {" + "estado=" + this.getEstadoDarsena() + '}';
    }

    //Calcula el tiempo de atencion
    public long calcularTiempoAtencion() {
        double demora = 15 + Math.random() * 5;
        this.tiempoAtencion = (long) (demora / 60);
        return getTiempoAtencion();
    }

    //Calcula el proximo fin de atencion
    public long proximoDarsena(long relojActual) {
        this.proxFinAtencion = relojActual + this.tiempoAtencion;
        return getProxFinAtencion();
    }
}
