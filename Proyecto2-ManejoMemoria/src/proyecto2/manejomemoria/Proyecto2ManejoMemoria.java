
package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

public class Proyecto2ManejoMemoria {

    
    public static void main(String[] args) throws IOException{
       Manejo_de_Archivos A= new Manejo_de_Archivos();
       //Abre el archivo y toma los datos
       LinkedList L= A.Leer_archivo("C:\\Users\\vero0_000\\Dropbox\\Documents\\NetBeansProjects\\Proyecto-2-Infraestructura-Tecnologica\\Procesos.txt");
       //crea la lista de procesos
       LinkedList <Interface_Proceso> R= A.Crear_Procesos(L);
       for (int i = 0; i < R.size(); i++) {
            System.out.println(R.get(i).ID_Proceso()+" "+R.get(i).Nombre_Proceso()+" "+R.get(i).Prioridad_Proceso()+" "+R.get(i).Tamaño_Total_Proceso());
            System.out.println("Linea");
        }
    }
    
}
