



package proyecto2.manejomemoria;
import java.util.*;
public class Manejo_Asignacion {
    
    Create_Alcance_Conjunto Create_Alcance_Conjunto;
    Create_Politica_Ubicacion Ubicacion;
    Create_Politica_Reemplazo Reemplazo;
    DTO DTO;
    
    public Manejo_Asignacion(DTO DTO) {
        this.DTO=DTO;
        this.Ubicacion=new Create_Politica_Ubicacion(DTO);
        this.Reemplazo=new Create_Politica_Reemplazo(DTO);
        this.Create_Alcance_Conjunto=new Create_Alcance_Conjunto(DTO);
    }
    public LinkedList<Marco> Asignacion_Fija(int ID_PROCESO, Paginas Pagina){
        LinkedList<Marco> Lista_Marcos= new LinkedList<Marco>();
        Lista_Marcos= Create_Alcance_Conjunto.Gestion_Alcance_Conjunto("Local", ID_PROCESO,Lista_Marcos);
        if (Verifica_Existencia_Espacio(Lista_Marcos)){
            Ubicacion.Gestiona_Politica_Ubicacion(Pagina,Lista_Marcos,"Local");
        }
        else{
            Reemplazo.Gestiona_Politica_Reemplazo(Pagina, Lista_Marcos);
        }
        return Lista_Marcos;
    }
    
    public LinkedList<Marco> Asignacion_Variable(int ID_PROCESO, Paginas Pagina){
        //if(DTO.Lista_Procesos.get(ID_PROCESO).Working_Set()==){}
        return new LinkedList<>();
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