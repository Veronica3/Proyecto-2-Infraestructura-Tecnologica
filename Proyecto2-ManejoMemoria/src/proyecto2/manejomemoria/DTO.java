
package proyecto2.manejomemoria;
import java.util.*;
public class DTO {
    
    //Listas para reemplazos y ubicacion
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal= new LinkedList<>();
    LinkedList<Paginas> Paginas_Referenciadas= new LinkedList<>();
    //Memoria FISICA Y VIRTUAL
    HashMap<Integer, Marco> Memoria_Fisica = new HashMap<Integer, Marco>();
    LinkedHashMap<String, Paginas> Memoria_Virtual;
    //Lista de PROCESOS y REFERENCIAS
    LinkedHashMap<Integer,Interface_Proceso> Lista_Procesos= new LinkedHashMap();
    LinkedList <Interface_Referencia> Lista_Referencias = new LinkedList();
    
    //Variables del Sistema
    String Politica_Recuperacion;
    String Politica_Ubicacion;
    String Politica_Reemplazo;
    String Politica_Limpieza;
    String Tamaño_Conjunto;
    String Ambito_Reemplazo;
    String Control_Limpieza;
    int Paginas_En_MM_Por_Proceso;
    int Tamaño_Memoria;
    int Tamaño_Paginas;
    
    //Variables para abrir archivos
    String Nombre_Archivo_Procesos;
    String Nombre_Archivo_Referencias;

    
    //Constructor de la Clase
    public DTO(String Politica_Recuperacion, String Politica_Ubicacion, String Politica_Reemplazo, String Politica_Limpieza, String Tamaño_Conjunto, String Ambito_Reemplazo, String Control_Limpieza,int Paginas_Por_Proceso, int Tamaño_Memoria, int Tamaño_Paginas) {
        this.Politica_Recuperacion = Politica_Recuperacion;
        this.Politica_Ubicacion = Politica_Ubicacion;
        this.Politica_Reemplazo = Politica_Reemplazo;
        this.Politica_Limpieza = Politica_Limpieza;
        this.Tamaño_Conjunto = Tamaño_Conjunto;
        this.Ambito_Reemplazo = Ambito_Reemplazo;
        this.Control_Limpieza = Control_Limpieza;
        this.Tamaño_Memoria = Tamaño_Memoria;
        this.Tamaño_Paginas = Tamaño_Paginas;
        this.Paginas_En_MM_Por_Proceso=Paginas_Por_Proceso;
    }
    
       public int TamañoPagina(){
        return Tamaño_Paginas;
    }
    
    
    
}