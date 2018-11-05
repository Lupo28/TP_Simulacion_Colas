package Logica;

public class Camion
{
    private int numero;
    private EstadoCamion estado;



    public Camion(int numero, EstadoCamion estado)
    {
        this.numero = numero;
        this.estado=estado;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoCamion getEstado() {
        return estado;
    }

    public void setEstado(EstadoCamion estado) {
        this.estado = estado;
    }


    public String getNumeroString() {

        return Integer.toString(getNumero());
    }
}
