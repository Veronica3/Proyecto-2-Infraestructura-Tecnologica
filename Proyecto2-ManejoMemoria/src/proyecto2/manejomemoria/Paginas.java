
package proyecto2.manejomemoria;


public class Paginas {
    int ID;
    int ID_Proceso;
    int Tamaño;
    boolean Bit_Presente=false;
    //boolean Bit_Modificado=false;
    //Bit_Accedido para Algoritmo de reemplazo MENOS USADO RECIENTEMENTE (LRU)
    
    public Paginas() {
    }
    
    public Paginas(int ID, int ID_Proceso, int Tamaño) {
        this.ID = ID;
        this.ID_Proceso = ID_Proceso;
        this.Tamaño = Tamaño;

    }
    
    
    
    
    
}
