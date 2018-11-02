package Logica;

import java.util.ArrayList;
import java.util.LinkedList;

public class Gestor {
    private int contadorRecalibracion;

    private ArrayList<String> conjuntoEventos;
    private LinkedList<Camion> camionesEnPuerta;
    private LlegadaDeCamion llegadaCamion;
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
        this.llegadaCamion=new LlegadaDeCamion(getServidorRecepcion());
    }

    public Evento getEventoActual() {
        return eventoActual;
    }

    public void setEventoActual(Evento eventoActual) {
        this.eventoActual = eventoActual;
    }

    public void inicio() {
        Reloj.getInstancia().setTiempoActual(0);
        LlegadaDeCamion primeraLlegada = new LlegadaDeCamion(this.ServidorRecepcion);
        this.setEventoActual(primeraLlegada);
        this.getConjuntoEventos().add(this.getEventoActual().getNombre());
        primeraLlegada.ejecutar();
        iterar();
    }

    public void addCamionEnPuerta(Camion c) {
        camionesEnPuerta.add(c);
    }


    public void iterar() {
        while (Reloj.getInstancia().getTiempoActual() < 2592000) {

            switch (proxEvento()) {
                case "Recepcion":
                    FinAtencionRecepcion finAtRecepcion = new FinAtencionRecepcion(this.ServidorRecepcion, this.ServidorBalanza);
                    this.setEventoActual(finAtRecepcion);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    finAtRecepcion.ejecutar();
                    Reloj.getInstancia().setTiempoActual(this.getServidorRecepcion().getProxFinAtencion());
                    break;
                case "Balanza":
                    FinAtencionBalanza finAtBalanza = new FinAtencionBalanza(this.ServidorBalanza, this.ServidoresDarsena);
                    this.setEventoActual(finAtBalanza);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    finAtBalanza.ejecutar();
                    Reloj.getInstancia().setTiempoActual(this.getServidorBalanza().getProxFinAtencion());
                    contadorRecalibracion++;
                    if (contadorRecalibracion == 15) {
                        setContadorRecalibracion(0);
                        ServidorBalanza.setEstadoBalanza(EstadoBalanza.En_Recalibracion);
                    }
                    break;
                case "Darsena":
                    Darsena darsenaFinalizada = this.ServidoresDarsena.getUltimaDarsena();
                    FinAtencionDarsena finAtDarsena = new FinAtencionDarsena(this.ServidoresDarsena, darsenaFinalizada.getId());
                    this.setEventoActual(finAtDarsena);
                    this.getConjuntoEventos().add(this.getEventoActual().getNombre());
                    finAtDarsena.ejecutar();
                    Reloj.getInstancia().setTiempoActual(this.getServidoresDarsena().getDarsena(darsenaFinalizada.getId()).getProxFinAtencion());
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

    public double tiempoMinimo()
    {
        double minTiempo=2592001;   //seteo el tiempo minimo en un valor bien alto para que pueda funcionar
        if(ServidoresDarsena.getDarsenas()[0].getProxFinAtencion()!=0)
        {
            minTiempo = ServidoresDarsena.getDarsenas()[0].getProxFinAtencion();
        }
        if(ServidoresDarsena.getDarsenas()[1].getProxFinAtencion( )!=0 && ServidoresDarsena.getDarsenas()[1].getProxFinAtencion()< minTiempo)
        {
            minTiempo=ServidoresDarsena.getDarsenas()[1].getProxFinAtencion( );
        }
        if(ServidorBalanza.getProxFinAtencion()!= 0 && ServidorBalanza.getProxFinAtencion() <minTiempo)
        {
            minTiempo=ServidorBalanza.getProxFinAtencion();
        }
        if(ServidorRecepcion.getProxFinAtencion()!=0 && ServidorRecepcion.getProxFinAtencion() < minTiempo)
        {
            minTiempo= ServidorRecepcion.getProxFinAtencion();
        }else
        {
            minTiempo=llegadaCamion.getProxLlegadaCamion();
        }
        return minTiempo;
    }

    public String proxEvento() {
        double tiempo = tiempoMinimo();

        if (tiempo == ServidoresDarsena.getDarsenas()[0].getProxFinAtencion() ) {
            return  "Darsena";
        } else if (tiempo == ServidoresDarsena.getDarsenas()[1].getProxFinAtencion()) {
            return "Darsena";
        } else if (tiempo == ServidorBalanza.getProxFinAtencion()) {
            return "Balanza";
        } else if(tiempo == llegadaCamion.getProxLlegadaCamion())
        {
            return "LlegadaCamion";
        }else
        {
            return "Recepcion";
        }
    }
}
