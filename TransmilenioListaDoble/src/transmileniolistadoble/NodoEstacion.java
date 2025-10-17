package transmileniolistadoble;

public class NodoEstacion {
    String nombre;
    NodoEstacion siguiente;
    NodoEstacion anterior;

    public NodoEstacion(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
        this.anterior = null;
    }
}
