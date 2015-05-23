
package proyecto2.manejomemoria;
import java.util.*;
import java.math.*;
public class DTO {
    
    //Listas para reemplazos y ubicacion
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal= new LinkedList<>();
    LinkedList<Paginas> Paginas_Referenciadas= new LinkedList<>();
    //Memoria FISICA Y VIRTUAL
    HashMap<Integer,LinkedHashMap<Integer, Marco>> Memoria_Fisica = new HashMap<Integer,LinkedHashMap<Integer, Marco> >();
    LinkedHashMap<String, Paginas> Memoria_Virtual=new LinkedHashMap<String, Paginas>();
    //Lista de PROCESOS y REFERENCIAS
    LinkedHashMap<Integer,Interface_Proceso> Lista_Procesos= new LinkedHashMap();
    LinkedList <Interface_Referencia> Lista_Referencias = new LinkedList();
    
    //Variables del Sistema
    String Politica_Recuperacion;
    String Politica_Ubicacion;
    String Politica_Reemplazo;
    String Politica_Limpieza;
    int Tiempo_de_Limpieza; 
    String Tamaño_Conjunto;
    int Minimo_Marcos;
    int Maximo_Marcos;
    int Tamano_aumento;
    String Ambito_Reemplazo;
    int Grado_Multiprogramacion; 
    int Working_Set;
    int Tamaño_Memoria_Fisica;
    int Bits;
    int Tamaño_Paginas; //almacena el tamaño en Bytes de la pagina
    String Unidad_Medida;
    int Cantidad_Total_Paginas_Memoria_Virtual; //almacena el total de paginas que se crean
    int Total_Tamaño_Pagina_Memoria_Virtual;
    
    //Variables para abrir archivos
    String Nombre_Archivo_Procesos;
    String Nombre_Archivo_Referencias;

    
    //Constructor de la Clase
     
    
    public DTO(String Politica_Recuperacion, String Politica_Ubicacion, String Politica_Reemplazo, String Politica_Limpieza, int Tiempo_de_Limpieza, String Tamaño_Conjunto, int Minimo_Marcos, int Maximo_Marcos, int Tamano_aumento, String Ambito_Reemplazo, int Grado_Multiprogramacion, int Working_Set, int Tamaño_Memoria_Fisica, int Bits, int Tamaño_Paginas, String Unidad_Medida){
        
        this.Politica_Recuperacion = Politica_Recuperacion;
        this.Politica_Ubicacion = Politica_Ubicacion;
        this.Politica_Reemplazo = Politica_Reemplazo;
        this.Politica_Limpieza = Politica_Limpieza;
        this.Tiempo_de_Limpieza = Tiempo_de_Limpieza;
        this.Tamaño_Conjunto = Tamaño_Conjunto;
        this.Minimo_Marcos = Minimo_Marcos;
        this.Maximo_Marcos = Maximo_Marcos;
        this.Tamano_aumento = Tamano_aumento;
        this.Ambito_Reemplazo = Ambito_Reemplazo;
        this.Grado_Multiprogramacion = Grado_Multiprogramacion;
        this.Working_Set = Working_Set;
        this.Tamaño_Memoria_Fisica = Tamaño_Memoria_Fisica;
        this.Bits = Bits;
        this.Tamaño_Paginas = Tamaño_Paginas;
        this.Unidad_Medida = Unidad_Medida;
   
    }

    public double TamañoPagina() {
        return Tamaño_Paginas;
    }
    
    //Permite agregar el nombre de los archivos al DTO
    public void Agregar_Archivos(String ArchivoProcesos, String ArchivoReferencias){
        Nombre_Archivo_Procesos= ArchivoProcesos;
        Nombre_Archivo_Referencias= ArchivoReferencias;
    }

    
    
}