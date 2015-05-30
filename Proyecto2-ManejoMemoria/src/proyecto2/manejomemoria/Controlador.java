package proyecto2.manejomemoria;
import java.util.*;

/////////////////////////////////////////////////////////////////////
public class Controlador {
    DTO Estructura_DTO;
    Politica_Recuperacion Llamada_Politica_Recuperacion;
    Politica_Limpieza Politica_Limpieza;
    Memoria_Virtual Memoria_Virtual;
    Busca_Paginas Buscar_Pagina;
    java.util.Date date= new java.util.Date();
    
/////////////////////////////////////////////////////////////////////
    //Constructor de controlador recibe DTO por medio del cual trabajan todas las funciones
    public Controlador(DTO Estructura) {
        Estructura_DTO=Estructura;
        Memoria_Virtual= new Memoria_Virtual(Estructura_DTO);
        Llamada_Politica_Recuperacion=new Politica_Recuperacion(Estructura_DTO);
    }
    
/////////////////////////////////////////////////////////////////////    
    public void Inicio_del_Programa(){
        //Lista de Bitacora que sera guardada en la lista general
        LinkedList<String> Nueva_Bitacora= new LinkedList();
        Estructura_DTO.Bitacora.add(Nueva_Bitacora);
        //Pregunta la politica de recuperacion
        if (Estructura_DTO.Politica_Recuperacion.equals("Demanda")){
            Politica_Limpieza = new Politica_Limpieza(Estructura_DTO);
            Leer_Referencias();
        }
        else{
            Llamada_Politica_Recuperacion.Prepaginacion();
            Politica_Limpieza = new Politica_Limpieza(5,Estructura_DTO);
            //LUEGO LEO REFERENCIAS DE PROCESOS?
            Leer_Referencias();
        }
    }
/////////////////////////////////////////////////////////////////////   
    //Lee las referencias, llama a la funcion
    public String Leer_Referencias (){
       
        //Lista de Referencias NORMAL sin convertir
        LinkedList <Interface_Referencia> Lista_Referencias = Estructura_DTO.Lista_Referencias;
        int ID_Proceso_De_Pagina;
        int ID_Pagina_Referenciada;
        int Desplazamiento;
        String Accion_W_R;
        Imprimir_Para_Pruebas I= new Imprimir_Para_Pruebas(Estructura_DTO);
        //Ciclo que lee cada una de las referencias de la lista
        for (int i = 0; i < Lista_Referencias.size(); i++) {
           // I.imprime_bitacora();
            
            Interface_Referencia Referencia_Leida=Lista_Referencias.get(i); //Crea una nueva interfaz en la cual se guarda la referencia leida en ese momento
            LinkedList Pagina_Referenciada= Memoria_Virtual.Realizar_Conversion_de_Referencias(Referencia_Leida);//Llamo a la funcion de Convertir a # de pagina
           
            ID_Pagina_Referenciada = (Integer) Pagina_Referenciada.get(0);//Convierte objeto en int, correspondiente al numero de pagina ID PAGINA, ID PROCESO, DESPLAZAMIENTO y ACCION
            Desplazamiento=(Integer) Pagina_Referenciada.get(1);
            System.out.println("pagina referenciada "+ ID_Pagina_Referenciada);
            ID_Proceso_De_Pagina= Referencia_Leida.ID_Proceso(); //Agarra datos de la referencia actual
            Accion_W_R= Referencia_Leida.Tipo_de_Accion();
            
            Estructura_DTO.Bitacora.getLast().add("\t\t**Nueva Página Referenciada**\n\nID de Página: "+ID_Pagina_Referenciada+"\nID de Proceso: "
            + ID_Proceso_De_Pagina+"\nAcción a Ejecutar: "+Accion_W_R+ "\nDesplazamiento: "+Desplazamiento+ "\nTiempo: "+(date.getTime())+"\nEjecutando Referencia. . .");
            
            Buscar_Pagina= new Busca_Paginas(Estructura_DTO); //BUSCA PAGINA referenciada en la MEMORIA VIRTUAL
            Paginas Pagina_Encontrada=Buscar_Pagina.Busca_Pagina_En_Memoria_Virtual(ID_Proceso_De_Pagina,ID_Pagina_Referenciada);
            if(Pagina_Encontrada==null){
                return "La página no existe";
            }
            else
                Llamada_Politica_Recuperacion.Paginacion_Bajo_Demanda(Pagina_Encontrada); //Llama a DEMANDA  o PREPAGINACION
             
        }
        I.imprime_bitacora();
        Politica_Limpieza.Fin_Tarea=true;
        return "Lectura Exitosa";
    }
    
}