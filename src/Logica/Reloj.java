package Logica;

public class Reloj {
    private static Reloj instancia;
    private double tiempoActual;

    public Reloj() {
        this.tiempoActual = 0;
    }

    public static Reloj getInstancia() {
        if (instancia == null) {
            instancia = new Reloj();
        }
        return instancia;
    }

    public double getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(double tiempoActual) {
        this.tiempoActual = tiempoActual;
    }



    public String tiempoString(){

//        return String.valueOf(tiempoActual);
        tiempoActual=(long)tiempoActual;
        double horas = (long)tiempoActual / 3600;
        double minutos = (long)(tiempoActual - horas*3600) / 60;
        double segundos = (long) (tiempoActual - (horas*3600 + minutos*60));
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos < 10 ) ceroS = "0";
        horas = horas % 24;

        return ceroH + String.valueOf(horas) + ":"  + ceroM + String.valueOf(minutos) + ":" + ceroS + String.valueOf(segundos);
    }


    public Boolean esCierrePlanta(){
        return (this.tiempoActual < 18 && this.tiempoActual > 5) ? false : true;
    }


}
