
package proyecto2.manejomemoria;

import java.util.LinkedList;

public class Politica_Limpieza {
    DTO Estructura_DTO;
    public Politica_Limpieza(DTO Estructura) {
        Estructura_DTO=Estructura;
    }
    
    //Cuando se hace reemplazo
    public void Limpieza_Por_Demanda(Paginas Pagina_Para_Limpieza){
        Pagina_Para_Limpieza.Bit_Suciedad=0;
    }
    //Cada cierto tiempo
    public void Pre_Limpieza(){
        LinkedList<Marco> Memoria_Fisica=Estructura_DTO.Memoria_Fisica;
        for (int i = 0; i < Memoria_Fisica.size(); i++) {
           Memoria_Fisica.get(i).Pagina.Bit_Suciedad=0;
        }
    }
}
