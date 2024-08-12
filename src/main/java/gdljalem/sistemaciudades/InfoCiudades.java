
package gdljalem.sistemaciudades;

import java.util.HashMap;
import java.util.Map;

public class InfoCiudades {
    //Definir atributo infoCiudades que sera un HashMap para almcenar información adicional de cada ciudad 
    Map<String, Map<String, String>> informacionCiudades;
    
    //Contructor: Inicializado HashMap
    public InfoCiudades() {
        this.informacionCiudades = new HashMap<>();
    }
    //Metodo: Permite agregar información adicional a una ciudad en especifico 
    //Parametros: Nombre de la ciudad y mapa de la información de la ciudad
    public void AddInfoCiudad(String nombre, Map<String, String> informacion) {
        informacionCiudades.put(nombre, informacion);
    }
    //Metodo: Permite Obtener la información de las ciudades
    //Parametro: String nombre
    public Map<String, String> GetInfoCiudad(String nombre) {
        return informacionCiudades.get(nombre);
    }
}
