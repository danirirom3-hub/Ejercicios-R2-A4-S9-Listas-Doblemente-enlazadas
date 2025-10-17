package listadoble_javainteractiva;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ejercicio1_JavaInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> lista = new LinkedList<>();
        int opcion;

        System.out.println("LISTA DOBLEMENTE ENLAZADA CON LINKEDLIST (JAVA)");

        // Crear lista inicial
        System.out.print("Cuantos numeros desea agregar inicialmente? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Digite el numero " + (i + 1) + ": ");
            int valor = sc.nextInt();
            lista.add(valor);
        }

        System.out.println("Lista inicial: " + lista);

        // Menú de opciones
        do {
            System.out.println("MENU LISTA ");
            System.out.println("1. Insertar numero antes de otro");
            System.out.println("2. Eliminar numero");
            System.out.println("3. Mostrar lista (inicio - fin)");
            System.out.println("4. Mostrar lista (fin - inicio)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Digite el numero de referencia: ");
                    int ref = sc.nextInt();
                    System.out.print("Digite el numero nuevo a insertar: ");
                    int nuevo = sc.nextInt();
                    int indice = lista.indexOf(ref);
                    if (indice != -1) {
                        lista.add(indice, nuevo);
                        System.out.println("Se inserto " + nuevo + " antes de " + ref);
                    } else {
                        System.out.println("El valor de referencia no existe en la lista.");
                    }
                    break;

                case 2:
                    System.out.print("Digite el numero a eliminar: ");
                    int eliminar = sc.nextInt();
                    boolean eliminado = lista.remove(Integer.valueOf(eliminar));
                    if (eliminado) {
                        System.out.println("Se elimino el numero " + eliminar);
                    } else {
                        System.out.println("El numero no se encontro en la lista.");
                    }
                    break;

                case 3:
                    System.out.println("Lista (inicio - fin): " + lista);
                    break;

                case 4:
                    System.out.print("Lista (fin - inicio): ");
                    ListIterator<Integer> it = lista.listIterator(lista.size());
                    while (it.hasPrevious()) {
                        System.out.print(it.previous() + " ");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
