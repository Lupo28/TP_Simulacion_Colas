package Logica;

public class FinAtencionRecepcion extends Evento
{
    private Recepcion recepcion;
    private Balanza balanza;

    public FinAtencionRecepcion(Recepcion recepcion, Balanza balanza) {
        this.recepcion = recepcion;
        this.balanza = balanza;
    }

    public void ejecutar()
    {
        balanza.calcularTiempoAtencion();
        if (balanza.getEstadoBalanza() == EstadoBalanza.Ocupado || balanza.getEstadoBalanza() == EstadoBalanza.En_Recalibracion)
        {
            balanza.getCola().add(recepcion.getCamion());
            recepcion.setCamion(null);

        }
        else
            {
            balanza.setCamion(recepcion.getCamion());
            recepcion.setCamion(null);

            }

        if (!recepcion.getCola().isEmpty()){
            recepcion.setCamion(recepcion.getCola().poll());
        }
        else{
            recepcion.setEstado(EstadoRecepcion.Libre);
        }
    }
    public String getNombre()
    {
        String nombre= "Fin At Recepcion";
        return nombre;
    }
}
