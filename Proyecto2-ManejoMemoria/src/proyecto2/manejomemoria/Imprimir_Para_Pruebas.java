
package proyecto2.manejomemoria;

import java.util.Iterator;
import java.util.*;
public class Imprimir_Para_Pruebas {
    DTO Estrutura_DTO;
    public Imprimir_Para_Pruebas(DTO Estructura) {
        Estrutura_DTO=Estructura;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para imprimir los marcos
    public void imprime_lista_marcos(HashMap Mapa_Marco){
     HashMap<String, Marco> Mapa_Marcos=Mapa_Marco;
        
     Iterator<String> keySetIterator = Mapa_Marcos.keySet().iterator();
     System.out.println("\nIMPRIME MARCO**********");

     while(keySetIterator.hasNext()){
            //Agarra la llave actual
            String key = keySetIterator.next();
            System.out.println("Clave: " + key + " -> Valor: "+Mapa_Marcos.get(key).ID_Marco +"Pagina: "+ Mapa_Marcos.get(key).Pagina);

     }
}
    ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para PRUEBA IMPRESION
    public void imprime_lista_paginas(){
       
        System.out.println("\nIMPRIME PAGINAS**********");
        for (int i = 0; i < Estrutura_DTO.Lista_Paginas_En_Memoria_Principal.size(); i++) {
            System.out.println("PG  "+ Estrutura_DTO.Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina);
        }
        System.out.println("*************************************************");

    }
}
