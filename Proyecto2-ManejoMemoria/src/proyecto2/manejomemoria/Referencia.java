
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
   
   /*Función que lee la referencia y retorna la dirección el id del proceso, la página y el desplazamiento
   */
   public LinkedList Realizar_Conversion_de_Referencias(DTO Configuracion, Referencia Referencia){
        LinkedList <Integer> ResultadoL= new LinkedList();
        int NReferencia= Referencia.Numero_Direccion_Referencia();
        int dividendo= (Configuracion.Tamaño_Paginas*1024);
        int Cociente= NReferencia/dividendo;
        int Residuo= NReferencia%dividendo;
        ResultadoL.add(Referencia.ID_Proceso());//Almacena el id del proceso
        ResultadoL.add(Cociente);//almacena el numero de página
        ResultadoL.add(Residuo);//almacena el desplazamiento 
        return ResultadoL;       
    }
}
