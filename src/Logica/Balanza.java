package Logica;

public class Balanza {
    private long tiempoPesando;
    private long proxFinAtencion;
    private boolean estado;
    private Camion camion;
    private EstadoBalanza estadoBalanza;



    public Balanza(long tiempoPesando, Camion camion, EstadoBalanza estadoBalanza)
    {
        this.tiempoPesando=tiempoPesando;
        this.camion=camion;
        this.estadoBalanza=estadoBalanza;

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
