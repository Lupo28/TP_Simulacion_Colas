package Logica;

public class LlegadaDeCamion extends Evento
{

    private long tiempoLlegada;
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
    public LlegadaDeCamion(){};

    public LlegadaDeCamion(  double randomLlegada, Gestor gestor) {
        this.gestor=gestor;
        this.camion = generarCamion();
        this.randomLlegada = randomLlegada;

        contadorCamiones++;
    }

    public String getNombre()
    {
        String nombre= "Lleg Camion";
        return nombre;
    }

    public double calcularTiempoLlegada(long tiempoActual)
    {
        return Distribuciones.proximoRecepcion(tiempoActual);
    }

    public Camion generarCamion()
    {
        Camion camion = new Camion(contadorCamiones,EstadoCamion.Nuevo);
        camion.setNumero(contadorCamiones);
        return camion;
    }


    public Recepcion asignarRecepcion(Camion c)
    {
        if(recepcion.getCola()==null)
        {
            if(recepcion.getEstado().getName()=="Libre")
            {
                recepcion.setCamion(c);
                c.setEstado(EstadoCamion.En_cola_Recepcion);
                recepcion.setEstado(EstadoRecepcion.Ocupado);
            }
            else
            {
                c.setEstado(EstadoCamion.En_cola_Recepcion);
                recepcion.agregarCamionAcola(c);
            }


        }
        return recepcion;
    }

    public void ejecutar()
    {
        gestor.getConjuntosCamiones().add(camion);

        LlegadaDeCamion proximaLlegada=new LlegadaDeCamion();

    }
}
