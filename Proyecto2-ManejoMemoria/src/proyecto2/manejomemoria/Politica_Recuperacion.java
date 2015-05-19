
package proyecto2.manejomemoria;
import java.util.*;
//Politica de recuparacion... Para traer paginas de MEMORIA VIRTUAL a MEMORIA PRINCIPAL
public class Politica_Recuperacion {
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal;
    //Constructor de la clase
    public Politica_Recuperacion() {
    }
    //Verifica si una pagina esta en memoria principal
    public boolean Esta_En_Memoria_Principal(LinkedList Lista_Paginas_MM, Paginas Pagina_Referenciada){
        Lista_Paginas_En_Memoria_Principal= Lista_Paginas_MM;
        if (Lista_Paginas_En_Memoria_Principal.contains(Pagina_Referenciada)){
            return true;
        }
        return false;
    }
    //Trae a memoria la pagina referenciada
    public void Paginacion_Bajo_Demanda(LinkedList Lista_Paginas_En_MM, Paginas Pagina_Referenciada){
        Lista_Paginas_En_Memoria_Principal=Lista_Paginas_En_MM;
        if (Esta_En_Memoria_Principal(Lista_Paginas_En_MM, Pagina_Referenciada)){
            
        }
    }
    //Trae a memoria un conjunto de paginas
    public void Prepaginacion(){
    
    }
}
