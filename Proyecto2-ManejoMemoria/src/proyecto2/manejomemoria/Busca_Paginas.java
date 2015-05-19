
package proyecto2.manejomemoria;
import java.util.*;
//Clase para buscar paginas en Memoria principal O Lista de Memorias
public class Busca_Paginas {
    
    public Busca_Paginas() {
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //Busca la pagina referenciada en la lista general
    public int Busca_Pagina_En_Lista(LinkedList Lista_Paginas_En_Memoria_Principal, Paginas Pagina_Referenciada){
        LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal1= Lista_Paginas_En_Memoria_Principal;
        //Buusca en toda la lista
        for (int i = 0; i < Lista_Paginas_En_Memoria_Principal.size(); i++) {
            //Si el ID de la pagina referenciada esta en la lista retorna el indice en el que se encuentra
            if (Lista_Paginas_En_Memoria_Principal1.get(i).ID_Pagina==Pagina_Referenciada.ID_Pagina){
                return i;
            }
        }
        //SINO encuentra la pagina retorna -1
        return -1;
    } 
       ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para buscar la pagina en los marcos
    public int Busca_Pagina_En_Memoria_Principal (LinkedList Lista_Paginas_En_Memoria_Principal,HashMap Mapa_Marcos,Paginas Pagina){
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
    }
    
}
