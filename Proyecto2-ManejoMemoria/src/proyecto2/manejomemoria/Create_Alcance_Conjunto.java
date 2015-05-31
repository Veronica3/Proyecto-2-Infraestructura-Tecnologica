
package proyecto2.manejomemoria;

import java.util.LinkedList;


public class Create_Alcance_Conjunto {
    DTO DTO;
    Alcance_Conjunto alcance_Conjunto;

    public Create_Alcance_Conjunto(DTO DTO) {
        this.DTO = DTO;
        this.alcance_Conjunto= new Alcance_Conjunto(DTO);
    }
    
    public LinkedList<Marco> Gestion_Alcance_Conjunto(String Ambito_Reemplazo, int ID_Proceso,LinkedList<Marco> General ){
        if(Ambito_Reemplazo.equals("Global")){
            alcance_Conjunto.Ambito_Global( ID_Proceso, General);
        }
        else{
            alcance_Conjunto.Ambito_Local(ID_Proceso, General);
        }
        return General;
    } 
}

