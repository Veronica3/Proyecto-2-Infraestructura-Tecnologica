
package proyecto2.manejomemoria;

public class Añadir_a_Bitacora {
    DTO Estructura_DTO;
    public Añadir_a_Bitacora(DTO Estructura) {
        this.Estructura_DTO=Estructura;
    }
    public void Añadir_Accion_A_Bitacora(String Sentencia){
        Estructura_DTO.Bitacora.getLast().add(Sentencia);
    }
}
