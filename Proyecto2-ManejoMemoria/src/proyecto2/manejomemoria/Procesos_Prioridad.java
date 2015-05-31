/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.manejomemoria;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 *
 * @author paola
 */
public class Procesos_Prioridad {
       
    public LinkedList<Interface_Proceso> Colas_Prioridad(Interface_Proceso Proceso,LinkedList<Interface_Proceso> Lista_Procesos){
        LinkedList<Interface_Proceso> Procesos_Prioridad;
        if(Lista_Procesos.isEmpty()){
            Lista_Procesos.add(Proceso);
        }
        else{
            if(Lista_Procesos.getLast().Prioridad_Proceso()>Proceso.Prioridad_Proceso()){
                Lista_Procesos.addLast(Proceso);
            }
            else{
                for (int i = 0; i < Lista_Procesos.size(); i++) {
                    if(Lista_Procesos.get(i).Prioridad_Proceso()<Proceso.Prioridad_Proceso()){
                        Lista_Procesos.add(i, Proceso);
                        break;
                    }
                    if(Lista_Procesos.get(i).Prioridad_Proceso()==Proceso.Prioridad_Proceso() &&( i==Lista_Procesos.size()-1)){
                       Lista_Procesos.addLast(Proceso);
                        break;
                    }
                    
                }
            }
        }
        return Lista_Procesos;
    }
    
}
