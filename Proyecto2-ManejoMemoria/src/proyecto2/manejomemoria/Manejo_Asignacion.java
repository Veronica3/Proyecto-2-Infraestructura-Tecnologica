



package proyecto2.manejomemoria;
import java.util.*;
public class Manejo_Asignacion {
    
    Create_Alcance_Conjunto Ambito_Reemplazo;
    Create_Politica_Ubicacion Ubicacion;
    Create_Politica_Reemplazo Reemplazo;
    DTO DTO;
    
    public Manejo_Asignacion(DTO DTO) {
        this.DTO=DTO;
        this.Ubicacion=new Create_Politica_Ubicacion(DTO);
        this.Reemplazo=new Create_Politica_Reemplazo(DTO);
        this.Ambito_Reemplazo=new Create_Alcance_Conjunto(DTO);
    }
    public LinkedList<Marco> Asignacion_Fija(int ID_PROCESO, Paginas Pagina){
        LinkedList<Marco> Ambito_Local= new LinkedList<Marco>();
        Ambito_Local= Ambito_Reemplazo.Gestion_Alcance_Conjunto("Local", ID_PROCESO,Ambito_Local);
        if (Verifica_Existencia_Espacio(Ambito_Local)){
            Ubicacion.Gestiona_Politica_Ubicacion(ID_PROCESO, Pagina);
        }
        else{
            Reemplazo.Gestiona_Politica_Reemplazo(Pagina, Ambito_Local);
        }
        return Ambito_Local;
    }
    
    public LinkedList<Marco> Asignacion_Variable(int ID_PROCESO, Paginas Pagina){
        LinkedList<Marco> Ambito_Local= new LinkedList<>();//= Manejo_Alcance.Ambito_Local(DTO, ID_PROCESO,new LinkedList<Marco>());
        if(Verifica_Existencia_Espacio(Ambito_Local)){
            
        
        }
        
        return Ambito_Local;
    }
    private boolean Verifica_Existencia_Espacio(LinkedList<Marco> Marcos){
        boolean Resultado=false;
        for (int i = 0; i < Marcos.size(); i++) {
            if(Marcos.get(i).ID_Proceso_Dueño==0){
                Resultado=true;
                break;
            }
        }
        return Resultado;
    }
}