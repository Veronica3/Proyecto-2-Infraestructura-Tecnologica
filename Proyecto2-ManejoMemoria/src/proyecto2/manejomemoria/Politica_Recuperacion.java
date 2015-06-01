package proyecto2.manejomemoria;
import java.text.SimpleDateFormat;
import java.util.*;

//Politica de recuparacion... Para traer paginas de MEMORIA VIRTUAL a MEMORIA PRINCIPAL
public class Politica_Recuperacion {
    DTO Estructura_DTO;
    Busca_Paginas Buscar_Pagina;
    Añadir_a_Bitacora Bitacora;
    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
    Calendar calendario1;
    Politica_Reemplazo Referencia_A_Pagina;
    
////////////////////////////////////////////////////////////////////////////    
    //Constructor de la clase
    public Politica_Recuperacion(DTO Estructura) {
        Estructura_DTO= Estructura;
        Buscar_Pagina= new Busca_Paginas(Estructura_DTO);
        Bitacora= new Añadir_a_Bitacora(Estructura_DTO);
        Referencia_A_Pagina= new Politica_Reemplazo(Estructura_DTO);
    }
////////////////////////////////////////////////////////////////////////////        
    //Trae a memoria la pagina referenciada
    public String Paginacion_Bajo_Demanda( Paginas Pagina_Referenciada){
        
        if (Buscar_Pagina.Busca_Pagina_En_Memoria_Fisica(Pagina_Referenciada)!=-1){
            if (Estructura_DTO.Politica_Reemplazo.equals("Reloj")){
              Lista_Circular Lista_Reloj= Estructura_DTO.Lista_Reloj;
              Lista_Reloj.Cambiar_Bit_Modificado(Pagina_Referenciada);
            }
            else{    
                if (Estructura_DTO.Politica_Reemplazo.equals("LRU")||Estructura_DTO.Politica_Reemplazo.equals("LRU")){
                    Referencia_A_Pagina.Cambio_En_Lista_Pagina_Referenciada(Pagina_Referenciada);
                }
                String Sentencia=("\nLa página referenciada ya se encuentra en memoria principal\n"); //Se guarda la accion en bitacora
                Bitacora.Añadir_Accion_A_Bitacora(Sentencia); //Agrega accion a bitacora
                return "La pagina ya se encuentra en memoria principal";
            }
        }
        else {
            
            int ID_Proceso_Pagina= Pagina_Referenciada.ID_Proceso;
            int ID_Pagina_Referenciada= Pagina_Referenciada.ID_Pagina;
            calendario1 = Calendar.getInstance();
            String Sentencia=("\nTiempo: "+formato.format(calendario1.getTime())+"\n***Fallo de Página***\n"+"La pagina "+ID_Pagina_Referenciada+" del proceso "
                    +ID_Proceso_Pagina+" no se encuentra en memoria principal");
            Bitacora.Añadir_Accion_A_Bitacora(Sentencia);//Agrego accion a bitacora
            Paginas Pagina_Buscada_En_Memoria_Virtual= Buscar_Pagina.Busca_Pagina_En_Memoria_Virtual(ID_Proceso_Pagina, ID_Pagina_Referenciada);
            //Fallo de pagina y busca si esta en memoria virtual
            return "";//LLAMA A POLITICA DE UBICACION Y LE ENVIA LA PAGINA
            
        }
         return ""; 
    }
    
////////////////////////////////////////////////////////////////////////////    
    //Trae a memoria un conjunto de paginas
    public void Prepaginacion(){
        Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas(Estructura_DTO);
        Imprime.imprime_lista_procesos();
        
        calendario1 = Calendar.getInstance(); //Lista de Bitacora que sera guardada en la lista general
        String Sentencia=("\nTiempo: "+formato.format(calendario1.getTime())+"\n\t\t***Iniciando Prepaginación***\n");
        Bitacora.Añadir_Accion_A_Bitacora(Sentencia);//Agrego accion a bitacora
       
        LinkedList<Paginas> Memoria_Virtual=Estructura_DTO.Memoria_Virtual;
        int Cantidad_de_Procesos= Estructura_DTO.Lista_Procesos.size();
        int ID_Proceso_Buscado=2;  //ID proceso
        int Contador_ID_Pagina=0;  //Conatdor para igualar al working set
        //Ciclo de busqueda en los marcos
        System.out.println("Tama;m memoria "+ Memoria_Virtual.size());
       
        for (int i = 0; i < Memoria_Virtual.size(); i++) {
            Imprime.imprime_lista_paginas();
            
            if(Memoria_Virtual.get(i).ID_Proceso==0){ //Cuando el ID del proceso es 0 se termina ya que sino sigue revisando TODA la memoria virtual
                break;
            }
            else if (Memoria_Virtual.get(i).ID_Proceso==ID_Proceso_Buscado){
                
                if (Contador_ID_Pagina<3/*working set*/){ //Entra si todavia no se ha completado el numero de paginas
                   Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(i);
                   //LLAMO A UBICACION ****Estructura_DTO.Paginas_Referenciadas.add(Pagina);
                   Contador_ID_Pagina+=1;
                }
                                               
            }
           
            else{
               Paginas Pagina=Estructura_DTO.Memoria_Virtual.get(i);
               //LLAMO A UBICACION   ***Estructura_DTO.Paginas_Referenciadas.add(Pagina);
               ID_Proceso_Buscado+=1;
               Contador_ID_Pagina=1;
            }
          }
        //LLAMO A FUNCION DE UBICACION-
        Imprimir_Para_Pruebas pImprime= new Imprimir_Para_Pruebas(Estructura_DTO);
        pImprime.imprime_lista_paginas();
       /* Estructura_DTO.Bitacora.getLast().add("\nTiempo: "+date.getTime()+"\nSe cargaron a memoria principal "+Estructura_DTO.Working_Set+
                " páginas de cada proceso");*/
        //DE ACUERDO AL WORKING SET
        
    }
}

