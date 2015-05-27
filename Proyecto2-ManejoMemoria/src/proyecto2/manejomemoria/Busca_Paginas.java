
package proyecto2.manejomemoria;
import java.util.*;
//Clase para buscar paginas en Memoria principal O Lista de Memorias
public class Busca_Paginas {
    DTO Estructura_DTO;
    Paginas Pagina_a_Buscar;
    Paginas Pagina_Retornada=null;
    public Busca_Paginas(DTO Estructura) {
        Estructura_DTO=Estructura;
        
    }
    
    public Paginas Busca_Pagina_En_Memoria_Virtual(int ID_Proceso_Pagina, int ID_Pagina_Referenciada){
        LinkedList<Paginas> Memoria_Virtual=Estructura_DTO.Memoria_Virtual;
        //Ciclo de busqueda en los marcos
        for (int i = 0; i < Memoria_Virtual.size(); i++) {
           //Pregunta si ID de proceso y Pagina coinciden
            if (Memoria_Virtual.get(i).ID_Pagina==ID_Pagina_Referenciada && Memoria_Virtual.get(i).ID_Proceso==ID_Proceso_Pagina){
                Pagina_Retornada= Memoria_Virtual.get(i);
            }
            //Paginas Pagina=Memoria_Virtual.get(i);
                     
        }
        return Pagina_Retornada;
    
    }
       ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para buscar la pagina en los marcos
      public Paginas Busca_Pagina_En_Memoria_Principal (Paginas Pagina_Referenciada){
         LinkedList<Paginas> Memoria_Virtual=Estructura_DTO.Memoria_Virtual;
        //Ciclo de busqueda en los marcos
        for (int i = 0; i < Memoria_Virtual.size(); i++) {
           //Pregunta si ID de proceso y Pagina coinciden
            if (Memoria_Virtual.get(i).ID_Pagina==Pagina_Referenciada.ID_Pagina && Memoria_Virtual.get(i).ID_Proceso==Pagina_Referenciada.ID_Proceso){
                Pagina_Retornada= Memoria_Virtual.get(i);
            }         
        }
        return Pagina_Retornada;
    
    }
    
}