package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Proyecto2ManejoMemoria {
     
    public static void main(String[] args) throws IOException{
       Manejo_de_Archivos A= new Manejo_de_Archivos();
        DTO COnf= new DTO( "Politica_Recuperacion", "Politica_Ubicacion", "Politica_Reemplazo", "Politica_Limpieza",4, "Tamaño_Conjunto",  2, 5,3,"Ambito_Reemplazo", 5, 4,250,32,10, "K");
        COnf.Agregar_Archivos( "C:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\Procesos.txt",
        "C:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\Referencias.txt");
//Abre el archivo y toma los datosC:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\
       LinkedList L= A.Leer_archivo(COnf.Nombre_Archivo_Procesos);
       //crea la lista de procesos
       A.Crear_Procesos(L,COnf);
      LinkedHashMap <Integer, Interface_Proceso> R= COnf.Lista_Procesos;
        Iterator e= R.keySet().iterator();
       while(e.hasNext()){
           Integer key=(int)e.next();
           System.out.println("ID proceso: "+R.get(key).ID_Proceso()+
                   "  Nombre proceso "+ R.get(key).Nombre_Proceso()+
                   " Tamano "+R.get(key).Tamaño_Total_Proceso()+
                   "  Prioridad "+R.get(key).Prioridad_Proceso()+
                   "  Es bloqueado "+R.get(key).Es_Bloqueado_Proceso());     
       }
       LinkedList referencias=A.Leer_archivo(COnf.Nombre_Archivo_Referencias);
       A.Crear_Referencias(referencias,COnf);
       LinkedList <Interface_Referencia> Q= COnf.Lista_Referencias;
       for (int i = 0; i < Q.size(); i++) {
            System.out.println(Q.get(i).ID_Proceso()+" "+Q.get(i).Numero_Direccion_Referencia()+" "+Q.get(i).Tipo_de_Accion());
        }
    //crear el mapa virtual
     Memoria_Virtual V= new Memoria_Virtual(COnf);
       V.Crear_Memoria_Virtual();
        System.out.println(COnf.Bits);
        System.out.println(COnf.Tamaño_Paginas);
        System.out.println(COnf.Cantidad_Total_Paginas_Memoria_Virtual);
        System.out.println(COnf.Total_Tamaño_Pagina_Memoria);
        //Imprime paginas
       /*LinkedHashMap <String,Paginas>M=COnf.Memoria_Virtual;
       Iterator ii= M.keySet().iterator();
       while(ii.hasNext()){
           String key=(String)ii.next();
           System.out.println("ID pagina: "+M.get(key).ID_Pagina);
            System.out.println("ID proceso: "+M.get(key).ID_Proceso);
  
           }*/
       //Falta crear el metodo que lee las referencias
        
              
    }  
       

}