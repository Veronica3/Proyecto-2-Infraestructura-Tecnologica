
package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Memoria_Virtual {
    LinkedHashMap<String, Paginas> MemoriaVirtual;
            
    public Memoria_Virtual() {
           MemoriaVirtual= new LinkedHashMap();/*se crea una estructura mapa con llave valor, 
        la cual almacenara la información correspondiente al disco*/
    }
    //Metodo encargado de crear la memoria virtual
    public LinkedHashMap Crear_Memoria_Virtual(LinkedHashMap<Integer,Interface_Proceso> LProcesos,DTO Configuracion){
        int cantidad_paginas;
        Iterator ii= LProcesos.keySet().iterator();//sirve para recorrer el mapa
       while(ii.hasNext()){
           Integer key=(int)ii.next();
           System.out.println(LProcesos.get(key).Tamaño_Total_Proceso());
           cantidad_paginas= LProcesos.get(key).Tamaño_Total_Proceso()/Configuracion.TamañoPagina();
           LProcesos.get(key).Asignar_Paginas(cantidad_paginas);
           System.out.println("Cantidad paginas: "+cantidad_paginas);
           Crear_Paginas(cantidad_paginas,LProcesos.get(key), Configuracion.Tamaño_Paginas);

           }
       return MemoriaVirtual;
    }   
    private void Crear_Paginas(int cantidad_paginas, Interface_Proceso Proceso, int TamañoP){
        Paginas Pagina;
        int ID_Pagina=0;
        int InicioMemoria=0;
        int FinalMemoria=(TamañoP-1)*1024;
        for (int i = 0; i < cantidad_paginas; i++) {
            Pagina= new Paginas(ID_Pagina, Proceso.ID_Proceso(),InicioMemoria,FinalMemoria, TamañoP); 
            MemoriaVirtual.put(Proceso.ID_Proceso()+"_"+ID_Pagina, Pagina);
            ID_Pagina++;
            InicioMemoria=FinalMemoria+1;
            FinalMemoria=FinalMemoria+(TamañoP*1024);
            
        }
}        

}


