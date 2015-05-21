
package proyecto2.manejomemoria;


public class Marco {
    int ID_Marco;     
    Paginas Pagina; //con Pagina==null valido que el marco esta vacio??
    int ID_Proceso_Dueño;
    boolean Modificado;

    public Marco() {
    }
    
    public Marco(int ID_Marco, int Tamaño, int Inicio, int Final, Paginas Pagina) {
        this.ID_Marco = ID_Marco;
       
        this.Pagina = Pagina;
    }
    
    
}
