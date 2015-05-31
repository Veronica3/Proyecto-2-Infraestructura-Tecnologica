
package proyecto2.manejomemoria;

import java.text.SimpleDateFormat;
import java.util.*;

public class Politica_Limpieza {
    Timer timer;
    DTO Estructura_DTO;
    boolean Fin_Tarea;
    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
    Calendar calendario1;
    Calendar calendario2;
    Añadir_a_Bitacora Bitacora;
/////////////////////////////////////////////////////////////////////////////////////  
   //Constructor para DEMANDA
    public Politica_Limpieza(DTO Estructura) {
        Estructura_DTO=Estructura;
        Bitacora= new Añadir_a_Bitacora(Estructura_DTO);
    }
/////////////////////////////////////////////////////////////////////////////////////  
    public Politica_Limpieza(int n, DTO Estructura) {
        Estructura_DTO = Estructura;
        Bitacora= new Añadir_a_Bitacora(Estructura_DTO);
        timer= new Timer();
        timer.schedule(new Pre_Limpieza(), 0, /*Estructura_DTO.Tiempo_de_Limpieza*/1000);
    }
/////////////////////////////////////////////////////////////////////////////////////      
    //Cuando se hace reemplazo
    public void Limpieza_Por_Demanda(Paginas Pagina_Para_Limpieza){
        calendario1 = Calendar.getInstance();//Obtiene el tiempo de ahorita para la bitacora
        String Sentencia="Tiempo de limpieza: "+formato.format(calendario1.getTime())+"\nIniciando Limpieza. . .\n";
        Bitacora.Añadir_Accion_A_Bitacora(Sentencia);//Agrego accion a bitacora
       
        Pagina_Para_Limpieza.Bit_Suciedad=0; //Cambio el bit de suciedad 
        
        String Sentencia2=("\nLimpieza Finalizada de Página: " +Pagina_Para_Limpieza.ID_Pagina + " del proceso: " + Pagina_Para_Limpieza.ID_Proceso);
        Bitacora.Añadir_Accion_A_Bitacora(Sentencia2);//Agrego accion a bitacora
    }
/////////////////////////////////////////////////////////////////////////////////////    
    //Cada cierto tiempo
    class Pre_Limpieza extends TimerTask{
        
        //Funcion RUN que se sobreescribe
        public void run(){
            //Si ya finalizó el programa se cancela el timer
            if(Fin_Tarea){
                timer.cancel();
            }
            //Mientras no haya terminado se sigue ejecutando
            else{
                calendario2 = Calendar.getInstance();
                if (Estructura_DTO.Lista_Paginas_En_Memoria_Principal.isEmpty()){
                    String Sentencia=("Tiempo de limpieza: "+formato.format(calendario2.getTime())+"\nIniciando Limpieza. . .\n"
                            + "No hay paginas en memoria principal\n");
                    Bitacora.Añadir_Accion_A_Bitacora(Sentencia);//Agrego accion a bitacora
                    
                    }
                else {
                    String Sentencia=("Tiempo de limpieza: "+formato.format(calendario2.getTime())+"\nIniciando Limpieza. . .\n");
                    Bitacora.Añadir_Accion_A_Bitacora(Sentencia);//Agrego accion a bitacora
                    
                    LinkedList<Marco> Memoria_Fisica=Estructura_DTO.Memoria_Fisica;//Cambia el bit de suciedad de todas las paginas  de la memoria fisica 
                    for (int i = 0; i < Memoria_Fisica.size(); i++) {
                       Memoria_Fisica.get(i).Pagina.Bit_Suciedad=0;
                    }
                    String Sentencia2=("Se ejecutó limpieza de paginas correctamente\n");
                    Bitacora.Añadir_Accion_A_Bitacora(Sentencia2);
                
                }
            }
        }
        
    }
}
