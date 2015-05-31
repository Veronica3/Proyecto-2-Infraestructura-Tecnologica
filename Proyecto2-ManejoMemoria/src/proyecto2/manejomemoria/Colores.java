
package proyecto2.manejomemoria;
import java.awt.Color;
import java.util.Random;
import java.util.*;

public class Colores {

    public Colores() {
    }
    public Color Crear_Color(LinkedHashMap<Integer,Interface_Proceso> ListaProceso){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        if (Existe_Color(randomColor, ListaProceso)){
            return Crear_Color(ListaProceso);
        }
        else{
            return randomColor;
        }
    }    
    private boolean Existe_Color(Color color, LinkedHashMap<Integer,Interface_Proceso> ListaProceso){
      if (ListaProceso.isEmpty()){
            return false;
        }
        else{
            Iterator e= ListaProceso.keySet().iterator();
            while(e.hasNext()){
                Integer key=(int)e.next();
                if(ListaProceso.get(key).Retornar_Color()==color){
                    return true;
            }           
        }
            return false;
    }
   }
    
}

