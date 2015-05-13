package proyecto2.manejomemoria;
import java.io.*;
import java.util.*;

//Clase que realiza las funciones de gestion de un archivo de texto
public class Manejo_de_Archivos {

    public Manejo_de_Archivos() { //Constructor 
    }
    
    //metodo que lee el archivo de texto
    public LinkedList Leer_archivo(String NombreArchivo) throws FileNotFoundException, IOException {
        String linea_de_texto;
        LinkedList <String> Informacion_de_Archivo= new LinkedList(); //lista que contiene la información del archivo de texto
        FileReader abrirArchivo= new FileReader(NombreArchivo);//Abre el archivo de texto
        BufferedReader linea = new BufferedReader(abrirArchivo);//objeto que permitira leer lineas del archivo
        
        while((linea_de_texto = linea.readLine())!=null) {
                Informacion_de_Archivo.add(linea_de_texto);
        }
        
        linea.close(); //se cierrra el archivo de texto
        return Informacion_de_Archivo; // se retorna la lista con los datos
    
    }
    
    //metodo que crea los procesos de acuerdo a los datos obtenidos en el archivo de texto
    public LinkedList Crear_Procesos(LinkedList Informacion_de_Archivo){
        LinkedList <Proceso> LProcesos = new LinkedList();
        if (Informacion_de_Archivo.isEmpty()) //si la lista está vacía significa que no tiene procesos
            return null;
        else {
            for (int i = 0; i < Informacion_de_Archivo.size(); i++) {//recorre la lista de elementos
                
                
            }
        
        }
        
        return LProcesos;
    }
}
