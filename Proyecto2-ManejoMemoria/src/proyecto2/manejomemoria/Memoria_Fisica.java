
package proyecto2.manejomemoria;
import java.util.*;
public class Memoria_Fisica {

    public Memoria_Fisica() {
    }
    
    /*Crea la cantidad de marcos correspondientes a los parametros entrantes*/
       
    public void Crea_Memoria_Fisica(DTO DTO){
        int Cantidad_Paginas=(int) DTO.Tamaño_Memoria_Fisica/DTO.Tamaño_Paginas;
        for (int i = 0; i < Cantidad_Paginas; i++) {
            Marco Marco=new Marco(i,null,0);
            DTO.Memoria_Fisica.add(Marco);
        }
        
          
    }
    
    public  LinkedList<Interface_Proceso> Busca_Procesos_Mayor_Prioridad(DTO DTO){
        LinkedList<Interface_Proceso> Lista_Procesos_Asignar=new LinkedList<Interface_Proceso>();
        Proceso Proceso;
        while(!Lista_Procesos_Asignar.isEmpty()&&Lista_Procesos_Asignar.size()<DTO.Grado_Multiprogramacion){
            
        
        }
        return Lista_Procesos_Asignar;
    }
    /*Asignacion de marcos por proceso segun el working set*/
    public void Asignacion_Marcos_Procesos(DTO DTO){
        for (int i = 0; i < DTO.Lista_Procesos.size(); i++) {
            Asigna_Proceso_Dueño(DTO,DTO.Lista_Procesos.get(i).ID_Proceso());
        }
        
    }
    
    /*Se incorpora el ID_Proceso al marco correspondiente*/
    private void Asigna_Proceso_Dueño(DTO DTO,int ID_PROCESO){
        int Memoria_Asignada=0;
        while (Memoria_Asignada<DTO.Working_Set) {            
            for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
                if(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño==0){
                    DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño=ID_PROCESO; 
                    Memoria_Asignada+=1;
                    break;
                }  
                
            }
        }
    
    }
    
    public static void main(String[] args) {
        DTO DTO= new DTO( "Politica_Recuperacion", "Politica_Ubicacion", "Politica_Reemplazo", "Politica_Limpieza",4, "Tamaño_Conjunto",  2, 5,3,"Ambito_Reemplazo", 5, 4,250, 32,10, "K");
        
        Proceso P1= new Proceso(3,"P0",7,true,89,4);
        Proceso P2= new Proceso(1,"P1",7,true,89,4);
        Proceso P3= new Proceso(2,"P2",7,true,89,4);
        DTO.Lista_Procesos.put(0,P1);
        DTO.Lista_Procesos.put(1,P2);
        DTO.Lista_Procesos.put(2,P3);
        Memoria_Fisica Manejo_Memoria=new Memoria_Fisica();
        Manejo_Memoria.Crea_Memoria_Fisica(DTO);
        Manejo_Memoria.Asignacion_Marcos_Procesos(DTO);
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            System.out.print(DTO.Memoria_Fisica.get(i).ID_Marco);
            System.out.print(">");
            System.out.print(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño);
        } 
        
    }
}