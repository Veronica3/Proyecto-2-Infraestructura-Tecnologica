
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
    public void imprime_lista_memoria_virtual(){
        System.out.println("Obtiene valor del primero> "+  Estrutura_DTO.Memoria_Virtual.size());
        Iterator<String> keySetIterator = Estrutura_DTO.Memoria_Virtual.keySet().iterator();
        System.out.println("\nIMPRIME Memoria virtual**********");

        while(keySetIterator.hasNext()){
               //Agarra la llave actual
               String key = keySetIterator.next();
               System.out.println("Clave: " + key + " -> Valor: "+Estrutura_DTO.Memoria_Virtual.get(key).ID_Proceso+" Pagina: "+ Estrutura_DTO.Memoria_Virtual.get(key).ID_Pagina);

     }
}
    ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para PRUEBA IMPRESION
    public void imprime_lista_paginas(){
       
        System.out.println("\nIMPRIME PAGINAS**********");
        for (int i = 0; i < Estrutura_DTO.Paginas_Referenciadas.size(); i++) {
            System.out.println("PG  "+ Estrutura_DTO.Paginas_Referenciadas.get(i).ID_Pagina+ " Proceso> "+ Estrutura_DTO.Paginas_Referenciadas.get(i).ID_Proceso);
        }
        System.out.println("*************************************************");

    }
    public void imprime_lista_procesos(){
        Iterator<Integer> keySetIterator = Estrutura_DTO.Lista_Procesos.keySet().iterator();
        System.out.println("\nIMPRIME Procesos**********");
        while(keySetIterator.hasNext()){
            //Agarra la llave actual
            Integer key = keySetIterator.next();
            System.out.println("Clave: " + key + " -> Valor: ID "+Estrutura_DTO.Lista_Procesos.get(key).ID_Proceso());

     }
    }
}
