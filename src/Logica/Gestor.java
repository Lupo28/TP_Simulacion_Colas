package Logica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.Fila;

import java.util.ArrayList;
import java.util.LinkedList;

public class Gestor {
    private int contadorRecalibracion;
    private ObservableList<Fila> data;
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
        this.data = FXCollections.observableArrayList();

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
        Reloj.getInstancia().setTiempoActual(llegadaCamion.getProxLlegadaCamion());
        this.cargarFila();
        llegadaCamion.ejecutar();
        this.llegadaCamion.setCamion(llegadaCamion.generarCamion());
        this.llegadaCamion.sumarContadorCamiones();
        iterar();
    }

    public void addCamionEnPuerta(Camion c) {
        camionesEnPuerta.add(c);
    }


    public void iterar() {
        while (Reloj.getInstancia().getTiempoActual() < 2592000) {
            this.cargarFila();
            switch (proxEvento()) {
                case "Recepcion":
                    FinAtencionRecepcion finAtRecepcion = new FinAtencionRecepcion(this.ServidorRecepcion, this.ServidorBalanza);
                    this.setEventoActual(finAtRecepcion);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(this.getServidorRecepcion().getProxFinAtencion());
                    finAtRecepcion.ejecutar();
                    if(getServidorRecepcion().getCamion() == null) {
                        getServidorRecepcion().setRandomAtencion(0);
                        getServidorRecepcion().setTiempoAtencion(0);
                        getServidorRecepcion().setProxFinAtencion(0);
                    }
                    break;
                case "Balanza":
                    FinAtencionBalanza finAtBalanza = new FinAtencionBalanza(this.ServidorBalanza, this.ServidoresDarsena);
                    this.setEventoActual(finAtBalanza);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(this.getServidorBalanza().getProxFinAtencion());
                    finAtBalanza.ejecutar();
                    if(getServidorBalanza().getCamion() == null) {
                        getServidorBalanza().setRandomAtencion(0);
                        getServidorBalanza().setTiempoAtencion(0);
                        getServidorBalanza().setProxFinAtencion(0);
                    }
                    break;
                case "Darsena":
                    Darsena darsenaFinalizada = this.ServidoresDarsena.getUltimaDarsena();
                    FinAtencionDarsena finAtDarsena = new FinAtencionDarsena(this.ServidoresDarsena, darsenaFinalizada.getId() - 1);
                    this.setEventoActual(finAtDarsena);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(this.getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).getProxFinAtencion());
                    finAtDarsena.ejecutar();
                    contadorRecalibracion++;
                    if (contadorRecalibracion == 15) {
                        setContadorRecalibracion(0);
                        ServidoresDarsena.getDarsena(darsenaFinalizada.getId() - 1).calcularTiempoRecalibrado();
                        this.finAtRecalibrado = new FinAtencionRecalibrado(ServidoresDarsena, darsenaFinalizada.getId() - 1);
                    }
                    if(getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).getCamion() == null) {
                        getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).setRandomAtencion(0);
                        getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).setTiempoAtencion(0);
                        getServidoresDarsena().getDarsena(darsenaFinalizada.getId() - 1).setProxFinAtencion(0);
                    }
                    break;

                case "LlegadaCamion":
                    this.setEventoActual(llegadaCamion);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(llegadaCamion.getProxLlegadaCamion());
                    llegadaCamion.ejecutar();
                    this.llegadaCamion.setCamion(llegadaCamion.generarCamion());
                    llegadaCamion.sumarContadorCamiones();
                    break;

                case "FinRecalibracion":
                    this.finAtRecalibrado.ejecutar();
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
        return this.data;
    }

    public void cargarFila()
    {
        String relojContent = Reloj.getInstancia().tiempoString();
        String eventContent = eventoActual.getNombre();
        String camionContent= (llegadaCamion.getCamion() != null) ? llegadaCamion.getCamion().getNumeroString() : "-";
        String rnd1Content=Double.toString(llegadaCamion.getRandomLlegada()) ;
        String tiempoEntreLlegadasContent=llegadaCamion.getTiempoLlegada1();
        String proxContent=llegadaCamion.getProxFinLlegada1();
        String colaRecepcionContent=Integer.toString(getServidorRecepcion().getCola().size());
        String camionRecepcionContent=(getServidorRecepcion().getCamion() != null) ? getServidorRecepcion().getCamion().getNumeroString() : "-";
        String estadoRecepcionContet=getServidorRecepcion().getEstado().getName();
        String rndRecepcionContent=Double.toString(getServidorRecepcion().getRandomAtencion());
        String tiempoLlegadaRecepcionContent=getServidorRecepcion().getTiempoAtencion1();
        String proxFinAtencionRecepcionContent=getServidorRecepcion().getProxFinAtencion1();
        String colaRecepContent=Integer.toString(getServidorRecepcion().getCola().size());
        String camionBalanzContent=(getServidorBalanza().getCamion() != null) ? getServidorBalanza().getCamion().getNumeroString() : "-";
        String estadBalanzContent=getServidorBalanza().getEstadoBalanza().getName();
        String rndBalanzaContent=Double.toString(getServidorBalanza().getRandomAtencion());
        String tiempoAtencionBalanzContent=getServidorBalanza().tiempoAtencion1();
        String proxFinAtBalContent=getServidorBalanza().proxFinTiempoAtencion1();
        String colaBalanzContent=Integer.toString(getServidorBalanza().getCola().size());
        String camionDarse1Content=(getServidoresDarsena().getDarsenas()[0].getCamion() != null) ? getServidoresDarsena().getDarsenas()[0].getCamion().getNumeroString() : "-";
        String estadoDarse1Content=getServidoresDarsena().getDarsenas()[0].getEstadoDarsena().getName();
        String rndmDarse1Content=Double.toString(getServidoresDarsena().getDarsenas()[0].getRandomAtencion());
        String tiempoAtencionDarse1Content=getServidoresDarsena().getDarsenas()[0].getTiempoAtencion1();
        String finAtencionProxDarse1Content=getServidoresDarsena().getDarsenas()[0].getProxFinAtencion1();
        String camionDarse2Content=(getServidoresDarsena().getDarsenas()[1].getCamion() != null) ? getServidoresDarsena().getDarsenas()[1].getCamion().getNumeroString() : "-";
        String estadoDarse2Content=getServidoresDarsena().getDarsenas()[1].getEstadoDarsena().getName();
        String rndDarse2Content=Double.toString(getServidoresDarsena().getDarsenas()[1].getRandomAtencion());
        String tiempoArDarse2Content=getServidoresDarsena().getDarsenas()[1].getTiempoAtencion1();
        String proxFinAtDarse2Content=getServidoresDarsena().getDarsenas()[1].getProxFinAtencion1();
        String colaDarsenas=Integer.toString(getServidoresDarsena().getCola().size());

        data.add(new Fila(relojContent,eventContent,camionContent,rnd1Content,tiempoEntreLlegadasContent,proxContent,colaRecepcionContent,
                camionRecepcionContent,estadoRecepcionContet,rndRecepcionContent,tiempoLlegadaRecepcionContent,proxFinAtencionRecepcionContent,
                colaRecepContent,camionBalanzContent,estadBalanzContent,rndBalanzaContent,tiempoAtencionBalanzContent,proxFinAtBalContent,
                colaBalanzContent,camionDarse1Content,estadoDarse1Content,rndmDarse1Content,tiempoAtencionDarse1Content,finAtencionProxDarse1Content,
                camionDarse2Content,estadoDarse2Content,rndDarse2Content,tiempoArDarse2Content,proxFinAtDarse2Content, colaDarsenas));

    }
}
