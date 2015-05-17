
package proyecto2.manejomemoria;

import java.util.Iterator;
import java.util.*;
public class Imprimir_Para_Pruebas {
    
    public Imprimir_Para_Pruebas() {
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para imprimir los marcos
    public void imprime_lista_marcos(HashMap Mapa_Marco){
     HashMap<Integer, Marco> Mapa_Marcos=Mapa_Marco;
        
     Iterator<Integer> keySetIterator = Mapa_Marcos.keySet().iterator();
     System.out.println("\nIMPRIME MARCO**********");

     while(keySetIterator.hasNext()){
            //Agarra la llave actual
            Integer key = keySetIterator.next();
            System.out.println("Clave: " + key + " -> Valor: "+Mapa_Marcos.get(key).ID_Marco +"Pagina: "+ Mapa_Marcos.get(key).Pagina);

     }
}
    ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para PRUEBA IMPRESION
    public void imprime_lista_paginas(LinkedList Lista_Paginas_En_Memoria ){
        LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal= Lista_Paginas_En_Memoria;
        System.out.println("\nIMPRIME PAGINAS**********");
        for (int i = 0; i < Lista_Paginas_En_Memoria_Principal.size(); i++) {
            System.out.println("PG  "+ Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina);
        }
        System.out.println("*************************************************");

    }
}
