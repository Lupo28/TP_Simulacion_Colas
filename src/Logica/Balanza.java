package Logica;

import java.util.LinkedList;

public class Balanza {
    private long tiempoPesando;
    private long proxFinAtencion;
    private Camion camion;
    private EstadoBalanza estadoBalanza;
    private LinkedList<Camion> cola;

    public long getProxFinAtencion() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(long proxFinAtencion) {
        this.proxFinAtencion = proxFinAtencion;
    }

    public Balanza(long tiempoPesando, Camion camion, EstadoBalanza estadoBalanza)
    {
        this.tiempoPesando=tiempoPesando;
        this.camion=camion;
        this.estadoBalanza=estadoBalanza;
        this.cola=null;

    }

    public LinkedList<Camion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Camion> cola) {
        this.cola = cola;
    }
    public long getTiempoPesando() {
        return tiempoPesando;
    }

    public void setTiempoPesando(long tiempoPesando) {
        this.tiempoPesando = tiempoPesando;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public EstadoBalanza getEstadoBalanza() {
        return estadoBalanza;
    }

    public void setEstadoBalanza(EstadoBalanza estadoBalanza) {
        this.estadoBalanza = estadoBalanza;
    }
}
