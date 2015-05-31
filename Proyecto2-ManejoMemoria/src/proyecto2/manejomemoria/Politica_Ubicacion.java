
package proyecto2.manejomemoria;
import java.util.*;


public class Politica_Ubicacion {
    
    DTO DTO;

    public Politica_Ubicacion(DTO DTO) {
        this.DTO = DTO;
        
    }
    
    public void Siguiente_Disponible(LinkedList<Marco> Posibles){}
    public void Primero_Disponible( int ID_PROCESO,Paginas Pagina){
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            if(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño==ID_PROCESO && DTO.Memoria_Fisica.get(i).Pagina==null){
                DTO.Memoria_Fisica.get(i).Pagina=Pagina;
            }  
        } 
    }
}
