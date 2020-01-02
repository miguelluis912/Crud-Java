/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Proyecto.modelo.dt.NotaDT;
import Proyecto.modelo.facade.sistemaFacade;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class ListaNota extends javax.swing.JInternalFrame {
    NotaDT dt = new NotaDT();
    sistemaFacade fac = new sistemaFacade();

    /**
     * Creates new form ListaNota
     */
    public ListaNota() {
        initComponents();
        llenado();
    }
    
    
    public void llenado(){
        
        String[]columnas={"Clave Nota","Notas","IdAlumnos","IdExamenes","Actualizar","Eliminar"};
        List lista;
        int fila =-1;
        try {
            Object[][] data= new Object[fac.listaNota().size()][6];
            lista=fac.listaNota();
            //Actualizar
            Iterator it=lista.iterator();
            while(it.hasNext()){
                dt = (NotaDT) it.next();
                fila++;
            data[fila][0] = dt.getIdNota();
            data[fila][1] = dt.getNotas();
            data[fila][2] = dt.getIdAlumnos();
            data[fila][3] = dt.getIdExamenes();
            data[fila][4]="Actualizar";
            data[fila][5]="Eliminar";
                
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(data,columnas));
        } catch (Exception e) {
            Logger.getLogger(ListaNota.class.getName()).log(Level.SEVERE, null,e);
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

        pantalla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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

        jLabel1.setText("Lista Nota");

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        dt.setIdNota(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()));
        dt.setNotas(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString()));
        dt.setIdAlumnos(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString()));
        dt.setIdExamenes(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString()));
        
         if(jTable1.getSelectedColumn() ==4){
            //Actualizar
            if(JOptionPane.showConfirmDialog(this, "Estas seguro de actualizar los datos","Actualizar",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                try {
                    //Llamar  al metedo en sistema facade para actualizar
                    fac.actualizaNota(dt);
                } catch (SQLException e) {
                    Logger.getLogger(ListaNota.class.getName()).log(Level.SEVERE, null,e);
                }catch (Exception e) {
                    Logger.getLogger(ListaNota.class.getName()).log(Level.SEVERE, null,e);
                }
                
            }    
        }
         
         if(jTable1.getSelectedColumn() == 5){
            //Eliminar
            if(JOptionPane.showConfirmDialog(this, "Estas seguro de Eliminar los datos","Elimnar",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                try {
                    //Llamar  al metedo en sistema facade para actualizar
                    fac.eliminarNota(dt);
                    llenado();
                } catch (SQLException e) {
                    Logger.getLogger(ListaNota.class.getName()).log(Level.SEVERE, null,e);
                }catch (Exception e) {
                    Logger.getLogger(ListaNota.class.getName()).log(Level.SEVERE, null,e);
                }
                
            }
        }
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pantalla;
    // End of variables declaration//GEN-END:variables
}