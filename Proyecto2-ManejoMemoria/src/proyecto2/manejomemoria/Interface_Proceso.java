
package proyecto2.manejomemoria;

public interface Interface_Proceso {

    public void Asignar_Paginas(int Cantidad_PaginasP);
    
    public int ID_Proceso();
    
    public String Nombre_Proceso();
    
    public int Tamaño_Total_Proceso();
    
    public int Prioridad_Proceso();
    
    public int Cantidad_Paginas();
     
    public boolean Es_Bloqueado_Proceso();
}
