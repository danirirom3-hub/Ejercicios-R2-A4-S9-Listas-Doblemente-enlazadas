package transmileniolistadoble;
import java.util.Scanner;

public class Ejecutar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEstaciones ruta = new ListaEstaciones();
        int opcion;

        // Ruta inicial del PDF (sin Universidades)
        ruta.agregarEstacion("Las Aguas");
        ruta.agregarEstacion("Museo del Oro");
        ruta.agregarEstacion("San Victorino");
        ruta.agregarEstacion("Tercer Milenio");

        System.out.println("Ruta inicial del TransMilenio (linea B):");
        ruta.recorrerRuta();

        // Menú de operaciones interactivas
        do {
            System.out.println("MENU RUTA TRANSMILENIO ");
            System.out.println("1. Insertar estacion antes de otra");
            System.out.println("2. Eliminar una estacion");
            System.out.println("3. Mostrar ruta (inicio - fin)");
            System.out.println("4. Mostrar ruta (fin - inicio)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la estacion de referencia: ");
                    String ref = sc.nextLine();
                    System.out.print("Ingrese el nombre de la nueva estacion: ");
                    String nueva = sc.nextLine();
                    ruta.insertarAntesDe(ref, nueva);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la estacion a eliminar: ");
                    String eliminar = sc.nextLine();
                    ruta.eliminarEstacion(eliminar);
                    break;
                case 3:
                    ruta.recorrerRuta();
                    break;
                case 4:
                    ruta.recorrerRutaInversa();
                    break;
                case 5:
                    System.out.println("Finalizando simulacion...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
