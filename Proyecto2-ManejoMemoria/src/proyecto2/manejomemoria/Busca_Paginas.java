
package proyecto2.manejomemoria;
import java.util.*;
//Clase para buscar paginas en Memoria principal O Lista de Memorias
public class Busca_Paginas {
    DTO Estructura_DTO;
    Paginas Pagina_a_Buscar;
    Paginas Pagina_Retornada=null;
/////////////////////////////////////////////////////////////////////////////   
    public Busca_Paginas(DTO Estructura) {
        Estructura_DTO=Estructura;
        
    }
/////////////////////////////////////////////////////////////////////////////    
    public Paginas Busca_Pagina_En_Memoria_Virtual(int ID_Proceso_Pagina, int ID_Pagina_Referenciada){
        
        LinkedList<Paginas> Memoria_Virtual=Estructura_DTO.Memoria_Virtual;
        
        for (int i = 0; i < Memoria_Virtual.size(); i++) { //Ciclo de busqueda en los marcos
           //Pregunta si ID de proceso y Pagina coinciden
            if (Memoria_Virtual.get(i).ID_Pagina==ID_Pagina_Referenciada && Memoria_Virtual.get(i).ID_Proceso==ID_Proceso_Pagina){
                return Pagina_Retornada= Memoria_Virtual.get(i);
            }
                     
        }
        return Pagina_Retornada;
    
    }
///////////////////////////////////////////////////////////////////////////// 
    public int Busca_Pagina_En_Memoria_Fisica(Paginas Pagina_Referenciada){
        LinkedList<Marco> Memoria_Fisica=Estructura_DTO.Memoria_Fisica;
        //Ciclo de busqueda en los marcos
        for (int i = 0; i < Memoria_Fisica.size(); i++) {
           //Pregunta si ID de proceso y Pagina coinciden
            if (Memoria_Fisica.get(i).Pagina.ID_Pagina==Pagina_Referenciada.ID_Pagina && Memoria_Fisica.get(i).Pagina.ID_Proceso==Pagina_Referenciada.ID_Proceso){
                return Memoria_Fisica.get(i).ID_Marco;
            }
                     
        }
        return -1;
    
    }
////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para buscar la pagina en los marcos
      public Paginas Busca_Pagina_En_Memoria_Principal (Paginas Pagina_Referenciada){
         LinkedList<Paginas> Lista_Memoria_Principal=Estructura_DTO.Lista_Paginas_En_Memoria_Principal;
        //Ciclo de busqueda en los marcos
        for (int i = 0; i < Lista_Memoria_Principal.size(); i++) {
           //Pregunta si ID de proceso y Pagina coinciden
            if (Lista_Memoria_Principal.get(i).ID_Pagina==Pagina_Referenciada.ID_Pagina && Lista_Memoria_Principal.get(i).ID_Proceso==Pagina_Referenciada.ID_Proceso){
                return Pagina_Retornada= Lista_Memoria_Principal.get(i);
            }         
        }
        return Pagina_Retornada;
    
    }
    //Funcion para buscar la pagina en los marcos
      public int Retorna_Indice_Pagina_MM (Paginas Pagina_Referenciada){
         LinkedList<Paginas> Lista_Memoria_Principal=Estructura_DTO.Lista_Paginas_En_Memoria_Principal;
        //Ciclo de busqueda en los marcos
        for (int i = 0; i < Lista_Memoria_Principal.size(); i++) {
           //Pregunta si ID de proceso y Pagina coinciden
            if (Lista_Memoria_Principal.get(i).ID_Pagina==Pagina_Referenciada.ID_Pagina && Lista_Memoria_Principal.get(i).ID_Proceso==Pagina_Referenciada.ID_Proceso){
                return i;
            }         
        }
        return -1;
    
    }
}