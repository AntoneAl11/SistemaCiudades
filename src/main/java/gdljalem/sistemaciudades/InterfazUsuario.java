
package gdljalem.sistemaciudades;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InterfazUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaCiudades sistema = new SistemaCiudades();
        InfoCiudades info = new InfoCiudades();

        // Crear algunas ciudades de ejemplo
        Ciudad guadalajara = new Ciudad("Guadalajara");
        Ciudad zapopan = new Ciudad("Zapopan");
        Ciudad tlaquepaque = new Ciudad("Tlaquepaque");
        Ciudad tonala = new Ciudad("Tonalá");

        // Agregar conexiones entre ciudades
        guadalajara.agregarConexion(zapopan, 10);
        guadalajara.agregarConexion(tlaquepaque, 15);
        zapopan.agregarConexion(tonala, 20);
        tlaquepaque.agregarConexion(tonala, 25);

        // Agregar ciudades al sistema
        sistema.agregarRuta(guadalajara, 0);
        sistema.agregarRuta(zapopan, 10);
        sistema.agregarRuta(tlaquepaque, 15);
        sistema.agregarRuta(tonala, 20);

        while (true) {
            System.out.println("1. Agregar ciudad");
            System.out.println("2. Buscar ruta más corta");
            System.out.println("3. Mostrar información de una ciudad");
            System.out.println("4. Visualizar rutas disponibles");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la ciudad:");
                    String nombre = scanner.nextLine();
                    Ciudad ciudad = new Ciudad(nombre);
                    sistema.agregarRuta(ciudad, 0); // Ejemplo de agregar ciudad con distancia 0
                    System.out.println("Ciudad agregada: " + nombre);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la ciudad de origen:");
                    String nombreOrigen = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la ciudad de destino:");
                    String nombreDestino = scanner.nextLine();
                    Ciudad origen = new Ciudad(nombreOrigen);
                    Ciudad destino = new Ciudad(nombreDestino);
                    Set<Ciudad> visitadas = new HashSet<>();
                    int distancia = sistema.buscarCaminoMasCorto(origen, destino, visitadas);
                    if (distancia == Integer.MAX_VALUE) {
                        System.out.println("No se encontró una ruta entre " + nombreOrigen + " y " + nombreDestino);
                    } else {
                        System.out.println("La ruta más corta entre " + nombreOrigen + " y " + nombreDestino + " es de " + distancia + " unidades.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la ciudad:");
                    String nombreCiudad = scanner.nextLine();
                    Map<String, String> informacion = info.GetInfoCiudad(nombreCiudad);
                    if (informacion != null) {
                        System.out.println("Información de " + nombreCiudad + ": " + informacion);
                    } else {
                        System.out.println("No se encontró información para la ciudad: " + nombreCiudad);
                    }
                    break;
                case 4:
                    System.out.println("Rutas disponibles en orden de distancia:");
                    while (!sistema.colaDePrioridades.isEmpty()) {
                        Ruta ruta = sistema.obtenerRutaMasCorta();
                        System.out.println("Ciudad: " + ruta.ciudad.nombre + ", Distancia: " + ruta.distancia);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
