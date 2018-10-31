package Logica;

public enum EstadoBalanza {

    Libre("Libre"),
    En_Recalibracion("En Recalibracion"),
    Ocupado("Ocupado");


    private final String name;

    private EstadoBalanza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
