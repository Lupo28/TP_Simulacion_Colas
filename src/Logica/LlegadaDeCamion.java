package Logica;

public class LlegadaDeCamion extends Evento
{

    private long tiempoLlegada;
    private long proxLlegadaCamion;
    private Camion camion;
    private double randomLlegada;
    private Recepcion recepcion;
    private static int contadorCamiones = 1;

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(long tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public double getRandomLlegada() {
        return randomLlegada;
    }

    public void setRandomLlegada(double randomLlegada) {
        this.randomLlegada = randomLlegada;
    }

    public LlegadaDeCamion(long tiempoLlegada, Gestor gestor, Recepcion recepcion)
    {
        this.gestor=gestor;
        this.randomLlegada=Math.random();
        this.tiempoLlegada=tiempoLlegada;
        this.recepcion=recepcion;
    };

    public LlegadaDeCamion(Gestor gestor) {
        this.gestor=gestor;
        this.camion = generarCamion();
        this.randomLlegada = Math.random();
        this.recepcion = new Recepcion();
        contadorCamiones++;

    }

    public String getNombre()
    {
        String nombre= "Lleg Camion";
        return nombre;
    }

    public long calcularTiempoLlegada(long tiempoActual)
    {

        return Distribuciones.proximoRecepcion(tiempoActual,randomLlegada);
    }

    public Camion generarCamion()
    {
        Camion camion = new Camion(contadorCamiones,EstadoCamion.Nuevo);
        camion.setNumero(contadorCamiones);
        return camion;
    }


    public void ejecutar()
    {

    }
}
