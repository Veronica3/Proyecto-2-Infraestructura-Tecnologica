
package proyecto2.manejomemoria;

import java.awt.Color;

public interface Interface_Proceso {

    public void Asignar_Paginas(int Cantidad_PaginasP);
    
    public int ID_Proceso();
    
    public String Nombre_Proceso();
    
    public int Tamaño_Total_Proceso();
    
    public int Prioridad_Proceso();
    
    public int Cantidad_Paginas();
    public int Working_Set();
    public boolean Es_Bloqueado_Proceso();
     public void Asignar_Color(Color C);
    
    public Color Retornar_Color();
    
    
}
