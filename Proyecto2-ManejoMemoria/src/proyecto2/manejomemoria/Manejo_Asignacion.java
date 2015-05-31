package proyecto2.manejomemoria;
import java.util.*;
public class Manejo_Asignacion {
    
    Create_Alcance_Conjunto Ambito_Reemplazo=new Create_Alcance_Conjunto();
    Create_Politica_Ubicacion Ubicacion=new Create_Politica_Ubicacion();
    Create_Politica_Reemplazo Reemplazo=new Create_Politica_Reemplazo(null);
    Memoria_Fisica memoria_Fisica=new Memoria_Fisica();
    DTO DTO;
    public Manejo_Asignacion(DTO DTO) {
        this.DTO=DTO;
    }
    public LinkedList<Marco> Asignacion_Fija(int ID_PROCESO, Paginas Pagina){
        LinkedList<Marco> Ambito_Local= new LinkedList<Marco>();
        Ambito_Local= Ambito_Reemplazo.Gestion_Alcance_Conjunto("Local", DTO, ID_PROCESO,Ambito_Local);
        if (memoria_Fisica.Verifica_Existencia_Espacio(Ambito_Local)){
            Ubicacion.Gestiona_Politica_Ubicacion(DTO, ID_PROCESO, Pagina);
        }
        else{
            Reemplazo.Gestiona_Politica_Reemplazo(Pagina, Ambito_Local);
        }
        return Ambito_Local;
    }
    public LinkedList<Marco> Asignacion_Variable(int ID_PROCESO, Paginas Pagina){
        LinkedList<Marco> Ambito_Local= new LinkedList<>();//= Manejo_Alcance.Ambito_Local(DTO, ID_PROCESO,new LinkedList<Marco>());
        if(memoria_Fisica.Verifica_Existencia_Espacio(Ambito_Local)){
            
        
        }
        
        return Ambito_Local;
    }
  
}