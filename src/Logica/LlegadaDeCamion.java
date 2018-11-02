package Logica;

public class LlegadaDeCamion extends Evento
{

    private double tiempoLlegada;

    public double getProxLlegadaCamion() {
        return proxLlegadaCamion;
    }

    public void setProxLlegadaCamion(double proxLlegadaCamion) {
        this.proxLlegadaCamion = proxLlegadaCamion;
    }

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



    public Camion generarCamion()
    {
        Camion camion = new Camion(contadorCamiones,EstadoCamion.Nuevo);
        camion.setNumero(contadorCamiones);
        return camion;
    }

    public void calcularTiempoLlegada() {
        setRandomLlegada(Math.random());
        double demora = -(1/7.5)*Math.log(1-randomLlegada);
        setTiempoLlegada(demora / 60);
    }

    public void calcularProxLlegada()
    {
        setTiempoLlegada(this.getTiempoLlegada()+Reloj.getInstancia().getTiempoActual());
    }

    public void ejecutar()
    {
        this.calcularTiempoLlegada();
        this.calcularProxLlegada();
        if (recepcion.getEstado()==EstadoRecepcion.Libre)
        {
            recepcion.setEstado(EstadoRecepcion.Ocupado);
            recepcion.setCamion(this.getCamion());
        }
        else
        {
            recepcion.getCola().add(this.getCamion());
        }
    }
}
