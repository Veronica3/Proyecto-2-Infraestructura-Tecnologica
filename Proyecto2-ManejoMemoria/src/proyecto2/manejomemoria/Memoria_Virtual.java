
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
        LinkedHashMap <Integer, Interface_Proceso> ListaProcesos= Informacion_Configuracion.Lista_Procesos;
        Iterator e= ListaProcesos.keySet().iterator();
       while(e.hasNext()){//recorro lista de procesos 
           Integer key=(int)e.next();
            if (Informacion_Configuracion.Memoria_Virtual.isEmpty()){ //inicializo las variables 
                //revisar
            }
            //realizo unas operaciones
            int Convertir_Tamaño_Proceso= ListaProcesos.get(key).Tamaño_Total_Proceso(); // paso de KB, la memoria total requerida
                //saber en cuantas paginas almaceno el proceso
            int Cantidad_Paginas;
            double tamaño=Convertir_Tamaño_Proceso/Informacion_Configuracion.Total_Tamaño_Pagina_Memoria;
            if ((Convertir_Tamaño_Proceso%Informacion_Configuracion.Total_Tamaño_Pagina_Memoria)==0){
                Cantidad_Paginas=(int)tamaño;
            }
            else{
                Cantidad_Paginas=(int)tamaño+1;
            }
             
            if (Almaceno_Proceso_en_Memoria_Virtual(Cantidad_Paginas)){//verifica que el proceso se pueda 
                //almacenar en  memoria virtual 
                System.out.println("Proceso: "+ListaProcesos.get(key).ID_Proceso()+ " TamañoT: "+ListaProcesos.get(key).Tamaño_Total_Proceso()
                +"Cantidad Paginas "+Cantidad_Paginas);
                 Crear_Paginas(ListaProcesos.get(key),Cantidad_Paginas);//crea las páginas y se las asigna al proceso
                }
        }
       
    }   
    //Pregunta si se puede almacenar proceso en memoria virtual, debido al tamaño de memoria que requiere
    public boolean Almaceno_Proceso_en_Memoria_Virtual(double Cantidad_Paginas){
        
        if(Informacion_Configuracion.Cantidad_Total_Paginas_Memoria_Virtual>Informacion_Configuracion.Memoria_Virtual.size()){
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
    private void Crear_Paginas(Interface_Proceso Proceso, double Cantidad_Paginas){
        Paginas Pagina;
        int ID_Pagina=0;
        for (int i = 0; i <Cantidad_Paginas ; i++) {
            Pagina= new Paginas(ID_Pagina, Proceso.ID_Proceso()); 
            Informacion_Configuracion.Memoria_Virtual.put(Proceso.ID_Proceso()+"_"+ID_Pagina, Pagina);
            ID_Pagina++;
        }
        
}        

       /*Función que lee la referencia y retorna la dirección el id del proceso, la página y el desplazamiento
   */
   public LinkedList Realizar_Conversion_de_Referencias(Interface_Referencia Referencia){
        LinkedList <Integer> ResultadoL= new LinkedList();
        int NReferencia= Referencia.Numero_Direccion_Referencia();//la referencia esta en bytes        
        int dividendo= Informacion_Configuracion.Total_Tamaño_Pagina_Memoria*1024;//convertir de KB a B
        int Pagina= NReferencia/dividendo;
        int Desplazamiento= NReferencia%dividendo;
        ResultadoL.add(Pagina);//almacena el numero de página
        ResultadoL.add(Desplazamiento);//almacena el desplazamiento 
        return ResultadoL;       
    }
        
   
}


