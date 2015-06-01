
package proyecto2.manejomemoria;
import java.util.*;


public class Politica_Ubicacion {
    
    DTO DTO;

    public Politica_Ubicacion(DTO DTO) {
        this.DTO = DTO;
        
    } 
    public String Siguiente_Disponible(Paginas Pagina,LinkedList<Marco> Posibles,String Ambito){
        String Resultado="";
        if(!(Existe_Ultimo_Ubicado(Posibles, Ambito))){
            Resultado= Primero_Disponible(Pagina, Posibles, Ambito);
        }
        else{
            int ID_Ultimo_Marco=Encuentra_Ultimo_Ubicado(Posibles, Ambito);
            if(ID_Ultimo_Marco==Posibles.size()){
                Resultado= Primero_Disponible(Pagina, Posibles, Ambito);
            }
            else{
                List<Marco> Lista_Recortada=Posibles.subList(ID_Ultimo_Marco+1, Posibles.size());
                Resultado= Primero_Disponible(Pagina,Lista_Recortada, Ambito);
            }            
        }
        return Resultado;
    }
    public String Primero_Disponible( Paginas Pagina, List<Marco> Lista_Posibles,String Ambito){
        String Resultado="No se encuentran Marcos vacíos";
        for (int i = 0; i < Lista_Posibles.size(); i++) {
            if(Lista_Posibles.get(i).Pagina==null){
                Resultado=Cambia_Memoria_Fisica(Lista_Posibles.get(i).ID_Marco, Pagina,Ambito);
            }
        }
        return Resultado;
 
    }
    private String Cambia_Memoria_Fisica(int ID_Marco, Paginas Pagina, String Ambito){
        String Respuesta="Error al ubicar la página";
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            if(DTO.Memoria_Fisica.get(i).ID_Marco==ID_Marco){
                DTO.Memoria_Fisica.get(i).Pagina=Pagina;
                DTO.Memoria_Fisica.get(i).ID_Proceso_Dueño=Pagina.ID_Proceso;
                DTO.Lista_Paginas_En_Memoria_Principal.add(Pagina);
                if(Ambito.equals("Local")){
                    DTO.Memoria_Fisica.get(i).Ultimo_Colocado_Local=true;
                }
                else{
                    DTO.Memoria_Fisica.get(i).Ultimo_Colocado_Global=true;
                }
                Respuesta="Página ubicada con éxito";
                break;
            }   
        }
        return Respuesta;
    }
    private boolean Existe_Ultimo_Ubicado(LinkedList<Marco> Posibles,String Ambito){
        boolean Existe=false;
        for (int i = 0; i < Posibles.size(); i++) {
            if(Ambito.equals("Local")){
                if(Posibles.get(i).Ultimo_Colocado_Local==true){
                    Existe=true;
                }
            }
            else{
                if(Posibles.get(i).Ultimo_Colocado_Global==true){
                    Existe=true;
                }
            }
        }
        return Existe;
    }
    private int Encuentra_Ultimo_Ubicado(LinkedList<Marco> Posibles,String Ambito){
        int ID_Marco=0;
        for (int i = 0; i < Posibles.size(); i++) {
            if(Ambito.equals("Local")){
                if(Posibles.get(i).Ultimo_Colocado_Local==true){
                    DTO.Memoria_Fisica.get(i).Ultimo_Colocado_Local=false;
                    ID_Marco=i;    
                }
            }
            else{
                if(Posibles.get(i).Ultimo_Colocado_Global==true){
                    DTO.Memoria_Fisica.get(i).Ultimo_Colocado_Global=false;
                    ID_Marco=i;
                }
            }
        }
        return ID_Marco ;
    }
}
