package listadoble_propia;

public class Ejecutar {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        // Lista inicial
        lista.agregarFinal(5);
        lista.agregarFinal(7);
        lista.agregarFinal(12);
        lista.agregarFinal(20);

        System.out.println("Lista inicial:");
        lista.recorrerAdelante();

        // Insertar 10 antes del 12
        lista.insertarAntesDe(12, 10);
        lista.recorrerAdelante();

        // Eliminar el nodo con valor 7
        lista.eliminarPorValor(7);
        lista.recorrerAdelante();

        // Recorrer en reversa
        lista.recorrerReversa();
    }
}
