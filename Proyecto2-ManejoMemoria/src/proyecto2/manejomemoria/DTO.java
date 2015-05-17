
package proyecto2.manejomemoria;
import java.util.*;
public class DTO {
    //Declaracion de variables del DTO
    LinkedList<Paginas> Lista_Paginas_MM;
    HashMap<Integer, Marco> Mapa_Marcos = new HashMap<Integer, Marco>();
    String Politica_Recuperacion;
    String Politica_Ubicacion;
    String Politica_Reemplazo;
    String Politica_Limpieza;
    String Tamaño_Conjunto;
    String Ambito_Reemplazo;
    String Control_Limpieza;
    int Tamaño_Memoria;
    int Tamaño_Paginas;

    public DTO(String Politica_Recuperacion, String Politica_Ubicacion, String Politica_Reemplazo, String Politica_Limpieza, String Tamaño_Conjunto, String Ambito_Reemplazo, String Control_Limpieza, int Tamaño_Memoria, int Tamaño_Paginas) {
        this.Politica_Recuperacion = Politica_Recuperacion;
        this.Politica_Ubicacion = Politica_Ubicacion;
        this.Politica_Reemplazo = Politica_Reemplazo;
        this.Politica_Limpieza = Politica_Limpieza;
        this.Tamaño_Conjunto = Tamaño_Conjunto;
        this.Ambito_Reemplazo = Ambito_Reemplazo;
        this.Control_Limpieza = Control_Limpieza;
        this.Tamaño_Memoria = Tamaño_Memoria;
        this.Tamaño_Paginas = Tamaño_Paginas;
    }
    
       public int TamañoPagina(){
        return Tamaño_Paginas;
    }
    
    
    
}