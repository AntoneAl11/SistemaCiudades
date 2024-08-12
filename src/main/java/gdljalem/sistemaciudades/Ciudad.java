
package gdljalem.sistemaciudades;
import java.util.HashMap;
import java.util.Map;

public class Ciudad {
    //Crear atributo nombre para almacenar nombre de la ciudad
    String nombre;
    //Crear mapa con nombre conexiones para almancernar la ciudades con su distancia
    Map<Ciudad, Integer> conexiones; // Ciudades conectadas y sus distancias
    
    //Constructor: Inicializa el nombre de la ciuidad y crea un nuevo hashmap para las conexciones
    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.conexiones = new HashMap<>();
    }
    //Metodo para agregar conexiones que permita agregar la ciudad y su distancia
    public void agregarConexion(Ciudad city, int distancia) {
        conexiones.put(city, distancia);
    }
}
