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
    public String Paginacion_Bajo_Demanda( Paginas Pagina_Referenciada){
        
        if (Esta_En_Memoria_Principal(Pagina_Referenciada)){
            Estructura_DTO.Bitacora.getLast().add("\nPagina referenciada ya se encuentra en memoria principal\n");
            return "La pagina ya se encuentra en memoria principal";
        }
        else {
            
            int ID_Proceso_Pagina= Pagina_Referenciada.ID_Proceso;
            int ID_Pagina_Referenciada= Pagina_Referenciada.ID_Pagina;
            Estructura_DTO.Bitacora.getLast().add("\n\t\t***Fallo de Página***\n"+"La pagina "+ID_Pagina_Referenciada+" del proceso "+ID_Proceso_Pagina+
                        " no se encuentra en memoria principal");
            Paginas Pagina_Buscada_En_Memoria_Virtual= Buscar_Pagina.Busca_Pagina_En_Memoria_Virtual(ID_Proceso_Pagina, ID_Pagina_Referenciada);
            //Fallo de pagina y busca si esta en memoria virtual
            return "";//LLAMA A POLITICA DE UBICACION Y LE ENVIA LA PAGINA
            
        }
          
    }
    //Trae a memoria un conjunto de paginas
    public void Prepaginacion(){
         LinkedList<Paginas> Memoria_Virtual=Estructura_DTO.Memoria_Virtual;
        int Cantidad_de_Procesos= Estructura_DTO.Lista_Procesos.size();
        //ID's
        int ID_Proceso_Buscado=2;
        int Contador_ID_Pagina=0;
        //Ciclo de busqueda en los marcos
        for (int i = 0; i < Memoria_Virtual.size(); i++) {
            //System.out.println("for");
            //Pregunta si la pagina actual es del proceso Referenciado
            if (Memoria_Virtual.get(i).ID_Proceso==ID_Proceso_Buscado){
                //Entra si todavia no se ha completado el numero de paginas
                if (Contador_ID_Pagina<3/*working set*/){
                   Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(i);
                   Estructura_DTO.Paginas_Referenciadas.add(Pagina);
                   Contador_ID_Pagina+=1;
                }
                                               
            }
           
            else{
               Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(i);
               Estructura_DTO.Paginas_Referenciadas.add(Pagina);
               ID_Proceso_Buscado+=1;
               Contador_ID_Pagina=1;
            }
          }
        //LLAMO A FUNCION DE UBICACION-
        Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas(Estructura_DTO);
        Imprime.imprime_lista_paginas();
        
        //DE ACUERDO AL WORKING SET
        
    }
}

