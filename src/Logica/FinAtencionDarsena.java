package Logica;

public class FinAtencionDarsena extends Evento {
    private ConjuntoDarsena darsenas;
    private int darsenaFinalizada;

    public FinAtencionDarsena(ConjuntoDarsena darsenas, int darsenaFinalizada){
        this.darsenas = darsenas;
        this.darsenaFinalizada = darsenaFinalizada;
    }


    public void ejecutar() {
        getCamionDarsena(darsenas.getDarsena(darsenaFinalizada).getCamion());
        if(!darsenas.getCola().isEmpty()){
            darsenas.getDarsena(darsenaFinalizada).setCamion(darsenas.getCola().poll());
        }
        else
        {
            darsenas.getDarsena(darsenaFinalizada).setCamion(null);
            darsenas.getDarsena(darsenaFinalizada).setEstadoDarsena(EstadoDarsena.Libre);
        }
    }

    public Camion getCamionDarsena(Camion camion){
        return camion;
    }

    public String getNombre() {
        String nombre= "Fin At Darsena " + this.darsenas.getDarsena(darsenaFinalizada).getId();
        return nombre;
    }
}
