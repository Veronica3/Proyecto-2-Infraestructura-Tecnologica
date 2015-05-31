
package proyecto2.manejomemoria;
import java.util.*;
public class Memoria_Fisica {
    Procesos_Prioridad Manejo_Multiprogramacion=new Procesos_Prioridad();
    DTO DTO;

    public Memoria_Fisica(DTO DTO) {
        this.DTO = DTO;
    }
    
    /*Crea la cantidad de marcos correspondientes a los parametros entrantes*/
       
    public void Crea_Memoria_Fisica(){
        int Cantidad_Paginas=(int) DTO.Tamaño_Memoria_Fisica/DTO.Tamaño_Paginas;
        for (int i = 0; i < Cantidad_Paginas; i++) {
            Marco Marco=new Marco(i,null,0);
            DTO.Memoria_Fisica.add(Marco);
        }
        
          
    }
    
    /*Asignacion de marcos por proceso segun el working set*/
    public void Asignacion_Marcos_Procesos(){
        LinkedList<Interface_Proceso> Lista_Proceso=Ordena_Segun_Prioridad();  
        for (int i = 0; i < Lista_Proceso.size(); i++) {
            Asigna_Proceso_Dueño(Lista_Proceso.get(i).ID_Proceso());
        }
        
    }
    /*Con esto solo los proceso de mayor prioridad acceden a la memoria fisica*/
    private LinkedList<Interface_Proceso> Ordena_Segun_Prioridad(){
        LinkedList<Interface_Proceso> Proceso_Prioridad=new LinkedList<Interface_Proceso>();
        for (int i = 0; i < DTO.Lista_Procesos.size(); i++) {
            Proceso_Prioridad=Manejo_Multiprogramacion.Colas_Prioridad(DTO.Lista_Procesos.get(i), Proceso_Prioridad);
        }
        return Proceso_Prioridad;
    
    }
    /*Se incorpora el ID_Proceso al marco correspondiente*/
    private void Asigna_Proceso_Dueño(int ID_PROCESO){
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
        
        Proceso P1= new Proceso(3,"P0",10,true,89,4);
        Proceso P2= new Proceso(1,"P1",3,true,89,4);
        Proceso P3= new Proceso(2,"P2",4,true,89,4);
        DTO.Lista_Procesos.put(0,P1);
        DTO.Lista_Procesos.put(1,P2);
        DTO.Lista_Procesos.put(2,P3);
        Memoria_Fisica Manejo_Memoria=new Memoria_Fisica(DTO);
        Manejo_Memoria.Crea_Memoria_Fisica();
        Manejo_Memoria.Asignacion_Marcos_Procesos();
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            System.out.print(DTO.Memoria_Fisica.get(i).ID_Marco);
            System.out.print(">");
            System.out.print(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño);
        }    
    }
}