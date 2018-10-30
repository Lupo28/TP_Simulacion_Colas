package Logica;

public  class Distribuciones {

    public static long proximoRecepcion(long tiempoActual){
        double demora = 3 + Math.random() * 4;
        double proximo = tiempoActual - demora / 60;
        return (long)proximo;
    }

    public static long proximoBalanza(long tiempoActual){
        double demora = 5 + Math.random() * 2;
        double proximo = tiempoActual - demora / 60;
        return (long)proximo;
    }

    public static long proximoDarsena(long tiempoActual){
        double demora = 15 + Math.random() * 5;
        double proximo = tiempoActual - demora / 60;
        return (long)proximo;
    }

    public static long proximoRecalibracion(long tiempoActual){
        double z = Math.sqrt(-2*Math.log(Math.random())*Math.cos(2*Math.PI*Math.random()));
        double demora = 10 + (z*1.2);
        double proximo = tiempoActual - demora / 60;
        return (long)proximo;
    }
}
