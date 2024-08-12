
package gdljalem.sistemaciudades;

public class Ruta implements Comparable<Ruta> {
    //Crear atributos ciudad y distancia 
    Ciudad ciudad;
    int distancia;
    
    //Inicializa los atributos ciudad y distancia
    public Ruta(Ciudad ciudad, int distancia) {
        this.ciudad = ciudad;
        this.distancia = distancia;
    }
    //Metodo comopareTo para comparar rutas para la cola de prioridades
    @Override
    public int compareTo(Ruta otra) {
        return Integer.compare(this.distancia, otra.distancia);
    }
}


