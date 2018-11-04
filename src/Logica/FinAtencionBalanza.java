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
                balanza.getCamion().setEstado(EstadoCamion.En_Descargue);
                conjuntoDarsena.getDarsenas()[0].setCamion(balanza.getCamion());
                balanza.setCamion(null);
            }
            else
            {
                if(conjuntoDarsena.getDarsenas()[1].getEstadoDarsena()==EstadoDarsena.Libre)
                {
                    balanza.getCamion().setEstado(EstadoCamion.En_Descargue);
                    conjuntoDarsena.getDarsenas()[1].setCamion(balanza.getCamion());
                    balanza.setCamion(null);
                }
                else
                {
                    balanza.getCamion().setEstado(EstadoCamion.En_Cola_De_Descarga);
                    conjuntoDarsena.getCola().add(balanza.getCamion());
                    balanza.setCamion(null);
                }
            }
        }
        else
        {
            balanza.getCamion().setEstado(EstadoCamion.En_Cola_De_Descarga);
            conjuntoDarsena.getCola().add(balanza.getCamion());
            balanza.setCamion(null);
        }
        if (balanza.getCola().isEmpty())
        {
            balanza.setEstadoBalanza(EstadoBalanza.Libre);
        }
        else
        {
            balanza.getCola().getFirst().setEstado(EstadoCamion.En_Pesaje);
            balanza.setCamion(balanza.getCola().poll());
        }


    }
    public String getNombre()
    {
        String nombre= "Fin At Balanza";
        return nombre;
    }
}
