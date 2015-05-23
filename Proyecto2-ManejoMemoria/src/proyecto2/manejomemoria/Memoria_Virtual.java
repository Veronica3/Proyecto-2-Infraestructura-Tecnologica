
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
        //recorro la lista de procesos
         LinkedHashMap <Integer, Interface_Proceso> R= Informacion_Configuracion.Lista_Procesos;
        Iterator e= R.keySet().iterator();
       while(e.hasNext()){//recorro lista de procesos 
           Integer key=(int)e.next();
            if (Informacion_Configuracion.Memoria_Virtual.isEmpty()){ //inicializo las variables
                Asignar_Cantidad_Paginas_Memoria_Virtual();//asigna a la variable del DTO la info
                Asignar_Total_Tamaño_Pagina_Memoria_Virtual();//asigna a la variable del DTO la info
            }
            
            if (Almaceno_Proceso_en_Memoria_Virtual(R.get(key).Tamaño_Total_Proceso())){//verifica que el proceso se pueda 
                //almacenar en  memoria virtual 
                    Crear_Paginas(R.get(key));//crea las páginas y se las asigna al proceso
                }
        }
       
    }   
    //Pregunta si se puede almacenar proceso en memoria virtual, debido al tamaño de memoria que requiere
    public boolean Almaceno_Proceso_en_Memoria_Virtual(int Tamaño_Proceso){
        
        if(Informacion_Configuracion.Cantidad_Total_Paginas_Memoria_Virtual>Informacion_Configuracion.Memoria_Virtual.size()){
               double Convertir_Tamaño_Proceso= Tamaño_Proceso*1024; // paso de KB a B, la memoria total requerida
               //saber en cuantas paginas almaceno el proceso
               double Cantidad_Paginas=Convertir_Tamaño_Proceso/Informacion_Configuracion.Total_Tamaño_Pagina_Memoria_Virtual;
               double Suma= Cantidad_Paginas+Informacion_Configuracion.Memoria_Virtual.size();
               if (Informacion_Configuracion.Cantidad_Total_Paginas_Memoria_Virtual>Suma){
                    return true;
               }
               else{
                   return false;//no cabe en memoria virtual 
               }
               
        }
        else{
            return false;// no cabe en memoria virtual
        }
    }
    //Crea las paginas que se le asignnaran a cada proceso en memoria virtual
    private void Crear_Paginas(Interface_Proceso Proceso){
        double Convertir_Tamaño_Proceso= Proceso.Tamaño_Total_Proceso()*1024; // paso de KB a B, la memoria total requerida
            //saber en cuantas paginas almaceno el proceso
        double Cantidad_Paginas=Convertir_Tamaño_Proceso/Informacion_Configuracion.Total_Tamaño_Pagina_Memoria_Virtual;
        Paginas Pagina;
        int ID_Pagina=0;
        for (int i = 0; i <Cantidad_Paginas ; i++) {
            Pagina= new Paginas(ID_Pagina, Proceso.ID_Proceso()); 
            Informacion_Configuracion.Memoria_Virtual.put(Proceso.ID_Proceso()+"_"+ID_Pagina, Pagina);
            ID_Pagina++;
        }
}        

        
    //Metodo que almacena la cantidad de paginas que se almacenan en memoria virtual
    private void Asignar_Cantidad_Paginas_Memoria_Virtual(){
        int Total_Paginas=Informacion_Configuracion.Bits-Informacion_Configuracion.Tamaño_Paginas;
        Informacion_Configuracion.Cantidad_Total_Paginas_Memoria_Virtual= Math.pow(2,Total_Paginas);
        
    }
    //Método que almacena el tamaño total de las paginas
    private void Asignar_Total_Tamaño_Pagina_Memoria_Virtual(){
        Informacion_Configuracion.Total_Tamaño_Pagina_Memoria_Virtual= Math.pow(2,Informacion_Configuracion.Tamaño_Paginas);//indica el tamaño de la pagina 
    }
}


