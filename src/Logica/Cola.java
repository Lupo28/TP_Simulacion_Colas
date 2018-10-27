package Logica;
import  java.util.LinkedList;

public class Cola<T> {
    private LinkedList<T> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public LinkedList<T> getColaActual() {
        return (LinkedList<T>) cola.clone();
    }

    public boolean estaVacia(){
        return cola.isEmpty();
    }

    public void agregarItem(T item){
        cola.addLast(item);
    }

    public T avanzar(){
        return cola.removeFirst();
    }

    public int camionesEnCola(){
        return cola.size();
    }

}
