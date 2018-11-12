package Logica;

public class Camion
{
    private int numero;
    private EstadoCamion estado;
    private double litrosCombustible;

    public Camion(int numero, EstadoCamion estado)
    {
        this.numero = numero;
        this.estado=estado;
        generarLitrosCombustible();
    }

    public Camion(EstadoCamion estado){
        this.numero = 0;
        this.estado = estado;
        generarLitrosCombustible();
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

    public double getLitrosCombustible() {
        return litrosCombustible;
    }

    public void setLitrosCombustible(double litrosCombustible) {
        this.litrosCombustible = litrosCombustible;
    }

    public void generarLitrosCombustible(){
        setLitrosCombustible(15000 + Math.random() * 5000);
    }

    public String getNumeroString() {

        return (this.numero != 0) ? Integer.toString(getNumero()) : "-";
    }
}
