package Logica;

public enum EstadoBalanza {

    Libre("Libre"),
    Ocupado("Ocupado");


    private final String name;

    private EstadoBalanza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
