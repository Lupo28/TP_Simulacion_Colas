package Logica;

public enum EstadoRecepcion {
    Libre("Libre"),
    Ocupado("Ocupado");


    private final String name;

    EstadoRecepcion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    }
