
package Vista_Sistema_Simulacion;
import java.awt.*;
import proyecto2.manejomemoria.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class Vista_Memoria_Fisica extends javax.swing.JFrame implements java.awt.event.ActionListener{
    private LinkedList <proyecto2.manejomemoria.Marco>Marcos;
    private proyecto2.manejomemoria.DTO InformacionDTO;
    private LinkedHashMap<Integer,proyecto2.manejomemoria.Interface_Proceso> Lista_Procesos;
    
     public void actionPerformed(ActionEvent e) {
         String Informacion="";
         String NumeroBoton= e.getActionCommand();
        if (NumeroBoton.equals("")){
            Informacion= "El marco no se encuentra asignado";
        }
        else{            
            proyecto2.manejomemoria.Marco marco;
            proyecto2.manejomemoria.Paginas Pagina;
            for (int i = 0; i < Marcos.size(); i++) {
                String MarcoID=Integer.toString(Marcos.get(i).getIDMarco());             
                if (MarcoID.equals(NumeroBoton)){
                    marco=Marcos.get(i);
                    Informacion= "Número pagina: "+marco.getIDMarco()+"\n\r Código proceso: "+marco.getIDProceso();
                    Pagina=marco.getPagina();
                    Informacion+="\n\r Bit de modificado: "+Pagina.getBit_Modificado();
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(null,Informacion,"Información Marco",JOptionPane.INFORMATION_MESSAGE);
	}
    public Vista_Memoria_Fisica(){//(proyecto2.manejomemoria.DTO InformacionDTO) {
        initComponents();
        
         Marcos= new LinkedList();
                proyecto2.manejomemoria.Paginas P1= new Paginas(1,1);
                proyecto2.manejomemoria.Paginas P2= new Paginas(2,1);
                P2.setBit_Modificado(1);
                proyecto2.manejomemoria.Paginas P4= new Paginas(4,1);
                proyecto2.manejomemoria.Paginas P5= new Paginas(5,1);
                proyecto2.manejomemoria.Paginas P6= new Paginas(6,1);
                proyecto2.manejomemoria.Paginas P3= new Paginas(3,2);
                proyecto2.manejomemoria.Marco frame1= new Marco(1, P1, 1);
                proyecto2.manejomemoria.Marco frame2= new Marco(2, P2, 1);
                proyecto2.manejomemoria.Marco frame3= new Marco(3, P3, 2);
                proyecto2.manejomemoria.Marco frame4= new Marco(4, P4, 1);
                proyecto2.manejomemoria.Marco frame5= new Marco(5, P5, 1);
                proyecto2.manejomemoria.Marco frame6= new Marco(6, P6, 1);
                proyecto2.manejomemoria.Marco frame7= new Marco(0, null, 0);
                
                Marcos.add(frame1);
                Marcos.add(frame2);
                Marcos.add(frame3);
                Marcos.add(frame4);
                Marcos.add(frame5);
                Marcos.add(frame6);
                Marcos.add(frame7);
          Lista_Procesos= new LinkedHashMap();
                proyecto2.manejomemoria.Colores C= new Colores();
                
                proyecto2.manejomemoria.Interface_Proceso Pr1= new Proceso(1,"P1",3,true,300,4);
                Pr1.Asignar_Color(C.Crear_Color(Lista_Procesos));
                Lista_Procesos.put(1,Pr1);
                 proyecto2.manejomemoria.Interface_Proceso Pr2= new Proceso(2,"P1",3,true,300,4);
                Pr2.Asignar_Color(C.Crear_Color(Lista_Procesos));
                Lista_Procesos.put(2,Pr2);
                 proyecto2.manejomemoria.Interface_Proceso Pr3= new Proceso(3,"P1",3,true,300,4);
                Pr3.Asignar_Color(C.Crear_Color(Lista_Procesos));
                Lista_Procesos.put(3,Pr3);
                
              
        JButton  Boton;//boton que representara el marco
        JPanel Panel_Memoria_Fisica = new JPanel();
        Panel_Memoria_Fisica.setLayout(new GridLayout(5,5));
        //Panel_Memoria_Fisica.setLayout(new GridLayout(50,Marcos.size()/50));
        this.add(Panel_Memoria_Fisica);
       Panel_Memoria_Fisica.setBounds(70, 70,100,100 );      
        // Añadir botones al panel
        for(int i = 0; i < Marcos.size(); i++){     
            if (Marcos.get(i).getIDMarco()!=0){
                proyecto2.manejomemoria.Marco marco=Marcos.get(i);
                 Boton= new JButton(Integer.toString(marco.getIDMarco()));
                 Color c=ObtenerColor(marco);
                if(marco.getPagina().getBit_Modificado()==1){

                    Boton.setBackground(c.darker() );//java.awt.Color.BLUE.darker()); 
                }
                else{
                    Boton.setBackground(c);
                }
            }
            else{
                 Boton= new JButton("");
                Boton.setBackground(java.awt.Color.white);
            }
            Panel_Memoria_Fisica.add(Boton);
            Boton.addActionListener(this);
           }
        Panel_Memoria_Fisica.setVisible(true);
     
}
    public Color ObtenerColor(proyecto2.manejomemoria.Marco marco){
         Iterator e= Lista_Procesos.keySet().iterator();
            while(e.hasNext()){
                Integer key=(int)e.next();
                if(Lista_Procesos.get(key).ID_Proceso()==marco.getIDProceso()){
                   return Lista_Procesos.get(key).Retornar_Color();
                }
            }
            return new Color(0,0,0);
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Indicaciones = new javax.swing.JLabel();
        Cantidad_Referencias = new javax.swing.JLabel();
        Referencias = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Indicaciones.setText("La tabla muestra como está compuesta la memoria física despúes de");

        Cantidad_Referencias.setText("#");

        Referencias.setText("referencias");

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Titulo.setText("Visualizar Memoria Física");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(Titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(Indicaciones)
                        .addGap(18, 18, 18)
                        .addComponent(Cantidad_Referencias)
                        .addGap(18, 18, 18)
                        .addComponent(Referencias)))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cantidad_Referencias)
                        .addComponent(Referencias))
                    .addComponent(Indicaciones))
                .addContainerGap(421, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_Memoria_Fisica().setVisible(true);
                
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad_Referencias;
    private javax.swing.JLabel Indicaciones;
    private javax.swing.JLabel Referencias;
    private javax.swing.JLabel Titulo;
    // End of variables declaration//GEN-END:variables

   
}