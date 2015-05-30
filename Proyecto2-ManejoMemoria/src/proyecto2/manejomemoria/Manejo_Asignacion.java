package proyecto2.manejomemoria;
import java.util.*;
public class Manejo_Asignacion {
    Alcance_Conjunto Manejo_Alcance=new Alcance_Conjunto();
    Politica_Ubicacion politica_Ubicacion=new Politica_Ubicacion();
    Memoria_Fisica memoria_Fisica=new Memoria_Fisica();
    public Manejo_Asignacion() {
    }
    public LinkedList<Marco> Asignacion_Fija(DTO DTO, int ID_PROCESO){
        LinkedList<Marco> Ambito_Local= Manejo_Alcance.Ambito_Local(DTO, ID_PROCESO,new LinkedList<Marco>());
        return Ambito_Local;
    }
    public LinkedList<Marco> Asignacion_Variable(DTO DTO, int ID_PROCESO){
        LinkedList<Marco> Ambito_Local= Manejo_Alcance.Ambito_Local(DTO, ID_PROCESO,new LinkedList<Marco>());
        if(memoria_Fisica.Verifica_Existencia_Espacio(Ambito_Local)){
            
        
        }
        
        return Ambito_Local;
    }
  
}