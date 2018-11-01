package Logica;

public abstract class Evento implements Comparable<Evento>
{
    protected long reloj;
    protected Gestor gestor;

    public Evento(long reloj, Gestor gestor) {
        this.reloj = reloj;
        this.gestor = gestor;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public  Evento() { }

    public long getReloj() {
        return reloj;
    }
    public void setReloj(long reloj) {
        this.reloj = reloj;
    }

    public int compareTo(Evento e) {
        if ((this.getReloj() - e.getReloj()) > 0.0 ) {
            return 1;
        } else if ((this.getReloj() - e.getReloj()) < 0.0 ){
            return -1;
        } else {
            return 0;
        }
    }
    public abstract void ejecutar();
    public abstract String getNombre();
}
