
package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Validaciones {

    //Preunta si el string es de tipo numerico
    public  boolean isNumeric(String Dato){
	try {
		Integer.parseInt(Dato);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
  /* public boolean Validar_ID(String ID, LinkedList Procesos){
    
    }*/
}
