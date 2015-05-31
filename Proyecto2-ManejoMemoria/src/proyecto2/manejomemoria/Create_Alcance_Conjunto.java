
package proyecto2.manejomemoria;

import java.util.LinkedList;


public class Create_Alcance_Conjunto {
    Alcance_Conjunto alcance_Conjunto= new Alcance_Conjunto();
    public LinkedList<Marco> Gestion_Alcance_Conjunto(String Ambito_Reemplazo,DTO DTO, int ID_Proceso,LinkedList<Marco> General ){
        if(Ambito_Reemplazo.equals("Global")){
            alcance_Conjunto.Ambito_Global(DTO, ID_Proceso, General);
        }
        else{
            alcance_Conjunto.Ambito_Local(DTO, ID_Proceso, General);
        }
        return General;
    } 
}
