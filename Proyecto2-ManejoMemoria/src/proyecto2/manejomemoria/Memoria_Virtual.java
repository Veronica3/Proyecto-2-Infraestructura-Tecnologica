
package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;
import java.math.*;

public class Memoria_Virtual {
            DTO Informacion_Configuracion;
    public Memoria_Virtual(DTO Informacion) {
        Informacion_Configuracion= Informacion;
          /*se crea una estructura mapa con llave valor, 
        la cual almacenara la información correspondiente al disco*/
    }
    //Metodo encargado de crear la memoria virtual
    //Validar si la memoria virtual esta vacía, si es asi pregunto si la cantidad de memoria que requiere le proceso es men
    //menor a la cantidad valida de memoria si es así voy a asignar las paginas al proceso
    //sino no lo incluyo
    public void Crear_Memoria_Virtual(){
        if (Informacion_Configuracion.Memoria_Virtual.isEmpty()){
            
        }
        /*int cantidad_paginas= (Informacion_Configuracion.Bits-Informacion_Configuracion.Tamaño_Paginas)
        if (Configuracion.Memoria_Virtual.isEmpty()){//pregunta si la memoria virtual esta vacía es el primer proceso que ingresa
            if (Excede_Tamaño())
        }
        else{
             int Tamaño_Memoria_Virtual_Actual= Configuracion.Tamaño_Paginas*Configuracion.Memoria_Virtual.size();
        if (Excede_Tamaño()){}
        LinkedHashMap<Integer,Interface_Proceso> LProcesos= Configuracion.Lista_Procesos;
        Iterator ii= LProcesos.keySet().iterator();//sirve para recorrer el mapa
       while(ii.hasNext()){
           Integer key=(int)ii.next();
           System.out.println(LProcesos.get(key).Tamaño_Total_Proceso());
           cantidad_paginas= LProcesos.get(key).Tamaño_Total_Proceso()/Configuracion.TamañoPagina();
           LProcesos.get(key).Asignar_Paginas(cantidad_paginas);
           System.out.println("Cantidad paginas: "+cantidad_paginas);
           Crear_Paginas(cantidad_paginas,LProcesos.get(key), Configuracion.Tamaño_Paginas);
       }
           }*/
    }   
    //Pregunta si se puede almacenar proceso en memoria virtual, debido al tamaño de memoria que requiere
    public boolean Almaceno_Proceso_en_Memoria_Virtual(int Tamaño){
        int Paginas_bits= Informacion_Configuracion.Bits-Informacion_Configuracion.Tamaño_Paginas;
        
        int tamaño_virtua
        double Tamaño_Total_Virtual= Math.pow(2,tamaño_virtual);
        if(Tamaño_Total_Virtual>Tamaño){
                return false;
        }
        else{
            return true;
        }
    }
    //Crea las paginas que se le asignnaran a cada proceso en memoria virtual
    private void Crear_Paginas(int cantidad_paginas, Interface_Proceso Proceso, int TamañoP){
        Paginas Pagina;
        int ID_Pagina=0;
        int InicioMemoria=0;
        int FinalMemoria=TamañoP-1;//unidad base es bits
        for (int i = 0; i < cantidad_paginas; i++) {
            Pagina= new Paginas(ID_Pagina, Proceso.ID_Proceso(),InicioMemoria,FinalMemoria, TamañoP); 
            Informacion_Configuracion.Memoria_Virtual.put(Proceso.ID_Proceso()+"_"+ID_Pagina, Pagina);
            ID_Pagina++;
            InicioMemoria=FinalMemoria+1;
            FinalMemoria=FinalMemoria+TamañoP;
            
        }
}        

}


