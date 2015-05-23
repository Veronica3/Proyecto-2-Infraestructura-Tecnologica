
package proyecto2.manejomemoria;


public class Paginas {
    int ID_Pagina;
    int ID_Proceso;
    //int InicioMemoria;
    //int FinalMemoria;
    //int Tamaño;
    //boolean Bit_Presente=false;
    int Bit_Modificado=0;
    //Bit_Accedido para Algoritmo de reemplazo MENOS USADO RECIENTEMENTE (LRU)
    
    public Paginas() {
    }
    
    public Paginas(int ID_Pagina, int ID_Proceso) {
        this.ID_Pagina = ID_Pagina;
        this.ID_Proceso = ID_Proceso;
        //this.Tamaño = Tamaño;
        //this.Bit_Presente=false;
        //this.InicioMemoria=InicioMemoria;
        //this.FinalMemoria=FinalMemoria;
     }
    
    
    
    
    
}
