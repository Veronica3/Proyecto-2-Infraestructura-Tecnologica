
package proyecto2.manejomemoria;
import java.util.*;

public class Politica_Reemplazo {
    //Politica de reemplazo FIFO, elimina la primer pagina de la lista y agrega la nueva de ultimo.
    public void Politica_FIFO (LinkedList Lista_Paginas_MM, Paginas Nueva_Pagina) {
        Lista_Paginas_MM.removeFirst();
        Lista_Paginas_MM.addLast(Nueva_Pagina);
        
        //Llamo a funcion que asigna la nueva pagina al marco disponible
        Asignacion_a_Marco(Nueva_Pagina);
}
   
    
    public void Politica_Menos_Utilizado_Recientemente (LinkedList Lista_Paginas_MM){
        
    }
    
    public void Politica_Reloj(){
    
    }
    
    //Funcion para la asignacion de marcos
     public void Asignacion_a_Marco(Paginas Nueva_Pagina_a_Asignar){
        
        
    }
}
