
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
        int NReferencia= Referencia.Numero_Direccion_Referencia();//la referencia esta en bytes        
        int dividendo= Configuracion.Total_Tamaño_Pagina_Memoria*1024;//convertir de KB a B
        int Pagina= NReferencia/dividendo;
        int Desplazamiento= NReferencia%dividendo;
        ResultadoL.add(Referencia.ID_Proceso());//Almacena el id del proceso
        ResultadoL.add(Pagina);//almacena el numero de página
        ResultadoL.add(Desplazamiento);//almacena el desplazamiento 
        return ResultadoL;       
    }
}
