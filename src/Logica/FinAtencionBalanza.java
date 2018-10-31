package Logica;

public class FinAtencionBalanza extends Evento {
    private Balanza balanza;
    private Camion camion;

    public void ejecutar()
    {
        balanza.getCamion().setEstado(EstadoCamion.En_Pesaje);

        if (balanza.getCola().isEmpty())
        {
            balanza.setEstadoBalanza(EstadoBalanza.Libre);
        }
        else
        {
            balanza.setCamion(balanza.getCola().getFirst());
        }


    }
    public String getNombre()
    {
        String nombre= "Fin At Balanza";
        return nombre;
    }

    public Recepcion  getRecepcion()

    {
        return null;
    }
}
