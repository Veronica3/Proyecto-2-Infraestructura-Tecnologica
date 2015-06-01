
package proyecto2.manejomemoria;
import java.util.*;

public class Lista_Circular {
    class Nodo {
        Paginas informacion;
        Nodo anterior,siguiente;
    }
    
    private Nodo Raiz;
    
    public Lista_Circular () {
        Raiz=null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////          
    public void Ingresar_Primero(Paginas Nuevo) {
        Nodo Nuevo_Nodo=new Nodo();
        Nuevo_Nodo.informacion=Nuevo;
        if (Raiz==null) {
            Nuevo_Nodo.siguiente=Nuevo_Nodo;
            Nuevo_Nodo.anterior=Nuevo_Nodo;            
            Raiz=Nuevo_Nodo;
        } else {
            Nodo Ultimo=Raiz.anterior;
            Nuevo_Nodo.siguiente=Raiz;
            Nuevo_Nodo.anterior=Ultimo;
            Raiz.anterior=Nuevo_Nodo;
            Ultimo.siguiente=Nuevo_Nodo;
            Raiz=Nuevo_Nodo;
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    public void Ingresar_Ultimo(Paginas Nuevo) {
        Nodo Nuevo_Nodo=new Nodo();
        Nuevo_Nodo.informacion=Nuevo;
        if (Raiz==null) {
            Nuevo_Nodo.siguiente=Nuevo_Nodo;
            Nuevo_Nodo.anterior=Nuevo_Nodo;            
            Raiz=Nuevo_Nodo;
        } else {
            Nodo Ultimo=Raiz.anterior;
            Nuevo_Nodo.siguiente=Raiz;
            Nuevo_Nodo.anterior=Ultimo;
            Raiz.anterior=Nuevo_Nodo;
            Ultimo.siguiente=Nuevo_Nodo;
        }
    }    
    //////////////////////////////////////////////////////////////////////////////////////////
    public boolean Lista_Vacia ()
    {
        if (Raiz == null)
            return true;
        else
            return false;
    }
   ////////////////////////////////////////////////////////////////////////////////////////// 
    public void Imprimir_Lista ()
    {
        if (!Lista_Vacia()) {
            Nodo Recorrido=Raiz;
            do {
                System.out.print (Recorrido.informacion + "-");
                Recorrido = Recorrido.siguiente;                
            } while (Recorrido!=Raiz);
            System.out.println();
        }    
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //Cuenta la cantidad de paginas/elemnetos en la lista
    public int Largo_de_Lista ()
    {
        int cantidad = 0;
        if (!Lista_Vacia()) {
            Nodo Recorrido=Raiz;
            do {
                cantidad++;
                Recorrido = Recorrido.siguiente;                
            } while (Recorrido!=Raiz);
        }    
        return cantidad;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public void Cambiar_Bit_Modificado(Paginas Pagina_Referenciada){
        
        if (!Lista_Vacia()) {
            Nodo Recorrido=Raiz;
            while(Recorrido!=Raiz){
                 
                if (Recorrido.informacion.ID_Pagina==Pagina_Referenciada.ID_Pagina){
                   Recorrido.informacion.Bit_Modificado=1;
                }
                else
                    Recorrido = Recorrido.siguiente;    
            }
        }
    } 
    //////////////////////////////////////////////////////////////////////////////////////////
    public int Indice_Pagina_A_Reemplazar(Paginas Pagina_A_Reemplazar){
        int indice= 0;
        if (!Lista_Vacia()) {
            Nodo Recorrido=Raiz;
            while(Recorrido!=Raiz){
                 
                if (Recorrido.informacion.ID_Pagina==Pagina_A_Reemplazar.ID_Pagina){
                   return  indice;
                }
                else{
                    indice+=1;
                    Recorrido = Recorrido.siguiente;    
                }
            }
            return -1;
        }
        return -1;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //Busca dentro de la lista circular la pagina a reemplazar y retorna su indice
    public int ID_Marco_De_Pagina_A_Reemplazar( LinkedList<Marco> Lista_Marcos_A){
        
        if (!Lista_Vacia()) {
            boolean NoEncontrado=true;
            Nodo Recorrido=Raiz;
            while(NoEncontrado){
               for (int j = 0; j < Lista_Marcos_A.size(); j++) {  //Ingresa a lista de marcos en los cuales compara cada pagina con todas las del marco
                    
                    if (Recorrido.informacion.ID_Pagina==Lista_Marcos_A.get(j).Pagina.ID_Pagina
                       && Recorrido.informacion.ID_Proceso==Lista_Marcos_A.get(j).Pagina.ID_Proceso && Recorrido.informacion.Bit_Modificado==0){
                       Borrar_Elemento(Indice_Pagina_A_Reemplazar(Recorrido.informacion));
                       return  Lista_Marcos_A.get(j).ID_Marco;
                    } 
                }
                Recorrido.informacion.Bit_Modificado=0; //Coloca bit de modificado en 0 para segunda oportunidad
                Recorrido = Recorrido.siguiente;  //Paso a buscar a la siguiente pagina   
                    
            }
            return -1;
        }
        return -1;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////
    public void Borrar_Elemento (int Posicion)
    {
        if (Posicion <= Largo_de_Lista ())    {
            if (Posicion == 1) {
                if (Largo_de_Lista()==1) {
                    Raiz=null;
                } 
                else {
                    Nodo Ultimo=Raiz.anterior;    
                    Raiz = Raiz.siguiente;
                    Ultimo.siguiente=Raiz;
                    Raiz.anterior=Ultimo;
                } 
            } 
            else {
                Nodo Recorrido = Raiz;
                for (int f = 1 ; f <= Posicion - 1 ; f++)
                    Recorrido = Recorrido.siguiente;
                Nodo anteriorerior = Recorrido.anterior;
                Recorrido=Recorrido.siguiente;
                anteriorerior.siguiente=Recorrido;
                Recorrido.anterior=anteriorerior;
            }
        }
    }
}
