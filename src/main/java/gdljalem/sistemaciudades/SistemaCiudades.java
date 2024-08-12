
package gdljalem.sistemaciudades;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//Creación de la clase sistema de ciudades donde se desarrollara la logica para festionar las ciudades y sus rutas
public class SistemaCiudades {
    //Es una ProtioryQueue que almacena las rutas de la función 
    PriorityQueue<Ruta> colaDePrioridades;
    
    //Inicializa la cola de prioridades
    public SistemaCiudades() {
        this.colaDePrioridades = new PriorityQueue<>();
    }

    // Método para agregar una ruta a la cola de prioridades
    public void agregarRuta(Ciudad ciudad, int distancia) {
        Ruta ruta = new Ruta(ciudad, distancia);
        colaDePrioridades.add(ruta);
    }
    
    // Método para obtener la ruta más corta de la cola de prioridades
    public Ruta obtenerRutaMasCorta() {
        return colaDePrioridades.poll();
    }
    //Se define el metodo de recursividad para buscar el camino mas corto entre ciudades
    //Se definen los parametros de busqueda Ciudad origen, Ciudad destino y set<Ciudad> visitadas conjunto para evitar ciclos
    public int buscarCaminoMasCorto(Ciudad origen, Ciudad destino, Set<Ciudad> visitadas) {
        //Condicion de que si se reqpite el roigen y destino de 0 ya que es el mismo lugar
        if (origen.equals(destino)) {
            return 0;
        }
        //Codigo de cuando ingresemos la ciudad la agregue en la lista de ya visitadas
        visitadas.add(origen);
        //Se inicia el atributo distanciaMinima con el maximo valor
        int distanciaMinima = Integer.MAX_VALUE;
        //Iteración o bucle las conexciones de la ciudad
        for (Map.Entry<Ciudad, Integer> conexion : origen.conexiones.entrySet()) {
            //Si la ciudad ya fue visitada se llava recursivamente al metodo "buscarCaminoMasCorto para esa ciudad
            if (!visitadas.contains(conexion.getKey())) {
                int distancia = buscarCaminoMasCorto(conexion.getKey(), destino, visitadas);
                if (distancia != Integer.MAX_VALUE) {   
                    distanciaMinima = Math.min(distanciaMinima, distancia + conexion.getValue());
                }
            }
        }
        //Se elimina la ciudad de origen del conjunto de ciudades visitadas
        visitadas.remove(origen);
        //Se retorna la distancia mínima encontrada
        return distanciaMinima;
    }

    // Método para optimizar la búsqueda de rutas utilizando "divide y vencerás"
    public int optimizarRuta(List<Ciudad> ciudades) {
        if (ciudades.size() <= 1) {
            return 0;
        }
        int mitad = ciudades.size() / 2;
        List<Ciudad> izquierda = ciudades.subList(0, mitad);
        List<Ciudad> derecha = ciudades.subList(mitad, ciudades.size());
        return optimizarRuta(izquierda) + optimizarRuta(derecha);
    }
}
