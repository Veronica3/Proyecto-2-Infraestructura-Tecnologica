
package proyecto2.manejomemoria;


public class Marco {
    int ID_Marco;
    int Tamaño;
    int Inicio;
    int Final;
    Paginas Pagina; //con Pagina==null valido que el marco esta vacio??
    boolean Bloqueado; // Pagina 362 > Si el marco esta bloquado no se puede reemplazar la pag
    boolean Modificado;

    public Marco() {
    }
    
    public Marco(int ID_Marco, int Tamaño, int Inicio, int Final, Paginas Pagina) {
        this.ID_Marco = ID_Marco;
        this.Tamaño = Tamaño;
        this.Inicio = Inicio;
        this.Final = Final;
        this.Pagina = Pagina;
    }
    
    
}
