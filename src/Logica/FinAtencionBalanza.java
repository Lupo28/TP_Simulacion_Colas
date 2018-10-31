package Logica;

public class FinAtencionBalanza extends Evento {
    private Balanza balanza;
    private ConjuntoDarsena conjuntoDarsena;

    public FinAtencionBalanza( Balanza balanza,  ConjuntoDarsena conjuntoDarsena) {
        this.balanza = balanza;
        this.conjuntoDarsena = conjuntoDarsena;
    }

    public FinAtencionBalanza()
    {
    }

    public void ejecutar()
    {
        if(conjuntoDarsena.getCola().isEmpty())
        {
            if(conjuntoDarsena.getDarsenas()[0].getEstadoDarsena() == EstadoDarsena.Libre)
            {
                conjuntoDarsena.getDarsenas()[0].setCamion(balanza.getCamion());
            }
            else
            {
                if(conjuntoDarsena.getDarsenas()[1].getEstadoDarsena()==EstadoDarsena.Libre)
                {
                    conjuntoDarsena.getDarsenas()[1].setCamion(balanza.getCamion());
                }
                else
                {
                    conjuntoDarsena.getCola().add(balanza.getCamion());
                }
            }
        }
        else
        {
            conjuntoDarsena.getCola().add(balanza.getCamion());
        }
        if (balanza.getCola().isEmpty())
        {
            balanza.setEstadoBalanza(EstadoBalanza.Libre);
        }
        else
        {
            balanza.setCamion(balanza.getCola().poll());
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
