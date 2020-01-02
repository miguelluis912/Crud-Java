/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Proyecto.modelo.dt.RespuestasDT;
import Proyecto.modelo.facade.sistemaFacade;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Puppies
 */
public class ListaRespuestas extends javax.swing.JInternalFrame {

    
        RespuestasDT dt = new RespuestasDT();
        sistemaFacade fac = new sistemaFacade();
    /**
     * Creates new form ListaRespuestas
     */
    public ListaRespuestas() {
        initComponents();
        llenado();
    }
    
     public void llenado(){
        String[]columnas={"Clave Respuestas","RespuestaA","RespuestaB","RespuestaC","Actualizar","Eliminar"};
        List lista;
        int fila =-1;
        try {
            Object[][] data= new Object[fac.listaRespuestas().size()][6];
            lista=fac.listaRespuestas();
            //Actualizar
            Iterator it=lista.iterator();
            while(it.hasNext()){
                dt = (RespuestasDT) it.next();
                fila++;
            
                data[fila][0] = dt.getIdRespuestas();
                data[fila][1] = dt.getRespuestaA();
                data[fila][2] = dt.getRespuestaB();
                data[fila][3] = dt.getRespuestaC();
                data[fila][4]="Actualizar";
                data[fila][5]="Eliminar";
                
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(data,columnas));
        } catch (Exception e) {
            Logger.getLogger(ListaRespuestas.class.getName()).log(Level.SEVERE, null,e);
        }
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton1)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        dt.setIdRespuestas(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()));
        dt.setRespuestaA(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString()); 
        dt.setRespuestaB(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        dt.setRespuestaC(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        
        
  
        
        if(jTable1.getSelectedColumn() ==4){
            //Actualizar
            if(JOptionPane.showConfirmDialog(this, "Estas seguro de actualizar los datos","Actualizar",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                try {
                    //Llamar  al metedo en sistema facade para actualizar
                    fac.actualizaRespuestas(dt);
                } catch (SQLException e) {
                    Logger.getLogger(ListaRespuestas.class.getName()).log(Level.SEVERE, null,e);
                }catch (Exception e) {
                    Logger.getLogger(ListaRespuestas.class.getName()).log(Level.SEVERE, null,e);
                }
                
            }    
        }
        
        if(jTable1.getSelectedColumn() == 5){
            //Eliminar
            if(JOptionPane.showConfirmDialog(this, "Estas seguro de Eliminar los datos","Elimnar",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                try {
                    //Llamar  al metedo en sistema facade para actualizar
                    fac.eliminarRespuestas(dt);
                    llenado();
                } catch (SQLException e) {
                    Logger.getLogger(ListaRespuestas.class.getName()).log(Level.SEVERE, null,e);
                }catch (Exception e) {
                    Logger.getLogger(ListaRespuestas.class.getName()).log(Level.SEVERE, null,e);
                }
                
            }
        }
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}