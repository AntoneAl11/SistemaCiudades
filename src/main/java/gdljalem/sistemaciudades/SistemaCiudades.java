
package gdljalem.sistemaciudades;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Creación de la clase sistema de ciudades donde se desarrollara la logica para festionar las ciudades y sus rutas
public class SistemaCiudades {
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
}
