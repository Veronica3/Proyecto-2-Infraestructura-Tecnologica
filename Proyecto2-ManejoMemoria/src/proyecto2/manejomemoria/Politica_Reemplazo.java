
package proyecto2.manejomemoria;
import java.util.*;
import java.util.HashMap;

public class Politica_Reemplazo {
    //Instancia para ubicar la nueva Pagina
    Politica_Ubicacion Ubicacion_Pagina;
    //Lista de paginas en memoria principal
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal=new LinkedList<>();
    //Mapa de MARCOS
    HashMap<Integer, Marco> Mapa_Marcos = new HashMap<Integer, Marco>();
    //Busca Paginas para ALGORITMOS de LRU y MRU
    Busca_Paginas Buscar_Pagina= new Busca_Paginas();
    //Para PRUEBAS
    Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas();
    //Lista para algoritmo RELOJ
    Lista_Circular Lista_Reloj= new Lista_Circular();
    
   // PRUEBAS 
     //Nuevas paginas
     Paginas pg1= new Paginas(1, 1, 20,0,0);
     Paginas pg2= new Paginas(2, 1, 20,0,0);
     Paginas pg3= new Paginas(3, 2, 20,0,0);
     Paginas pg4= new Paginas(4, 3, 20,0,0);
     //Pagina que no se ha asignado a un marco
     Paginas pg5= new Paginas(5, 3, 20,0,0);
     
     //Nuevos Marcos
     Marco m1= new Marco(1, 20, 0, 19, pg1);
     Marco m2= new Marco(2, 20, 0, 19, pg2);
     Marco m3= new Marco(3, 20, 0, 19, pg3);
     Marco m4= new Marco(4, 20, 0, 19, pg4);
     //Mapa de marcos
     
    ////////////////////////////////////////////////////////////////////////////////////////
     //FUNCION DE PRUEBA
   public void llena(){
         
         //Llena la lista
         System.out.println(pg1.ID_Pagina);
         Lista_Paginas_En_Memoria_Principal.addFirst(pg1);
         Lista_Paginas_En_Memoria_Principal.addFirst(pg2);
         Lista_Paginas_En_Memoria_Principal.addFirst(pg3);
         Lista_Paginas_En_Memoria_Principal.addFirst(pg4);
        // Lista_Paginas_En_Memoria_Principal.addFirst(pg5);
         //Agrego marcos 
         Mapa_Marcos.put(1,m1);
         Mapa_Marcos.put(2,m2);
         Mapa_Marcos.put(3,m3);
         Mapa_Marcos.put(4,m4);
         //Cargo paginas a marcos bit de presente pasa a true
         pg1.Bit_Presente=true;
         pg2.Bit_Presente=true;
         pg3.Bit_Presente=true;
         pg4.Bit_Presente=true;
         
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
        Ubicacion_Pagina.Asignacion_a_Marco(Nueva_Pagina);
}
    ////////////////////////////////////////////////////////////////////////////////////////
    //Se implementa con lista igual que FIFO pero la lista cambia cada vez que se referencia una pagina
    public void Politica_Menos_Utilizado_Recientemente ( Paginas Pagina_Nueva){
        //Guardo la pagina que se va a eliminar
        Paginas Pagina_Reemplazada=Lista_Paginas_En_Memoria_Principal.getLast();
       
        //Quita la pagina del marco asignado
        Remover_Pagina_Del_Marco(Pagina_Reemplazada);
        
        //Cambio el BIT PRESENTE indicando que ya no va a estar en MEMORIA PRINCIPAL
        Pagina_Reemplazada.Bit_Presente=false;
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
        Pagina_Reemplazada.Bit_Presente=false;
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
        //Obtengo ID del marco donde se encuentra la pagina a remover
        int ID_Marco= Buscar_Pagina.Busca_Pagina_En_Memoria_Principal(Mapa_Marcos,Pagina_A_Remover);
        //Valida que el MARCO EXISTA
        if (ID_Marco!=-1){
            //Creo un nuevo marco, que obtiene la pagina a remover
            Marco marco= Mapa_Marcos.get(ID_Marco);
            //remuevo la pagina del marco
            marco.Pagina=null;
        }
        else
            System.out.println("El marco no existe ");
        //System.out.println("Marco a remover pagina "+ marco.ID_Marco);
        
        Imprime.imprime_lista_marcos(Mapa_Marcos);
    }
    ////////////////////////////////////////////////////////////////////////////////////////
   /* public void Ubicar_Nueva_Pagina(){
        
    }
    */

    ////////////////////////////////////////////////////////////////////////////////////////
    /*Utilizada desde las referencias, cuando se realiza la conversion y dice cual pagina se ocupa
    Cambia la posicion de las paginas, en la lista de paginas general del sistema*/
    public void Pagina_Referenciada(Paginas Pagina_Referenciada){
        System.out.println("\nESTAMOS EN REFERENCIAS**********");
        //Busca si la pagina referenciada esta en memoria
        if (Buscar_Pagina.Busca_Pagina_En_Memoria_Principal(Mapa_Marcos,Pagina_Referenciada)!=-1){
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
    }
 
    ////////////////////////////////////////////////////////////////////////////////////////
    //MAIN
     public static void main(String[] args) {
         //Lista de paginas
        LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal= new LinkedList<>();
            //Nuevas paginas
         
         Politica_Reemplazo nuevo= new Politica_Reemplazo();
         nuevo.llena();
         nuevo.Pagina_Referenciada(nuevo.pg2);
         nuevo.Pagina_Referenciada(nuevo.pg1);
         nuevo.Pagina_Referenciada(nuevo.pg4);
         nuevo.Politica_Menos_Utilizado_Recientemente(nuevo.pg5);
         /*if ( nuevo.Busca_Pagina_En_Memoria_Principal(nuevo.pg5)){
             System.out.println("Si esta");
         }
         else
             System.out.println("No esta");*/
    }
    
}