package transmileniolistadoble;
public class ListaEstaciones {
    private NodoEstacion cabeza;
    private NodoEstacion cola;

    // Agregar estación al final
    public void agregarEstacion(String nombre) {
        NodoEstacion nueva = new NodoEstacion(nombre);
        if (cabeza == null) {
            cabeza = cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    // Insertar antes de una estación específica
    public void insertarAntesDe(String referencia, String nuevaEstacion) {
        NodoEstacion actual = cabeza;
        while (actual != null && !actual.nombre.equalsIgnoreCase(referencia)) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("La estacion " + referencia + " no existe en la ruta.");
            return;
        }

        NodoEstacion nueva = new NodoEstacion(nuevaEstacion);
        if (actual == cabeza) {
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cabeza = nueva;
        } else {
            NodoEstacion anterior = actual.anterior;
            anterior.siguiente = nueva;
            nueva.anterior = anterior;
            nueva.siguiente = actual;
            actual.anterior = nueva;
        }
        System.out.println("Se inserto " + nuevaEstacion + " antes de " + referencia);
    }

    // Eliminar una estación por nombre
    public void eliminarEstacion(String nombre) {
        NodoEstacion actual = cabeza;
        while (actual != null && !actual.nombre.equalsIgnoreCase(nombre)) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("La estacion " + nombre + " no se encontro en la ruta.");
            return;
        }

        if (actual == cabeza && actual == cola) {
            cabeza = cola = null;
        } else if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        } else if (actual == cola) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        System.out.println("Se elimino la estacion: " + nombre);
    }

    // Recorrer de inicio a fin
    public void recorrerRuta() {
        if (cabeza == null) {
            System.out.println("La ruta esta vacia.");
            return;
        }
        System.out.println("Ruta (inicio - fin):");
        NodoEstacion actual = cabeza;
        while (actual != null) {
            System.out.println(" - " + actual.nombre);
            actual = actual.siguiente;
        }
    }

    // Recorrer de fin a inicio
    public void recorrerRutaInversa() {
        if (cola == null) {
            System.out.println("La ruta esta vacia.");
            return;
        }
        System.out.println("Ruta (fin - inicio):");
        NodoEstacion actual = cola;
        while (actual != null) {
            System.out.println(" - " + actual.nombre);
            actual = actual.anterior;
        }
    }
}
