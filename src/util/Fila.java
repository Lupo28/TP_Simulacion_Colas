package util;
import javafx.beans.property.SimpleStringProperty;
public class Fila {

    private final SimpleStringProperty dia;
    private final SimpleStringProperty reloj;
    private final SimpleStringProperty event;
    private final SimpleStringProperty colaEnPuerta;
    private final SimpleStringProperty camion;
    private final SimpleStringProperty rnd1;
    private final SimpleStringProperty tiempoEntreLlegadas;
    private final SimpleStringProperty prox;
    private final SimpleStringProperty colaRecepcion;
    private final SimpleStringProperty camionRecepcion;
    private final SimpleStringProperty estadoRecepcion;
    private final SimpleStringProperty rndRecepcion;
    private final SimpleStringProperty tiempoLlegadaRecepcion;
    private final SimpleStringProperty proxFinAtencionRecepcion;
    private final SimpleStringProperty colaBalanza;
    private final SimpleStringProperty camionBalanz;
    private final SimpleStringProperty estadBalanza;
    private final SimpleStringProperty rndBalanz;
    private final SimpleStringProperty tiempoAtencionBalanz;
    private final SimpleStringProperty proxFinAtBalan;
    private final SimpleStringProperty camionDarsen1;
    private final SimpleStringProperty estadoDarsen1;
    private final SimpleStringProperty rndDarsen1;
    private final SimpleStringProperty tiempoAtencionDarse1;
    private final SimpleStringProperty finAtencionProxDarse1;
    private final SimpleStringProperty camionDarse2;
    private final SimpleStringProperty estadoDarse2;
    private final SimpleStringProperty rndDarse2;
    private final SimpleStringProperty tiempoAtDarse2;
    private final SimpleStringProperty proxFinAtDarse2;
    private final SimpleStringProperty colaDarsena;
    private final SimpleStringProperty litros1;
    private final SimpleStringProperty litros2;




    public Fila(String dia, String reloj, String event, String colaEnPuerta, String camion, String rnd1, String tiempoEntreLlegadas, String prox, String colaRecepcion, String camionRecepcion, String estadoRecepcion, String rndRecepcion, String tiempoLlegadaRecepcion, String proxFinAtencionRecepcion, String colaBalanza, String camionBalanz, String estadBalanza, String rndBalanz, String tiempoAtencionBalanz, String proxFinAtBalan, String camionDarsen1, String estadoDarsen1, String rndmDarsen1, String tiempoAtencionDarse1, String finAtencionProxDarse1, String camionDarse2, String estadoDarse2, String rndDarse2, String tiempoAtDarse2, String proxFinAtDarse2, String colaDarsena, String litros1, String litros2) {
        this.dia= new SimpleStringProperty(dia);
        this.reloj = new SimpleStringProperty(reloj);
        this.event = new SimpleStringProperty(event);
        this.colaEnPuerta = new SimpleStringProperty(colaEnPuerta);
        this.camion = new SimpleStringProperty(camion);
        this.rnd1 = new SimpleStringProperty(rnd1);
        this.tiempoEntreLlegadas = new SimpleStringProperty(tiempoEntreLlegadas);
        this.prox = new SimpleStringProperty(prox);
        this.colaRecepcion = new SimpleStringProperty(colaRecepcion);
        this.camionRecepcion = new SimpleStringProperty(camionRecepcion);
        this.estadoRecepcion = new SimpleStringProperty(estadoRecepcion);
        this.rndRecepcion = new SimpleStringProperty(rndRecepcion);
        this.tiempoLlegadaRecepcion = new SimpleStringProperty(tiempoLlegadaRecepcion);
        this.proxFinAtencionRecepcion = new SimpleStringProperty(proxFinAtencionRecepcion);
        this.colaBalanza = new SimpleStringProperty(colaBalanza);
        this.camionBalanz = new SimpleStringProperty(camionBalanz);
        this.estadBalanza = new SimpleStringProperty(estadBalanza);
        this.rndBalanz = new SimpleStringProperty(rndBalanz);
        this.tiempoAtencionBalanz = new SimpleStringProperty(tiempoAtencionBalanz);
        this.proxFinAtBalan = new SimpleStringProperty(proxFinAtBalan);
        this.camionDarsen1 = new SimpleStringProperty(camionDarsen1);
        this.estadoDarsen1 = new SimpleStringProperty(estadoDarsen1);
        this.rndDarsen1 = new SimpleStringProperty(rndmDarsen1);
        this.tiempoAtencionDarse1 = new SimpleStringProperty(tiempoAtencionDarse1);
        this.finAtencionProxDarse1 = new SimpleStringProperty(finAtencionProxDarse1);
        this.camionDarse2 = new SimpleStringProperty(camionDarse2);
        this.estadoDarse2 = new SimpleStringProperty(estadoDarse2);
        this.rndDarse2 = new SimpleStringProperty(rndDarse2);
        this.tiempoAtDarse2 = new SimpleStringProperty(tiempoAtDarse2);
        this.proxFinAtDarse2 = new SimpleStringProperty(proxFinAtDarse2);
        this.colaDarsena = new SimpleStringProperty(colaDarsena);
        this.litros1= new SimpleStringProperty(litros1);
        this.litros2= new SimpleStringProperty(litros2);
    }


    public String getColaEnPuerta() {
        return colaEnPuerta.get();
    }

    public SimpleStringProperty colaEnPuertaProperty() {
        return colaEnPuerta;
    }

    public void setColaEnPuerta(String colaEnPuerta) {
        this.colaEnPuerta.set(colaEnPuerta);
    }

    public String getReloj() {
        return reloj.get();
    }

    public SimpleStringProperty relojProperty() {
        return reloj;
    }

    public void setReloj(String reloj) {
        this.reloj.set(reloj);
    }

    public String getEvent() {
        return event.get();
    }

    public SimpleStringProperty eventProperty() {
        return event;
    }

    public void setEvent(String event) {
        this.event.set(event);
    }

    public String getCamion() {
        return camion.get();
    }

    public SimpleStringProperty camionProperty() {
        return camion;
    }

    public void setCamion(String camion) {
        this.camion.set(camion);
    }

    public String getRnd1() {
        return rnd1.get();
    }

    public SimpleStringProperty rnd1Property() {
        return rnd1;
    }

    public void setRnd1(String rnd1) {
        this.rnd1.set(rnd1);
    }

    public String getTiempoEntreLlegadas() {
        return tiempoEntreLlegadas.get();
    }

    public SimpleStringProperty tiempoEntreLlegadasProperty() {
        return tiempoEntreLlegadas;
    }

    public void setTiempoEntreLlegadas(String tiempoEntreLlegadas) {
        this.tiempoEntreLlegadas.set(tiempoEntreLlegadas);
    }

    public String getProx() {
        return prox.get();
    }

    public SimpleStringProperty proxProperty() {
        return prox;
    }

    public void setProx(String prox) {
        this.prox.set(prox);
    }

    public String getColaRecepcion() {
        return colaRecepcion.get();
    }

    public SimpleStringProperty colaRecepcionProperty() {
        return colaRecepcion;
    }

    public void setColaRecepcion(String colaRecepcion) {
        this.colaRecepcion.set(colaRecepcion);
    }

    public String getCamionRecepcion() {
        return camionRecepcion.get();
    }

    public SimpleStringProperty camionRecepcionProperty() {
        return camionRecepcion;
    }

    public void setCamionRecepcion(String camionRecepcion) {
        this.camionRecepcion.set(camionRecepcion);
    }

    public String getEstadoRecepcion() {
        return estadoRecepcion.get();
    }

    public SimpleStringProperty estadoRecepcionProperty() {
        return estadoRecepcion;
    }

    public void setEstadoRecepcion(String estadoRecepcion) {
        this.estadoRecepcion.set(estadoRecepcion);
    }

    public String getRndRecepcion() {
        return rndRecepcion.get();
    }

    public SimpleStringProperty rndRecepcionProperty() {
        return rndRecepcion;
    }

    public void setRndRecepcion(String rndRecepcion) {
        this.rndRecepcion.set(rndRecepcion);
    }

    public String getTiempoLlegadaRecepcion() {
        return tiempoLlegadaRecepcion.get();
    }

    public SimpleStringProperty tiempoLlegadaRecepcionProperty() {
        return tiempoLlegadaRecepcion;
    }

    public void setTiempoLlegadaRecepcion(String tiempoLlegadaRecepcion) {
        this.tiempoLlegadaRecepcion.set(tiempoLlegadaRecepcion);
    }

    public String getProxFinAtencionRecepcion() {
        return proxFinAtencionRecepcion.get();
    }

    public SimpleStringProperty proxFinAtencionRecepcionProperty() {
        return proxFinAtencionRecepcion;
    }

    public void setProxFinAtencionRecepcion(String proxFinAtencionRecepcion) {
        this.proxFinAtencionRecepcion.set(proxFinAtencionRecepcion);
    }

    public String getCamionBalanz() {
        return camionBalanz.get();
    }

    public SimpleStringProperty camionBalanzProperty() {
        return camionBalanz;
    }

    public void setCamionBalanz(String camionBalanz) {
        this.camionBalanz.set(camionBalanz);
    }

    public String getEstadBalanza() {
        return estadBalanza.get();
    }

    public SimpleStringProperty estadBalanzaProperty() {
        return estadBalanza;
    }

    public void setEstadBalanza(String estadBalanza) {
        this.estadBalanza.set(estadBalanza);
    }

    public String getRndBalanz() {
        return rndBalanz.get();
    }

    public SimpleStringProperty rndBalanzProperty() {
        return rndBalanz;
    }

    public void setRndBalanz(String rndBalanz) {
        this.rndBalanz.set(rndBalanz);
    }

    public String getTiempoAtencionBalanz() {
        return tiempoAtencionBalanz.get();
    }

    public SimpleStringProperty tiempoAtencionBalanzProperty() {
        return tiempoAtencionBalanz;
    }

    public void setTiempoAtencionBalanz(String tiempoAtencionBalanz) {
        this.tiempoAtencionBalanz.set(tiempoAtencionBalanz);
    }

    public String getProxFinAtBalan() {
        return proxFinAtBalan.get();
    }

    public SimpleStringProperty proxFinAtBalanProperty() {
        return proxFinAtBalan;
    }

    public void setProxFinAtBalan(String proxFinAtBalan) {
        this.proxFinAtBalan.set(proxFinAtBalan);
    }

    public String getColaBalanza() {
        return colaBalanza.get();
    }

    public SimpleStringProperty colaBalanzaProperty() {
        return colaBalanza;
    }

    public void setColaBalanza(String colaBalanza) {
        this.colaBalanza.set(colaBalanza);
    }

    public String getCamionDarsen1() {
        return camionDarsen1.get();
    }

    public SimpleStringProperty camionDarsen1Property() {
        return camionDarsen1;
    }

    public void setCamionDarsen1(String camionDarsen1) {
        this.camionDarsen1.set(camionDarsen1);
    }

    public String getEstadoDarsen1() {
        return estadoDarsen1.get();
    }

    public SimpleStringProperty estadoDarsen1Property() {
        return estadoDarsen1;
    }

    public void setEstadoDarsen1(String estadoDarsen1) {
        this.estadoDarsen1.set(estadoDarsen1);
    }

    public String getRndDarsen1() {
        return rndDarsen1.get();
    }

    public SimpleStringProperty rndDarsen1Property() {
        return rndDarsen1;
    }

    public void setRndDarsen1(String rndmDarsen1) {
        this.rndDarsen1.set(rndmDarsen1);
    }

    public String getTiempoAtencionDarse1() {
        return tiempoAtencionDarse1.get();
    }

    public SimpleStringProperty tiempoAtencionDarse1Property() {
        return tiempoAtencionDarse1;
    }

    public void setTiempoAtencionDarse1(String tiempoAtencionDarse1) {
        this.tiempoAtencionDarse1.set(tiempoAtencionDarse1);
    }

    public String getFinAtencionProxDarse1() {
        return finAtencionProxDarse1.get();
    }

    public SimpleStringProperty finAtencionProxDarse1Property() {
        return finAtencionProxDarse1;
    }

    public void setFinAtencionProxDarse1(String finAtencionProxDarse1) {
        this.finAtencionProxDarse1.set(finAtencionProxDarse1);
    }

    public String getCamionDarse2() {
        return camionDarse2.get();
    }

    public SimpleStringProperty camionDarse2Property() {
        return camionDarse2;
    }

    public void setCamionDarse2(String camionDarse2) {
        this.camionDarse2.set(camionDarse2);
    }

    public String getEstadoDarse2() {
        return estadoDarse2.get();
    }

    public SimpleStringProperty estadoDarse2Property() {
        return estadoDarse2;
    }

    public void setEstadoDarse2(String estadoDarse2) {
        this.estadoDarse2.set(estadoDarse2);
    }

    public String getRndDarse2() {
        return rndDarse2.get();
    }

    public SimpleStringProperty rndDarse2Property() {
        return rndDarse2;
    }

    public void setRndDarse2(String rndDarse2) {
        this.rndDarse2.set(rndDarse2);
    }

    public String getTiempoAtDarse2() {
        return tiempoAtDarse2.get();
    }

    public SimpleStringProperty tiempoAtDarse2Property() {
        return tiempoAtDarse2;
    }

    public void setTiempoAtDarse2(String tiempoAtDarse2) {
        this.tiempoAtDarse2.set(tiempoAtDarse2);
    }

    public String getProxFinAtDarse2() {
        return proxFinAtDarse2.get();
    }

    public SimpleStringProperty proxFinAtDarse2Property() {
        return proxFinAtDarse2;
    }

    public void setProxFinAtDarse2(String proxFinAtDarse2) {
        this.proxFinAtDarse2.set(proxFinAtDarse2);
    }

    public String getColaDarsena() {
        return colaDarsena.get();
    }

    public SimpleStringProperty colaDarsenaProperty() {
        return colaDarsena;
    }

    public void setColaDarsena(String colaDarsenas) {
        this.colaDarsena.set(colaDarsenas);
    }



    public String getLitros1() {
        return litros1.get();
    }

    public SimpleStringProperty litros1Property() {
        return litros1;
    }

    public void setLitros1(String litros) {
        this.litros1.set(litros);
    }


    public String getDia() {
        return dia.get();
    }

    public SimpleStringProperty diaProperty() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }
    public String getLitros2() {
        return litros2.get();
    }

    public SimpleStringProperty litros2Property() {
        return litros2;
    }

    public void setLitros2(String litros2) {
        this.litros2.set(litros2);
    }

}
