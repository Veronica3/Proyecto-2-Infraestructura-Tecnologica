package proyecto2.manejomemoria;
import java.util.*;

public class Controlador {
    DTO Estructura_DTO;
    Politica_Recuperacion Llamada_Politica_Recuperacion;
    Memoria_Virtual Memoria_Virtual;
    Busca_Paginas Buscar_Pagina;
    //Constructor de controlador recibe DTO por medio del cual trabajan todas las funciones
    public Controlador(DTO Estructura) {
        Estructura_DTO=Estructura;
        Memoria_Virtual= new Memoria_Virtual(Estructura_DTO);
        Llamada_Politica_Recuperacion=new Politica_Recuperacion(Estructura_DTO);
    }
    
    public void Inicio_del_Programa(){
       
        if (Estructura_DTO.Politica_Recuperacion.equals("Demanda")){
            Leer_Referencias();
        }
        else{
            Llamada_Politica_Recuperacion.Prepaginacion();
            //LUEGO LEO REFERENCIAS DE PROCESOS?
            Leer_Referencias();
        }
    }
   
    //Lee las referencias, llama a la funcion
    public void Leer_Referencias (){
        //Lista de Bitacora que sera guardada en la lista general
        LinkedList<String> Nueva_Bitacora= new LinkedList();
        Estructura_DTO.Bitacora.add(Nueva_Bitacora);
        //Lista de Referencias NORMAL sin convertir
        LinkedList <Interface_Referencia> Lista_Referencias = Estructura_DTO.Lista_Referencias;
        int ID_Proceso_De_Pagina;
        int ID_Pagina_Referenciada;
        int Desplazamiento;
        String Accion_W_R;
        //Ciclo que lee cada una de las referencias de la lista
        for (int i = 0; i < Lista_Referencias.size(); i++) {
            //Crea una nueva interfaz en la cual se guarda la referencia leida en ese momento
            Interface_Referencia Referencia_Leida=Lista_Referencias.get(i);
            //Llamo a la funcion de Convertir a # de pagina
            LinkedList Pagina_Referenciada= Memoria_Virtual.Realizar_Conversion_de_Referencias(Referencia_Leida);
            //Convierte objeto en int, correspondiente al numero de pagina ID PAGINA, ID PROCESO, DESPLAZAMIENTO y ACCION
            ID_Pagina_Referenciada = (Integer) Pagina_Referenciada.get(0);
            Desplazamiento=(Integer) Pagina_Referenciada.get(1);
            //Agarra datos de la referencia actual
            ID_Proceso_De_Pagina= Referencia_Leida.ID_Proceso();
            Accion_W_R= Referencia_Leida.Tipo_de_Accion();
            
            //BUSCA PAGINA referenciada en la MEMORIA VIRTUAL
            Buscar_Pagina= new Busca_Paginas(Estructura_DTO);
            Paginas Pagina_Encontrada=Buscar_Pagina.Busca_Pagina_En_Memoria_Virtual(ID_Proceso_De_Pagina,ID_Pagina_Referenciada);
            //Llama a DEMANDA  o PREPAGINACION
            Llamada_Politica_Recuperacion.Paginacion_Bajo_Demanda(Pagina_Encontrada);
            
        // Estructura_DTO.Paginas_Referenciadas
            
        }
    }
}