
package proyecto2.manejomemoria;
import java.util.*;
import java.util.HashMap;

public class Politica_Reemplazo {
    Politica_Ubicacion Ubicacion_Pagina;
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal=new LinkedList<>();
    HashMap<Integer, Marco> Mapa_Marcos = new HashMap<Integer, Marco>();
    
   // PRUEBAS 
     //Nuevas paginas
     Paginas pg1= new Paginas(1, 1, 20);
     Paginas pg2= new Paginas(2, 1, 20);
     Paginas pg3= new Paginas(3, 2, 20);
     Paginas pg4= new Paginas(4, 3, 20);
     //Pagina que no se ha asignado a un marco
     Paginas pg5= new Paginas(5, 3, 20);
     
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
        // Lista_Paginas_En_Memoria_Principal.addFirst(pg4);
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
       
        //Quitarla del marco asignado
        Remover_Pagina_Del_Marco(Pagina_Reemplazada);
        //REMUEVO la pagina de la lista
        Lista_Paginas_En_Memoria_Principal.removeLast();
        //Cambio el BIT PRESENTE indicando que ya no va a estar en MEMORIA PRINCIPAL
        Pagina_Reemplazada.Bit_Presente=false;
        
        System.out.println("Pagina a remover ** " + Pagina_Reemplazada.ID_Pagina);
        //Ubico la nuevo pagina
        //Ubicacion_Pagina.Asignacion_a_Marco(Pagina_Nueva);
   }
    ////////////////////////////////////////////////////////////////////////////////////////
    
    public void Politica_Reloj(){
    
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Remover_Pagina_Del_Marco(Paginas Pagina_A_Remover){
        //Obtengo ID del marco donde se encuentra la pagina
        int ID_Marco= Busca_Pagina_En_Memoria_Principal(Pagina_A_Remover);
        System.out.println("ID de marco "+ID_Marco);
        Marco marco= Mapa_Marcos.get(ID_Marco);
        //System.out.println("Marco a remover pagina "+ marco.ID_Marco);
        //marco.Pagina=null;
        imprime_lista_marcos();
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Ubicar_Nueva_Pagina(){
        
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //Busca la pagina referenciada en la lista general
    public int Busca_Pagina_En_Lista( Paginas Pagina_Referenciada){
        //Buusca en toda la lista
        for (int i = 0; i < Lista_Paginas_En_Memoria_Principal.size(); i++) {
            //Si el ID de la pagina referenciada esta en la lista retorna el indice en el que se encuentra
            if (Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina==Pagina_Referenciada.ID_Pagina){
                return i;
            }
        }
        //SINO encuentra la pagina retorna -1
        return -1;
    } 
    public void imprime_lista_marcos(){
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
    public void imprime_lista_paginas(){
        System.out.println("\nIMPRIME PAGINAS**********");
        for (int i = 0; i < Lista_Paginas_En_Memoria_Principal.size(); i++) {
            System.out.println("PG  "+ Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina);
        }
        System.out.println("*************************************************");

    }
    ////////////////////////////////////////////////////////////////////////////////////////
    /*Utilizada desde las referencias, cuando se realiza la conversion y dice cual pagina se ocupa
    Cambia la posicion de las paginas, en la lista de paginas general del sistema*/
    public void Pagina_Referenciada(Paginas Pagina_Referenciada){
        System.out.println("\nESTAMOS EN REFERENCIAS**********");
        //Busca si la pagina referenciada esta en memoria
        if (Busca_Pagina_En_Memoria_Principal(Pagina_Referenciada)!=-1){
            //PRUEBA
            imprime_lista_paginas();
           
            //Agarra el indice de la pagina referenciada en la lista actual
           int indice_a_cambiar= Busca_Pagina_En_Lista(Pagina_Referenciada);
           //si el indice es DIFERENTE A -1 quiere decir que la pagina SI EXISTE en la lista de paginas
           if (indice_a_cambiar!=-1){
              //Remueve la pagina de la posicion actual 
              Lista_Paginas_En_Memoria_Principal.remove(indice_a_cambiar);
              //Ingresa la pagina a la primera posicion
              Lista_Paginas_En_Memoria_Principal.addFirst(Pagina_Referenciada);
              imprime_lista_paginas();
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
    //Funcion para buscar la pagina en los marcos
    public int Busca_Pagina_En_Memoria_Principal (Paginas Pagina){
         System.out.println("\nESTAMOS EN BUSCA MM **********");
        //Agarra la llave del marco para iterar sobre el Hashmap
        Iterator<Integer> keySetIterator = Mapa_Marcos.keySet().iterator();
        //Ciclo de busqueda en los marcos
        while(keySetIterator.hasNext()){
            //Agarra la llave actual
            Integer key = keySetIterator.next();
            Marco marco=Mapa_Marcos.get(key);
            System.out.println("Clave: " + key + " -> Valor: "+Mapa_Marcos.get(key).ID_Marco +"Pagina: "+ Mapa_Marcos.get(key).Pagina.ID_Pagina);
            //Pregunta si la pagina esta en Memoria principal
            if ((Pagina.ID_Pagina==marco.Pagina.ID_Pagina)&&(marco.Pagina.Bit_Presente)){
                return marco.ID_Marco;
            }
            
          }
         return -1;   
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
