
package proyecto2.manejomemoria;
import java.util.*;
import java.util.HashMap;

public class Politica_Reemplazo {
    
    Politica_Ubicacion Ubicacion_Pagina= new Politica_Ubicacion(); //Instancia para ubicar la nueva Pagina
    DTO Estructura_DTO; //Estructura
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal;
    //Busca Paginas para ALGORITMOS de LRU y MRU
    Busca_Paginas Buscar_Pagina;
    //Para PRUEBAS
    Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas(Estructura_DTO);
    //Lista para algoritmo RELOJ
    Lista_Circular Lista_Reloj= new Lista_Circular();
    
     //Pagina que no se ha asignado a un marco
     Paginas pg5= new Paginas(5, 3);

    public Politica_Reemplazo(DTO Estructura_DTO) {
        
        this.Estructura_DTO = Estructura_DTO;
        this.Lista_Paginas_En_Memoria_Principal= Estructura_DTO.Lista_Paginas_En_Memoria_Principal;
        
    }

     //Nuevos Marcos
     Marco m1= new Marco(1, Estructura_DTO.Memoria_Virtual.get(0),2);
     Marco m2= new Marco(2, Estructura_DTO.Memoria_Virtual.get(1),3);
     Marco m3= new Marco(3, Estructura_DTO.Memoria_Virtual.get(2),4);
     Marco m4= new Marco(4, Estructura_DTO.Memoria_Virtual.get(3),5);
     
    //Mapa de marcos
     
    ////////////////////////////////////////////////////////////////////////////////////////
     //FUNCION DE PRUEBA
   public void llena(){
         
         
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //Politica de reemplazo FIFO, elimina la primer pagina de la lista y agrega la nueva de ultimo.
    public void Politica_FIFO ( Paginas Nueva_Pagina) {
        //Remueve la primera pagina ya que es la que lleva mas tiempo en Memoria
        Paginas Pagina_Reemplazada=Lista_Paginas_En_Memoria_Principal.removeFirst();
        //Llama a funcion para que la remueva del marco asignado
        Remover_Pagina_Del_Marco(Pagina_Reemplazada);
        
        //Agrega la nueva pagina a la lista
        Lista_Paginas_En_Memoria_Principal.addLast(Nueva_Pagina);
        
        //Llamo a funcion que asigna la nueva pagina al marco disponible
        //Ubicacion_Pagina.Asignacion_a_Marco(Nueva_Pagina);
}
    ////////////////////////////////////////////////////////////////////////////////////////
    //Se implementa con lista igual que FIFO pero la lista cambia cada vez que se referencia una pagina
    public void Politica_Menos_Utilizado_Recientemente ( Paginas Pagina_Nueva){
        //Guardo la pagina que se va a eliminar
        Paginas Pagina_Reemplazada=Lista_Paginas_En_Memoria_Principal.getLast();
       
        //Quita la pagina del marco asignado
        Remover_Pagina_Del_Marco(Pagina_Reemplazada);
        
        //Cambio el BIT PRESENTE indicando que ya no va a estar en MEMORIA PRINCIPAL
    //Pagina_Reemplazada.Bit_Presente=false;
        //REMUEVO la pagina de la lista
        Lista_Paginas_En_Memoria_Principal.removeLast();
        
        //Ubico la nuevo pagina  FALTA-------
        //Ubicacion_Pagina.Asignacion_a_Marco(Pagina_Nueva);
        
        System.out.println("Pagina a remover ** " + Pagina_Reemplazada.ID_Pagina);
        
   }
    ////////////////////////////////////////////////////////////////////////////////////////
     
    //Se implementa con lista igual LRU pero elimina la pagina mas RECIENTEMENTE UTILIZADA
    public void Politica_Mas_Utilizado_Recientemente ( Paginas Pagina_Nueva){
        //Guardo la pagina que se va a eliminar
        Paginas Pagina_Reemplazada=Lista_Paginas_En_Memoria_Principal.getFirst();
       
        //Quita la pagina del marco asignado
        Remover_Pagina_Del_Marco(Pagina_Reemplazada);
        
        //Cambio el BIT PRESENTE indicando que ya no va a estar en MEMORIA PRINCIPAL
     //Pagina_Reemplazada.Bit_Presente=false;
        //REMUEVO la pagina de la lista
        Lista_Paginas_En_Memoria_Principal.removeFirst();
        
        //Ubico la nuevo pagina  FALTA-------
        //Ubicacion_Pagina.Asignacion_a_Marco(Pagina_Nueva);
        
        System.out.println("Pagina a remover ** " + Pagina_Reemplazada.ID_Pagina);
        
   }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Politica_Reloj(){
        //Implementando
        //UTILIZA FALLO DE PAGINA> CUANDO OCURRE LA MANECILLA APUNTA A ESA PAGINA
        
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Remover_Pagina_Del_Marco(Paginas Pagina_A_Remover){
        Buscar_Pagina= new Busca_Paginas(Estructura_DTO);
        
        //Obtengo ID del marco donde se encuentra la pagina a remover
        int ID_Marco= Buscar_Pagina.Busca_Pagina_En_Memoria_Fisica(Pagina_A_Remover);
        //Valida que el MARCO EXISTA
      /*  if (ID_Marco!=-1){
            //Creo un nuevo marco, que obtiene la pagina a remover
            Marco marco= Mapa_Marcos.get(ID_Marco);
            //remuevo la pagina del marco
            marco.Pagina=null;
        }
        else
            System.out.println("El marco no existe ");
        //System.out.println("Marco a remover pagina "+ marco.ID_Marco);
        
        Imprime.imprime_lista_marcos(Mapa_Marcos);
    }*/
    ////////////////////////////////////////////////////////////////////////////////////////
   /* public void Ubicar_Nueva_Pagina(){
        
    }
    */

    ////////////////////////////////////////////////////////////////////////////////////////
    /*Utilizada desde las referencias, cuando se realiza la conversion y dice cual pagina se ocupa
    Cambia la posicion de las paginas, en la lista de paginas general del sistema*/
   /* public void Pagina_Referenciada(Paginas Pagina_Referenciada){
        System.out.println("\nESTAMOS EN REFERENCIAS**********");
        //Busca si la pagina referenciada esta en memoria
        if (Buscar_Pagina.Busca_Pagina_En_Memoria_Principal(Lista_Paginas_En_Memoria_Principal, Mapa_Marcos,Pagina_Referenciada)!=-1){
            //PRUEBA
            Imprime.imprime_lista_paginas(Lista_Paginas_En_Memoria_Principal);
           
            //Agarra el indice de la pagina referenciada en la lista actual
           int indice_a_cambiar= Buscar_Pagina.Busca_Pagina_En_Lista(Lista_Paginas_En_Memoria_Principal,Pagina_Referenciada);
           //si el indice es DIFERENTE A -1 quiere decir que la pagina SI EXISTE en la lista de paginas
           if (indice_a_cambiar!=-1){
              //Remueve la pagina de la posicion actual 
              Lista_Paginas_En_Memoria_Principal.remove(indice_a_cambiar);
              //Ingresa la pagina a la primera posicion
              Lista_Paginas_En_Memoria_Principal.addFirst(Pagina_Referenciada);
              Imprime.imprime_lista_paginas(Lista_Paginas_En_Memoria_Principal);
           }
           else{
               System.out.println("La pagina no existe");
           }
        }
        else
            //APLICO REEMPLAZO
            System.out.println("FALLO DE PAGINA");
        //Lista_Paginas_En_Memoria_Principal.
    }*/
    }
}
