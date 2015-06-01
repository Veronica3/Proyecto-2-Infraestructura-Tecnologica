



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
    public String Asignacion_Fija(int ID_PROCESO, Paginas Pagina){
        String Respuesta="";
        LinkedList<Marco> Lista_Marcos= new LinkedList<Marco>();
        Lista_Marcos= Create_Alcance_Conjunto.Gestion_Alcance_Conjunto("Local", ID_PROCESO,Lista_Marcos);
        if (Verifica_Existencia_Espacio(Lista_Marcos)){
            Respuesta=Ubicacion.Gestiona_Politica_Ubicacion(Pagina,Lista_Marcos,"Local");
        }
        else{
            Reemplazo.Gestiona_Politica_Reemplazo(Pagina, Lista_Marcos);
        }
        return Respuesta;
    }
    public String Asignacion_Variable(int ID_PROCESO, Paginas Pagina){
        String Respuesta="";
        LinkedList<Marco> Lista_Marcos= new LinkedList<Marco>();
        Lista_Marcos= Create_Alcance_Conjunto.Gestion_Alcance_Conjunto("Local", ID_PROCESO,Lista_Marcos);
        if (Verifica_Existencia_Espacio(Lista_Marcos)){
            Respuesta=Ubicacion.Gestiona_Politica_Ubicacion(Pagina,Lista_Marcos,"Local");
        }
        else{
            if(DTO.Lista_Procesos.get(ID_PROCESO).Working_Set()==DTO.Maximo_Marcos){
                Reemplazo.Gestiona_Politica_Reemplazo(Pagina, Lista_Marcos);
            }
            else{
                Respuesta=Asigna_Mas_Marcos(ID_PROCESO);
                if(Respuesta.equals("Aumento de Marcos a "+ID_PROCESO+" realizado con éxito")){
                    Respuesta=Asignacion_Variable(ID_PROCESO, Pagina);
                }
            }
        }
        
        return Respuesta;
    }
    private String Asigna_Mas_Marcos(int ID_Proceso){
        String Respuesta="Aumento de Marcos a "+ID_Proceso+" realizado con éxito";
        LinkedList<Marco> Lista_Marcos_Vacios=Lista_Marcos_Vacios();
        if(DTO.Tamano_aumento>=Lista_Marcos_Vacios.size()){
            Respuesta="No existe Memoria Disponible para el proceso "+ ID_Proceso;
        }
        else{
            for (int i = 0; i < DTO.Tamano_aumento; i++) {
                
                if(Lista_Marcos_Vacios.get(i).ID_Proceso_Dueño!=0){
                    DTO.Lista_Procesos.get(Lista_Marcos_Vacios.get(i).ID_Proceso_Dueño).Cambiar_Working_Set(-1);
                }
                DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño=ID_Proceso;
                DTO.Lista_Procesos.get(ID_Proceso).Cambiar_Working_Set(1);
            }
        }
        return Respuesta;
    }
    private LinkedList<Marco> Lista_Marcos_Vacios(){
        LinkedList<Marco> Lista_Marcos_Vacios= new LinkedList<Marco>();
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            if(DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño==0){
                Lista_Marcos_Vacios.addFirst(DTO.Memoria_Fisica.get(i));
            }
            else{
                int ID_PROCESO=DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño;
                if(DTO.Memoria_Fisica.get(i).Pagina==null && DTO.Lista_Procesos.get(ID_PROCESO).Working_Set()>DTO.Minimo_Marcos){
                    Lista_Marcos_Vacios.addLast(DTO.Memoria_Fisica.get(i));
                }
            }
            
        }
        return Lista_Marcos_Vacios;
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