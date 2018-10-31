package Logica;

import java.util.LinkedList;
import java.util.TreeSet;

public class Gestor
{
    private int contador;

    private TreeSet<Evento> conjuntoEventos;
    private LinkedList<Camion> camionesEnPuerta;

    private static Evento eventoActual;

    private Recepcion ServidorRecepcion;
    private Balanza ServidorBalanza;
    private ConjuntoDarsena ServidoresDarsena;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


    public TreeSet<Evento> getConjuntoEventos()
    {
        return conjuntoEventos;
    }

    public void setConjuntoEventos(TreeSet<Evento> conjuntoEventos) {
        this.conjuntoEventos = conjuntoEventos;
    }

    public LinkedList<Camion> getCamionesEnPuerta() {
        return camionesEnPuerta;
    }

    public void setCamionesEnPuerta(LinkedList<Camion> camionesEnPuerta) {
        this.camionesEnPuerta = camionesEnPuerta;
    }

    public Gestor()
    {
        this.contador = 0;
        this.conjuntoEventos = new TreeSet<>();
        this.camionesEnPuerta = new LinkedList<>();
        this.ServidorRecepcion = new Recepcion();
        this.ServidorBalanza = new Balanza();
        this.ServidoresDarsena = new ConjuntoDarsena();
    }

    public Evento getEventoActual() {
        return eventoActual;
    }

    public void setEventoActual(Evento eventoActual) {
        this.eventoActual = eventoActual;
    }

    public void inicio()
    {
        Recepcion recepcion= new Recepcion();
        iterar();
    }

    public void addCamionEnPuerta(Camion c)
    {
        camionesEnPuerta.add(c);
    }


    public void iterar()
    {
        while(Reloj.getInstancia().getTiempoActual()< 43200)
        {
            eventoActual = conjuntoEventos.pollFirst();
            Reloj.getInstancia().setTiempoActual(eventoActual.getReloj());
            eventoActual.ejecutar();
        }
    }
}
