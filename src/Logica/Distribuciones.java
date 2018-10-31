package Logica;

public  class Distribuciones {

    public static long proximoRecepcion(long tiempoActual, double random){
        double demora = 3 + random * 4;
        double proximo = tiempoActual + (demora / 60);
        return (long)proximo;
    }

    public static long proximoBalanza(long tiempoActual , double random ){
        double demora = 5 + random * 2;
        double proximo = tiempoActual + (demora / 60);
        return (long)proximo;
    }

    public static long proximoDarsena(long tiempoActual, double random){
        double demora = 15 + random * 5;
        double proximo = tiempoActual + (demora / 60);
        return (long)proximo;
    }

    public static long proximoRecalibracion(long tiempoActual, double random){
        double z = Math.sqrt(-2*Math.log(random)*Math.cos(2*Math.PI*random));
        double demora = 10 + (z*1.2);
        double proximo = tiempoActual + (demora / 60);
        return (long)proximo;
    }
}
