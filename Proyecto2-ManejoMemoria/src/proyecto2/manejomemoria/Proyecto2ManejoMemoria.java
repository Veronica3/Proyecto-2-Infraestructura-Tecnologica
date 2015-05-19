package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Proyecto2ManejoMemoria {

    
    public static void main(String[] args) throws IOException{
       Manejo_de_Archivos A= new Manejo_de_Archivos();
       //Abre el archivo y toma los datos
       LinkedList L= A.Leer_archivo("C:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\Procesos.txt");
       //crea la lista de procesos
       LinkedHashMap <Integer, Interface_Proceso> R= A.Crear_Procesos(L);  
        Iterator e= R.keySet().iterator();
       while(e.hasNext()){
           Integer key=(int)e.next();
           System.out.println("ID pagina: "+R.get(key).ID_Proceso()+" Tamano "+R.get(key).Tamaño_Total_Proceso());     
       }
       LinkedList Referencia= A.Leer_archivo("C:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\Referencias.txt");
       //crea la lista de procesos
       DTO COnf= new DTO("olitica_Recuperacion", "Politica_Ubicacion","Politica_Reemplazo","Politica_Limpieza","Tamaño_Conjunto","Ambito_Reemplazo", "Control_Limpieza", 9, 5,50);
       Referencia referencia= new Referencia(1, 250670, "r");
       LinkedList QA= referencia.Realizar_Conversion_de_Referencias(COnf, referencia);
        System.out.println(QA.get(0)+" "+QA.get(1)+" "+QA.get(2));
        int s= 50*1024;
        System.out.println(250670%s);
       
    }
       /*LinkedList <Interface_Referencia> Q= A.Crear_Referencias(Referencia, R);
       for (int i = 0; i < Q.size(); i++) {
            System.out.println(Q.get(i).ID_Proceso()+" "+Q.get(i).Numero_Direccion_Referencia()+" "+Q.get(i).Tipo_de_Accion());
        }*/
    //crear el mapa virtual
     /*  Memoria_Virtual V= new Memoria_Virtual();
       
       LinkedHashMap <String,Paginas>M=V.Crear_Memoria_Virtual(R, COnf);
       Iterator ii= M.keySet().iterator();
       while(ii.hasNext()){
           String key=(String)ii.next();
           System.out.println("ID pagina: "+M.get(key).ID_Pagina);
            System.out.println("ID proceso: "+M.get(key).ID_Proceso);
             System.out.println("Inicio Memoria: "+M.get(key).InicioMemoria);
              System.out.println("Final Memoria: "+M.get(key).FinalMemoria);
  
           }
       //Falta crear el metodo que lee las referencias
    }  */ 
       

}
