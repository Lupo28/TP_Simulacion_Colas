package Logica;

import java.util.LinkedList;

public class Balanza {
    private Double tiempoAtencion;
    private double tiempoRecalibrado;
    private Double proxFinAtencion;
    private double randomAtencion;
    private double randomRecal1;
    private double randomRecal2;
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

    public double getRandomRecal1() {
        return randomRecal1;
    }

    public void setRandomRecal1(double randomRecal1) {
        this.randomRecal1 = randomRecal1;
    }

    public double getRandomRecal2() {
        return randomRecal2;
    }

    public void setRandomRecal2(double randomRecal2) {
        this.randomRecal2 = randomRecal2;
    }

    public Balanza()
    {
        this.tiempoAtencion = null;
        this.proxFinAtencion = null;
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

    public double getTiempoRecalibrado(){return tiempoRecalibrado;}

    public void setTiempoRecalibrado(double tiempoRecalibrado){this.tiempoRecalibrado = tiempoRecalibrado;}

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
    public double calcularTiempoAtencion(){
        this.setRandomAtencion(Math.random());
        double demora = 5 + this.getRandomAtencion() * 2;
        this.tiempoAtencion = (demora/60);
        return getTiempoAtencion();
    }

    public double proximoBalanza(long relojActual){
        this.proxFinAtencion = relojActual + this.tiempoAtencion;
        return getProxFinAtencion();
    }

    //Calcula el tiempo que tomara recalibrar la balanza
    public double calcularTiempoRecalibrado(){
        this.setRandomRecal1(Math.random());
        this.setRandomRecal2(Math.random());
        double z = Math.sqrt(-2*Math.log(this.getRandomRecal1())*Math.cos(2*Math.PI*this.getRandomRecal2()));
        double demora = 10 + (z*1.2);
        this.tiempoRecalibrado = (demora / 60);
        this.estadoBalanza = EstadoBalanza.En_Recalibracion;
        return getTiempoRecalibrado();
    }

    @Override
    public String toString() {
        return "Balanza{" +
                "tiempoAtencion=" + tiempoAtencion +
                ", tiempoRecalibrado=" + tiempoRecalibrado +
                ", proxFinAtencion=" + proxFinAtencion +
                ", camion=" + camion +
                ", estadoBalanza=" + estadoBalanza +
                ", cola=" + cola +
                '}';
    }
}
