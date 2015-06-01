
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
        for (int i = 0; i < Estrutura_DTO.Memoria_Virtual.size(); i++) {
            System.out.println("Pagina " + Estrutura_DTO.Memoria_Virtual.get(i).ID_Proceso);
        }
    }
     ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para imprimir los marcos
    public void imprime_bitacora(){
        for (int i = 0; i < Estrutura_DTO.Bitacora.size(); i++) {
            System.out.println("***BITACORA**** \n");
            for (int j = 0; j < Estrutura_DTO.Bitacora.get(i).size(); j++) {
                 System.out.println(Estrutura_DTO.Bitacora.get(i).get(j));
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //Funcion para PRUEBA IMPRESION
    public void imprime_lista_paginas(){
        LinkedList<Paginas> Lista_Paginas_Referenciadas=Estrutura_DTO.Lista_Paginas_En_Memoria_Principal;
        System.out.println("\nIMPRIME PAGINAS**********");
        for (int i = 0; i < Lista_Paginas_Referenciadas.size(); i++) {
            System.out.println("PG  "+ Lista_Paginas_Referenciadas.get(i).ID_Pagina+ " Proceso> "+ Lista_Paginas_Referenciadas.get(i).ID_Proceso);
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
