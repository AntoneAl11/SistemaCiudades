
package gdljalem.sistemaciudades;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InfoCiudades infoCiudades = new InfoCiudades();

        // Crear información para una ciudad
        Map<String, String> infoGuadalajara = new HashMap<>();
        infoGuadalajara.put("Población", "1,495,182");
        infoGuadalajara.put("Fundación", "1542");

        // Agregar información de la ciudad
        infoCiudades.AddInfoCiudad("Guadalajara", infoGuadalajara);

        // Obtener y mostrar información de la ciudad
        Map<String, String> info = infoCiudades.GetInfoCiudad("Guadalajara");
        System.out.println("Información de Guadalajara: " + info);
        
        SistemaCiudades sistema = new SistemaCiudades();

        // Crear ciudades
        Ciudad guadalajara = new Ciudad("Guadalajara");
        Ciudad zapopan = new Ciudad("Zapopan");

        // Agregar rutas
        sistema.agregarRuta(zapopan, 10);
        sistema.agregarRuta(guadalajara, 5);

        // Obtener y mostrar la ruta más corta
        Ruta rutaMasCorta = sistema.obtenerRutaMasCorta();
        System.out.println("Ruta más corta: " + rutaMasCorta.ciudad.nombre + " con distancia " + rutaMasCorta.distancia);
    }
}
