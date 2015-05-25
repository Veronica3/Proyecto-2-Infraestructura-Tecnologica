
package proyecto2.manejomemoria;
import java.util.*;
//Politica de recuparacion... Para traer paginas de MEMORIA VIRTUAL a MEMORIA PRINCIPAL
public class Politica_Recuperacion {
    DTO Estructura_DTO;
    Busca_Paginas Buscar_Pagina;
    //Constructor de la clase
    public Politica_Recuperacion(DTO Estructura) {
        Estructura_DTO= Estructura;
        Buscar_Pagina= new Busca_Paginas(Estructura_DTO);
    }
    //Verifica si una pagina esta en memoria principal
    public boolean Esta_En_Memoria_Principal(Paginas Pagina_Referenciada){
       
        if (Estructura_DTO.Lista_Paginas_En_Memoria_Principal.contains(Pagina_Referenciada)){
            return true;
        }
        return false;
    }
    //Trae a memoria la pagina referenciada
    public void Paginacion_Bajo_Demanda( Paginas Pagina_Referenciada){
        
        if (Esta_En_Memoria_Principal(Pagina_Referenciada)){
            int ID_Proceso_Pagina= Pagina_Referenciada.ID_Proceso;
            int ID_Pagina_Referenciada= Pagina_Referenciada.ID_Pagina;
            Paginas Pagina_Buscada_En_Memoria_Virtual= Buscar_Pagina.Busca_Pagina_En_Memoria_Virtual(ID_Proceso_Pagina, ID_Pagina_Referenciada);
            //Fallo de pagina y busca si esta en memoria virtual
            if (Pagina_Buscada_En_Memoria_Virtual!=null){
                //LLAMA A POLITICA DE UBICACION Y LE ENVIA LA PAGINA
            }
            
        }
    }
    //Trae a memoria un conjunto de paginas
    public void Prepaginacion(){
        
        int Cantidad_de_Procesos= Estructura_DTO.Lista_Procesos.size();
        //ID's
        int ID_Proceso_Buscado=2;
       // int ID_Pagina_Buscado=1;
        //Contadores 
       // int Contador_ID_Proceso=0;
        
        //Key
        Iterator<String> keySetIterator = Estructura_DTO.Memoria_Virtual.keySet().iterator();
        int Contador_ID_Pagina=0;
        //Ciclo de busqueda en los marcos
        while(keySetIterator.hasNext()){
            
            //Agarra la llave actual
            String key = keySetIterator.next();
            //Parte la clave en ID_PROCESO ID_PAGINA
            String[] Clave_Memoria_Virtual = key.split("_");
            int ID_Proceso_Pagina = Integer.parseInt(Clave_Memoria_Virtual[0]); 
            int ID_Pagina_Referenciada = Integer.parseInt(Clave_Memoria_Virtual[1]);
            //System.out.println("ID proceso pagina mapa "+ID_Proceso_Pagina+" ID proceso buscado "+ ID_Proceso_Buscado);
            System.out.println("FUERA if: Id pro pag "+ID_Proceso_Pagina+" ID proce buscad "+ID_Proceso_Buscado);  
            //Pregunta si la pagina actual es del proceso Referenciado
            if (ID_Proceso_Pagina==ID_Proceso_Buscado){
                if (Contador_ID_Pagina<3/*working set*/){
                   Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(key);
                   Estructura_DTO.Paginas_Referenciadas.add(Pagina);
                   Contador_ID_Pagina+=1;
                }
                                               
            }
           
            else{
               Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(key);
               Estructura_DTO.Paginas_Referenciadas.add(Pagina);
               ID_Proceso_Buscado+=1;
               Contador_ID_Pagina=1;
            }
          }
        Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas(Estructura_DTO);
        Imprime.imprime_lista_paginas();
        
        //DE ACUERDO AL WORKING SET
        
    }
}

