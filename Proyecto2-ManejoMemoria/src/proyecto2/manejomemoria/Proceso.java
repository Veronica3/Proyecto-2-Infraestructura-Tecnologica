
package proyecto2.manejomemoria;
import java.util.*;
//Clase proceso que permite 
public class Proceso implements Interface_Proceso{
    
    int ID_Proceso;
    String Nombre_Proceso;
    int Prioridad;
    int Cantidad_de_memoria;
    int Cantidad_Paginas=0;
    
    public Proceso(int idP, String NombreP, int PrioridadP,int MemoriaTP) { //Constructor del proceso
        ID_Proceso= idP;
        Nombre_Proceso= NombreP;
        Prioridad= PrioridadP;
        Cantidad_de_memoria= MemoriaTP;    
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
    
    public int Cantidad_Paginas(){
        return Cantidad_Paginas;
    }
   
    
}
