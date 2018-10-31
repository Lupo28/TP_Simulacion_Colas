package Logica;

public class Reloj {
    private static Reloj instancia;
    private int ultNumeroCamion;
    private long tiempoActual;

    private Reloj() {
        this.ultNumeroCamion = 0;
        this.tiempoActual = 0;
    }

    public static Reloj getInstancia() {
        if (instancia == null) {
            instancia = new Reloj();
        }
        return instancia;
    }

    public long getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(long tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public int getNumeroCamion(){
        return this.ultNumeroCamion++;
    }

    public String tiempoString(){

        long horas = tiempoActual / 3600;
        long minutos = (tiempoActual - horas*3600) / 60;
        long segundos2 =  tiempoActual - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";

        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }


    public static String tiempoString(long tiempo){

        long horas = tiempo / 3600;
        long minutos = (tiempo - horas*3600) / 60;
        long segundos2 =  tiempo - (horas*3600 + minutos*60);
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos2 < 10 ) ceroS = "0";

        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos2;
    }

    public Boolean esCierrePlanta(){
        return (this.tiempoActual < 18 && this.tiempoActual > 5) ? false : true;
    }


}
