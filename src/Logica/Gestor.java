package Logica;

import java.util.ArrayList;
import java.util.TreeSet;

public class Gestor
{
    private long reloj;
    private int contador;
    private int cantIteraciones;

    private TreeSet<Evento> conjuntoEventos;
    private ArrayList<Camion> ConjuntosCamiones;

    private Evento eventoActual;

    public double getReloj() {
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

    public int getCantIteraciones() {
        return cantIteraciones;
    }

    public void setCantIteraciones(int cantIteraciones) {
        this.cantIteraciones = cantIteraciones;
    }

    public TreeSet<Evento> getConjuntoEventos() {
        return conjuntoEventos;
    }

    public void setConjuntoEventos(TreeSet<Evento> conjuntoEventos) {
        this.conjuntoEventos = conjuntoEventos;
    }

    public ArrayList<Camion> getConjuntosCamiones() {
        return ConjuntosCamiones;
    }

    public void setConjuntosCamiones(ArrayList<Camion> conjuntosCamiones) {
        ConjuntosCamiones = conjuntosCamiones;
    }

    public Gestor( int contador, int cantIteraciones, TreeSet<Evento> conjuntoEventos, ArrayList<Camion> cola, int contadorCola, ArrayList<Camion> conjuntosCamiones) {
        this.reloj = 0;
        this.contador = contador;
        this.cantIteraciones = cantIteraciones;
        this.conjuntoEventos = conjuntoEventos;
        ConjuntosCamiones = conjuntosCamiones;
    }


    public void inicio(int cantIteraciones)
    {
        this.cantIteraciones=cantIteraciones;
        Recepcion recepcion= new Recepcion();

        LlegadaDeCamion proximaLlegada = new LlegadaDeCamion(Distribuciones.proximoRecepcion(reloj), this);
        conjuntoEventos.add(proximaLlegada);


        iterar();

    }


    public void iterar()
    {
        double diferencia;
        for (int i = 0; i <cantIteraciones ; i++)
        {
            eventoActual = conjuntoEventos.pollFirst();


            this.reloj = eventoActual.getReloj();

            eventoActual.ejecutar();
        }
    }
}
