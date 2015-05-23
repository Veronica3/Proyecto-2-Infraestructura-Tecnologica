
package proyecto2.manejomemoria;

import java.util.LinkedList;

public class Referencia implements Interface_Referencia{
    int ID_Proceso;
    int Direccion_Referencia;
    String Accion; //Se refiere a que si escribe o lee

    public Referencia(int ID_Proceso, int Direccion_Referencia, String Accion) {
        this.ID_Proceso = ID_Proceso;
        this.Direccion_Referencia = Direccion_Referencia;
        this.Accion = Accion;
    }
    
    public int ID_Proceso(){
        return ID_Proceso;
    }
    
   public int Numero_Direccion_Referencia(){
       return Direccion_Referencia;
   }   
   public String Tipo_de_Accion(){//escritura o lectura
       return Accion;
   }
   
}
