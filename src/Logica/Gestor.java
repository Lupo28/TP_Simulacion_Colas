package Logica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.Fila;

import java.util.ArrayList;
import java.util.LinkedList;

public class Gestor {
    private int contadorRecalibracion;
    private static ObservableList<Fila> data;
    private ArrayList<String> conjuntoEventos;
    private LinkedList<Camion> camionesEnPuerta;
    private LlegadaDeCamion llegadaCamion;
    private FinAtencionRecalibrado finAtRecalibrado;
    private static Evento eventoActual;

    private Recepcion ServidorRecepcion;
    private Balanza ServidorBalanza;
    private ConjuntoDarsena ServidoresDarsena;

    public int getContadorRecalibracion() {
        return contadorRecalibracion;
    }

    public void setContadorRecalibracion(int contador) {
        this.contadorRecalibracion = contador;
    }


    public ArrayList<String> getConjuntoEventos() {
        return conjuntoEventos;
    }

    public void setConjuntoEventos(ArrayList<String> conjuntoEventos) {
        this.conjuntoEventos = conjuntoEventos;
    }

    public LinkedList<Camion> getCamionesEnPuerta() {
        return camionesEnPuerta;
    }

    public void setCamionesEnPuerta(LinkedList<Camion> camionesEnPuerta) {
        this.camionesEnPuerta = camionesEnPuerta;
    }

    public Gestor() {
        this.contadorRecalibracion = 0;
        this.conjuntoEventos = new ArrayList<>();
        this.camionesEnPuerta = new LinkedList<>();
        this.ServidorRecepcion = new Recepcion();
        this.ServidorBalanza = new Balanza();
        this.ServidoresDarsena = new ConjuntoDarsena();
        this.llegadaCamion = new LlegadaDeCamion(getServidorRecepcion());
        this.data=FXCollections.observableArrayList();

    }

    public Evento getEventoActual() {
        return eventoActual;
    }

    public void setEventoActual(Evento eventoActual) {
        this.eventoActual = eventoActual;
    }

    public void inicio() {
        Reloj.getInstancia().setTiempoActual(0);
        this.setEventoActual(llegadaCamion);
        this.getConjuntoEventos().add(this.getEventoActual().getNombre());
        llegadaCamion.ejecutar();
        Reloj.getInstancia().setTiempoActual(llegadaCamion.getProxLlegadaCamion());
        iterar();
    }

    public void addCamionEnPuerta(Camion c) {
        camionesEnPuerta.add(c);
    }


    public void iterar() {
        while (Reloj.getInstancia().getTiempoActual() < 259) {
            this.cargarFila();
            switch (proxEvento()) {
                case "Recepcion":
                    FinAtencionRecepcion finAtRecepcion = new FinAtencionRecepcion(this.ServidorRecepcion, this.ServidorBalanza);
                    this.setEventoActual(finAtRecepcion);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    finAtRecepcion.ejecutar();
                    Reloj.getInstancia().setTiempoActual(this.getServidorRecepcion().getProxFinAtencion());
                    getServidorBalanza().setEstadoBalanza(EstadoBalanza.Ocupado);
                    getServidorBalanza().setProxFinAtencion(Reloj.getInstancia().getTiempoActual());
                    getServidorRecepcion().setProxFinAtencion(0);
                    break;
                case "Balanza":
                    FinAtencionBalanza finAtBalanza = new FinAtencionBalanza(this.ServidorBalanza, this.ServidoresDarsena);
                    this.setEventoActual(finAtBalanza);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    finAtBalanza.ejecutar();
                    Reloj.getInstancia().setTiempoActual(this.getServidorBalanza().getProxFinAtencion());
                    getServidorBalanza().setProxFinAtencion(0);
                    break;
                case "Darsena":
                    Darsena darsenaFinalizada = this.ServidoresDarsena.getUltimaDarsena();
                    FinAtencionDarsena finAtDarsena = new FinAtencionDarsena(this.ServidoresDarsena, darsenaFinalizada.getId() - 1);
                    this.setEventoActual(finAtDarsena);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    finAtDarsena.ejecutar();
                    Reloj.getInstancia().setTiempoActual(this.getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).getProxFinAtencion());
                    contadorRecalibracion++;
                    if (contadorRecalibracion == 15) {
                        setContadorRecalibracion(0);
                        ServidoresDarsena.getDarsena(darsenaFinalizada.getId() - 1).calcularTiempoRecalibrado();
                        this.finAtRecalibrado = new FinAtencionRecalibrado(ServidoresDarsena, darsenaFinalizada.getId() - 1);
                    }
                    getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).setProxFinAtencion(0);
                    break;

                case "LlegadaCamion":
                    this.setEventoActual(llegadaCamion);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    this.llegadaCamion.setCamion(llegadaCamion.generarCamion());
                    llegadaCamion.sumarContadorCamiones();
                    llegadaCamion.ejecutar();
                    Reloj.getInstancia().setTiempoActual(llegadaCamion.getProxLlegadaCamion());
                    break;

                case "FinRecalibracion":
                    break;

            }
        }
    }

    public Recepcion getServidorRecepcion() {
        return ServidorRecepcion;
    }

    public void setServidorRecepcion(Recepcion servidorRecepcion) {
        ServidorRecepcion = servidorRecepcion;
    }

    public Balanza getServidorBalanza() {
        return ServidorBalanza;
    }

    public void setServidorBalanza(Balanza servidorBalanza) {
        ServidorBalanza = servidorBalanza;
    }

    public ConjuntoDarsena getServidoresDarsena() {
        return ServidoresDarsena;
    }

    public void setServidoresDarsena(ConjuntoDarsena servidoresDarsena) {
        ServidoresDarsena = servidoresDarsena;
    }

    public double tiempoMinimo() {
        double minTiempo = 2592001;   //seteo el tiempo minimo en un valor bien alto para que pueda funcionar
        if (ServidoresDarsena.getDarsenas()[0].getProxFinAtencion() != 0) {
            minTiempo = ServidoresDarsena.getDarsenas()[0].getProxFinAtencion();
        }
        if (ServidoresDarsena.getDarsenas()[1].getProxFinAtencion() != 0 && ServidoresDarsena.getDarsenas()[1].getProxFinAtencion() < minTiempo) {
            minTiempo = ServidoresDarsena.getDarsenas()[1].getProxFinAtencion();
        }
        if (ServidorBalanza.getProxFinAtencion() != 0 && ServidorBalanza.getProxFinAtencion() < minTiempo) {
            minTiempo = ServidorBalanza.getProxFinAtencion();
        }
        if (ServidorRecepcion.getProxFinAtencion() != 0 && ServidorRecepcion.getProxFinAtencion() < minTiempo) {
            minTiempo = ServidorRecepcion.getProxFinAtencion();
        }
        if (llegadaCamion.getProxLlegadaCamion() != 0 && llegadaCamion.getProxLlegadaCamion() < minTiempo) {
            minTiempo = llegadaCamion.getProxLlegadaCamion();
        }
        if (ServidoresDarsena.getDarsenas()[0].getProxFinRecalibrado() != 0 && ServidoresDarsena.getDarsenas()[0].getProxFinRecalibrado() < minTiempo) {
            minTiempo = ServidoresDarsena.getDarsenas()[0].getProxFinRecalibrado();
        }
        if (ServidoresDarsena.getDarsenas()[1].getProxFinRecalibrado() != 0 && ServidoresDarsena.getDarsenas()[1].getProxFinRecalibrado() < minTiempo) {
            minTiempo = ServidoresDarsena.getDarsenas()[1].getProxFinRecalibrado();
        }

//        minTiempo=Math.min(ServidoresDarsena.getDarsenas()[0].getProxFinAtencion(),ServidoresDarsena.getDarsenas()[1].getProxFinAtencion());
//        minTiempo=Math.min(minTiempo,ServidorBalanza.getProxFinAtencion());
//        minTiempo=Math.min(minTiempo,ServidorRecepcion.getProxFinAtencion());
//        minTiempo=Math.min(minTiempo,llegadaCamion.getProxLlegadaCamion());
        return minTiempo;
    }

    public String proxEvento() {
        double tiempo = tiempoMinimo();

        if (tiempo == ServidoresDarsena.getDarsenas()[0].getProxFinAtencion()) {
            return "Darsena";
        } else if (tiempo == ServidoresDarsena.getDarsenas()[1].getProxFinAtencion()) {
            return "Darsena";
        } else if (tiempo == ServidorBalanza.getProxFinAtencion()) {
            return "Balanza";
        } else if (tiempo == llegadaCamion.getProxLlegadaCamion()) {
            return "LlegadaCamion";
        } else if(tiempo == ServidoresDarsena.getDarsenas()[0].getProxFinRecalibrado()){
            return "Fin Recalibracion";
        } else if(tiempo == ServidoresDarsena.getDarsenas()[1].getProxFinRecalibrado()){
            return "Fin Recalibracion";
        }else{
            return "Recepcion";
        }
    }

    public ObservableList<Fila> getData() {
        return data;
    }

    public void cargarFila()
    {
        String relojContent = Reloj.getInstancia().tiempoString();
        String eventContent = eventoActual.getNombre();
        String camionContent="2";
        String rnd1Content="3";
        String tiempoEntreLlegadasContent="4";
        String proxContent="5";
        String colaRecepcionContent="2";
        String camionRecepcionContent="2";
        String estadoRecepcionContet="2";
        String rndRecepcionContent="2";
        String tiempoLlegadaRecepcionContent="2";
        String proxFinAtencionRecepcionContent="2";
        String colaRecepContent="2";
        String camionBalanzContent="2";
        String estadBalanzContent="2";
        String rndBalanzaContent="-";
        String tiempoAtencionBalanzContent="-";
        String proxFinAtBalContent="-";
        String colaBalanzContent="-";
        String camionDarse1Content="-";
        String estadoDarse1Content="-";
        String rndmDarse1Content="-";
        String tiempoAtencionDarse1Content="-";
        String finAtencionProxDarse1Content="-";
        String camionDarse2Content="-";
        String estadoDarse2Content="-";
        String rndDarse2Content="-";
        String tiempoArDarse2Content="-";
        String proxFinAtDarse2Content="-";

        data.add(new Fila(relojContent,eventContent,camionContent,rnd1Content,tiempoEntreLlegadasContent,proxContent,colaRecepcionContent,
                camionRecepcionContent,estadoRecepcionContet,rndRecepcionContent,tiempoLlegadaRecepcionContent,proxFinAtencionRecepcionContent,
                colaRecepContent,camionBalanzContent,estadBalanzContent,rndBalanzaContent,tiempoAtencionBalanzContent,proxFinAtBalContent,
                colaBalanzContent,camionDarse1Content,estadoDarse1Content,rndmDarse1Content,tiempoAtencionDarse1Content,finAtencionProxDarse1Content,
                camionDarse2Content,estadoDarse2Content,rndDarse2Content,tiempoArDarse2Content,proxFinAtDarse2Content));
    }
}
