package Logica;

public class FinAtencionRecalibrado extends Evento
{
    private Balanza balanza;

    public  void ejecutar()
    {
        if(balanza.getCola().isEmpty())
        {
            balanza.setEstadoBalanza(EstadoBalanza.Libre);
        }
        else
        {
            balanza.setEstadoBalanza(EstadoBalanza.Ocupado);
        }


    }
    public  String getNombre()
    {
        String nombre= "Fin At Recalibrado";
        return nombre;
    }
}
