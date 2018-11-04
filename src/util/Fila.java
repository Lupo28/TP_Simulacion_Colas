package util;
import javafx.beans.property.SimpleStringProperty;
public class Fila {

    private final SimpleStringProperty reloj;
    private final SimpleStringProperty event;
    private final SimpleStringProperty camion;
    private final SimpleStringProperty rnd1;
    private final SimpleStringProperty tiempoEntreLlegadas;
    private final SimpleStringProperty prox;
    private final SimpleStringProperty colaRececion;
    private final SimpleStringProperty camionRecepcion;
    private final SimpleStringProperty estadoRecepcion;
    private final SimpleStringProperty rndRecepcion;
    private final SimpleStringProperty tiempoLlegadaRecepcion;
    private final SimpleStringProperty proxFinAtencionRecepcion;
    private final SimpleStringProperty colaRecep;
    private final SimpleStringProperty camionBalanz;
    private final SimpleStringProperty estadBalanza;
    private final SimpleStringProperty rndBalanz;
    private final SimpleStringProperty tiempoAtencionBalanz;
    private final SimpleStringProperty proxFinAtBalan;
    private final SimpleStringProperty colaBalanz;
    private final SimpleStringProperty camionDarsen1;
    private final SimpleStringProperty estadoDarsen1;
    private final SimpleStringProperty rndmDarsen1;
    private final SimpleStringProperty tiempoAtencionDarse1;
    private final SimpleStringProperty finAtencionProxDarse1;
    private final SimpleStringProperty camionDarse2;
    private final SimpleStringProperty estadoDarse2;
    private final SimpleStringProperty rndDarse2;
    private final SimpleStringProperty tiempoAtDarse2;
    private final SimpleStringProperty proxFinAtDarse2;

    public Fila(String reloj, String event, String camion, String rnd1, String tiempoEntreLlegadas, String prox, String colaRececion, String camionRecepcion, String estadoRecepcion, String rndRecepcion, String tiempoLlegadaRecepcion, String proxFinAtencionRecepcion, String colaRecep, String camionBalanz, String estadBalanza, String rndBalanz, String tiempoAtencionBalanz, String proxFinAtBalan, String colaBalanz, String camionDarsen1, String estadoDarsen1, String rndmDarsen1, String tiempoAtencionDarse1, String finAtencionProxDarse1, String camionDarse2, String estadoDarse2, String rndDarse2, String tiempoAtDarse2, String proxFinAtDarse2) {
        this.reloj = new SimpleStringProperty(reloj);
        this.event = new SimpleStringProperty(event);
        this.camion = new SimpleStringProperty(camion);
        this.rnd1 = new SimpleStringProperty(rnd1);
        this.tiempoEntreLlegadas = new SimpleStringProperty(tiempoEntreLlegadas);
        this.prox = new SimpleStringProperty(prox);
        this.colaRececion = new SimpleStringProperty(colaRececion);
        this.camionRecepcion = new SimpleStringProperty(camionRecepcion);
        this.estadoRecepcion = new SimpleStringProperty(estadoRecepcion);
        this.rndRecepcion = new SimpleStringProperty(rndRecepcion);
        this.tiempoLlegadaRecepcion = new SimpleStringProperty(tiempoLlegadaRecepcion);
        this.proxFinAtencionRecepcion = new SimpleStringProperty(proxFinAtencionRecepcion);
        this.colaRecep = new SimpleStringProperty(colaRecep);
        this.camionBalanz = new SimpleStringProperty(camionBalanz);
        this.estadBalanza = new SimpleStringProperty(estadBalanza);
        this.rndBalanz = new SimpleStringProperty(rndBalanz);
        this.tiempoAtencionBalanz = new SimpleStringProperty(tiempoAtencionBalanz);
        this.proxFinAtBalan = new SimpleStringProperty(proxFinAtBalan);
        this.colaBalanz = new SimpleStringProperty(colaBalanz);
        this.camionDarsen1 = new SimpleStringProperty(camionDarsen1);
        this.estadoDarsen1 = new SimpleStringProperty(estadoDarsen1);
        this.rndmDarsen1 = new SimpleStringProperty(rndmDarsen1);
        this.tiempoAtencionDarse1 = new SimpleStringProperty(tiempoAtencionDarse1);
        this.finAtencionProxDarse1 = new SimpleStringProperty(finAtencionProxDarse1);
        this.camionDarse2 = new SimpleStringProperty(camionDarse2);
        this.estadoDarse2 = new SimpleStringProperty(estadoDarse2);
        this.rndDarse2 = new SimpleStringProperty(rndDarse2);
        this.tiempoAtDarse2 = new SimpleStringProperty(tiempoAtDarse2);
        this.proxFinAtDarse2 = new SimpleStringProperty(proxFinAtDarse2);
    }
}
