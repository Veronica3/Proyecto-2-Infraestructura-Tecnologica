
package proyecto2.manejomemoria;
import java.util.*;

public class Politica_Reemplazo {
    Politica_Ubicacion Ubicacion_Pagina;
    
    
    //Politica de reemplazo FIFO, elimina la primer pagina de la lista y agrega la nueva de ultimo.
    public void Politica_FIFO (LinkedList Lista_Paginas_MM, Paginas Nueva_Pagina) {
        Lista_Paginas_MM.removeFirst();
        Lista_Paginas_MM.addLast(Nueva_Pagina);
        
        //Llamo a funcion que asigna la nueva pagina al marco disponible
        Ubicacion_Pagina.Asignacion_a_Marco(Nueva_Pagina);
}
   
    //Se implementa con lista igual que FIFO
    public void Politica_Menos_Utilizado_Recientemente (LinkedList Lista_Paginas_MM, Paginas Pagina_Referenciada){
    
    }
    
    public void Politica_Reloj(){
    
    }
    
    public void Pagina_Referenciada(LinkedList Lista_Paginas_MM, Map Mapa_Marcos, Paginas Pagina_Referenciada){
        if (Busca_Pagina_En_Memoria_Principal(Mapa_Marcos)){
            
        }
        //Lista_Paginas_MM.
    }
    
    public boolean Busca_Pagina_En_Memoria_Principal (Map Mapa_Marcos){
    return true;    
    }
    
    
}
