
package proyecto2.manejomemoria;
import java.util.*;


public class Politica_Ubicacion {
    

//Funcion para la asignacion de marcos 
    public void Crear_Memoria_Fisica(DTO DTO){
        int canidad_paginas=DTO.Tamaño_Memoria_Fisica/DTO.Tamaño_Paginas;
        int tamaño = (int) Math.floor(Math.sqrt(canidad_paginas));
        int Agregar= canidad_paginas-tamaño;
        for (int i = 0; i < tamaño; i++) {
            DTO.Memoria_Fisica.put(i, new LinkedHashMap<Integer,Marco>());
            for (int j = 0; j < tamaño; j++) {
                DTO.Memoria_Fisica.get(i).put(j, null);
                        }
        }
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            for (int j = 0; j < DTO.Memoria_Fisica.get(i).size(); j++) {
                System.out.print(j);
            }
        }
    }
    
    
    
}
