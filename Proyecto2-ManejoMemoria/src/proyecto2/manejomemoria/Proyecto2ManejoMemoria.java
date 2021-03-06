package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Proyecto2ManejoMemoria {
     
    public static void main(String[] args) throws IOException{
       Manejo_de_Archivos Manejo_Archivos= new Manejo_de_Archivos();
       DTO COnf= new DTO( "Bajo Demanda", "Primero Disponible", "FIFO", "Bajo Demanda", 2, "Fijo", 2, 4, 2, "Local", 5, 3, 250, 32, 12, "K");
       COnf.Agregar_Archivos( "C:\\Users\\paola\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\Procesos.txt",
        "C:\\Users\\paola\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\Referencias.txt");
//Abre el archivo y toma los datosC:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Proyecto2-ManejoMemoria\\src\\proyecto2\\manejomemoria\\
       LinkedList L= Manejo_Archivos.Leer_archivo(COnf.Nombre_Archivo_Procesos);
       //crea la lista de procesos
       Manejo_Archivos.Crear_Procesos(L,COnf);
       LinkedHashMap <Integer, Interface_Proceso> R= COnf.Lista_Procesos;
       Iterator e= R.keySet().iterator();
       while(e.hasNext()){
           Integer key=(int)e.next();
           System.out.println("ID proceso: "+R.get(key).ID_Proceso()+
                   "  Nombre proceso "+ R.get(key).Nombre_Proceso()+
                   " Tamano "+R.get(key).Tamaño_Total_Proceso()+
                   "  Prioridad "+R.get(key).Prioridad_Proceso()+
                   "  Es bloqueado "+R.get(key).Es_Bloqueado_Proceso()+
                   "Color: "+R.get(key).Retornar_Color());     
       }
       LinkedList referencias=Manejo_Archivos.Leer_archivo(COnf.Nombre_Archivo_Referencias);
       Manejo_Archivos.Crear_Referencias(referencias,COnf);
       LinkedList <Interface_Referencia> Q= COnf.Lista_Referencias;
       for (int i = 0; i < Q.size(); i++) {
            System.out.println(Q.get(i).ID_Proceso()+" "+Q.get(i).Numero_Direccion_Referencia()+" "+Q.get(i).Tipo_de_Accion());
        }

    //crear el mapa virtual
        Memoria_Virtual V= new Memoria_Virtual(COnf);
       
        V.Crear_Memoria_Virtual();
         System.out.println(COnf.Memoria_Virtual.get(0).ID_Proceso);
        V.Recorrer_Lista_Procesos_Asinar_Memoria_Virtual();
        
        
        Controlador C= new Controlador(COnf);
        C.Inicio_del_Programa();
        //PRUEBA PARA RECUPERACION
        /*Politica_Recuperacion PR= new Politica_Recuperacion(COnf);
        PR.Prepaginacion();*/
        /*for (int i = 0; i < COnf.Memoria_Virtual.size(); i++) {
             System.out.println(COnf.Memoria_Virtual.get(i).ID_Proceso);
        }*/
       
        /*Imprime.imprime_lista_memoria_virtual();
        Imprime.imprime_lista_procesos();*/
        //Imprime paginas
       /*LinkedHashMap <String,Paginas>M=COnf.Memoria_Virtual;
       Iterator ii= M.keySet().iterator();
       while(ii.hasNext()){
           String key=(String)ii.next();
           System.out.println("ID pagina: "+M.get(key).ID_Pagina);
            System.out.println("ID proceso: "+M.get(key).ID_Proceso);
  
           }*/       
              
    }  
       

}