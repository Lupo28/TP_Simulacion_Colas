package Logica;

public enum EstadoCamion
{
    En_cola_Recepcion ("En cola de Recepcion"),
    En_Recepcion ("En Recepcion"),
    En_Cola_Balanza_("En cola de Pesaje"),
    En_Pesaje("Pesandose"),
    En_Cola_De_Descarga("En cola de Descarga"),
    En_Descargue("Descargandose");


    private final String name;

        EstadoCamion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
