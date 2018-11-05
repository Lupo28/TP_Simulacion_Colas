package Logica;

public class FinAtencionRecepcion extends Evento {
    private Recepcion recepcion;
    private Balanza balanza;

    public FinAtencionRecepcion(Recepcion recepcion, Balanza balanza) {
        this.recepcion = recepcion;
        this.balanza = balanza;
    }

    public void ejecutar() {
        if (balanza.getEstadoBalanza() == EstadoBalanza.Ocupado) {
            recepcion.getCamion().setEstado(EstadoCamion.En_Cola_Balanza_);
            balanza.getCola().add(recepcion.getCamion());
            recepcion.setCamion(null);

        } else {
            recepcion.getCamion().setEstado(EstadoCamion.En_Pesaje);
            balanza.setCamion(recepcion.getCamion());
            recepcion.setCamion(null);

        }

        if (!recepcion.getCola().isEmpty()) {
            recepcion.getCola().getFirst().setEstado(EstadoCamion.En_Recepcion);
            recepcion.setCamion(recepcion.getCola().poll());
        } else {
            recepcion.setEstado(EstadoRecepcion.Libre);
        }
    }

    public String getNombre() {
        String nombre = "Fin At Recepcion";
        return nombre;
    }
}
