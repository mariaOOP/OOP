/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author tato
 */
public class Programas extends javax.swing.JFrame {

    /**
     * Creates new form Programas
     */
    public Programas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCrearPrograma = new javax.swing.JButton();
        jButtonBuscarPrograma = new javax.swing.JButton();
        jButtonVerTodosProgramas = new javax.swing.JButton();
        jButtonEliminarPrograma = new javax.swing.JButton();
        jButtonModificarPrograma = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(168, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCrearPrograma.setText("Crear ");
        jButtonCrearPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearProgramaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCrearPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, -1));

        jButtonBuscarPrograma.setText("Buscar");
        jButtonBuscarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarProgramaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscarPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, -1));

        jButtonVerTodosProgramas.setText("Ver todos");
        jButtonVerTodosProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerTodosProgramasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVerTodosProgramas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, -1));

        jButtonEliminarPrograma.setText("Eliminar");
        jButtonEliminarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProgramaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, -1));

        jButtonModificarPrograma.setText("Modificar");
        jButtonModificarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarProgramaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificarPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, -1));

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearProgramaActionPerformed
        // TODO add your handling code here:
        new MostrarPrograma(this, rootPaneCheckingEnabled).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCrearProgramaActionPerformed

    private void jButtonModificarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarProgramaActionPerformed
        // TODO add your handling code here:
        BuscarPrograma programa = new BuscarPrograma();
       
        programa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonModificarProgramaActionPerformed

    private void jButtonBuscarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarProgramaActionPerformed
        // TODO add your handling code here:
        new BuscarPrograma().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBuscarProgramaActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        new VistaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonEliminarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProgramaActionPerformed
        // TODO add your handling code here:
        BuscarPrograma programaAEliminar = new BuscarPrograma();
        programaAEliminar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEliminarProgramaActionPerformed

    private void jButtonVerTodosProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerTodosProgramasActionPerformed
        // TODO add your handling code here:
        TablaProgramas todosProgramas = new TablaProgramas(this, rootPaneCheckingEnabled);
        todosProgramas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVerTodosProgramasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Programas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Programas().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarPrograma;
    private javax.swing.JButton jButtonCrearPrograma;
    private javax.swing.JButton jButtonEliminarPrograma;
    private javax.swing.JButton jButtonModificarPrograma;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonVerTodosProgramas;
    // End of variables declaration//GEN-END:variables
}
