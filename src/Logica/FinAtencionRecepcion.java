package Logica;

public class FinAtencionRecepcion extends Evento
{
    private Recepcion recepcion;
    private Balanza balanza;

    public FinAtencionRecepcion(long reloj, Gestor gestor, Recepcion recepcion) {
        super(reloj, gestor);
        this.recepcion = recepcion;
    }

    public void ejecutar()
    {
        recepcion.getCamion().setEstado(EstadoCamion.Recepcionado);
        balanza.setCamion(recepcion.getCamion());
        if (!recepcion.getCola().isEmpty())
        {
            recepcion.setCamion(recepcion.getCola().poll());
        }
    }
    public String getNombre()
    {
        String nombre= "Fin At Recepcion";
        return nombre;
    }
}
