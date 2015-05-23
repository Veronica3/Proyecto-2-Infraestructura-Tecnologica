
package proyecto2.manejomemoria;
import java.util.*;
public class Memoria_Fisica {

    public Memoria_Fisica() {
    }
    
    /*Controla la creacion de la memoria fisica,busca la cantidad de columnas y filas que necesita 
    y verifica que se encuentre completa seg[un lo especificado en el DTO*/
       
    public void Controla_Memoria_Fisica(DTO DTO){
        int cantidad_paginas=(int) DTO.Tamaño_Memoria_Fisica/DTO.Tamaño_Paginas;
        int tamaño_Columna = (int) Math.floor(Math.sqrt(cantidad_paginas));
        int tamaño_Fila=Ajusta_Cantidad_Filas(tamaño_Columna, cantidad_paginas);
        Crea_Matriz(tamaño_Columna, tamaño_Fila, DTO,0);
        int Columnas_Faltantes=cantidad_paginas-(tamaño_Columna*tamaño_Fila);
        System.out.println(Columnas_Faltantes);
        System.out.println(tamaño_Fila);
        Crea_Matriz(Columnas_Faltantes, 1, DTO,DTO.Memoria_Fisica.size());
        
        for (int i = 0; i < DTO.Memoria_Fisica.size(); i++) {
            for (int j = 0; j < DTO.Memoria_Fisica.get(i).size(); j++) {
                System.out.print(j);
            }
        }    
    }
    //Crea la Matriz de la MemariaFisica, seg[un las columnas y las filas que se le manden
    private void Crea_Matriz(int Tamaño_Columna,int Tamaño_Fila,DTO DTO,int Tamaño_general ){   
        for (int i = 0; i < Tamaño_Fila; i++) {
            DTO.Memoria_Fisica.put(Tamaño_general+i, new LinkedHashMap<Integer,Marco>());
            for (int j = 0; j < Tamaño_Columna; j++) {
                DTO.Memoria_Fisica.get(Tamaño_general+i).put(j, null);
                        }
        }
    }
    // Se encarga de sumarle una a las filas o dejarla igual que las columnas, esto para que sean menos las faltantes.
    private int Ajusta_Cantidad_Filas(int Tamaño_Columna,int cantidad_paginas ){
        int Total_Actual=Tamaño_Columna*(Tamaño_Columna+1);
        if(Total_Actual<cantidad_paginas){
            return Tamaño_Columna+1;
        }
        else{
            return Tamaño_Columna;
        }
    }
    
}
