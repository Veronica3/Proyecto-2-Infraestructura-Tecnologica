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
            if (!linea_de_texto.equals("")){//evita agregar los saltos de linea
               Informacion_de_Archivo.add(linea_de_texto);
            }
        }
        
        linea.close(); //se cierrra el archivo de texto
        return Informacion_de_Archivo; // se retorna la lista con los datos
    }
    
    //metodo que crea los procesos de acuerdo a los datos obtenidos en el archivo de texto
    public LinkedList Crear_Procesos(LinkedList Informacion_de_Archivo){
        LinkedList <Interface_Proceso> LProcesos = new LinkedList();
        Interface_Proceso NuevoProceso;
        if (Informacion_de_Archivo.isEmpty()) //si la lista está vacía significa que no tiene procesos
            return null;
        else {
            for (int i = 0; i < Informacion_de_Archivo.size(); i++) {//recorre la lista de elementos
                    NuevoProceso= EsProceso(Informacion_de_Archivo.get(i).toString(), LProcesos);
                    if(NuevoProceso!= null){
                            LProcesos.add(NuevoProceso);//Almacena el proceso en lista de procesos
                           }
            }       
        }
        
        return LProcesos;
    }
         
    //Funcion que recibe una línea, verifica que se cumpla con las validaciones, si se cumple crea un proceso con los datos
    private Interface_Proceso EsProceso(String Linea_Informacion, LinkedList<Interface_Proceso> LProcesos){
        Validaciones V=new Validaciones();
        String Datos_Proceso[] = Linea_Informacion.split(",");
        int ID_Proceso;
        String Nombre_Proceso;
        int Tamaño_T;
        int Prioridad;
        for (int i = 0; i < 3; i++) {
            if (!V.isNumeric(Datos_Proceso[i])){ //si el elemento que se reciba no es un numero, significa que los datos son inválidos
                return null; //el proceso no se crea
            }
            //si es numero sigue la ejecución normal
        }
        //cuando finaliza convierte los string a int y los asigna a las variables respectivas
       ID_Proceso= Integer.parseInt(Datos_Proceso[0]);
       //comprueba que el id del proceso es único
       if (V.Es_Nuevo_ID(ID_Proceso, LProcesos)){
              Tamaño_T= Integer.parseInt(Datos_Proceso[1]);
              Prioridad=Integer.parseInt(Datos_Proceso[2]);
              Nombre_Proceso=Datos_Proceso[3];
              Interface_Proceso Proceso= new Proceso(ID_Proceso, Nombre_Proceso,Prioridad,Tamaño_T);//se crea el proceso
              return Proceso;//Retorno el proceso
              
       }
       else{
            return null;//significa que el proceso no se crea
       }
    
    }
}
