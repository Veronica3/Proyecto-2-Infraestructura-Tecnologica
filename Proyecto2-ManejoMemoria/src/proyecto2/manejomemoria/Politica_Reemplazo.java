
package proyecto2.manejomemoria;
import java.util.*;

public class Politica_Reemplazo {
    int ID_Marco;
    DTO Estructura_DTO; //Estructura
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal;
    Busca_Paginas Buscar_Pagina;//Busca Paginas para ALGORITMOS de LRU y MRU
    Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas(Estructura_DTO);//Para PRUEBAS
    Lista_Circular Lista_Reloj= new Lista_Circular();//Lista para algoritmo RELOJ
    LinkedList<Marco> Lista_Marcos;
    
///////////////////////////////////////////////////////////////////////////////////////////////    
    public Politica_Reemplazo(DTO Estructura_DTO) {
        
        this.Estructura_DTO = Estructura_DTO;
        this.Lista_Paginas_En_Memoria_Principal= Estructura_DTO.Lista_Paginas_En_Memoria_Principal;
        this.ID_Marco=-1;
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////
    //Politica de reemplazo FIFO, elimina la primer pagina de la lista y agrega la nueva de ultimo.
    public void Politica_FIFO ( Paginas Nueva_Pagina, LinkedList<Marco> Lista_Marcos_Reemplazo) {
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Pagina_A_Reemplazar(Lista_Marcos_Reemplazo, "FIFO");//Remueve la primera pagina ya que es la que lleva mas tiempo en Memoria
        Remover_Pagina_Del_Marco(ID_Marco_De_Pagina_Reemplazada);//Llama a funcion para que la remueva del marco asignado
        Lista_Paginas_En_Memoria_Principal.addLast(Nueva_Pagina); //Agrega la nueva pagina a la lista
        
}
////////////////////////////////////////////////////////////////////////////////////////
    //Se implementa con lista igual que FIFO pero la lista cambia cada vez que se referencia una pagina
    public void Politica_Menos_Utilizado_Recientemente ( Paginas Pagina_Nueva, LinkedList<Marco> Lista_Marcos_Reemplazo){
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Pagina_A_Reemplazar(Lista_Marcos_Reemplazo, "LRU");//Guardo la pagina que se va a eliminar
        Remover_Pagina_Del_Marco( ID_Marco_De_Pagina_Reemplazada);//Quita la pagina del marco asignado
        Lista_Paginas_En_Memoria_Principal.removeLast(); //REMUEVO la pagina de la lista
        
        //System.out.println("Pagina a remover ** " + ID_Marco_De_Pagina_Reemplazada.ID_Pagina);
        
   }
////////////////////////////////////////////////////////////////////////////////////////
     
    //Se implementa con lista igual LRU pero elimina la pagina mas RECIENTEMENTE UTILIZADA
    public void Politica_Mas_Utilizado_Recientemente ( Paginas Pagina_Nueva, LinkedList<Marco> Lista_Marcos_Reemplazo){
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Pagina_A_Reemplazar(Lista_Marcos, "MRU");//Guardo la pagina que se va a eliminar
        Remover_Pagina_Del_Marco(ID_Marco_De_Pagina_Reemplazada);//Quita la pagina del marco asignado
        Lista_Paginas_En_Memoria_Principal.removeFirst(); //REMUEVO la pagina de la lista
        
        //System.out.println("Pagina a remover ** " + Pagina_Reemplazada.ID_Pagina);
        
   }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Politica_Reloj(){
        //Implementando  Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        //UTILIZA FALLO DE PAGINA> CUANDO OCURRE LA MANECILLA APUNTA A ESA PAGINA
        
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    public int Pagina_A_Reemplazar(LinkedList<Marco> Lista_Marcos_A, String Politica){
        for (int i = 0; i < Lista_Paginas_En_Memoria_Principal.size(); i++) {//INGRESA a lista de paginas en memoria fisica
            for (int j = 0; j < Lista_Marcos_A.size(); j++) {  //Ingresa a lista de marcos en los cuales compara cada pagina con todas las del marco
                if (Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina==Lista_Marcos_A.get(j).Pagina.ID_Pagina
                    && Lista_Paginas_En_Memoria_Principal.get(i).ID_Proceso==Lista_Marcos_A.get(j).Pagina.ID_Pagina){
                    if (Politica.equals("FIFO")||Politica.equals("MRU")){
                        return Lista_Marcos_A.get(j).ID_Marco;
                    }
                    else
                        ID_Marco= Lista_Marcos_A.get(j).ID_Marco;
                }
            }
        }
        return -1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void Remover_Pagina_Del_Marco(int Marco_De_Pagina_A_Remover){
        Buscar_Pagina= new Busca_Paginas(Estructura_DTO);
        
        if (ID_Marco!=-1){ //Valida que el MARCO EXISTA
            for (int i = 0; i < Estructura_DTO.Memoria_Fisica.size(); i++) {
                
            }
        }
        else
            System.out.println("El marco no existe ");
        //System.out.println("Marco a remover pagina "+ marco.ID_Marco);
        
       // Imprime.imprime_lista_marcos(Mapa_Marcos);
    }
    ////////////////////////////////////////////////////////////////////////////////////////
   /* public void Ubicar_Nueva_Pagina(){
        
    }
    */ ////////////////////////////////////////////////////////////////////////////////////////
    /*Utilizada desde las referencias, cuando se realiza la conversion y dice cual pagina se ocupa
    Cambia la posicion de las paginas, en la lista de paginas general del sistema*/
    public void Pagina_Referenciada(Paginas Pagina_Referenciada){
        System.out.println("\nESTAMOS EN REFERENCIAS**********");
        //Busca si la pagina referenciada esta en memoria
        if (Buscar_Pagina.Busca_Pagina_En_Memoria_Principal(Pagina_Referenciada)!=null){
          
           int indice_a_cambiar= Buscar_Pagina.Retorna_Indice_Pagina_MM(Pagina_Referenciada); //Agarra el indice de la pagina referenciada en la lista actual
           
           if (indice_a_cambiar!=-1){ //si el indice es DIFERENTE A -1 quiere decir que la pagina SI EXISTE en la lista de paginas
              Lista_Paginas_En_Memoria_Principal.remove(indice_a_cambiar);//Remueve la pagina de la posicion actual 
              Lista_Paginas_En_Memoria_Principal.addFirst(Pagina_Referenciada);//Ingresa la pagina a la primera posicion
              Imprime.imprime_lista_paginas(); //Imprime Lista
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
    }

