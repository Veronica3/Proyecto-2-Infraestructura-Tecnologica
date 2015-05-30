

package proyecto2.manejomemoria;

import java.util.LinkedList;

public class Alcance_Conjunto {
    
     public LinkedList<Marco> Ambito_Global(DTO DTO,int ID_PROCESO, LinkedList<Marco> Lista_Ambito_Global){
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            Interface_Proceso Proceso=DTO.Lista_Procesos.get(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño);
            if(Proceso.Working_Set()>DTO.Minimo_Marcos && Proceso.ID_Proceso()!=ID_PROCESO){
                if(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño!=0){
                    Lista_Ambito_Global.add(DTO.Memoria_Fisica.get(i));
                }
                else if (Proceso.Es_Bloqueado_Proceso()==false){
                    Lista_Ambito_Global.add(DTO.Memoria_Fisica.get(i));
                }
            }            
        }
        return Lista_Ambito_Global; 
    }
     
     public LinkedList<Marco> Ambito_Local(DTO DTO, int ID_PROCESO, LinkedList<Marco> Lista_Ambito_Local){
        
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            if(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño==ID_PROCESO){
                Lista_Ambito_Local.add(DTO.Memoria_Fisica.get(i));
            }
        }
        return Lista_Ambito_Local; 
    } 
}
