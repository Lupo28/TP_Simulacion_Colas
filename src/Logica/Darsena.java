package Logica;

import java.util.LinkedList;

public class Darsena {
    private int id;
    private double tiempoAtencion;
    private double proxFinAtencion;
    private double tiempoRecalibrado;
    private double proxFinRecalibrado;
    private double randomRecal1;
    private double randomRecal2;
    private double randomAtencion;
    private Camion camion;
    private EstadoDarsena estadoDarsena;

    public Darsena() {
        this.tiempoAtencion = 0;
        this.proxFinAtencion = 0;
        this.estadoDarsena = EstadoDarsena.Libre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRandomAtencion() {
        return randomAtencion;
    }

    public void setRandomAtencion(double randomAtencion) {
        this.randomAtencion = randomAtencion;
    }

    public double getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(double tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public double getProxFinAtencion() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(double proxFinAtencion) {
        this.proxFinAtencion = proxFinAtencion;
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

    public double getTiempoRecalibrado() {
        return tiempoRecalibrado;
    }

    public void setTiempoRecalibrado(double tiempoRecalibrado) {
        this.tiempoRecalibrado = tiempoRecalibrado;
    }

    public double getProxFinRecalibrado() {
        return proxFinRecalibrado;
    }

    public void setProxFinRecalibrado(double proxFinRecalibrado) {
        this.proxFinRecalibrado = proxFinRecalibrado;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
        if (camion != null) {
            calcularTiempoAtencion();
            proximoDarsena(Reloj.getInstancia().getTiempoActual());
            this.setEstadoDarsena(EstadoDarsena.Ocupado);
        }
    }

    public EstadoDarsena getEstadoDarsena() {
        return estadoDarsena;
    }

    public void setEstadoDarsena(EstadoDarsena estadoDarsena) {
        this.estadoDarsena = estadoDarsena;
    }

    @Override
    public String toString() {
        return "Darsena (" + id + ") {" + "estado=" + this.getEstadoDarsena() + '}';
    }

    //Calcula el tiempo de atencion
    public void calcularTiempoAtencion() {
        this.setRandomAtencion(Math.random());
        double demora = 15 + this.getRandomAtencion() * 5;
        this.tiempoAtencion = (demora / 60);
    }

    //Calcula el proximo fin de atencion
    public void proximoDarsena(double relojActual) {
        this.proxFinAtencion = relojActual + this.tiempoAtencion;
    }

    //Calcula el tiempo que tomara recalibrar la darsena
    public void calcularTiempoRecalibrado(){
        this.setRandomRecal1(Math.random());
        this.setRandomRecal2(Math.random());
        double z = Math.sqrt(-2*Math.log(this.getRandomRecal1())*Math.cos(2*Math.PI*this.getRandomRecal2()));
        double demora = 10 + (z*1.2);
        this.tiempoRecalibrado = (demora / 60);
        this.estadoDarsena = EstadoDarsena.En_Recalibracion;
    }

    public void proximoFinRecalibrado(double relojActual){
        this.proxFinRecalibrado = relojActual + this.tiempoRecalibrado;
    }
}
