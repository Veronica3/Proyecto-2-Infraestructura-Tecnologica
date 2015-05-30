
package proyecto2.manejomemoria;
import java.util.*;
//Clase proceso que permite 
public class Proceso implements Interface_Proceso{
    
    int ID_Proceso;
    String Nombre_Proceso;
    int Prioridad;
    boolean Bloqueado;  // Pagina 362 > Si el marco esta bloquado no se puede reemplazar la pag
    int Cantidad_de_memoria;
    int Working_Set;
    int Cantidad_Paginas=0;

    public Proceso(int ID_Proceso, String Nombre_Proceso, int Prioridad, boolean Bloqueado, int Cantidad_de_memoria, int Working_Set) {
        this.ID_Proceso = ID_Proceso;
        this.Nombre_Proceso = Nombre_Proceso;
        this.Prioridad = Prioridad;
        this.Bloqueado = Bloqueado;
        this.Cantidad_de_memoria = Cantidad_de_memoria;
        this.Working_Set = Working_Set;
    }

    public void Asignar_Paginas(int Cantidad_PaginasP){
        Cantidad_Paginas= Cantidad_PaginasP;
    }
    
    public int ID_Proceso(){
        return ID_Proceso;
    }
        
    public String Nombre_Proceso(){
        return Nombre_Proceso;
    }
    
    public int Tamaño_Total_Proceso(){
        return Cantidad_de_memoria;
    }
    
    public int Prioridad_Proceso(){
        return Prioridad;
    }
    
    public boolean Es_Bloqueado_Proceso(){
        return Bloqueado;
    }
    
    public int Cantidad_Paginas(){
        return Cantidad_Paginas;
    }
    public int Working_Set(){
        return Working_Set;
    }
    
    
   
    
}
