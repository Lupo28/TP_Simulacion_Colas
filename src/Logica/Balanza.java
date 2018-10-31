package Logica;

import java.util.LinkedList;

public class Balanza {
    private long tiempoAtencion;
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

    public Balanza()
    {
        this.cola = new LinkedList<Camion>();
        this.estadoBalanza = EstadoBalanza.Libre;
    }

    public LinkedList<Camion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Camion> cola) {
        this.cola = cola;
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

    public EstadoBalanza getEstadoBalanza() {
        return estadoBalanza;
    }

    public void setEstadoBalanza(EstadoBalanza estadoBalanza) {
        this.estadoBalanza = estadoBalanza;
    }

    //Calcula tiempo de atencion
    public long calcularTiempoAtencion(){
        double demora = 5 + Math.random() * 2;
        this.tiempoAtencion = (long)(demora/60);
        return getTiempoAtencion();
    }

    public long proximoBalanza(long relojActual){
        this.proxFinAtencion = relojActual + this.tiempoAtencion;
        return getProxFinAtencion();
    }
}
