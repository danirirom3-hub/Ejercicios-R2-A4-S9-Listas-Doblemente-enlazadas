package listadoble_propia;
public class ListaDoble {
    private Nodo cabeza;
    private Nodo cola;

    public void agregarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void insertarAntesDe(int referencia, int nuevoValor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != referencia) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("El valor " + referencia + " no existe en la lista.");
            return;
        }

        Nodo nuevo = new Nodo(nuevoValor);
        if (actual == cabeza) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        } else {
            Nodo anterior = actual.anterior;
            anterior.siguiente = nuevo;
            nuevo.anterior = anterior;
            nuevo.siguiente = actual;
            actual.anterior = nuevo;
        }
        System.out.println("Se insertó " + nuevoValor + " antes de " + referencia);
    }

    public void eliminarPorValor(int valor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != valor) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("El valor " + valor + " no se encontró en la lista.");
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
        System.out.println("Se eliminó el nodo con valor " + valor);
    }

    public void recorrerAdelante() {
        System.out.print("Lista (inicio → fin): ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void recorrerReversa() {
        System.out.print("Lista (fin → inicio): ");
        Nodo actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }
}
