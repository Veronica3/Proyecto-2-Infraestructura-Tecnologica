
package proyecto2.manejomemoria;
import java.util.*;
import java.util.HashMap;

public class Politica_Reemplazo {
    Politica_Ubicacion Ubicacion_Pagina;
    HashMap<Integer, Marco> Mapa_Marcos = new HashMap<Integer, Marco>();
   
   /* PRUEBAS 
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

    */
     //FUNCION DE PRUEBA
   /* public void llena(){
         
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
         
    }*/
    
    //Politica de reemplazo FIFO, elimina la primer pagina de la lista y agrega la nueva de ultimo.
    public void Politica_FIFO (LinkedList Lista_Paginas_MM, Paginas Nueva_Pagina) {
        Lista_Paginas_MM.removeFirst();
        Lista_Paginas_MM.addLast(Nueva_Pagina);
        
        //Llamo a funcion que asigna la nueva pagina al marco disponible
        Ubicacion_Pagina.Asignacion_a_Marco(Nueva_Pagina);
}
   
    //Se implementa con lista igual que FIFO
    public void Politica_Menos_Utilizado_Recientemente (LinkedList Lista_Paginas_MM, Paginas Pagina_Referenciada){
    
    }
    
    public void Politica_Reloj(){
    
    }
    
    //Utilizada desde las referencias, cuando se realiza la conversion y dice cual pagina se ocupa
    public void Pagina_Referenciada(LinkedList Lista_Paginas_MM, HashMap Mapa_Marcos, Paginas Pagina_Referenciada){
        //Busca si la pagina referenciada esta en memoria
        if (Busca_Pagina_En_Memoria_Principal(Pagina_Referenciada)){
            
        }
        //Lista_Paginas_MM.
    }
   
    //Funcion para buscar la pagina en los marcos
    public boolean Busca_Pagina_En_Memoria_Principal (Paginas Pagina_Referenciada){
         
        //Agarra la llave del marco para iterar sobre el Hashmap
        Iterator<Integer> keySetIterator = Mapa_Marcos.keySet().iterator();
        //Ciclo de busqueda en los marcos
        while(keySetIterator.hasNext()){
            //Agarra la llave actual
            Integer key = keySetIterator.next();
            Marco marco=Mapa_Marcos.get(key);
            System.out.println("key: " + key + " value: " + Mapa_Marcos.get(key));
            //Pregunta si la pagina esta en Memoria principal
            if ((Pagina_Referenciada.ID_Pagina==marco.Pagina.ID_Pagina)&&(marco.Pagina.Bit_Presente)){
                return true;
            }
            
          }
         return false;   
    }
    
    
    //MAIN
     public static void main(String[] args) {
         //Lista de paginas
        /* LinkedList<Paginas> Lista_Paginas_MM;
            //Nuevas paginas
         
         Politica_Reemplazo nuevo= new Politica_Reemplazo();
         nuevo.llena();
         if ( nuevo.Busca_Pagina_En_Memoria_Principal(nuevo.pg5)){
             System.out.println("Si esta");
         }
         else
             System.out.println("No esta");*/
    }
    
}
