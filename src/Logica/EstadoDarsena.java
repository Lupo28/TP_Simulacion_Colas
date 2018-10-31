package Logica;

public enum EstadoDarsena {
    Libre("Libre"),
    Ocupado("Ocupado");


    private final String name;

    private EstadoDarsena(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
