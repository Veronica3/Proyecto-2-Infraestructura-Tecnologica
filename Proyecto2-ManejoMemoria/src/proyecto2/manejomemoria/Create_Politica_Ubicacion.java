/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.manejomemoria;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author paola
 */
public class Create_Politica_Ubicacion {
    DTO DTO;
    Politica_Ubicacion ubicacion;

    public Create_Politica_Ubicacion(DTO DTO) {
        this.DTO = DTO;
        this.ubicacion=new Politica_Ubicacion(DTO);
    }
    
    public void Gestiona_Politica_Ubicacion(Paginas Pagina, LinkedList<Marco> Lista_Marco, String Ambito){
        if(DTO.Politica_Ubicacion.equals("Primero Disponible")){
            ubicacion.Primero_Disponible( Pagina, Lista_Marco,Ambito);
        }
        else{
            ubicacion.Siguiente_Disponible(Pagina,Lista_Marco,Ambito);
        }
    }
    
}
