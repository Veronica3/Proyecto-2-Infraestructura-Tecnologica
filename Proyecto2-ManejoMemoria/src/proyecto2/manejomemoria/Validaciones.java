
package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Validaciones {

    public Validaciones() {
    }
    

    //Preunta si el string es de tipo numerico
    public  boolean isNumeric(String Dato){
	try {
		Integer.parseInt(Dato);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    //verifica que el id del proceso sea único
   public boolean Es_Nuevo_ID(int ID, LinkedList <Interface_Proceso> Procesos){
       if (Procesos.isEmpty()){ //si la lista esta vacía 
           return true;
       }
       else{
           for (int i = 0; i < Procesos.size(); i++) {
               if (Procesos.get(i).ID_Proceso()==ID){//ya existe el id
                   return false; 
               }
           }
           return true; //el id no existe
       }
    }
   //Si la accion de la referencia es escribir o leer
   public boolean Es_Valida_Accion(String Accion){
       if (Accion.equals("w")){
           return true;
       }
       if(Accion.equals("r")){
           return true;
       }
       else{
           return false;
        }
   }
}
