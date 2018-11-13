package Logica;

public class Reloj {
    private static Reloj instancia;
    private static double tiempoActual;
    private static int dia;
    private static boolean alternativa;

    public static boolean isAlternativa() {
        return alternativa;
    }

    public static void setAlternativa(boolean alternativa) {
        Reloj.alternativa = alternativa;
    }

    public static void setInstancia(Reloj instancia) {
        Reloj.instancia = instancia;
        setDia(0);
    }

    public static int getDia() {
        return dia;
    }

    public static void setDia(int dia) {
        Reloj.dia = dia;
    }

    public Reloj() {
        if(alternativa)
        {
            this.tiempoActual = 43200.00;//12HS
        }
        else{
            this.tiempoActual = 18000;//5HS
        }
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



    public static String tiempoString(double tiempo){

//        return String.valueOf(tiempoActual);
        tiempo=(long)tiempo;
        long horas = (long)tiempo / 3600;
        long minutos = (long)(tiempo - horas*3600) / 60;
        long segundos = (long) (tiempo - (horas*3600 + minutos*60));
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos < 10 ) ceroS = "0";
        horas = horas % 24;


        return ceroH + String.valueOf(horas) + ":"  + ceroM + String.valueOf(minutos) + ":" + ceroS + String.valueOf(segundos);
    }
    public static String tiempoString(){


        tiempoActual=(long)tiempoActual;
        long horas = (long)tiempoActual/3600 ;
        long minutos = (long)(tiempoActual - horas*3600) / 60;
        long segundos = (long) (tiempoActual - (horas*3600 + minutos*60));
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos < 10 ) ceroS = "0";
        horas = horas % 24;
        if(horas==1)
        {
            dia++;
        }

        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos;
    }


    public Boolean esCierrePlanta(){
        return (this.tiempoActual < 18 && this.tiempoActual > 5) ? false : true;
    }


    public static void resetearReloj()
    {
       setInstancia(null);
    }

}
