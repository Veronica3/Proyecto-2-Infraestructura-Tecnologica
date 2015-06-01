
package proyecto2.manejomemoria;
import java.text.*;
import java.util.*;

public class Politica_Reemplazo {
    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
    Calendar calendario;
    int ID_Marco; //Utilizado para obtener el id del marco al que le voy a reemplazar la pagina
    DTO Estructura_DTO; //Estructura
    LinkedList<Paginas> Lista_Paginas_En_Memoria_Principal; //Lista
    Busca_Paginas Buscar_Pagina;//Busca Paginas para ALGORITMOS de LRU y MRU
    Imprimir_Para_Pruebas Imprime= new Imprimir_Para_Pruebas(Estructura_DTO);//Para PRUEBAS
    Lista_Circular Lista_Reloj;//Lista para algoritmo RELOJ
    LinkedList<Marco> Lista_Marcos; //Marcos para realizar el reemplazo
    Añadir_a_Bitacora Bitacora; //Bitacora en la que se guardan todas las operaciones realizadas
    String Operacion_Reemplazo; //String que recibe bitacora
    
///////////////////////////////////////////////////////////////////////////////////////////////    
    public Politica_Reemplazo(DTO Estructura_DTO) {
        
        this.Estructura_DTO = Estructura_DTO;
        this.Lista_Paginas_En_Memoria_Principal= Estructura_DTO.Lista_Paginas_En_Memoria_Principal;
        this.ID_Marco=-1;
        this.Bitacora= new Añadir_a_Bitacora(Estructura_DTO);
        this.Lista_Reloj=Estructura_DTO.Lista_Reloj;
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////
    //Politica de reemplazo FIFO, elimina la primer pagina de la lista y agrega la nueva de ultimo.
    public void Politica_FIFO ( Paginas Nueva_Pagina, LinkedList<Marco> Lista_Marcos_Reemplazo) {
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Pagina_A_Reemplazar(Lista_Marcos_Reemplazo, "FIFO");//Remueve la primera pagina ya que es la que lleva mas tiempo en Memoria
        Operacion_Reemplazo= Remover_Pagina_Del_Marco(ID_Marco_De_Pagina_Reemplazada, Nueva_Pagina);//Llama a funcion para que la remueva del marco asignado
        Bitacora.Añadir_Accion_A_Bitacora(Operacion_Reemplazo);//Agrega accion ejecutada a bitacora
        Lista_Paginas_En_Memoria_Principal.removeFirst(); //Remueve la primer pagina
        Lista_Paginas_En_Memoria_Principal.addLast(Nueva_Pagina); //Agrega la nueva pagina a la lista
}
////////////////////////////////////////////////////////////////////////////////////////
    //Se implementa con lista igual que FIFO pero la lista cambia cada vez que se referencia una pagina
    public void Politica_Menos_Utilizado_Recientemente ( Paginas Nueva_Pagina, LinkedList<Marco> Lista_Marcos_Reemplazo){
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Pagina_A_Reemplazar(Lista_Marcos_Reemplazo, "LRU");//Guardo la pagina que se va a eliminar
        Operacion_Reemplazo=Remover_Pagina_Del_Marco( ID_Marco_De_Pagina_Reemplazada, Nueva_Pagina);//Quita la pagina del marco asignado
        Bitacora.Añadir_Accion_A_Bitacora(Operacion_Reemplazo);//Agrega accion ejecutada a bitacora
        Lista_Paginas_En_Memoria_Principal.removeLast(); //REMUEVO la pagina de la lista
        Lista_Paginas_En_Memoria_Principal.addFirst(Nueva_Pagina); //Agrega la nueva pagina a la lista
        //System.out.println("Pagina a remover ** " + ID_Marco_De_Pagina_Reemplazada.ID_Pagina);
        
   }
////////////////////////////////////////////////////////////////////////////////////////
     
    //Se implementa con lista igual LRU pero elimina la pagina mas RECIENTEMENTE UTILIZADA
    public void Politica_Mas_Utilizado_Recientemente ( Paginas Nueva_Pagina, LinkedList<Marco> Lista_Marcos_Reemplazo){
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Pagina_A_Reemplazar(Lista_Marcos, "MRU");//Guardo la pagina que se va a eliminar
        Operacion_Reemplazo=Remover_Pagina_Del_Marco(ID_Marco_De_Pagina_Reemplazada, Nueva_Pagina);//Quita la pagina del marco asignado
        Bitacora.Añadir_Accion_A_Bitacora(Operacion_Reemplazo);//Agrega accion ejecutada a bitacora
        Lista_Paginas_En_Memoria_Principal.removeFirst(); //Remueve la primer pagina
        Lista_Paginas_En_Memoria_Principal.addLast(Nueva_Pagina); //Agrega la nueva pagina a la lista
        //System.out.println("Pagina a remover ** " + Pagina_Reemplazada.ID_Pagina);
        
   }
////////////////////////////////////////////////////////////////////////////////////////
    public void Politica_Reloj(Paginas Nueva_Pagina, LinkedList<Marco> Lista_Marcos_Reemplazo){
        Lista_Marcos=Lista_Marcos_Reemplazo; //Asigno lista de marcos en los que se puede aplicar reemplazo
        int ID_Marco_De_Pagina_Reemplazada=Lista_Reloj.ID_Marco_De_Pagina_A_Reemplazar(Lista_Marcos);
        Operacion_Reemplazo= Remover_Pagina_Del_Marco(ID_Marco_De_Pagina_Reemplazada, Nueva_Pagina);//Llama a funcion para que la remueva del marco asignado
        Bitacora.Añadir_Accion_A_Bitacora(Operacion_Reemplazo);//Agrega accion ejecutada a bitacora
        //CUANDO BUSCA EL MARCO LLAMA A FUNCION QUE ELIMINA LA PAGINA DE LA LISTA CIRCULAR
        Nueva_Pagina.Bit_Modificado=1;
        Lista_Reloj.Ingresar_Ultimo(Nueva_Pagina);
    }
    
////////////////////////////////////////////////////////////////////////////////////////
    public int Pagina_A_Reemplazar(LinkedList<Marco> Lista_Marcos_A, String Politica){
        for (int i = 0; i < Lista_Paginas_En_Memoria_Principal.size(); i++) {//INGRESA a lista de paginas en memoria fisica
            for (int j = 0; j < Lista_Marcos_A.size(); j++) {  //Ingresa a lista de marcos en los cuales compara cada pagina con todas las del marco
                if (Lista_Paginas_En_Memoria_Principal.get(i).ID_Pagina==Lista_Marcos_A.get(j).Pagina.ID_Pagina
                    && Lista_Paginas_En_Memoria_Principal.get(i).ID_Proceso==Lista_Marcos_A.get(j).Pagina.ID_Proceso){
                    if (Politica.equals("FIFO")||Politica.equals("MRU")){
                        return Lista_Marcos_A.get(j).ID_Marco;
                    }
                    else
                        ID_Marco= Lista_Marcos_A.get(j).ID_Marco;
                }
            }
        }
        return ID_Marco;
    }
 
////////////////////////////////////////////////////////////////////////////////////////
    public String Remover_Pagina_Del_Marco(int Marco_De_Pagina_A_Remover, Paginas Nueva_Pagina){
        Buscar_Pagina= new Busca_Paginas(Estructura_DTO);
        
        if (ID_Marco!=-1){ //Valida que el MARCO EXISTA
            for (int i = 0; i < Estructura_DTO.Memoria_Fisica.size(); i++) {
                Marco Marco= Estructura_DTO.Memoria_Fisica.get(i); //Asigno el marco actual
                if (Marco.ID_Marco==ID_Marco){ //Pregunto si los ID's coinciden
                    Marco.Pagina=Nueva_Pagina;  //Reemplazo pagina
                    Marco.ID_Proceso_Dueño=Nueva_Pagina.ID_Proceso; //Actualizo ID proceso due;o del marco
                   
                    calendario = Calendar.getInstance();
                    return "\nTiempo reemplazo: "+formato.format(calendario.getTime())+" \nMarco para reemplazo: "+ 
                            ID_Marco+"\nPágina para asignar a marco: " + Nueva_Pagina.ID_Pagina
                            +"\nPágina perteneciente al Proceso: " + Nueva_Pagina.ID_Proceso;
                }
            }
        }
        else
            return "Operación inválida. El marco no existe";
        
        return "";//System.out.println("Marco a remover pagina "+ marco.ID_Marco);
        //Imprime.imprime_lista_marcos(Mapa_Marcos);
    }
    
////////////////////////////////////////////////////////////////////////////////////////
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
        
    }
    

    }

