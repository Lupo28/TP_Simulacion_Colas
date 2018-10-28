package Logica;

public class Recepcion {
    private long tiempoAtencion;
    private long proxFinAtencion;
    private EstadoRecepcion estado;

    public Recepcion(){}

    public Recepcion(long tiempoAtencion, EstadoRecepcion estado) {
        this.tiempoAtencion = tiempoAtencion;
        this.estado = estado;
    }

    public long getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(long tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
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

    public void atender(Camion camion){

    }
}
