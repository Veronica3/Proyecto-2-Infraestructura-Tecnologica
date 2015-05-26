
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
 
    public void Crear_Memoria_Virtual(){
        //Creo la lista que contiene la memoria virtual
        Paginas Pagina;
        for (int i = 0; i < Informacion_Configuracion.Cantidad_Total_Paginas_Memoria_Virtual; i++) {
              Pagina= new Paginas(0,0); 
              Informacion_Configuracion.Memoria_Virtual.add(Pagina);
                       
        }
    }
    //Metodo que recorre la lista de procesos y asigna al proceso las paginas
    public void Recorrer_Lista_Procesos_Asinar_Memoria_Virtual(){
         LinkedHashMap <Integer, Interface_Proceso> R= Informacion_Configuracion.Lista_Procesos;
        Iterator e= R.keySet().iterator();
       while(e.hasNext()){
           Integer key=(int)e.next();
            Asignar_Paginas_Proceso(R.get(key));
            
        }
    }
       private int Cantidad_Paginas_Proceso(Interface_Proceso Proceso){
         int Convertir_Tamaño_Proceso= Proceso.Tamaño_Total_Proceso(); // paso de KB, la memoria total requerida
                //saber en cuantas paginas almaceno el proceso
            int Cantidad_Paginas;
            double tamaño=Convertir_Tamaño_Proceso/Informacion_Configuracion.Total_Tamaño_Pagina_Memoria;
            if ((Convertir_Tamaño_Proceso%Informacion_Configuracion.Total_Tamaño_Pagina_Memoria)==0){
                Cantidad_Paginas=(int)tamaño;
            }
            else{
                Cantidad_Paginas=(int)tamaño+1;
            }
            return Cantidad_Paginas;
       }
        //Funcion que asigna al proceso la cantidad de paginas que requiere
     //Validar que exista las páginas libres que requiera 
      private void Asignar_Paginas_Proceso(Interface_Proceso Proceso){
        int Cantidad_Paginas= Cantidad_Paginas_Proceso(Proceso);
        Paginas Pagina;
        int ID_Pagina=0;
        for (int i = 0; i <Cantidad_Paginas ; i++) {
            Pagina= Retornar_Pagina_Desocupada();
            if (Pagina!=null){//significa que la pagina está desocupada y lasogno
            Pagina.ID_Proceso= Proceso.ID_Proceso(); 
            Pagina.ID_Pagina=ID_Pagina;
            ID_Pagina++;
            }
            else{
                break; //la memoria virtual ya esta llena
            }
        }
        
}        
     //Función que busca el primer elemento en memoria virtual que no este asignado a algún proceso
      private Paginas Retornar_Pagina_Desocupada(){
          //recorre toda la lista de memoria virtual 
          for (int i = 0; i < Informacion_Configuracion.Memoria_Virtual.size(); i++) {
              //l primera pagina que encuentre desocupada la retorna
              if ( Informacion_Configuracion.Memoria_Virtual.get(i).ID_Proceso==0){
                  return Informacion_Configuracion.Memoria_Virtual.get(i);
              }                 
          }
          return null;
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


