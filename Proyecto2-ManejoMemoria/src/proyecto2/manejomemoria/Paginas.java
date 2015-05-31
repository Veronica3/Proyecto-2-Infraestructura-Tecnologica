
package proyecto2.manejomemoria;


public class Paginas {
    int ID_Pagina;
    int ID_Proceso;
    int Bit_Suciedad=0;
    int Bit_Modificado=0;
   
    public Paginas() {
    }
    
    public Paginas(int ID_Pagina, int ID_Proceso) {
        this.ID_Pagina = ID_Pagina;
        this.ID_Proceso = ID_Proceso;
        
     }
    
       public int get_IDPagina(){
        return ID_Pagina;
    }
    
          public int getBit_Modificado(){
             return Bit_Modificado;
    }
              public int getBit_Suciedad(){
                return Bit_Suciedad;
    }
              
    public void setBit_Modificado(int Numero){
           Bit_Modificado=Numero;
    }
    
    
    
    
}
