
package proyecto2.manejomemoria;

import java.util.*;

public class Politica_Limpieza {
    Timer timer;
    DTO Estructura_DTO;
    boolean Fin_Tarea;
    java.util.Date date= new java.util.Date();
/////////////////////////////////////////////////////////////////////////////////////  
   //Constructor para DEMANDA
    public Politica_Limpieza(DTO Estructura) {
        Estructura_DTO=Estructura;
        
    }
/////////////////////////////////////////////////////////////////////////////////////  
    public Politica_Limpieza(int n, DTO Estructura) {
        Estructura_DTO = Estructura;
        timer= new Timer();
        timer.schedule(new Pre_Limpieza(), 0, /*Estructura_DTO.Tiempo_de_Limpieza*/2000);
    }
/////////////////////////////////////////////////////////////////////////////////////      
    //Cuando se hace reemplazo
    public void Limpieza_Por_Demanda(Paginas Pagina_Para_Limpieza){
        Estructura_DTO.Bitacora.getLast().add("Tiempo de limpieza: "+date.getTime()+"\nIniciando Limpieza. . .\n");
        Pagina_Para_Limpieza.Bit_Suciedad=0;
        Estructura_DTO.Bitacora.getLast().add("\nLimpieza Finalizada de Página: "
                +Pagina_Para_Limpieza.ID_Pagina + " del proceso: " + Pagina_Para_Limpieza.ID_Proceso);
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
                if (Estructura_DTO.Lista_Paginas_En_Memoria_Principal.isEmpty()){
                    Estructura_DTO.Bitacora.getLast().add("Tiempo de limpieza: "+date.getTime()+"\nIniciando Limpieza. . .\n "
                            + "No hay paginas en memoria principal\n");
                    }
                else {
                    Estructura_DTO.Bitacora.getLast().add("Tiempo de limpieza: "+date.getTime()+"\nIniciando Limpieza. . .\n");
                    //Cambia el bit de suciedad de todas las paginas  de la memoria fisica 
                    LinkedList<Marco> Memoria_Fisica=Estructura_DTO.Memoria_Fisica;
                    for (int i = 0; i < Memoria_Fisica.size(); i++) {
                       Memoria_Fisica.get(i).Pagina.Bit_Suciedad=0;
                    }
                    Estructura_DTO.Bitacora.getLast().add("Se ejecutó limpieza de paginas correctamente\n");
                
                }
            }
        }
        
    }
}
