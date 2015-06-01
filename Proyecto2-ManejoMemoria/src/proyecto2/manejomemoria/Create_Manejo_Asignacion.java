

package proyecto2.manejomemoria;

public class Create_Manejo_Asignacion {
    DTO DTO;
    Manejo_Asignacion Manejo_Asignacion;

    public Create_Manejo_Asignacion(DTO DTO) {
        this.DTO = DTO;
        this.Manejo_Asignacion= new Manejo_Asignacion(DTO);
    }
    
    public String Gestion_Manejo_Asignacion(Paginas Pagina){
        if(DTO.Tamaño_Conjunto.equals("Fijo")){
            Manejo_Asignacion.Asignacion_Fija(Pagina.ID_Proceso, Pagina);
        }
        else{
             Manejo_Asignacion.Asignacion_Variable(Pagina.ID_Proceso, Pagina);
        }
        return "";
    }
    
}
