package Logica;

import java.util.LinkedList;
import java.util.TreeSet;

public class Gestor
{
    private long reloj;
    private int contador;

    private TreeSet<Evento> conjuntoEventos;
    private LinkedList<Camion> conjuntosCamiones;

    private static Evento eventoActual;

    public long getReloj() {
        return reloj;
    }

    public void setReloj(long reloj) {
        this.reloj = reloj;
    }

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

    public LinkedList<Camion> getConjuntosCamiones() {
        return conjuntosCamiones;
    }

    public void setConjuntosCamiones(LinkedList<Camion> conjuntosCamiones) {
        conjuntosCamiones = conjuntosCamiones;
    }

    public Gestor()
    {
        this.reloj = 0;
        this.contador = 0;
        this.eventoActual = null;
        conjuntoEventos = new TreeSet<>();
        conjuntosCamiones = new LinkedList<>();
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
        LlegadaDeCamion proximaLlegada = new LlegadaDeCamion(Distribuciones.proximoRecepcion(getReloj(), Math.random()), this,recepcion);
        setEventoActual(proximaLlegada);
        conjuntoEventos.add(getEventoActual());
        iterar();

    }

    public void addCamion(Camion c)
    {
        conjuntosCamiones.add(c);
    }


    public void iterar()
    {
        while(reloj< 43200)
        {
            eventoActual = conjuntoEventos.pollFirst();
            this.reloj = eventoActual.getReloj();
            eventoActual.ejecutar();
        }
    }
}
