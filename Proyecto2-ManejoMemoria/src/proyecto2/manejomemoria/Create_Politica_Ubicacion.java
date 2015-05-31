/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.manejomemoria;

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
    
    public void Gestiona_Politica_Ubicacion(int ID_PROCESO,Paginas Pagina){
        if(DTO.Politica_Ubicacion.equals("Primero Disponible")){
            ubicacion.Primero_Disponible(ID_PROCESO, Pagina);
        }
        else{
            ubicacion.Siguiente_Disponible(null);
        }
    }
    
}
