package Logica;

import java.util.LinkedList;

public class ConjuntoDarsena {
    private Darsena[] darsenas = new Darsena[2];
    private LinkedList<Camion> cola;

    public Darsena[] getDarsenas() {
        return darsenas;
    }

    public void setDarsenas(Darsena[] darsenas) {
        this.darsenas = darsenas;
    }

    public LinkedList<Camion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Camion> cola) {
        this.cola = cola;
    }

    public ConjuntoDarsena() {
        cargarVector();
        this.cola = new LinkedList<Camion>();
    }

    public int size() {
        return darsenas.length;
    }

    public void cargarVector() {
        for (int i = 0; i < darsenas.length; i++) {
            darsenas[i] = new Darsena();
            darsenas[i].setId(i + 1);
        }
    }

    public Darsena[] getV() {
        return darsenas;
    }

    public void setV(Darsena[] v) {
        this.darsenas = v;
    }

    public Darsena getDarsena(int i) {
        return darsenas[i];
    }

    public void setDarsena(int i, Darsena d) {
        darsenas[i] = d;
    }

    public int getIndex(Darsena d) {
        int aux = -1;
        for (int i = 0; i < darsenas.length; i++) {
            if (d.equals(darsenas[i])) {
                aux = i;
                break;
            }
        }
        return aux;
    }

    public Darsena buscarDarsenaLibre() {
        Darsena d = null;
        for (Darsena darsena : darsenas) {
            if (darsena.getEstadoDarsena() == EstadoDarsena.Libre) {
                d = darsena;
            }
        }
        return d;
    }

    public Darsena getUltimaDarsena(){
        if(darsenas[0].getProxFinAtencion()==0)return darsenas[1];
        if (darsenas[1].getProxFinAtencion()==0)return  darsenas[0];
        return (darsenas[0].getProxFinAtencion() <= darsenas[1].getProxFinAtencion()) ? darsenas[0] : darsenas[1];
    }

    public StringBuilder mostrarVector() {
        StringBuilder string = new StringBuilder("\nDarsenas: ");
        for (Darsena darsena : darsenas) {
            string.append("\n" + (getIndex(darsena) + 1) + ") " + darsena.toString());
        }
        return string;
    }
}
