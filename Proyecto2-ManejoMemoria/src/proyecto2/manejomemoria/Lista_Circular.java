
package proyecto2.manejomemoria;

public class Lista_Circular {
    class Nodo {
        Paginas informacion;
        Nodo anterior,siguiente;
    }
    
    private Nodo Raiz;
    
    public Lista_Circular () {
        Raiz=null;
    }
              
  /*public void Ingresar_Primero(int Nuevo) {
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
    */
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
    
    public boolean Lista_Vacia ()
    {
        if (Raiz == null)
            return true;
        else
            return false;
    }
    
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
    //Busca dentro de la lista circular la pagina a reemplazar y retorna su indice
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
