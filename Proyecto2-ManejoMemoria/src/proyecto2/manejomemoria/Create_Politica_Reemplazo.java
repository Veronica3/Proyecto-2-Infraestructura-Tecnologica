
package proyecto2.manejomemoria;
import java.util.*; 

public class Create_Politica_Reemplazo {
    DTO DTO;
    Politica_Reemplazo politica_Reemplazo;
    public Create_Politica_Reemplazo(DTO DTO) {
        this.DTO = DTO;
        this.politica_Reemplazo= new Politica_Reemplazo(DTO);
    }
    
    public void Gestiona_Politica_Reemplazo(Paginas Pagina,LinkedList<Marco> Lista_Marcos){
        if(DTO.Politica_Reemplazo.equals("FIFO")){
            politica_Reemplazo.Politica_FIFO(Pagina, Lista_Marcos);
        }
        else if(DTO.Politica_Reemplazo.equals("LRU")){
            politica_Reemplazo.Politica_Menos_Utilizado_Recientemente(Pagina, Lista_Marcos);
        }
        else if(DTO.Politica_Reemplazo.equals("MRU")){
            politica_Reemplazo.Politica_Mas_Utilizado_Recientemente(Pagina, Lista_Marcos);
        }
        else{
            politica_Reemplazo.Politica_Reloj();
        }
    }
}
