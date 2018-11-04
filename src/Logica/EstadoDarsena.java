package Logica;

public enum EstadoDarsena {
    Libre("Libre"),
    En_Recalibracion("En Recalibracion"),
    Ocupado("Ocupado");


    private final String name;

    private EstadoDarsena(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
