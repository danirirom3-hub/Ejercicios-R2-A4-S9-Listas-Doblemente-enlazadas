package Listas;
import java.util.Scanner;

public class Ejecutar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();
        int opcion;

        do {
            System.out.println("MENU LISTA DOBLEMENTE ENLAZADA ");
            System.out.println("1. Agregar numero al final");
            System.out.println("2. Insertar antes de un valor");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Mostrar lista (inicio - fin)");
            System.out.println("5. Mostrar lista (fin - inicio)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero a agregar: ");
                    int valor = sc.nextInt();
                    lista.agregarFinal(valor);
                    break;
                case 2:
                    System.out.print("Ingrese el valor de referencia: ");
                    int ref = sc.nextInt();
                    System.out.print("Ingrese el nuevo valor a insertar: ");
                    int nuevo = sc.nextInt();
                    lista.insertarAntesDe(ref, nuevo);
                    break;
                case 3:
                    System.out.print("Ingrese el valor que desea eliminar: ");
                    int eliminar = sc.nextInt();
                    lista.eliminarPorValor(eliminar);
                    break;
                case 4:
                    lista.recorrerAdelante();
                    break;
                case 5:
                    lista.recorrerReversa();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}