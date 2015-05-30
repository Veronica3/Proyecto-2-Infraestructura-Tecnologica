
package proyecto2.manejomemoria;


public class Marco {
    int ID_Marco;     
    Paginas Pagina; //con Pagina==null valido que el marco esta vacio??
    int ID_Proceso_Dueño;
    boolean Ultimo_Colocado_Local;
    boolean Ultimo_Colocado_Global;

    public Marco() {
    }

    public Marco(int ID_Marco, Paginas Pagina, int ID_Proceso_Dueño) {
        this.ID_Marco = ID_Marco;
        this.Pagina = Pagina;
        this.ID_Proceso_Dueño = ID_Proceso_Dueño;
        Ultimo_Colocado_Global=false;
        Ultimo_Colocado_Local=false;
       
    }
    
    public int getIDMarco(){
        return ID_Marco;
    }
    
    public int getIDProceso(){
        return ID_Proceso_Dueño;
    }
    
    public Paginas getPagina(){
        return Pagina;
    }
}
