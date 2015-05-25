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
    public void Crear_Procesos(LinkedList Informacion_de_Archivo, DTO Configuracion){
        LinkedHashMap LProcesos= Configuracion.Lista_Procesos;
        Interface_Proceso NuevoProceso;
        if (Informacion_de_Archivo.isEmpty()) //si la lista está vacía significa que no tiene procesos
            LProcesos.put(null,null);
        else {
            for (int i = 0; i < Informacion_de_Archivo.size(); i++) {//recorre la lista de elementos
                    NuevoProceso= EsProceso(Informacion_de_Archivo.get(i).toString(), LProcesos, Configuracion);
                    if(NuevoProceso!= null){
                            LProcesos.put(NuevoProceso.ID_Proceso(), NuevoProceso);//Almacena el proceso en lista de procesos
                           }
            }       
        }
       
    }
         
    //Funcion que recibe una línea, verifica que se cumpla con las validaciones, si se cumple crea un proceso con los datos
    private Interface_Proceso EsProceso(String Linea_Informacion, LinkedHashMap<Integer,Interface_Proceso> LProcesos, DTO Configuracion){
        Validaciones V=new Validaciones();
        String Datos_Proceso[] = Linea_Informacion.split(",");
        int ID_Proceso;
        String Nombre_Proceso;
        int Tamaño_T;
        int Prioridad;
        boolean Estado;
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
           //Validar que la prioridad este dentro de 1-5
           Prioridad=Integer.parseInt(Datos_Proceso[2]); 
           if (0<Prioridad && Prioridad<6) {
               //Valida que el proceso tenga el estado de true o false que significa si esta bloqueado
               if (V.Es_Valido_Estado(Datos_Proceso[4])){
                    Tamaño_T= Integer.parseInt(Datos_Proceso[1]);
                    Nombre_Proceso=Datos_Proceso[3];
                    Estado=Boolean.valueOf(Datos_Proceso[4]);//convierte el estado a un boolean
                    Interface_Proceso Proceso= new Proceso(ID_Proceso, Nombre_Proceso,Prioridad,Estado, Tamaño_T,Configuracion.Working_Set);//se crea el proceso
                    return Proceso;//Retorno el proceso
               }
               else{
                   return null;
               }
               
            }
           else{
               return null;
           }
              
       }
       else{
            return null;//significa que el proceso no se crea
       }
    }
    
    //metodo que crea las referencias de acuerdo a los datos obtenidos en el archivo de texto
    public void Crear_Referencias(LinkedList Informacion_de_Archivo, DTO Configuracion){
        LinkedHashMap LProceso= Configuracion.Lista_Procesos;
        LinkedList LReferencias = Configuracion.Lista_Referencias;
        Interface_Referencia NuevaReferencia;
        if (Informacion_de_Archivo.isEmpty()) //si la lista está vacía significa que no tiene procesos
            return ;
        else {
            for (int i = 0; i < Informacion_de_Archivo.size(); i++) {//recorre la lista de elementos
                    NuevaReferencia= EsReferencia(Informacion_de_Archivo.get(i).toString(), LProceso);
                    if(NuevaReferencia!= null){
                            LReferencias.add(NuevaReferencia);//Almacena el proceso en lista de procesos
                           }
            }       
        }
        
//        return LReferencias;
    }
    
     private Interface_Referencia EsReferencia(String Linea_Informacion,LinkedHashMap<Integer,Interface_Proceso> LProcesos){
        Validaciones V=new Validaciones();
        String Datos_Proceso[] = Linea_Informacion.split(",");
        int ID_Proceso;
        String Tipo_Accion;
        int Direccion_Referencia;
        for (int i = 0; i < 2; i++) {
            if (!V.isNumeric(Datos_Proceso[i])){ //si el elemento que se reciba no es un numero, significa que los datos son inválidos
                return null; //el proceso no se crea
            }
            //si es numero sigue la ejecución normal
        }
        //cuando finaliza convierte los string a int y los asigna a las variables respectivas
       ID_Proceso= Integer.parseInt(Datos_Proceso[0]);
       //comprueba que el id del proceso exista
       if ((!V.Es_Nuevo_ID(ID_Proceso, LProcesos)) && (V.Es_Valida_Accion(Datos_Proceso[2]))){
              Direccion_Referencia= Integer.parseInt(Datos_Proceso[1]);
              Tipo_Accion=Datos_Proceso[2];
              Interface_Referencia Referencia= new Referencia(ID_Proceso, Direccion_Referencia,Tipo_Accion);//se crea la referencia
              return Referencia;//Retorno la referencia
              
       }
       else{
            return null;//significa que la referencia no se crea
       }
    }
}
