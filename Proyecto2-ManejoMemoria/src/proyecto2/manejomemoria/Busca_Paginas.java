
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
    ////////////////////////////////////////////////////////////////////////////////////////
    //Busca la pagina referenciada en la lista general
    public int Busca_Pagina_En_Lista_Memoria_Principal(){
        //Buusca en toda la lista
        for (int i = 0; i < Estructura_DTO.Lista_Paginas_En_Memoria_Principal.size(); i++) {
            //Si el ID de la pagina referenciada esta en la lista retorna el indice en el que se encuentra
            if (Estructura_DTO.Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina==Pagina_a_Buscar.ID_Pagina){
                return i;
            }
        }
        //SINO encuentra la pagina retorna -1
        return -1;
    } 
    public Paginas Busca_Pagina_En_Memoria_Virtual(int ID_Proceso_Pagina, int ID_Pagina_Referenciada){
        Iterator<String> keySetIterator = Estructura_DTO.Memoria_Virtual.keySet().iterator();
        //Ciclo de busqueda en los marcos
        while(keySetIterator.hasNext()){
            //Agarra la llave actual
            String key = keySetIterator.next();
            //Parte la clave en ID_PROCESO ID_PAGINA
            String[] Clave_Memoria_Virtual = key.split("_");
            int ID_Proceso = Integer.parseInt(Clave_Memoria_Virtual[0]); 
            int ID_Pagina = Integer.parseInt(Clave_Memoria_Virtual[1]);
            
            //Pregunta si ID de proceso y Pagina coinciden
            if (ID_Pagina==ID_Pagina_Referenciada && ID_Proceso==ID_Proceso_Pagina){
                Pagina_Retornada= Estructura_DTO.Memoria_Virtual.get(key);
            }
            Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(key);
            
          }
       
        return Pagina_Retornada;
    
    }
       ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para buscar la pagina en los marcos
   /* public int Busca_Pagina_En_Memoria_Principal (LinkedList Lista_Paginas_En_Memoria_Principal,HashMap Mapa_Marcos,Paginas Pagina){
        LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal1= Lista_Paginas_En_Memoria_Principal;
        HashMap<Integer, Marco> Mapa_Marcos1=Mapa_Marcos;
        System.out.println("\nESTAMOS EN BUSCA MM **********");
        //Agarra la llave del marco para iterar sobre el Hashmap
        Iterator<Integer> keySetIterator = Mapa_Marcos.keySet().iterator();
        //Ciclo de busqueda en los marcos
        while(keySetIterator.hasNext()){
            //Agarra la llave actual
            Integer key = keySetIterator.next();
            Marco marco=Mapa_Marcos1.get(key);
            System.out.println("Clave: " + key + " -> Valor: "+Mapa_Marcos1.get(key).ID_Marco +"Pagina: "+ Mapa_Marcos1.get(key).Pagina.ID_Pagina);
            //Pregunta si la pagina esta en Memoria principal
            if ((Pagina.ID_Pagina==marco.Pagina.ID_Pagina)&&(Lista_Paginas_En_Memoria_Principal1.contains(Pagina))){
                return marco.ID_Marco;
            }
            
          }
         return -1;   
    }*/
    
}
