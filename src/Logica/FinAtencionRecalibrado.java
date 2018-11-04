package Logica;

public class FinAtencionRecalibrado extends Evento
{
    private ConjuntoDarsena darsenas;
    private int darsenaFinalizada;

    public FinAtencionRecalibrado(ConjuntoDarsena darsenas, int darsenaFinalizada){
        this.darsenas = darsenas;
        this.darsenaFinalizada = darsenaFinalizada;
    }

    public void ejecutar()
    {
        if(darsenas.getCola().isEmpty())
        {
            darsenas.getDarsena(darsenaFinalizada).setEstadoDarsena(EstadoDarsena.Libre);
        }
        else
        {
            darsenas.getDarsena(darsenaFinalizada).setEstadoDarsena(EstadoDarsena.Ocupado);
        }


    }
    public  String getNombre()
    {
        String nombre= "Fin At Recalibrado - Darsena " + darsenaFinalizada;
        return nombre;
    }
}
