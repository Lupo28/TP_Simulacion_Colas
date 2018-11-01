package Logica;

public class LlegadaDeCamion extends Evento
{

    private double tiempoLlegada;
    private double proxLlegadaCamion;
    private Camion camion;
    private double randomLlegada;
    private Recepcion recepcion;
    private static int contadorCamiones;

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(double tiempoLlegada) {
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

    public LlegadaDeCamion( Recepcion recepcion)
    {
        this.camion=generarCamion();
        this.recepcion=recepcion;
        contadorCamiones++;
    }

    public String getNombre()
    {
        String nombre= "Lleg Camion";
        return nombre;
    }

    public double calcularTiempoLlegada(long tiempoActual)
    {

        return proximoRecepcion(tiempoActual,randomLlegada);
    }

    public Camion generarCamion()
    {
        Camion camion = new Camion(contadorCamiones,EstadoCamion.Nuevo);
        camion.setNumero(contadorCamiones);
        return camion;
    }

    public void calcularTiempoAtencion() {
        setRandomLlegada(Math.random());
        double demora = -(1/7.5)*Math.log(1-randomLlegada);
        setTiempoLlegada((long)demora / 60);
    }

    public void ejecutar()
    {

    }
}
