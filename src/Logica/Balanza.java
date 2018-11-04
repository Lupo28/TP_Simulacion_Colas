package Logica;

import java.util.LinkedList;

public class Balanza {
    private double tiempoAtencion;
    private double proxFinAtencion;
    private double randomAtencion;
    private Camion camion;
    private EstadoBalanza estadoBalanza;
    private LinkedList<Camion> cola;

    public double getProxFinAtencion() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(double proxFinAtencion) {
        this.proxFinAtencion = proxFinAtencion;
    }

    public double getRandomAtencion() {
        return randomAtencion;
    }

    public void setRandomAtencion(double randomAtencion) {
        this.randomAtencion = randomAtencion;
    }

    public Balanza()
    {
        this.tiempoAtencion = 0;
        this.proxFinAtencion = 0;
        this.cola = new LinkedList<Camion>();
        this.estadoBalanza = EstadoBalanza.Libre;
    }

    public LinkedList<Camion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Camion> cola) {
        this.cola = cola;
    }
    public double getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(double tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
        if (camion != null) {
            calcularTiempoAtencion();
            proximoBalanza(Reloj.getInstancia().getTiempoActual());
            this.setEstadoBalanza(EstadoBalanza.Ocupado);
        }
    }

    public EstadoBalanza getEstadoBalanza() {
        return estadoBalanza;
    }

    public void setEstadoBalanza(EstadoBalanza estadoBalanza) {
        this.estadoBalanza = estadoBalanza;
    }

    //Calcula tiempo de atencion
    public double calcularTiempoAtencion(){
        this.setRandomAtencion(Math.random());
        double demora = 5 + this.getRandomAtencion() * 2;
        this.tiempoAtencion = (demora/60);
        return getTiempoAtencion();
    }

    public double proximoBalanza(double relojActual){
        this.proxFinAtencion = relojActual + this.tiempoAtencion;
        return getProxFinAtencion();
    }

    @Override
    public String toString() {
        return "Balanza{" +
                "tiempoAtencion=" + tiempoAtencion +
                ", proxFinAtencion=" + proxFinAtencion +
                ", camion=" + camion +
                ", estadoBalanza=" + estadoBalanza +
                ", cola=" + cola +
                '}';
    }
}
