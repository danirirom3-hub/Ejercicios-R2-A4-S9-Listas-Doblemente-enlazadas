package Listas;
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

    public void insertarAntesDe(int valorReferencia, int nuevoValor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != valorReferencia) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("El valor " + valorReferencia + " no existe en la lista.");
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
        System.out.println("Se inserto " + nuevoValor + " antes de " + valorReferencia);
    }

    public void eliminarPorValor(int valor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != valor) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("El valor " + valor + " no se encontro en la lista.");
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

        System.out.println("Se elimino el nodo con valor " + valor);
    }

    public void recorrerAdelante() {
        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return;
        }
        System.out.print("Lista (inicio - fin): ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void recorrerReversa() {
        if (cola == null) {
            System.out.println("La lista esta vacia.");
            return;
        }
        System.out.print("Lista (fin - inicio): ");
        Nodo actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }
}